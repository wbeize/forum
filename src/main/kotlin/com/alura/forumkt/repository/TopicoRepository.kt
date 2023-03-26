package com.alura.forumkt.repository

import com.alura.forumkt.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}