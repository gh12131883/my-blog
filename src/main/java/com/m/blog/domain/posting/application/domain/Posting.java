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

    public static Posting.InBoardCondition forFilteredPage(String boardCollectionId, String boardId){
        return Posting.InBoardCondition.builder()
                .boardCollectionId(boardCollectionId)
                .boardId(boardId)
                .build();
    }

    public static Posting.PostingId get(String boardCollectionId, String boardId, String postingId){
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
        private String boardCollectionId;
        private String boardId;
        private String postingId;

        public static PostingId from(IdWithoutPostingId idWithoutPostingId, String postingId){
            return PostingId.builder()
                    .boardCollectionId(idWithoutPostingId.getBoardCollectionId())
                    .boardId(idWithoutPostingId.getBoardId())
                    .postingId(postingId)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class IdWithoutPostingId{
        private String boardCollectionId;
        private String boardId;
    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class InBoardCondition{
        private String boardCollectionId;
        private String boardId;
    }

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Mutable {
        private String title;
        private String content;
    }



}
