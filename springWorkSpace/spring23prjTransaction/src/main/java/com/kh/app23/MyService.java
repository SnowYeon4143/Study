package com.kh.app23;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(rollbackFor = Exception.class) checkedException도 롤백처리함
//@Transactional(noRollbackFor = NullPointerException.class) npe이 일어나면 롤백처리 안함
//@Transactional(readOnly = true) select만 가능
public class MyService {

	@Autowired
	private MyDao dao; 
	
//	@Transactional
	public void test() {
		//직접 try ~ catch로 처리하는게 바람직
		try {
		dao.testA();
		dao.testB();
		}catch(Exception e) {
			throw new RuntimeException("checked 익셉션 발생");
		}
	}
	
}
