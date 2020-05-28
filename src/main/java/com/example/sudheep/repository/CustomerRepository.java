package com.example.sudheep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sudheep.entity.Customer;

import antlr.collections.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{

}
