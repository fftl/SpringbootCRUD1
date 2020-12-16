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
        if(board.getId() == null){
            em.persist(board);
        } else {
            em.merge(board); // update 비슷한 것 왠만하면 merge가 아닌 ItemService의 변경감지를 이용하도록합니다.
        }
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
