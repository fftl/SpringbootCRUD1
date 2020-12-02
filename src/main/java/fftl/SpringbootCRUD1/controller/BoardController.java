package fftl.SpringbootCRUD1.controller;

import fftl.SpringbootCRUD1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/board/list")
    public String viewlist(){
        return "board/list";
    }
}
