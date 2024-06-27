package com.furnycrew.furnidream.common.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class FileDto {
    private Long id;
    private String contentType;
    private String originalFilename;    // 실제 업로드한 파일 이름
    private String renamedFilename;     // unique 한 파일 이름을 만들기 위한 속성
}
