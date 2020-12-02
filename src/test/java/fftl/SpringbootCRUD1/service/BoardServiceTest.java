package fftl.SpringbootCRUD1.service;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired
    BoardRepository  boardRepository;

    @Test
    void 회원가입() {
        //given
        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        String datetime = format1.format(date);

        Board board = new Board();
        board.setContent("내용을 테스트합니다.");
        board.setRegdate(datetime);
        board.setTitle("제목을 테스트합니다.");
        board.setWriter("작성자");

        //when
        Long saveId = boardService.addboard(board);

        //then
        Board findMember = boardService.findOne(saveId);
        assertThat(board.getWriter()).isEqualTo(findMember.getWriter());

    }
}