package fftl.SpringbootCRUD1.repository;

import fftl.SpringbootCRUD1.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
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
        Board board = em.find(Board.class, id);
        return board;
    }

    @Override
    public Board findByWriter(String writer) {
        return null;
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }
}
