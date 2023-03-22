package com.fastcampus.ch4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.PageHandler;
import com.fastcampus.ch4.domain.SearchCondition;
import com.fastcampus.ch4.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @PostMapping("/modify")
    public String modify(HttpSession session,BoardDto boardDto,RedirectAttributes ra,Model m,
                         SearchCondition sc){
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);

        try {
            m.addAttribute("page", sc.getPage());
            m.addAttribute("pageSize", sc.getPageSize());
            int rowCnt = boardService.modify(boardDto);

            if(rowCnt != 1)
                throw new Exception("Modify failed");
                 ra.addFlashAttribute("msg","MO_OK");

                return "redirect:/board/list?page="+sc.getPage()+"&pageSize="+sc.getPageSize() ;
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("boardDto", boardDto);
            ra.addFlashAttribute("msg","MO_ERR");
            return "board";
        }

    }
    @PostMapping("/write")
    public String write(BoardDto boardDto, HttpSession session,Model m, RedirectAttributes ra){
        String writer = (String) session.getAttribute("id");
        boardDto.setWriter(writer);
        try {
           int rowCnt = boardService.write(boardDto);

           if(rowCnt !=1)
               throw new Exception("Write failed");
            ra.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("boardDto", boardDto);
            ra.addFlashAttribute("msg", "WRT_ERR");
            return "board";
        }

    }

    @GetMapping("write")
    public String write(Model m){
        m.addAttribute("mode","new");
        return "board";
    }

    @GetMapping("/read")
    public String read(Integer bno,Integer page, Integer pageSize, Model m){
        try {
            BoardDto boardDto = boardService.read(bno);
//            m.addAttribute("boardDto", boardDto); //아래문장과 동일
            m.addAttribute(boardDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "board";
    }

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session,
                         RedirectAttributes ra){ //url에 한번만 표시되는 파라미터
        String writer = (String)session.getAttribute("id");
        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            int rowCnt = boardService.remove(bno, writer);

            if(rowCnt != 1 )
                throw new Exception("board remove error");
                ra.addFlashAttribute("msg", "DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("msg", "DEL_ERR");
            //addFlashAttribute 는 RedirectAttributes 를 사용할때 같이사용
        }

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(Model m, SearchCondition sc, HttpServletRequest request) {
        if(!loginCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동

        try {
            int totalCnt = boardService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<BoardDto> list = boardService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCnt", 0);
        }

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id")!=null;
    }
}