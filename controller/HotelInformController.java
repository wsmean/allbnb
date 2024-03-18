package com.sumin.allbnb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sumin.allbnb.HotelInformVO;
import com.sumin.allbnb.HotelService;
import com.sumin.allbnb.impl.HotelInformDAO;

@Controller
@SessionAttributes("hotel")
public class HotelInformController {
	
	@Autowired
	HotelService hotelService;
	
	public HotelInformController() {
		System.out.println("hotelInformController");
	}
	
	@RequestMapping("/hotelInform.do")
	public String loadHotelList(HotelInformVO vo, HotelInformDAO hotelDAO, Model model) {
		System.out.println("호텔 조회 처리 ");
		model.addAttribute("hotelList", hotelService.loadHotelList());
//		System.out.println("이거는 : "+hotelService.loadHotelList());
		return "main.jsp";
		
	}
	
	@RequestMapping("/hotelCountryInform.do")
	public String loadHotelCountryList(String country_name, HotelInformVO vo, HotelInformDAO hotelDAO, Model model) {
		System.out.println("값왔다!" + country_name);
		vo.setCountry_name(country_name);
		System.out.println("검색 : "+vo.getCountry_name());
		System.out.println("호텔 나라별 조회");
		model.addAttribute("hotelList",hotelService.loadHotelCountryList(vo));
		return "main.jsp";
		
	}
	
	@RequestMapping("/detail.do")
	public String loadDetailList(String hotel_title,HotelInformVO vo, HotelInformDAO hotelDAO, Model model) {
		System.out.println("값이 왔나? : "+hotel_title);
		vo.setHotel_title(hotel_title);
		System.out.println("검색: "+vo.getHotel_title());
		System.out.println("호텔 상세 정보 처리");
		model.addAttribute("hotelList",hotelService.loadHotelDetail(vo));
		return "detail.jsp";
		
	}
	
	@RequestMapping("/payment.do")
	public String loadpaymentList(String hotel_title,HotelInformVO vo, HotelInformDAO hotelDAO, Model model) {
		System.out.println("호텔 타이틀 : "+hotel_title);
		vo.setHotel_title(hotel_title);
		System.out.println("검색: "+vo.getHotel_title());
		System.out.println("호텔 다음 정보 처리");
		model.addAttribute("hotelList",hotelService.loadHotelDetail(vo));
		return "payment.jsp";
		
	}
	

	
}
