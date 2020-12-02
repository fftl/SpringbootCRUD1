package fftl.SpringbootCRUD1.controller;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardRepository;
import fftl.SpringbootCRUD1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/add")
    public String addForm(){
        return "board/add";
    }

    @PostMapping("board/add")
    public String add(Board boardform){
        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        String datetime = format1.format(date);

        Board board = new Board();
        board.setWriter(boardform.getWriter());
        board.setContent(boardform.getContent());
        board.setTitle(boardform.getTitle());
        board.setRegdate(datetime);

        boardService.addboard(board);

        return "redirect:/";
    }

    @GetMapping("/board/list")
    public String viewlist(){
        return "board/list";
    }
}