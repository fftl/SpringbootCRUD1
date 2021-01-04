package fftl.SpringbootCRUD1.repository;

import fftl.SpringbootCRUD1.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{ //JpaRepositroy<사용할 Entity, id 타입>

}
