package kr.ac.kopo.ui;

import kr.ac.kopo.vo.BoardVO;

public class SearchOneUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		int no = scanInt("조회할 글번호를 입력하세요 : ");
		BoardVO vo = service.하나글조회(no); 
		
		System.out.println("--------------------------------");
		System.out.println("\t번    호 : " + vo.getNo());
		System.out.println("\t제    목 : " + vo.getTitle());
		System.out.println("\t글 쓴  이 : " + vo.getWriter());
		System.out.println("\t등 록  일 : " + vo.getRegDate());
		System.out.println("--------------------------------");
		

	}

}
