package com.kh.app23;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(rollbackFor = Exception.class) checkedException�� �ѹ�ó����
//@Transactional(noRollbackFor = NullPointerException.class) npe�� �Ͼ�� �ѹ�ó�� ����
//@Transactional(readOnly = true) select�� ����
public class MyService {

	@Autowired
	private MyDao dao; 
	
//	@Transactional
	public void test() {
		//���� try ~ catch�� ó���ϴ°� �ٶ���
		try {
		dao.testA();
		dao.testB();
		}catch(Exception e) {
			throw new RuntimeException("checked �ͼ��� �߻�");
		}
	}
	
}
