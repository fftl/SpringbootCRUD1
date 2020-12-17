package fftl.SpringbootCRUD1.repository;

import fftl.SpringbootCRUD1.domain.Board;

import java.util.List;

public interface BoardRepository {

    Board save(Board board);
    Board findById(Long id);
    Board findByWriter(String writer);
    List<Board> findAll();
    int deleteBoard(Long id);

}
