package com.m.blog.domain.posting.infrastructure.repository;

import com.m.blog.domain.posting.application.domain.Posting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostingDslRepository {
    Page<PostingDto> getNonFilteredPage(Pageable pageable);

    Page<PostingDto> getFilteredPage(String boardCollectionIdm, String boardId, Pageable pageable);
    PostingDto getSinglePage(Posting.Id condition);
}
