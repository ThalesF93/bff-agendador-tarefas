package com.thales.bffagendador_tarefas.Business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTO {


    private Long id;
    private String numero;
    private String ddd;
}
