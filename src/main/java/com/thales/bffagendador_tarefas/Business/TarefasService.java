package com.thales.bffagendador_tarefas.Business;
import com.thales.bffagendador_tarefas.Business.dto.TarefasDTO;
import com.thales.bffagendador_tarefas.InfraStructure.Enuns.StatusNotificacaoEnum;
import com.thales.bffagendador_tarefas.InfraStructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTaredasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {

        tarefasClient.detelaTarefaPorId(id, token);
    }

    public TarefasDTO alteraStatus(StatusNotificacaoEnum status, String id, String token) {

        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTO dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);
    }

}
