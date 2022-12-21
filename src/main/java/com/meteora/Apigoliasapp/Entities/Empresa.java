package com.meteora.Apigoliasapp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meteora.Apigoliasapp.Dto.EstagiarioDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
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
  @JsonIgnore
  @OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<Estagiario> estagiario;

    //Possivel senha


    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estagiario=" + estagiario +
                '}';
    }
}
