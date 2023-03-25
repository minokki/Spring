package com.mino.service;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mino.mapper.BoardMapper;
import com.mino.mapper.BoardMapperTests;
import com.mino.model.BoardVO;
import com.mino.model.Criteria;


//서비스 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {
    
    @Autowired
    private BoardService boardservice;
    

    private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
    
//    @Test
//    public void 글작성테스트() {
//        
//        BoardVO vo = new BoardVO();
//        
//        vo.setTitle("service test");
//        vo.setContent("service test");
//        vo.setWriter("service test");
//        
//        boardservice.write(vo);
//        
//    }
//    
//    @Test
//    public void 게시글보기테스트() {
//    	
//    	List<BoardVO> list = boardservice.getList();
//    	
//    	for(Object a : list) {
//    		log.info("" + a);
//    	}
//    }
//    
//    @Test
//    public void 게시글조회테스트() {
//    	
//    	int bno = 9;
//    	
//    	log.info(""+ boardservice.getPage(bno));
//    }
    
//      @Test
//      public void 게시글수정테스트() {
//    	  
//    	  BoardVO vo = new BoardVO();
//    	  vo.setBno(2);
//    	  vo.setTitle("수정하기1");
//    	  vo.setContent("수정하기2");
//    	  int result = boardservice.modifyPage(vo);
//    	  
//    	  log.info("result" + result);
//      }
    
//    	@Test
//    	public void 게시글삭제테스트() {
//    		
//    		int bno = 4;
//    		
//    		int result = boardservice.delete(bno);
//    		
//    		log.info("result=" + result);
//    	}
//    	
    	@Test
    	public void 페이징테스트() {
    		Criteria cri = new Criteria();
    		cri.setPageNum(3);
    		List<BoardVO> list = boardservice.paging(cri);
    		
    		for(Object a : list) {
    			log.info(""+a);
    		}
    	}
 
}
 