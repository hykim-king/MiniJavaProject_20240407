package com.pcwk.ehr.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class MemberController implements PLog {

	private MemberDao dao;


	public MemberController() {
		dao = new MemberDao();
		

	}

	public int doSaveFile() {
		return dao.doSaveFile();
	}

	public List<MemberDTO> doRetrieve() {
		List<MemberDTO> list=new ArrayList<MemberDTO>();
		SearchDTO   search=new SearchDTO();
		// 1.Scanner
		// 2.검색할 사용자 정보
		// 3.dao.doSave(MemberDTO)
		Scanner scanner = new Scanner(System.in);		
		System.out.print("수정할 회원 정보를 입력 하세요.>"
				+ "\n( , )"
				+ "\n(10,이상무01)"
				+ "\n(20,james01@naver.com)"				
		        + "\n(30,010-1234-5680)");		
		String inputData = scanner.nextLine().trim();
		LOG.debug("inputData: " + inputData);		
		String[] strSearch=inputData.split(",");
		search = new SearchDTO(strSearch[0], strSearch[1]);
		
		list = dao.doRetrieve(search);
		return list;
	}
	
	
	public int doUpdate() {
		int flag = 0;
		MemberDTO param = new MemberDTO();// MemberDao 파라메터
		// 1.Scanner
		// 2.수정할 사용자 정보
		// 3.dao.doSave(MemberDTO)
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 회원 정보를 입력 하세요.>"
				+ "\n(james01,이상무33,a4321,james33@naver.com,010-1234-5680,2024-04-19,admin)");		
		String inputData = scanner.nextLine().trim();
		LOG.debug("inputData: " + inputData);
		String[] strMember=inputData.split(",");
		
		param = new MemberDTO(strMember[0], 
				              strMember[1], 
				              strMember[2], 
				              strMember[3], 
				              strMember[4], 
				              strMember[5], 
				              strMember[6]);
		
		// dao호출
		flag = dao.doUpdate(param);
		return flag;
	}
	public int doSave() {
		int flag = 0;
		MemberDTO param = new MemberDTO();// MemberDao 파라메터
		// 1.Scanner
		// 2.등록할 사용자 정보
		// 3.dao.doSave(MemberDTO)
		Scanner scanner = new Scanner(System.in);
		System.out.print("등록할 회원 정보를 입력 하세요.>"
				+ "\n(james33,이상무33,a4321,james33@naver.com,010-1234-5680,2024-04-19,admin)");		
		String inputData = scanner.nextLine().trim();
		LOG.debug("inputData: " + inputData);
		String[] strMember=inputData.split(",");
		
		param = new MemberDTO(strMember[0], 
				              strMember[1], 
				              strMember[2], 
				              strMember[3], 
				              strMember[4], 
				              strMember[5], 
				              strMember[6]);
		// dao호출
		flag = dao.doSave(param);
		return flag;
	}
	
	public int doDelete() {
		int flag = 0;
		MemberDTO param = new MemberDTO();// MemberDao 파라메터
		// 1.Scanner
		// 2.조회할 사용자 memberId
		// 3.dao.doDelete(MemberDTO)
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("단건 삭제할 회원ID를 입력 하세요.>\n(james01)");
		String inputData = scanner.nextLine().trim();
		LOG.debug("inputData: " + inputData);
		param.setMemberId(inputData);
		LOG.debug("param: " + param);
		
		// dao호출
		flag = dao.doDelete(param);
		
		return flag;
	}
	public MemberDTO doSelectOne() {
		MemberDTO outVO = null;// return
		MemberDTO param = new MemberDTO();// MemberDao 파라메터
		// 1.Scanner
		// 2.조회할 사용자 memberId
		// 3.dao.doSelectOne(MemberDTO)
		Scanner scanner = new Scanner(System.in);
		System.out.print("단건 조회할 회원ID를 입력 하세요.>\n(james01)");

		String inputData = scanner.nextLine().trim();
		LOG.debug("inputData: " + inputData);
		param.setMemberId(inputData);
		LOG.debug("param: " + param);

		// dao호출
		outVO = dao.doSelectOne(param);
		LOG.debug("outVO: " + outVO);

		return outVO;
	}

}
