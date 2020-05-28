package com.example.sudheep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sudheep.entity.Customer;
import com.example.sudheep.repository.CustomerRepository;

@SpringBootTest
class BasicCruDoperationsApplicationTests {

	@Autowired
	CustomerRepository repos;
	
	Customer customer = new Customer();
	Customer customer2 = new Customer();
	
	@Test
	void contextLoads() 
	{
	}
	
	@Test
	void SaveCustomer()
	{
//		customer.setId(1);
//		customer.setName("sudheep");
//		customer.setEmail("sudheep@Example.com");
//		
//		repos.save(customer);
		customer2.setEmail("example@ex.com");
		customer2.setName("example");
		repos.save(customer2);
	}
	
	@Test
	void findAllCustomers()
	{
		List<Customer> customers = repos.findAll();
//		System.out.println(customers.);
		for(Customer c : customers)
		{
			System.out.println(c.getId());
			System.out.println(c.getName());
			System.out.println(c.getEmail());
		}
	}
	
	
	@Test
	void findByIdCustomers()
	{
	Optional<Customer> customer = repos.findById(1);
	System.out.println(customer.get().getId());
	System.out.println(customer.get().getName());
	System.out.println(customer.get().getEmail());
	}
	
	@Test
	void update()
	{
		Optional<Customer> optional = repos.findById(1);
		Customer customer3 = optional.get();
		customer3.setName("sai");
		repos.save(customer3);
	}
	
	@Test
	void delete()
	{
		repos.deleteById(3);
	}
	
	@Test
	void deleteAll()
	{
		repos.deleteAll();
	}
	
	List<Customer> cus = new ArrayList<>();
	
	@Test
	void deleteIterator()
	{
		cus.add(customer2);
		
		Iterable<? extends Customer> entities = cus;
		repos.deleteAll(entities);
	}
	
	@Test
	void CountRows()
	{
		long l = repos.count();
		System.out.println(l);
	}

}
