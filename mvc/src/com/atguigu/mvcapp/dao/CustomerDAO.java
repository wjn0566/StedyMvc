package com.atguigu.mvcapp.dao;

import java.util.List;

import com.atguigu.mvcapp.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAll();
	
	public  void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/**
	 * ���غ�name��ȵļ�¼����
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
