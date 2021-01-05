package fftl.SpringbootCRUD1.controller;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardDto;
import fftl.SpringbootCRUD1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/add")
    public String goAdd(){
        return "board/add";
    }

    @PostMapping("/board/add")
    public String Add(Board boardform){
        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        String datetime = format1.format(date);

        Board board = new Board();
        board.setWriter(boardform.getWriter());
        board.setContent(boardform.getContent());
        board.setTitle(boardform.getTitle());
        board.setRegdate(datetime);

        boardService.saveBoard(board);

        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String golist(Model model){
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/board/{boardId}/update")
    public String goUpdate(@PathVariable("boardId") Long id, Model model){
        Board board = boardService.OneBoard(id);

        Board form = new Board();
        form.setId(board.getId());
        form.setWriter(board.getWriter());
        form.setRegdate(board.getRegdate());
        form.setContent(board.getContent());
        form.setTitle(board.getTitle());

        model.addAttribute("form", form);

        return "board/update";

    }

    @PostMapping("/board/{boardId}/update")
    public String updateBoard(@PathVariable("boardId") Long id, Board boardForm){

        boardService.updateBoard(id, boardForm);
        return "redirect:/board/list";

    }

    @GetMapping("/board/{boardId}/delete")
    public String deleteBoard(@PathVariable("boardId") Long id){

        boardService.deleteBoard(id);
        return "redirect:/board/list";

    }
}
