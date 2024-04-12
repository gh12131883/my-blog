package com.m.blog.domain.posting.application.service;

import com.m.blog.domain.board.application.domain.Board;
import com.m.blog.domain.board.infrastructure.repository.BoardDto;
import com.m.blog.domain.board.infrastructure.repository.BoardDslRepository;
import com.m.blog.domain.posting.application.domain.Posting;
import com.m.blog.domain.posting.application.query.FindPostingQuery;
import com.m.blog.domain.posting.infrastructure.repository.PostingDslRepository;
import com.m.blog.domain.posting.infrastructure.repository.PostingDto;
import com.m.blog.domain.posting.infrastructure.web.dto.PostingReadResponse;
import com.m.blog.global.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
class FindPostingService implements FindPostingQuery {
    private final BoardDslRepository boardDslRepository;
    private final PostingDslRepository postingDslRepository;

    public Page<PostingDto> getPaging(Pageable pageable) {
        return postingDslRepository.getNonFilteredPage(pageable);
    }

    public Page<PostingDto> getFilteredPage(Posting.InBoardCondition condition, Pageable pageable) {
        return postingDslRepository
                .getFilteredPage(condition.getBoardCollectionId(), condition.getBoardId(), pageable);
    }

    @Override
    public PagingResponse get(Board.BoardId boardId, Pageable pageable){
        BoardDto found = boardDslRepository
                .findBoardDto(boardId.getValue());

        Posting.InBoardCondition condition =
                Posting.forFilteredPage(boardId.getValue());

        return PagingResponse.get(getFilteredPage(condition, pageable), found);
    }

    @Override
    public PagingResponse getPagingResponse(Pageable pageable) {
        return PagingResponse.get(getPaging(pageable), null);
    }

    @Override
    public PostingReadResponse get(Posting.PostingId condition){
        return PostingReadResponse.of(postingDslRepository.getSinglePage(condition));
    }
}