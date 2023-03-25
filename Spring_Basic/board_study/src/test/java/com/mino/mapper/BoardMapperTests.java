package com.mino.mapper;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mino.model.BoardVO;
import com.mino.model.Criteria;

/*테스트시 작성*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
	
	@Autowired
	private BoardMapper boardMapper;
	
//	@Test
//	public void 글작성테스트() {
//	
//	BoardVO vo = new BoardVO();
//	
//	vo.setTitle("작성테스트1");
//	vo.setContent("작성테스트1");
//	vo.setWriter("작성테스트1");
//	
//	boardMapper.write(vo);;
//	
//	}
	
//	 @Test
//	public void 게시판리스트테스트() {
//	    	
//	List<BoardVO> list = boardMapper.getList();
//	    	
//	 for(Object a : list) {
//	 log.info("" + a);
//	  }
//
//	 }
	
//	@Test
//	public void 게시글조회테스트() {
//		//글번호 9번인 게시글 보는 테스트
//		int bno = 9;
//		
//		log.info(""+boardMapper.getPage(bno));
//		
//	}
	
//	@Test
//	public void 게시글수정테스트() {
//		BoardVO board = new BoardVO();
//		board.setBno(8);
//		board.setTitle("수정테스트3");
//		board.setContent("수정테스트3");
//		
//		int result = boardMapper.modifyPage(board);
//		
//		log.info("result= " +result);
//		
//		
//	}
	
//	@Test
//	public void 게시글삭제테스트() {
//		int bno =3;
//		int result = boardMapper.delete(bno);
//		
//		log.info("result=" + result);
//	}
	
	@Test
	public void 페이징테스트() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		List<BoardVO> list = boardMapper.paging(cri);
		
		for(Object a : list) {
			log.info(""+a);
		}
	}
}
