package com.pcwk.ehr.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pcwk.ehr.cmn.Box;
import com.pcwk.ehr.cmn.PLog;

public class MainCtrl implements PLog {

	MemberDTO member01;
	MemberDTO member02;
	MemberDTO member03;
	
	List<MemberDTO> box;
	
	MemberDao     dao;	
	
	MemberController  memberController;
	
	public MainCtrl() {
		member01 = new MemberDTO("james01", "이상무01", "a4321", "james01@naver.com", "010-1234-5678", "2024-04-19", "admin");
		member02 = new MemberDTO("james02", "이상무02", "a4321", "james02@naver.com", "010-1234-5679", "2024-04-19", "admin");
		member03 = new MemberDTO("james03", "이상무03", "a4321", "james03@naver.com", "010-1234-5680", "2024-04-19", "admin");
		
		box = new ArrayList<MemberDTO>();
		box.add(member01);
		box.add(member02);
		box.add(member03);
		
		
		dao = new MemberDao();
		
		//항상 3명 Member로 시작하기 위해
		dao.setListBox(box);
		dao.doSaveFile();		
		
		//controller객체 생성
		memberController = new MemberController();
		
		//menu
		System.out.println(menuString());
		
		//
		doActionMenu();
	}
	
	public void doActionMenu() {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.print("Menu를 선택 하세요.>");
			String menuInput = scanner.nextLine().trim();
			
			switch(menuInput) {
			case "1":
				List<MemberDTO> list = memberController.doRetrieve();
				for(MemberDTO dto :list) {
					System.out.println(dto);
				}
				break;
				
			case "2":
				MemberDTO member = memberController.doSelectOne();
				if(null != member) {
					System.out.println("단건 조회 되었습니다.");
				}else {
					System.out.println("회원 ID를 확인 하세요.");
				}
				
			case "3":
				int flagSave = memberController.doSave();
				if(1==flagSave) {
					System.out.println("등록 되었습니다.");
				}else {
					System.out.println("등록 실패.");
				}
				
				break;
				
			case "4":
				int flagUpdate = memberController.doUpdate();
				if(2==flagUpdate) {
					System.out.println("수정 되었습니다.");
				}else {
					System.out.println("수정 실패.");
				}				
				break;
			case "5":
				int flag = memberController.doDelete();
				if(1==flag) {
					System.out.println("삭제 되었습니다.");
				}else {
					System.out.println("삭제 실패.");
				}
				
				break;
			case "6":
				memberController.doSaveFile();
				System.out.println("┌─────────────────────────────────┐");
				System.out.println("│프로그램 종료!                      │");
				System.out.println("└─────────────────────────────────┘");
				System.exit(0);//프로그램 종료!
				break;
			default:
				System.out.println("Menu를 확인 하세요.");
				break;
				
			}
			
		}
		
	}
	/**
	 * console menu
	 * @return menu
	 */
	public String menuString() {
		StringBuilder sb = new StringBuilder(1500);
		sb.append(" +-+-+-+-+ +-+-+-+-+ +-+-+-+-+-+-+-+ \n");
		sb.append(" |M|i|n|i| |J|a|v|a| |P|r|o|j|e|c|t| \n");
		sb.append(" +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ \n");
		sb.append(" |2|0|2|4|.|0|4|.|2|4|               \n");
		sb.append(" +-+-+-+-+-+-+-+-+-+-+               \n");
		sb.append("  *** 회원 관리 프로그램 ***    \n");
		sb.append("  1. 회원 목록 조회                    \n");
		sb.append("  2. 회원 단건 조회                    \n");
		sb.append("  3. 회원 단건 저장                    \n");
		sb.append("  4. 회원 수정                           \n");
		sb.append("  5. 회원 삭제                           \n");
		sb.append("  6. 종료                                  \n");

		return sb.toString();
	}
	
	public static void main(String[] args) {
		MainCtrl mc=new MainCtrl();
		
	}

}
