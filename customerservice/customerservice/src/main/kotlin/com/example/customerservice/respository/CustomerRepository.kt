package com.example.customerservice.repository

import com.example.customerservice.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerModel, Long>