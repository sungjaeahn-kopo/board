package kr.ac.kopo.dao;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {

	private List<BoardVO> list;
	
	public BoardDAO() {
		list = new ArrayList<>();
	}
	
	/*
	 * 전체 게시글 조회
	 */
	
	public List<BoardVO> 전체게시글조회() throws Exception {
		
		return list;
	}
	
	public BoardVO 글번호조회(int no) throws Exception {
		
		for(BoardVO board : list) {
			if(board.getNo() == no)
				return board;
		}
		
		return null;
	}
	
	// 원래 인자를 4개 받아야하지만, BoardVO 객체에 담아두고 인자로 받음
	// VO 형태로 데이터를 주고받음
	public void 새글등록(BoardVO newBoard) {
		list.add(newBoard);
	}
	
	public void 게시글수정(BoardVO board) {
		
		for(BoardVO vo : list)  {
			if(vo.getNo() == board.getNo()) {
				vo.setTitle(board.getTitle());
				return;
			}
		}
	}
	
	public void 게시글삭제(int no) {
		
		for(BoardVO vo : list) {
			if(vo.getNo() == no) {
				list.remove(vo);
				return;
			}
		}
	}

	
	
	
	
}










