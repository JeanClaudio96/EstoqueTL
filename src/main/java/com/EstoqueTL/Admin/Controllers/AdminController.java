package com.EstoqueTL.Admin.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@GetMapping(value = "/")
	public String AdminGet(Model model) {
		return "admin/adminPage";
	}
}