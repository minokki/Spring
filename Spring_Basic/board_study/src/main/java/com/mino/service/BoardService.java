package com.mino.service;

import java.util.List;

import com.mino.model.BoardVO;
import com.mino.model.Criteria;

public interface BoardService {

	//게시글 작성
	public void write(BoardVO boardVO);
	
	//게시글 목록보기
	public List<BoardVO> getList();
	
	//게시글 보기(글번호)
	public BoardVO getPage(int bno);
	
	//게시글 수정
	public int modifyPage(BoardVO boardVO);
	
	//게시글 삭제
	public int delete(int bno);
	
	//게시글 페이징
	public List<BoardVO> paging(Criteria cri);
	
	//게시글 총갯수
	public int totalPage(Criteria cri);
	
}
