package com.okaplan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.okaplan.demo.Service.CustomerService;
import com.okaplan.demo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get customers from Service
		List<Customer> Thecustomers=customerService.getCustomers();
		//Add them to model
		theModel.addAttribute("customers", Thecustomers);	
		return "list-customers";
	}
	
	
	@GetMapping("/ShowAddForm")
	public String addCustomers(Model theModel) {
		Customer Thecustomer=new Customer();
		theModel.addAttribute("customer",Thecustomer);
		return "add-customer";
	}
	
	@PostMapping("/SaveCustomer")
	public String saveCustomers(@ModelAttribute("customer") Customer Thecustomer) {
		
		//save the customer by using Service
		customerService.saveCustomer(Thecustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomers(@RequestParam("customerId") int theId, Model theModel) {
		
		//get customer from DB
		Customer theCustomer=customerService.getCustomer(theId);
		//set customer as model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer by using Service
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName,
            Model theModel) {
		
		// search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
	}
}
