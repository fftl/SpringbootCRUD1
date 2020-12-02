package fftl.SpringbootCRUD1;

import fftl.SpringbootCRUD1.repository.BoardRepository;
import fftl.SpringbootCRUD1.repository.JPABoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BoardRepository boardRepository(){
        return new JPABoardRepository(em);
    }
}
