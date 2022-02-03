package com.kh.app18;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
//위의 3개 @Data가 포함
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVo {
	private String id;
	private String pwd;
	private String name;
	
//	public MemberVo(String id, String pwd, String name) {
//		this.id = id;
//		this.pwd = pwd;
//		this.name = name;
//	}
	
}
