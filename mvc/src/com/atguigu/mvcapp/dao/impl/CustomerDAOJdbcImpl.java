package com.atguigu.mvcapp.dao.impl;

import java.util.List;

import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.DAO;
import com.atguigu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		String sql = "SELECT id, name , address ,phone FROM customers ";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name, address,phone) VALUES(?,?,?)";
		update(sql, customer.getName(),  customer.getAddress(), customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id, name, address, phone FROM customer WHERE id = ?";
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM customers WHERE name = ?";
		
		return getForValue(sql, name);
	}

}
