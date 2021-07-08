package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAODB {

	private List<BoardVO> list;
	
	public BoardDAODB() {
		list = new ArrayList<>();
	}
	
	/*
	 * 전체 게시글 조회
	 */
	
	public List<BoardVO> 전체게시글조회() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO vo = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tbl_board order by no");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setNo(rs.getInt("no" ));
				vo.setRegDate(rs.getString("reg_date"));
				vo.setTitle(rs.getString("Title"));
				vo.setWriter(rs.getString("Writer"));
				list.add(vo);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		
		return list;
	}
	
	public BoardVO 글번호조회(int no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		BoardVO vo = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tbl_board where no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs.getFetchSize());
			while(rs.next()) {
				vo = new BoardVO();
				vo.setNo(no);
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegDate(rs.getString("reg_date"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return vo;
	}
	
	
	public void 새글등록(BoardVO newBoard) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tbl_board(no, title, writer)" );			
			sql.append("	values(seq_tbl_board_no.nextval, ?, ?)" );
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getWriter());

			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(conn, pstmt);
		}
		
	}
	
	public int 게시글수정(BoardVO board) {
		boolean bool = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			// append 이어붙이기
			sql.append("update tbl_board set title = ? where no = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setInt(2, board.getNo());
			
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return row;
	}
	
	public int 게시글삭제(BoardVO board) {
		int row = 0;
		// Connection conn = new Connection(); -> 왜 안되는지?
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 임시로 커넥션 객체 생성
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			// sql 추가
			sql.append("delete from tbl_board where no = ? ");
			// sql 불러오기
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getNo());
			
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		JDBCClose.close(conn, pstmt);
	}
		
		
		
		return row;
			
	}

	
	
	
	
}










