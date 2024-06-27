package com.furnycrew.furnidream.common.file;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileUploadService {
    @Value("${ftp.server.host}")
    private String server;

    @Value("${ftp.server.port}")
    private int port;

    @Value("${ftp.server.username}")
    private String username;

    @Value("${ftp.server.password}")
    private String password;

    public FileDto upload(String parentDir, MultipartFile multipartFile) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            try (InputStream inputStream = multipartFile.getInputStream()) {
                String contentType = multipartFile.getContentType();
                String originalFilename = multipartFile.getOriginalFilename();
                String renamedFilename = parentDir +  getRenamedFilename(originalFilename);
                // 실제 파일전송
//                boolean done = ftpClient.storeFile(dir + renamedFilename, inputStream);
                boolean done = ftpClient.storeFile(renamedFilename, inputStream);
                if (!done)
                    throw new RuntimeException("[" + multipartFile + "] 파일 업로드에 실패했습니다.");

                // Builder패턴을 사용하여 객체 생성
                return FileDto.builder() // 파라미터 생성자 이용
                        .originalFilename(originalFilename)
                        .renamedFilename(renamedFilename)
                        .contentType(contentType)
                        .build();
            }
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getRenamedFilename(String originalFilename) {
//        return "%s_%s".formatted(UUID.randomUUID().toString(), originalFilename);
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        return "%s_%s".formatted(UUID.randomUUID().toString(), ext);

    }
}
