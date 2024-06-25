package com.furnycrew.furnidream.common.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private Long id;
    private String originalFilename;
    private String savedFilename;
    private String fileDescription;
}
