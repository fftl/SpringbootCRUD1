package fftl.SpringbootCRUD1.repository;

import fftl.SpringbootCRUD1.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class JPABoardRepository implements BoardRepository{

    private final EntityManager em;

    @Autowired
    public JPABoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public Board findById(Long id) {
        return null;
    }

    @Override
    public Board findByWriter(String writer) {
        return null;
    }

    @Override
    public List<Board> findAll() {
        return null;
    }
}
