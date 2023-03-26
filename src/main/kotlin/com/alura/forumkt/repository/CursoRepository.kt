package com.alura.forumkt.repository

import com.alura.forumkt.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}