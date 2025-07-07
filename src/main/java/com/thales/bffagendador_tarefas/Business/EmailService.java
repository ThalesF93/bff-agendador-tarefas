package com.thales.bffagendador_tarefas.Business;
import com.thales.bffagendador_tarefas.Business.dto.TarefasDTO;
import com.thales.bffagendador_tarefas.InfraStructure.Enuns.StatusNotificacaoEnum;
import com.thales.bffagendador_tarefas.InfraStructure.client.EmailClient;
import com.thales.bffagendador_tarefas.InfraStructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTO dto) {
        emailClient.enviarEmail(dto);
    }


}
