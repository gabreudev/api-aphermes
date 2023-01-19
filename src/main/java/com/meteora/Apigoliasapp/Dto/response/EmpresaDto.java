package com.meteora.Apigoliasapp.Dto.response;

import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

    private Long  id;
    private String nome;



   // private List<EstagiarioDto> estagiarios = new ArrayList<EstagiarioDto>();

    public EmpresaDto(Empresa empresa) {
        this.nome = empresa.getNome();
        this.id =  empresa.getId();
    }

}
