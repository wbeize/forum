package com.alura.forumkt.mapper

import com.alura.forumkt.dto.TopicoView
import com.alura.forumkt.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView (
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}