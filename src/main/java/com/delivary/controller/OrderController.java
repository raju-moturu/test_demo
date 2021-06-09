package com.delivary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.delivary.dto.Address;
import com.delivary.dto.OrderAddress;
import com.delivary.dto.Orders;
import com.delivary.dto.ServiceStore;
import com.delivary.dto.User;
import com.delivary.repo.OrderAddressRepository;
import com.delivary.repo.OrderRepository;
import com.delivary.repo.ServiceStoreRepository;
import com.delivary.repo.UserRepository;

@Controller
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderAddressRepository orderAddRepo;
	
	@Autowired
	private ServiceStoreRepository serviceRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/addOrder")
	public String showAddOrder() {
		return "AddOrder";
	}
	
	@RequestMapping("/showStoreDetails")
	public String displyOrders(@RequestParam("storeId") Long id,ModelMap modelMap) {
		List<Orders> orders=orderRepo.findOrdersByServiceId(id);
	
		if(orders.isEmpty()) {
			modelMap.addAttribute("msg", "No orders available");
			return "displayOrders";
		}
		modelMap.addAttribute("orders", orders);
		return "displayOrders";
	}
	
	@RequestMapping("/addOrderDetails")
	public String addOrderDetails(@ModelAttribute("orders") Orders orders,@RequestParam("doorNo") String doorNo,@RequestParam("street") String street,@RequestParam("area") String area,@RequestParam("village") String village,@RequestParam("distric") String distric,@RequestParam("state") String state,@RequestParam("pincode") String pincode,ModelMap modelMap) {
		Orders order=orderRepo.save(orders);
		OrderAddress orderAdd=new OrderAddress();
		
		Address add=new Address();
		add.setDoorNo(doorNo);
		add.setStreet(street);
		add.setArea(area);
		add.setDistric(distric);
		add.setVillage(village);
		add.setState(state);
		add.setPincode(pincode);
		
		orderAdd.setOrder(order);
		orderAdd.setTo(add);
		
		orderAddRepo.save(orderAdd);
		
		List<Orders> orders1=orderRepo.findOrdersByServiceId(order.getServicestore().getId());
		
		modelMap.addAttribute("msg", "order Add success");
		modelMap.addAttribute("fromId",order.getServicestore().getId() );
		modelMap.addAttribute("orders", orders1);
		return "displayOrders";
	}
	
	
	@RequestMapping("/receivedOrders")
	public String displayRecivedOrders(@RequestParam("serviceId") Long id,ModelMap modelMap) {
		System.out.println();
		ServiceStore service=serviceRepo.getOne(id);
		System.out.println(service);
		List<Orders> orders=orderRepo.findReceiveOrdersByServiceId(service.getId());
		modelMap.addAttribute("orders", orders);
		return "displayReceivedOrders";
	}
	
	
	@RequestMapping("/showReceivedOrders")
	public String displayReceivedStore(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
		   User user=userRepo.findByEmail(email);
		   
		   
		   if(user.getPassword().equals(password)) {
			  Long id=user.getId();
			  ServiceStore servicestore=serviceRepo.findServiceId(id);
			  
			  List<Orders> orders=orderRepo.findReceiveOrdersByServiceId(servicestore.getId());
				modelMap.addAttribute("orders", orders);
				return "displayReceivedOrders";
		
		   }else {
			   modelMap.addAttribute("msg", "invalid Credentials");
			   return "StoreRecivedLogin";
		   }
	}
	
	@RequestMapping("/showReceivedLogin")
	public String displayRecivedLogin() {
		return "StoreRecivedLogin";
	}
	
}
