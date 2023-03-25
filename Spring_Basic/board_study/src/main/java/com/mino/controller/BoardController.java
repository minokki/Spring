package com.mino.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mino.model.BoardVO;
import com.mino.model.Criteria;
import com.mino.model.PageMakerDTO;
import com.mino.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService boardService;

	//롬복 사용하는 경우 @log4j 어노테이션사용하면 작성 하지않아도된다.
	 private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@GetMapping("/list")
	public void boardList(Model m, Criteria cri) {
		
		log.info("게시판 목록 페이지 진입");
		log.info("cri : " + cri);
		
		m.addAttribute("list",boardService.paging(cri));
		
		int total = boardService.totalPage(cri);
		PageMakerDTO pagemake = new PageMakerDTO(cri, total);
		
		
		m.addAttribute("pageMaker",pagemake);
		
	}
	
	@GetMapping("/write")
	public void boardWriteGet() {
		
		log.info("게시글 작성 페이지 진입");
		
	}
	
	//게시글 등록 
	@PostMapping("/write")
	public String boardWritePost(BoardVO boardVO, RedirectAttributes ra) { //RedirectAttributes 성공여부 알리는 문자를 같이 전송하기위함
		
		 log.info("BoardVO : " + boardVO);
		 boardService.write(boardVO);
		 
		 ra.addFlashAttribute("result","write success");
		 
		 return "redirect:/board/list";
		 
	}
	
	//게시글 조회
	@GetMapping("/read")
	public void boardPageGet(int bno, Model m,Criteria cri) {
		m.addAttribute("pageInfo",boardService.getPage(bno));
		m.addAttribute("cri",cri);
	
	}
	
	//게시글 수정 보기
	@GetMapping("/modify")
	public void boardModifyGet(int bno ,Model m,Criteria cri) {
		m.addAttribute("pageInfo",boardService.getPage(bno));
		m.addAttribute("cri",cri);
	}
	
	@PostMapping("/modify")
	public String boardModifyPost(BoardVO boardvo, RedirectAttributes ra,Criteria cri,Model m) {
		boardService.modifyPage(boardvo);
		ra.addFlashAttribute("result","modify success");
		m.addAttribute("cri",cri);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String boadDelete(int bno, RedirectAttributes ra) {
		boardService.delete(bno);
		ra.addFlashAttribute("result", "delete success");
		
		return "redirect:/board/list";
	}
	
	

}
