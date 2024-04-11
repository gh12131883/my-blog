package com.m.blog.domain.file.application.domain;

import com.m.blog.domain.posting.application.domain.Posting;
import com.m.blog.global.entity.SnowflakeIdGenerator;
import lombok.*;

@Getter
public class UploadedFile extends BaseFile{
    private final byte[] data;

    public UploadedFile(String originalFileName, String directoryName, byte[] data, Posting.Id id){
        this.originalFileName = originalFileName;
        this.id = SnowflakeIdGenerator.generateId() + getExtension();
        this.directoryName = directoryName;
        this.data = data;
        this.postingId = id;
    }
}

