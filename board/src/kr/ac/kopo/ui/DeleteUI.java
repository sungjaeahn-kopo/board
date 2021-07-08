package kr.ac.kopo.ui;

public class DeleteUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		int no = scanInt("삭제할 게시물 번호를 입력하세요 : ");
		boolean bool = service.글삭제서비스(no);
		if(bool == true) {
			System.out.println("[" + no + "]번 게시물을 삭제하였습니다");
		} else {
			System.out.println("[" + no + "]번 게시물을 삭제하지 못하였습니다");
		}
		
	}

}
