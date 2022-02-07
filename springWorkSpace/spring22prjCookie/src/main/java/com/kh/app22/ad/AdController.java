package com.kh.app22.ad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {
	@GetMapping("/ad")
	public String ad() {
		return "ad";
	}
}
