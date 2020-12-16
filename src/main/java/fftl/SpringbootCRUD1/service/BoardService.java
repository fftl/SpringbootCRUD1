package fftl.SpringbootCRUD1.service;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardRepository;
import fftl.SpringbootCRUD1.repository.JPABoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(JPABoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /** 게시글 등록 */
    public Long addboard(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    /** 아이디를 이용해 게시글 찾기*/
    public Board findOne(Long memberId) {
        return boardRepository.findById(memberId);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public void saveBoard(Board board){
        boardRepository.save(board);
    }


}
