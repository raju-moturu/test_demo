package com.delivary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.delivary.dto.Address;
import com.delivary.dto.ServiceStore;
import com.delivary.dto.User;
import com.delivary.repo.ServiceStoreRepository;
import com.delivary.repo.UserRepository;

@Controller
public class StoreController {

	@Autowired
	private ServiceStoreRepository serviceRepo;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showStores")
	public String showStores() {
		return "findStores";
	}

	@RequestMapping("/AddServiceStore")
	public String addStore(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepo.findByEmail(email);
		if(user==null ) {
			modelMap.addAttribute("msg", "Invalid email");
			return "addStoreLogin";
		}else if(user.getPassword().equals(password)) {
			Long id = user.getId();
			ServiceStore servicestore = serviceRepo.findServiceId(id);
			if(servicestore==null) {
				modelMap.addAttribute("userId", user.getId());
				return "AddDelivaryService";
			}else {
			    modelMap.addAttribute("msg","this user hava already store" );
			    return "addStoreLogin";
			}
		}else {
			 modelMap.addAttribute("msg","invalid credentials" );
			    return "addStoreLogin";
		}
		
		
		

	}

	@RequestMapping("/showAddStore")
	public String showAddServiceStore() {
		return "addStoreLogin";
	}

	@RequestMapping("/findStores")
	public String findStores(@RequestParam("city") String city, @RequestParam("area") String area, ModelMap modelMap) {
		List<ServiceStore> stores = serviceRepo.findStores(city, area);
		if (stores.isEmpty()) {
			modelMap.addAttribute("msg", "No data found");
			return "findStores";
		} else {
			modelMap.addAttribute("stores", stores);
			modelMap.addAttribute("address", area);
			return "displayStores";
		}
	}

	@RequestMapping("/showStoreLogin")
	public String displayStore(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepo.findByEmail(email);

		if (user.getPassword().equals(password)) {
			Long id = user.getId();
			ServiceStore servicestore = serviceRepo.findServiceId(id);
			modelMap.addAttribute("serviceId", servicestore.getId());
			return "AddOrder";
		} else {
			modelMap.addAttribute("msg", "invalid Credentials");
			return "StoreLogin";
		}
	}

	@RequestMapping("/storelogin")
	public String storeLogin() {
		return "StoreLogin";
	}
	
	
	@RequestMapping("/AddService")
	public String addServiceStore(@ModelAttribute("service_store") ServiceStore serviceStore,@RequestParam("doorNo") String doorNo,@RequestParam("street") String street,@RequestParam("area") String area,@RequestParam("village") String village,@RequestParam("distric") String distric,@RequestParam("state") String state,@RequestParam("pincode") String pincode,ModelMap modelMap ) {
		
		
		Address add=new Address();
		add.setDoorNo(doorNo);
		add.setStreet(street);
		add.setArea(area);
		add.setDistric(distric);
		add.setVillage(village);
		add.setState(state);
		add.setPincode(pincode);
		
		serviceStore.setAddress(add);
		
		
		
		serviceRepo.save(serviceStore);
		
		modelMap.addAttribute("msg", "Service store added successfully");
		return "userRegister";
	}
}
