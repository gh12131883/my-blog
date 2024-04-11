package com.m.blog.domain.posting.infrastructure.web.dto;

import lombok.Data;

@Data
public class PostingCreateRequest {
    private String boardCollectionId;
    private String boardId;
    private String title;
    private String content;
}

