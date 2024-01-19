package org.example.noticeboard.service;

import lombok.RequiredArgsConstructor;
import org.example.noticeboard.dto.BoardDTO;
import org.example.noticeboard.entity.BoardEntity;
import org.example.noticeboard.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toSaveEntity(boardDTO));
    }
}
