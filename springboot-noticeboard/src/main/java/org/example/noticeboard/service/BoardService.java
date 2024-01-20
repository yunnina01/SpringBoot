package org.example.noticeboard.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.noticeboard.dto.BoardDTO;
import org.example.noticeboard.entity.BoardEntity;
import org.example.noticeboard.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toSaveEntity(boardDTO));
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardDTO::toBoardDTO)
                .toList();
    }

    @Transactional
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    @Transactional
    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        return optionalBoardEntity.map(BoardDTO::toBoardDTO).orElse(null);
    }

    public BoardDTO update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        boardRepository.save(boardEntity);
        return findById(boardDTO.getId());
    }
}
