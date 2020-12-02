package fftl.SpringbootCRUD1.service;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardRepository;

public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /** 게시글 등록 */
    public Long addboard(Board board) {
        boardRepository.save(board);
        return board.getId();
    }
}
