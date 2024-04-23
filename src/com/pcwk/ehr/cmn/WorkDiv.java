package com.pcwk.ehr.cmn;

import java.util.List;

public interface WorkDiv<T> extends PLog {

	/**
	 * 목록 조회 
	 * @param search
	 * @return List<T>
	 */
	public List<T> doRetrieve(DTO search);
	
	
	/**
	 * 단건 저장
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doSave(T param);
	
	/**
	 * 단건 수정
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doUpdate(T param);
	
	
	/**
	 * 단건 삭제
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doDelete(T param);
	
	/**
	 * 단건 조회 
	 * @param param
	 * @return T
	 */
	public T doSelectOne(T param);
	
	/**
	 * 객체를 파일(json) 저정
	 * @return 저장건수
	 */
	public int doSaveFile();
	
	/**
	 *  파일(json) 객체로 변환
	 * @return 저장건수
	 */
	public int doReadFile();
	
	
}
