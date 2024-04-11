package com.m.blog.domain.file.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
public class DownloadedFile extends BaseFile{
    byte[] data;

    public static DownloadedFile from(byte[] data, File file){
        return DownloadedFile.builder()
                .id(file.getId())
                .originalFileName(file.getOriginalFileName())
                .directoryName(file.getDirectoryName())
                .data(data)
                .build();
    }
}
