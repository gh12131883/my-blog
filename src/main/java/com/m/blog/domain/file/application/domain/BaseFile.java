package com.m.blog.domain.file.application.domain;

import com.m.blog.domain.posting.application.domain.Posting;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Getter
public class BaseFile {
    private static final String downloadPrefix = "/file/download/";

    protected String id;
    protected String originalFileName;
    protected String directoryName;

    protected Posting.Id postingId;

    protected String getExtension(){
        if(originalFileName == null){
            throw new RuntimeException("originalFileName can't be null.");
        }
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }


    public String getFileKey(){
        return directoryName + "/" + id;
    }

    public String getDownloadUrl(){
        return downloadPrefix + id;
    }
}
