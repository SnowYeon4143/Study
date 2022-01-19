package com.kh.app05.color;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app05.color.model.vo.ColorVo;

@Controller
@RequestMapping("/color")
public class ColorController {
	
	@GetMapping("/select_color")
	public String selectColor() {
		return "color/select_color";
	}
	
	@PostMapping("/select_color")
	public String selectColor(@ModelAttribute ColorVo colorVo) {
		//다중 파라미터 처리
//		1. String[] colors = req.getParameterValues("color");
//		2. 파라미터 (String[] 변수)
//		3. @RequestParam List<String>
//		4. Model > filed // String[] // List<>

		String[] colors = colorVo.getColor();
				
		for(String s : colors) {
			System.out.println(s);
		}
		return "redirect:/color/select_color";
	}
}
