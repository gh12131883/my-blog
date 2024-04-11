package com.m.blog.domain.posting.application.domain;

import com.m.blog.domain.board.application.domain.Board;
import lombok.*;

@Data
@Builder
public class Posting {
    PostingId postingId;
    Board.BoardId boardId;
    String title;
    String content;

    public static Posting.InBoardCondition forFilteredPage(String boardCollectionId, String boardId){
        return Posting.InBoardCondition.builder()
                .boardCollectionId(boardCollectionId)
                .boardId(boardId)
                .build();
    }

    public static PostingId get(String postingId){
        return PostingId.builder()
                .value(postingId)
                .build();
    }


    @Getter
    @Builder
    @AllArgsConstructor
    public static class PostingId {
        private String value;
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
