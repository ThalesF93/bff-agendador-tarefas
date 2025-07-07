package com.thales.bffagendador_tarefas.InfraStructure.client;



import com.thales.bffagendador_tarefas.Business.dto.TarefasDTO;
import com.thales.bffagendador_tarefas.InfraStructure.Enuns.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefasDTO dto);
}
