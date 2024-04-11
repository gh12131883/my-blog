package com.m.blog.domain.board.infrastructure.repository;

public interface BoardDslRepository {
    BoardDto findBoardDto(long boardCollectionId, long boardId);
}
