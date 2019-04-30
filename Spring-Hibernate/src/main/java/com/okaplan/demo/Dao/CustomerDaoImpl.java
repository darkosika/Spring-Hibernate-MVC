package com.okaplan.demo.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.okaplan.demo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	//inject SessionFactory
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Customer> getCustomers() {
		
		//get current Hibernate Session
		Session currentSession=sessionFactory.getCurrentSession();
		//Create query
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName",Customer.class);
		//Execute and get ResultList
		List<Customer> customers=theQuery.getResultList();
		//return
		
		return customers;
	}


	public void saveCustomer(Customer thecustomer) {
		// TODO Auto-generated method stub
		//get current Hibernate Session
		
		Session currentSession=sessionFactory.getCurrentSession();
		//save customer to DB
		currentSession.saveOrUpdate(thecustomer);
	}


	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		//get current Hibernate Session
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		//now retrieve/read from db with primary key
		Customer Thecustomer=currentSession.get(Customer.class, theId);
		
		return Thecustomer;
	}


	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
		//get current Hibernate Session
		Session currentSession=sessionFactory.getCurrentSession();
		//delete from db
		Query theQuery=currentSession.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		theQuery.executeUpdate();
	}


	public List<Customer> searchCustomer(String theSearchName) {
		// TODO Auto-generated method stub
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
        
	}

}
