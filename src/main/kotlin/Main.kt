package br.com

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

fun main() {
    val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()
    val origin = "admin123"
    val newValue = passwordEncoder.encode(origin)
    println("Origin: $origin")
    println("New Value: $newValue")
}