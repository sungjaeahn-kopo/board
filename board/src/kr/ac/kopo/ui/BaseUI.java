package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.BoardServiceFactory;

// 실제 UI기능을 하지 않아 오버라이드를 할 필요가 없기 때문에 abstract로 선언해도 무방
public abstract class BaseUI implements IBoardUI{

	private Scanner sc;
	protected BoardService service;

	public BaseUI() {
		sc = new Scanner(System.in);
		service = BoardServiceFactory.getInstance();
	}
	
	// 같은 패키지가 아니더라도 상속관계면 사용가능
	protected String scanStr(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanStr(msg));
		return num;
	}
	
	
}
