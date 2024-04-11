package com.m.blog.domain.board.application.domain;

import com.m.blog.domain.boardCollection.application.domain.BoardCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class Board {
    Id id;
    BoardCollection.Id boardCollectionId;
    String name;
    String description;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Id {
        private String id;
    }
}
