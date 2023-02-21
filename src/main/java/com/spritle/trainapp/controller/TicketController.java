package com.spritle.trainapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.xml.IfTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotation.Adapt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.spritle.trainapp.dao.TicketDao;
import com.spritle.trainapp.dto.Agent;
import com.spritle.trainapp.dto.Booking;
import com.spritle.trainapp.dto.CoachDto;
import com.spritle.trainapp.dto.SuperAdmin;
import com.spritle.trainapp.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService service;

	@GetMapping("/index")
	public ModelAndView getHomePage(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/sup-admin")
	public ModelAndView getAddSupAdminPage(ModelAndView modelAndView) {
		modelAndView.setViewName("super-admin");
		return modelAndView;
	}

	@GetMapping("/sup-admin-register")
	public ModelAndView getAddSupAdminRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("super-admin-register");
		return modelAndView;
	}

	@GetMapping("/super-admin-add")
	public String saveAdmin(SuperAdmin admin, Model myModel) {
		SuperAdmin supadmin = service.saveSupadmin(admin);
		if (supadmin != null) {
			return "super-admin-login";
		} else {
			return "redirect:/super-admin-register";
		}
	}

	@GetMapping("/sup-admin-login")
	public ModelAndView getSupAdminLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("super-admin-login");
		return modelAndView;
	}

	@Autowired
	private TicketDao ticDao;

	@PostMapping("/sup-login-authendicate")
	public ModelAndView validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request, ModelAndView modelAndView, Model model) {
		SuperAdmin admin = new SuperAdmin();
		HttpSession session = request.getSession(true);

		if (ticDao.validateLogin(email, password)) {
			SuperAdmin admin1 = service.getAllAdmin1(email);
			model.addAttribute("admin", admin1);
			modelAndView.setViewName("super-admin-fuction");
			return modelAndView;
		} else
			modelAndView.setViewName("super-admin-login");
		return modelAndView;

	}

	@GetMapping("/agent-register")
	public ModelAndView getAgentLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("agent-add-page");
		return modelAndView;
	}

	@PostMapping("/agent-save")
	public String saveAgent(Agent agent, Model myModel) {
		System.out.println(agent);
		Agent agent1 = service.saveAgent(agent);
		if (agent1 != null) {
			return "ticket-booking-page";
		} else {
			return "redirect:/agent-add-page";
		}

	}

	@GetMapping("/list-all")
	public ModelAndView listAllEmployees(ModelAndView modelAndView, Model model) {
		List<Agent> allAgent = ticDao.getAllAgent();
		System.out.println(allAgent);
		model.addAttribute("agents", allAgent);
		modelAndView.setViewName("displayAll-agent");

		return modelAndView;
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("agentId") int id, Model model) {
		Agent deletedAgent = service.deleteEmployee(id);
		if (deletedAgent == null) {
			return "redirect:/super-admin-fuction";
		}
		return "forward:/list-all";
	}

	@GetMapping("/agent-login")
	public ModelAndView getAgentLogin(ModelAndView modelAndView) {
		modelAndView.setViewName("agent-login-page");
		return modelAndView;
	}

	@PostMapping("/agent-login-authendicate")
	public ModelAndView ValidatAgent(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request, ModelAndView modelAndView) {
		Agent agent = new Agent();
		HttpSession session = request.getSession(true);

		if (ticDao.agentLoginValidate(email, password)) {
			modelAndView.setViewName("ticket-booking-page");
			return modelAndView;
		} else
			modelAndView.setViewName("agent-login-page");
		return modelAndView;

	}

	@GetMapping("/compartment")
	public ModelAndView getCompartment(ModelAndView modelAndView) {
		modelAndView.setViewName("compartment-allocation");
		return modelAndView;
	}

	@GetMapping("/compartmentCreation")
	public ModelAndView getTable(ModelAndView modelAndView, @RequestParam("rows") int seat, Model model) {
		service.seatCreat(seat);
		ArrayList<Integer> list = new ArrayList<Integer>();
		model.addAttribute("allList", seat);
		modelAndView.setViewName("compartment-table");
		return modelAndView;
	}

	@PostMapping("/save-booking")
	public String saveBooking(Booking book, Model model) {

		System.out.println(book);
		Booking booked = service.saveBooking(book);
		if (booked != null) {
			List<CoachDto> allSeats = service.getAvailableSeats();
			for (CoachDto coachDto : allSeats) {
				if (book.getAge() >= 60 || book.getGender().equals("Female")) {
					if (isWindowSeat(coachDto.getSeatNo())) {
						// book
						coachDto.setStatus(true);
						coachDto.setBookId(booked.getBookingId());
						ticDao.updateStatus(coachDto);
						return "end-page";
					}
				} else {
					coachDto.setStatus(true);
					coachDto.setBookId(booked.getBookingId());

					ticDao.updateStatus(coachDto);
					return "end-page";
				}
			}
		}
		return null;
	}

	private boolean isWindowSeat(int seatNo) {
		ArrayList<Integer> windowSeats = new ArrayList<>();
		int n = 0;
		while(seatNo >= n) {
			windowSeats.add(6*n);
			windowSeats.add(6*n +1);
			n++;
		}
		return windowSeats.contains(seatNo);
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, ModelAndView view) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		view.setViewName("index");
		return view;
	}

}
