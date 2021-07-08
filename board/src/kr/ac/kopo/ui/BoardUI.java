package kr.ac.kopo.ui;

// BoardUI는 기능클래스
// 원래 extends BaseUI implements 
// 원하는 서비스를 선택하세요 : ~ 기능담당 - BoardUI
public class BoardUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		while(true) {
			// execute 메소드를 인터페이스가 알고 있으므로
			try {
				IBoardUI ui = null; 
				int type = menu();
				switch(type) {
				case 1:
					ui = new SearchAllUI();
					break;
				case 2:
					ui = new SearchOneUI();
					break;
				case 3:
					ui = new AddUI();	// 묵시적 형변환
					//AddUI add = new AddUI();
					//add.execute();
					break;
				case 4:
					ui = new UpdateUI();
					break;
				case 5:
					ui = new DeleteUI();
					break;
				case 0:
					ui = new ExitUI();	// 묵시적 형변환
					//ExitUI exit = new ExitUI();
					//exit.execute();
					break;
				}
				if(ui != null)
					ui.execute();
				else
					System.out.println("잘못 선택하셨습니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private int menu() {
		
		System.out.println("--------------------------");
		System.out.println("\t게시판 관리 프로그램");
		System.out.println("--------------------------");
		System.out.println("\t1. 전체게시글 조회");
		System.out.println("\t2. 글번호 조회");
		System.out.println("\t3. 새글 등록");
		System.out.println("\t4. 게시글 수정");
		System.out.println("\t5. 게시글 삭제");
		System.out.println("\t0. 종료");
		System.out.println("--------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
		
	}
	
}
