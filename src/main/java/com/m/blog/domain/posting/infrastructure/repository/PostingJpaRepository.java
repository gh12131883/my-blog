package com.m.blog.domain.posting.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostingJpaRepository extends JpaRepository<PostingEntity, PostingId>{
    Optional<PostingEntity> findByBoardCollectionIdAndBoardIdAndId(long boardCollectionId, long boardId, long id);
}