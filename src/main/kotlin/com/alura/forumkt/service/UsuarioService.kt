package com.alura.forumkt.service

import com.alura.forumkt.model.Usuario
import com.alura.forumkt.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (private val repository: UsuarioRepository ) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }

}
