package com.example.customerservice.service

import com.example.customerservice.model.CustomerModel
import com.example.customerservice.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val repository: CustomerRepository) {

    fun createCustomer(customer: CustomerModel): CustomerModel = repository.save(customer)

    fun getAllCustomers(): List<CustomerModel> = repository.findAll()

    fun getCustomerById(customerId: Long): CustomerModel =
        repository.findById(customerId).orElseThrow { RuntimeException("Customer not found") }

    fun updateCustomer(customerId: Long, updatedCustomer: CustomerModel): CustomerModel {
        val existingCustomer = getCustomerById(customerId)
        val updatedEntity = existingCustomer.copy(
            firstName = updatedCustomer.firstName,
            lastName = updatedCustomer.lastName,
            email = updatedCustomer.email
        )
        return repository.save(updatedEntity)
    }

    fun deleteCustomer(customerId: Long) {
        if (!repository.existsById(customerId)) {
            throw RuntimeException("Customer not found")
        }
        repository.deleteById(customerId)
    }
}