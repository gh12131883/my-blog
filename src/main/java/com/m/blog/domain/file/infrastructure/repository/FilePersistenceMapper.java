package com.m.blog.domain.file.infrastructure.repository;

import com.m.blog.domain.file.application.domain.UploadedFile;

public class FilePersistenceMapper {
    public static FileEntity of(UploadedFile uploadedFile){
        return FileEntity.builder()
                .id(uploadedFile.getId())
                .postingId(uploadedFile
                        .getPostingId()
                        .getId())
                .originalFileName(uploadedFile.getOriginalFileName())
                .filePath(uploadedFile.getDirectoryName())
                .build();
    }
}
