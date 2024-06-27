package com.furnycrew.furnidream.common.file;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @Autowired
    private ResourceLoader resourceLoader;

//    @PostMapping("/singleFile")
//    public String singleFile(
//            @RequestParam("singleFile") MultipartFile singleFile,
//            @RequestParam("singleFileDescription") String singleFileDescription,
//            Model model) throws IOException {
//        // 1. 저장할 경로 가져오기 : Resource
//        Resource resource = resourceLoader.getResource("classpath:static/images/");
//        log.debug("resource = {}", resource);
//        String dir = resource.getFile().getAbsolutePath();
//        log.debug("dir = {}", dir);
//        // 2. 저장할 이름을 새로 부여 (인코딩이슈, 보안이슈를 대비한 것이다)
//        String originalFilename = singleFile.getOriginalFilename();
//        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String savedName = UUID.randomUUID() + ext;
//        // 저장
//        singleFile.transferTo(new File(dir, savedName));
//        // 결과 피드백
//        model.addAttribute("message", "이미지 업로드 성공");
//        model.addAttribute("img", "upload/single/" + savedName);
//
//        return "redirect:/product/list";

    @PostMapping("/upload")
    public String upload(@RequestParam("upFile") List<MultipartFile> upFiles) throws IOException{
        // 1. 파일업로드 처리
        List<FileDto> list = new ArrayList<>();
        for (MultipartFile file : upFiles) {
            if (!file.isEmpty()) {
                FileDto fileDto = fileUploadService.upload("", file);
                list.add(fileDto);
            }
        }
        log.debug("list = {}", list);
        // 2. 업로드한 파일명/저장된 파일명 정보를 DB에 등록

        return "redirect:/";
    }
}
