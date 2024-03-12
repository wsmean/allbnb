package com.sumin.allbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sumin.allbnb.MembersService;
import com.sumin.allbnb.MembersVO;
import com.sumin.allbnb.impl.MembersDAO;

@Controller
@SessionAttributes("members")
public class MembersController {
	
	@Autowired
	MembersService membersService;
	
	public MembersController() {
		System.out.println("memberscontroller진입");
		}
	
	@RequestMapping("/admin.do")
	public String loadMembersList(MembersVO vo, MembersDAO membersDAO, Model model) {
		System.out.println("멤버 조회 처리 ");
		model.addAttribute("membersList", membersService.loadMembersList());
		System.out.println("이거는 : "+membersService.loadMembersList());
		return "admin.jsp";
		
	}
	
	@RequestMapping("/deleteMembers.do")
	public String deleteMembers(MembersVO vo, MembersDAO membersDAO) {
		System.out.println("멤버삭제처리");
		membersService.deleteMembers(vo);
		return "admin.do";
		
	}
	
}
