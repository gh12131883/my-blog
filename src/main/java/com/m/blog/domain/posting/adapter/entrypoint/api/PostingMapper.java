package com.m.blog.domain.posting.adapter.entrypoint.api;

import com.m.blog.domain.posting.application.domain.Posting;
import com.m.blog.domain.posting.infrastructure.web.dto.PostingCreateRequest;
import com.m.blog.domain.posting.infrastructure.web.dto.PostingReadFilteredPagingRequest;
import com.m.blog.domain.posting.infrastructure.web.dto.PostingUpdateRequest;
import com.m.blog.global.entity.SnowflakeIdGenerator;

class PostingMapper {
    public static Posting.Id toId(PostingUpdateRequest request){
        return Posting.Id.builder()
                .boardCollectionId(request.getBoardCollectionId())
                .boardId(request.getBoardId())
                .postingId(request.getPostingId())
                .build();
    }

    public static Posting toEntity(PostingUpdateRequest request){
        return Posting.builder()
                .id(toId(request))
                .title(request.getTitle())
                .content(request.getMarkup())
                .build();
    }

    public static Posting from(PostingCreateRequest request){
        return Posting.builder()
                .id(Posting.Id.builder()
                        .postingId(SnowflakeIdGenerator.generateId())
                        .build())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static Posting.IdWithoutPostingId of(PostingReadFilteredPagingRequest request){
        return Posting.IdWithoutPostingId.builder()
                .boardCollectionId(request.getBoardCollectionId())
                .boardId(request.getBoardId())
                .build();
    }

}
