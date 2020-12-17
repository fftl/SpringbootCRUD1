package fftl.SpringbootCRUD1.controller;

import fftl.SpringbootCRUD1.domain.Board;
import fftl.SpringbootCRUD1.repository.BoardRepository;
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

    @PostMapping("/board/add")
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
    public String viewlist(Model model){
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("board/{boardId}/update")
    public String viewUpdate(@PathVariable("boardId") Long id, Model model ){
        Board board = boardService.findOne(id);

        Board form = new Board();
        form.setId(board.getId());
        form.setWriter(board.getWriter());
        form.setRegdate(board.getRegdate());
        form.setContent(board.getContent());
        form.setTitle(board.getTitle());

        model.addAttribute("form", form);

        return "board/update";

    }

    @PostMapping("board/{boardId}/update")
    public String updateBoard(@PathVariable("boardId") Long id, @ModelAttribute("form") Board getForm){

        Board form = new Board();
        form.setId(getForm.getId());
        form.setWriter(getForm.getWriter());
        form.setContent(getForm.getContent());
        form.setTitle(getForm.getTitle());

        boardService.saveBoard(form);

        return "board/list";

    }

    @GetMapping("board/{boardId}/delete")
    public String deleteBoard(@PathVariable("boardId") Long id){

        boardService.deleteBoard(id);

        return "board/list";

    }
}
