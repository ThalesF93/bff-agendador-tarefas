package com.thales.bffagendador_tarefas.InfraStructure.client;



import com.thales.bffagendador_tarefas.Business.dto.TarefasDTO;
import com.thales.bffagendador_tarefas.InfraStructure.Enuns.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-Tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTO gravarTarefas(@RequestBody TarefasDTO dto,
                             @RequestHeader("Authorization") String token);


    @GetMapping("/eventos")

    List<TarefasDTO> buscaListaDeTaredasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTO> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
   void detelaTarefaPorId(@RequestParam("id") String id,
                          @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTO alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                       @RequestParam("id") String id,
                                       @RequestHeader("Authorization") String token);



    @PutMapping
   TarefasDTO updateTarefas(@RequestBody TarefasDTO dto,
                            @RequestParam("id") String id,
                            @RequestHeader("Authorization") String token);
}
