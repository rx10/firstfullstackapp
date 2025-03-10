package com.example.customerservice.controller

import com.example.customerservice.model.CustomerModel
import com.example.customerservice.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping("/api/customers")
class CustomerController(private val service: CustomerService) {

    @PostMapping
    fun createCustomer(@RequestBody customer: CustomerModel): ResponseEntity<CustomerModel> {
        return ResponseEntity.ok(service.createCustomer(customer))
    }

    @GetMapping
    fun getAllCustomers(): ResponseEntity<List<CustomerModel>> = ResponseEntity.ok(service.getAllCustomers())

    @GetMapping("/{customerId}")
    fun getCustomerById(@PathVariable customerId: Long): ResponseEntity<CustomerModel> =
        ResponseEntity.ok(service.getCustomerById(customerId))

    @PutMapping("/{customerId}")
    fun updateCustomer(@PathVariable customerId: Long, @RequestBody updatedCustomer: CustomerModel): ResponseEntity<CustomerModel> =
        ResponseEntity.ok(service.updateCustomer(customerId, updatedCustomer))

    @DeleteMapping("/{customerId}")
    fun deleteCustomer(@PathVariable customerId: Long): ResponseEntity<String> {
        service.deleteCustomer(customerId)
        return ResponseEntity.ok("Customer deleted successfully")
    }
}