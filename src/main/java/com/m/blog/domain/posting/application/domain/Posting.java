package com.m.blog.domain.posting.application.domain;

import com.m.blog.domain.board.application.domain.Board;
import lombok.*;

@Data
@Builder
public class Posting {
    Id id;
    Board.Id boardId;
    String title;
    String content;

    public static Posting.InBoardCondition forFilteredPage(String boardCollectionId, String boardId){
        return Posting.InBoardCondition.builder()
                .boardCollectionId(boardCollectionId)
                .boardId(boardId)
                .build();
    }

    public static Id get(String boardCollectionId, String boardId, String postingId){
        return Id.builder()
                .boardCollectionId(boardCollectionId)
                .boardId(boardId)
                .postingId(postingId)
                .build();
    }


    @Getter
    @Builder
    @AllArgsConstructor
    public static class Id {
        private String boardCollectionId;
        private String boardId;
        private String postingId;

        public static Id from(IdWithoutPostingId idWithoutPostingId, String postingId){
            return Id.builder()
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
