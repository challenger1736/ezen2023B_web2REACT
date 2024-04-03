package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.service.BoardService;
import ezenweb.service.FileService;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController // @Controller + @ResponseBody : 데이터 주고 받는 REST 역할
@RequestMapping("/board")
public class BoardController {

    @Autowired private BoardService boardService;

    @Autowired private FileService fileService;


    @PostMapping("/post.do")
    public boolean postBoard( BoardDto boardDto){
        //엔티티 객체 = DB의 하나의 레코드
//        BoardEntity boardEntity = new BoardEntity();


        return boardService.postBoard(boardDto);

    }

    @GetMapping("/get.do")
    public PageDto getBoard(int page, int view){
        return boardService.getBoard(page, view);
    }

    @PutMapping("/put.do")
    public boolean putBoard(){
        return boardService.putBoard();
    }

    @DeleteMapping("/delete.do")
    public boolean deleteBoard(int bno){




        return boardService.deleteBoard(bno);
    }
}
