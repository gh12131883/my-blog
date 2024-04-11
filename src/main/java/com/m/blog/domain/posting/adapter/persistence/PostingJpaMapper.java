package com.m.blog.domain.posting.adapter.persistence;

import com.m.blog.domain.posting.application.domain.Posting;
import com.m.blog.domain.posting.infrastructure.repository.PostingDto;
import com.m.blog.domain.posting.infrastructure.repository.PostingEntity;

import java.time.LocalDateTime;

public class PostingJpaMapper {
    public static PostingEntity toEntity (Posting domain){
        return PostingEntity.builder()
                .id(domain.getId().getId())
                .title(domain.getTitle())
                .content(domain.getContent())
                .build();
    }


}
