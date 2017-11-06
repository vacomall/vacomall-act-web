package com.vacomall.act.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import com.vacomall.act.common.controller.SuperController;
import com.vacomall.act.config.ActState;
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
		Integer st = actPsage.getActState();
		if(st == ActState._2){
			model.addAttribute("msg","活动维护中");
			return "act/act-page-error";
		}
		if(st == ActState._3){
			model.addAttribute("msg","该活动已下线");
			return "act/act-page-error";
		}
		if(st == ActState._4){
			model.addAttribute("msg","该活动已被管理员删除");
			return "act/act-page-error";
		}
		model.addAttribute("actPage",actPsage);
		return "act/act-page";
	}
}
