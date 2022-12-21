package com.meteora.Apigoliasapp.Dto;

import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstagiarioDto {
    private Long id;

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


    public EmpresaDto getEmpresa() {
        return empresa;
    }

    private EmpresaDto empresa;

    public EstagiarioDto(Estagiario estagiario) {
        this.id = estagiario.getId();
        this.nome = estagiario.getNome();
   /*     this.cpf = estagiario.getCpf();
        this.cidade = estagiario.getCidade();
        this.endereço = estagiario.getEndereço();
        this.rg = estagiario.getRg();
        this.uf = estagiario.getUf();
        this.email = estagiario.getEmail();
        this.cep = estagiario.getCep();
        this.telefoneCelular = estagiario.getTelefoneCelular();
        this.telefoneFixo = estagiario.getTelefoneFixo();
        this.linkedin = estagiario.getLinkedin();
        this.curriculoLattes = estagiario.getCurriculoLattes();
     */
    }
    public static List<EstagiarioDto> convert(List<Estagiario> estagiario){
        return estagiario.stream().map(EstagiarioDto::new).collect(Collectors.toList());
    }
}

