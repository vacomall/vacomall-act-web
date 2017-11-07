package com.vacomall.act.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.vacomall.act.common.controller.SuperController;
import com.vacomall.act.entity.ActPage;
import com.vacomall.act.service.IActPageService;

@Controller
@RequestMapping(value = "/actpage")
public class ActPageController extends SuperController{

	@Autowired
	private IActPageService actPageService;

	@RequestMapping(value="/{id}")
	public String index(@PathVariable Long id,Model model) {
		ActPage actPsage = actPageService.findOne(id);
		if(actPsage == null){
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		model.addAttribute("actPage",actPsage);
		return "act/act-page";
	}
}
