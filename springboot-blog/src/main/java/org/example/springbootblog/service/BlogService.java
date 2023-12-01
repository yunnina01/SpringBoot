package org.example.springbootblog.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootblog.domain.Article;
import org.example.springbootblog.dto.AddArticleRequest;
import org.example.springbootblog.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
