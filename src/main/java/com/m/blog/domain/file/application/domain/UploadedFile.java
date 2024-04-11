package com.m.blog.domain.file.application.domain;

import com.m.blog.global.entity.SnowflakeIdGenerator;
import lombok.*;

import java.util.UUID;

@Getter
public class UploadedFile extends BaseFile{
    private final byte[] data;

    public UploadedFile(String originalFileName, String directoryName, byte[] data){
        this.originalFileName = originalFileName;
        this.assignedFileName = SnowflakeIdGenerator.generateId() + getExtension();
        this.directoryName = directoryName;
        this.data = data;
    }
}

