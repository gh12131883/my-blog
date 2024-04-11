package com.m.blog.domain.posting.infrastructure.web.controller;

import com.m.blog.domain.posting.application.port.entrypoint.api.ChangePostingEndpointPort;
import com.m.blog.domain.posting.application.port.entrypoint.api.FindPositngEndpointPort;
import com.m.blog.domain.posting.infrastructure.web.dto.*;
import com.m.blog.global.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/posting")
@RequiredArgsConstructor
public class PostingController {
    private final FindPositngEndpointPort findPositngEndpointPort;
    private final ChangePostingEndpointPort changePostingEndpointPort;

    @ResponseBody
    @GetMapping("/list/latest")
    public PagingResponse list(Pageable pageable){
        return findPositngEndpointPort.getPagingResponse(PostingReadPagingRequest.builder()
                        .pageable(pageable)
                .build());
    }

    @ResponseBody
    @GetMapping("/list")
    public PagingResponse list(@RequestParam String boardId, @RequestParam String boardCollectionId, Pageable pageable){
        return findPositngEndpointPort.getPagingResponse(PostingReadFilteredPagingRequest.builder()
                        .boardCollectionId(boardCollectionId)
                        .boardId(boardId)
                        .pageable(pageable)
                .build());
    }

    @ResponseBody
    @GetMapping("/data")
    public PostingReadResponse data(@RequestParam String boardCollectionId, @RequestParam String boardId, @RequestParam String id){
        return findPositngEndpointPort.get(PostingReadRequest.builder().id(id).build());
    }

    @Transactional
    @ResponseBody
    @PutMapping("/data/update")
    public void update(@RequestBody PostingUpdateRequest requestDto){
        changePostingEndpointPort.update(requestDto);
    }

    @PostMapping("/data/insert/posting")
    @ResponseBody
    public void create(@RequestBody PostingCreateRequest requestDto){
        changePostingEndpointPort.create(requestDto);
    }
}
