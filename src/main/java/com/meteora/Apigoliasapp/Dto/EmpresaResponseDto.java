package com.meteora.Apigoliasapp.Dto;

import com.meteora.Apigoliasapp.Entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaResponseDto {
    private String nome;

 /*   private String cpf;

    private String cidade;

    private String endereço;

    private String rg;

    private String uf;

    private String email;

    private String cep;

    private String telefoneCelular;

    private String telefoneFixo;

    private String linkedin;

    private String curriculoLattes;  */

    public EmpresaResponseDto(Empresa empresa){
    this.nome= empresa.getNome();
    }
}
