package com.meteora.Apigoliasapp.Dto;

import com.meteora.Apigoliasapp.Entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

  //  private Long id;

    private String nome;

 /*   private String cnpj;

    private String cidade;

    private String endereço;

    private String telefone;

    private String uf;

    private String cep;

    private String razaoSocial;

    private String contatoResp_convenio;

    private String emailResp_convenio;

    private String nomeResp_financeiro;

    private String contatoResp_financeiro;

    private String nomeResp_juridico;

    private String contatoResp_juridico;

    private String emailResp_juridico; */


    public List<EstagiarioDto> getEstagiarios() {
        return estagiarios;
    }

    private List<EstagiarioDto> estagiarios;

    public EmpresaDto(Empresa empresa) {
//        this.id = empresa.getId();
        this.nome = empresa.getNome();
    /*    this.cnpj = empresa.getCnpj();
        this.cidade = empresa.getCidade();
        this.endereço = empresa.getEndereço();
        this.telefone = empresa.getTelefone();
        this.uf = empresa.getUf();
        this.cep = empresa.getCep();
        this.razaoSocial = empresa.getRazaoSocial();
        this.contatoResp_convenio = empresa.getContatoResp_convenio();
        this.emailResp_convenio = empresa.getEmailResp_convenio();
        this.nomeResp_financeiro = empresa.getNomeResp_financeiro();
        this.contatoResp_financeiro = empresa.getContatoResp_financeiro();
        this.nomeResp_juridico = empresa.getNomeResp_juridico();
        this.contatoResp_juridico = empresa.getContatoResp_juridico();
        this.emailResp_juridico = empresa.getEmailResp_juridico();
     */
    }

}
