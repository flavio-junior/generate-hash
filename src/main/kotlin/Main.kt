package br.com

import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

fun main() {
    val encoders: MutableMap<String, PasswordEncoder> = HashMap()
    val pbkdf2Encoder =
        Pbkdf2PasswordEncoder("", 8, 185000, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256)
    encoders["pbkdf2"] = pbkdf2Encoder
    val passwordEncoder = DelegatingPasswordEncoder("pbkdf2", encoders)
    passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder)

    val origin = "admin123"
    val result = passwordEncoder.encode(origin)
    println(origin)
    println("My hash $result")
}