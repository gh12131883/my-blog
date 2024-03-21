package com.m.blog.domain.posting.infrastructure.web.dto;

import lombok.Data;

@Data
public class PostingCreateRequest {
    private int boardCollectionId;
    private int boardId;
    private String title;
    private String content;
}

