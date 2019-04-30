package com.okaplan.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.Dao.CustomerDAO;
import com.okaplan.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject DAO
	
	@Autowired
	private CustomerDAO customerDao;
	
	@Transactional
	public List<Customer> getCustomers() {
	
		
		return customerDao.getCustomers();
	}
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(thecustomer);
		
	}
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		
		return customerDao.getCustomer(theId);
		
	}
	@Transactional
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(theId);
		
	}
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomer(theSearchName);
	}

}
