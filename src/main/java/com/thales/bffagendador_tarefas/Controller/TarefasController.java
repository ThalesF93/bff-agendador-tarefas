package com.thales.bffagendador_tarefas.Controller;


import com.thales.bffagendador_tarefas.Business.TarefasService;

import com.thales.bffagendador_tarefas.Business.dto.TarefasDTO;
import com.thales.bffagendador_tarefas.InfraStructure.Enuns.StatusNotificacaoEnum;
import com.thales.bffagendador_tarefas.InfraStructure.Security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "cadastra tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salva Tarefas", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca Tarefas por Período", description = "Busca terefas cadastradas por período")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTaredasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca lista de tarefas por Email de usuário", description = "Busca de terefas cadastradas por usuárioo")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta Tarefas por Id", description = "Deleta terefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> detelaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token) {

        tarefasService.deletaTarefaPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status Tarefas por Período", description = "Altera status das terefas cadastradas ")
    @ApiResponse(responseCode = "200", description = "Tarefa altereda com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                              @RequestParam("id") String id,
                                                              @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Atualiza Tarefas por Período", description = "Atualiza terefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTO dto, @RequestParam("id") String id,
                                                    @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
    }
}
