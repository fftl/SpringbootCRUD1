package fftl.SpringbootCRUD1.service;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardDto;
import fftl.SpringbootCRUD1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /** 게시글 등록 */
    @Transactional
    public Long saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board OneBoard(Long id){
        return boardRepository.findOneBoard(id);
    }

    @Transactional
    public Long updateBoard(Long id, Board board){
        Board boardForm = boardRepository.findOneBoard(id);
        boardForm.setWriter(board.getWriter());
        boardForm.setTitle(board.getTitle());
        boardForm.setContent(board.getContent());

        return boardRepository.save(boardForm);
    }

    public List<Board> findAll() {
        return boardRepository.findAllBoard();
    }

    @Transactional
    public void deleteBoard(Long id){
        Board board = boardRepository.findOneBoard(id);
        boardRepository.boardOneDelete(board);
    }
}
