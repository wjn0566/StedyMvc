package com.atguigu.mvcapp.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.atguigu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImplTest {

	private CustomerDAO  customerDAO = new CustomerDAOJdbcImpl();
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setAddress("Anhui");
		customer.setName("Jerry");
		customer.setPhone("13911111234");
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cus = customerDAO.get(1);
		System.out.println(cus);
	}

	@Test
	public void testDelete() {
		customerDAO.delete(1);
	}

	@Test
	public void testGetCountWithName() {
		long conuts = customerDAO.getCountWithName("ABC");
		System.out.println(conuts);
	}

}
