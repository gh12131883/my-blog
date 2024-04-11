package com.m.blog.domain.posting.infrastructure.repository;

import com.m.blog.domain.posting.application.domain.Posting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostingDslRepository {
    long findMaxId(long boardCollectionId, long boardId);
    Page<PostingDto> getNonFilteredPage(Pageable pageable);

    Page<PostingDto> getFilteredPage(long boardCollectionIdm, long boardId, Pageable pageable);
    PostingDto getSinglePage(Posting.PostingId condition);
}
