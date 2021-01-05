package fftl.SpringbootCRUD1.repository;

import fftl.SpringbootCRUD1.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository{ //JpaRepositroy<사용할 Entity, id 타입>

    private final EntityManager em;

    public Long save(Board board) {
        em.persist(board);
        return board.getId();
    }

    public Board findOneBoard(Long id) { return em.find(Board.class, id); }

    public List<Board> findAllBoard(){
        List<Board> result = em.createQuery("select b from Board b", Board.class).getResultList();

        return result;
    }

    public void boardOneDelete(Board board){
        em.remove(board);

    }
}
