package com.mino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mino.mapper.BoardMapper;
import com.mino.model.BoardVO;
import com.mino.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void write(BoardVO boardVO) {
		boardMapper.write(boardVO);
		
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	@Override
	public BoardVO getPage(int bno) {
		return boardMapper.getPage(bno);
	}

	@Override
	public int modifyPage(BoardVO boardVO) {
		return boardMapper.modifyPage(boardVO);
	}

	@Override
	public int delete(int bno) {
		return boardMapper.delete(bno);
	}

	@Override
	public List<BoardVO> paging(Criteria cri) {
		return boardMapper.paging(cri);
	}

	@Override
	public int totalPage(Criteria cri) {
		return boardMapper.totalPage(cri);
	}
	
	
	
	
	
}
