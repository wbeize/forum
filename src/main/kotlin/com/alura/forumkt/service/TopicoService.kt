package com.alura.forumkt.service

import com.alura.forumkt.dto.AtualizacaoTopicoForm
import com.alura.forumkt.dto.NovoTopicoForm
import com.alura.forumkt.dto.TopicoView
import com.alura.forumkt.exception.NotFoundException
import com.alura.forumkt.mapper.TopicoFormMapper
import com.alura.forumkt.mapper.TopicoViewMapper
import com.alura.forumkt.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "topico nao encontrado"
    ) {

    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}