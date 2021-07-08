package kr.ac.kopo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.dao.BoardDAODB;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {

//	private BoardDAO dao;
	private BoardDAODB dao;
	
	public BoardService() {
//		dao = new BoardDAO();
		dao = new BoardDAODB();
	}
	
	public void 새글등록서비스(BoardVO newBoard) throws Exception {
		// 등록할 게시물번호 추출
		newBoard.setNo(BoardSequence.getNo());
		
		// 등록날짜 추출
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		newBoard.setRegDate(sdf.format(new Date()));
		dao.새글등록(newBoard);
	}
	
	public List<BoardVO> 전체게시글조회서비스() throws Exception {
		List<BoardVO> list = dao.전체게시글조회();
		return list;
	}
	
	public BoardVO 하나글조회(int no) throws Exception {
		BoardVO vo = dao.글번호조회(no);
		return vo;
		
	}
	
	public boolean 글수정서비스(int no, String title) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		
		boolean bool = false;
		int row = dao.게시글수정(vo);
		
		if(row != 0) {
			bool = true;
		} else {
			bool = false;
		}
		
		return bool;
	}
	
	public boolean 글삭제서비스(int no) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		
		boolean bool = false;
		int row = dao.게시글삭제(vo);
		
		if(row != 0) {
			bool = true;
		} else {
			bool = false;
		}
		
		return bool;
	}
	
	
}
