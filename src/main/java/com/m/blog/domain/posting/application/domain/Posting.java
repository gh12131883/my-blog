package com.m.blog.domain.posting.application.domain;

import com.m.blog.domain.posting.infrastructure.repository.PostingDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Posting {
    PostingId id;
    String title;
    String content;

    public static Posting.InBoardCondition forFilteredPage(long boardCollectionId, long boardId){
        return Posting.InBoardCondition.builder()
                .boardCollectionId(boardCollectionId)
                .boardId(boardId)
                .build();
    }

    public static Posting.PostingId get(long boardCollectionId, long boardId, long postingId){
        return Posting.PostingId.builder()
                .boardCollectionId(boardCollectionId)
                .boardId(boardId)
                .postingId(postingId)
                .build();
    }


    @Getter
    @Builder
    @AllArgsConstructor
    public static class PostingId{
        private long boardCollectionId;
        private long boardId;
        private long postingId;

        public static PostingId from(IdWithoutPostingId idWithoutPostingId, long postingId){
            return PostingId.builder()
                    .boardCollectionId(idWithoutPostingId.getBoardCollectionId())
                    .boardId(idWithoutPostingId.getBoardId())
                    .postingId(postingId)
                    .build();
        }
    }

    public static NewId getNextId(long maxId){
        return NewId.builder()
                .value(maxId + 1)
                .build();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class IdWithoutPostingId{
        private long boardCollectionId;
        private long boardId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class NewId{
        private long value;
    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class InBoardCondition{
        private long boardCollectionId;
        private long boardId;
    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Mutable {
        private String title;
        private String content;
    }



}
