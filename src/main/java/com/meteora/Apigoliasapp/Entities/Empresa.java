package com.meteora.Apigoliasapp.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @Column
    private String nome;
  /*  @NotNull
    @NotEmpty
    @Column
    private String cnpj;
    @NotNull
    @NotEmpty
    @Column
    private String cidade;
    @NotNull
    @NotEmpty
    @Column
    private String endereço;
    @NotNull
    @NotEmpty
    @Column
    private String telefone;
    @NotNull
    @NotEmpty
    @Column
    private String uf;
    @NotNull
    @NotEmpty
    @Column
    private String cep;
    @NotNull
    @NotEmpty
    @Column
    private String razaoSocial;
    @NotNull
    @NotEmpty
    @Column
    private String nomeResp_convenio;
    @NotNull
    @NotEmpty
    @Column
    private String contatoResp_convenio;
    @NotNull
    @NotEmpty
    @Column
    private String emailResp_convenio;
    @NotNull
    @NotEmpty
    @Column
    private String nomeResp_financeiro;
    @NotNull
    @NotEmpty
    @Column
    private String contatoResp_financeiro;
    @NotNull
    @NotEmpty
    @Column
    private String emailResp_financeiro;
    @NotNull
    @NotEmpty
    @Column
    private String nomeResp_juridico;
    @NotNull
    @NotEmpty
    @Column
    private String contatoResp_juridico;
    @NotNull
    @NotEmpty
    @Column
    private String emailResp_juridico;
*/
    @OneToMany
    private List<Estagiario> estagiario;


    //Possivel senha
}
