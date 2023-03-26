package com.alura.forumkt.service

import com.alura.forumkt.model.Curso
import com.alura.forumkt.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)
    }

}
