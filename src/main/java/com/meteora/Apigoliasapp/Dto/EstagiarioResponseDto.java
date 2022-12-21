package com.meteora.Apigoliasapp.Dto;

import com.meteora.Apigoliasapp.Entities.Estagiario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstagiarioResponseDto {
    private String nome;

    public EstagiarioResponseDto(Estagiario estagiario){
        this.nome = estagiario.getNome();
    }
}
