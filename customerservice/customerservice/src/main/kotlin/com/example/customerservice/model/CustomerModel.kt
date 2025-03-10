package com.example.customerservice.model

import jakarta.persistence.*

@Entity
data class CustomerModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val firstName: String,
    val lastName: String,
    val email: String
)