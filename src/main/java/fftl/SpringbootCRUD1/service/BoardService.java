package fftl.SpringbootCRUD1.service;

import fftl.SpringbootCRUD1.domain.Board;
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
    public Long addboard(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    /** 아이디를 이용해 게시글 찾기*/
    public Optional<Board> findOne(Long memberId) {
        return boardRepository.findById(memberId);
    }

//    public void updateBoard(Long id,Board board){
//        Board form = boardRepository.findOne(id);
//
//
//
//        boardRepository.save(form);
//    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public void saveBoard(Board board){
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long memberId){
        boardRepository.deleteById(memberId);
    }
}
