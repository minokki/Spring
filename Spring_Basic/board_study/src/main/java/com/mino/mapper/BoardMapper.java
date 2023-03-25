package com.mino.mapper;

import java.util.List;

import com.mino.model.BoardVO;
import com.mino.model.Criteria;

public interface BoardMapper {

    //글작성
	public void write(BoardVO board);
	
	//글목록 보기
	public List<BoardVO> getList();
	
	//게시글 조회(글번호로)
	public BoardVO getPage(int bno);
	
	//게시글 수정
	public int modifyPage(BoardVO board);
	
	//게시글 삭제
	public int delete(int bno);
	
	//게시판 페이징
	public List<BoardVO> paging(Criteria cri);
	
	//전체 게시물 갯수
	public int totalPage(Criteria cri);
}
