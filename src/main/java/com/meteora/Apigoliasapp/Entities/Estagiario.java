package com.meteora.Apigoliasapp.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity

@Getter
@Setter
@Data
@Table
public class Estagiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @Column
    private String nome;
   /* @NotNull
    @NotEmpty
    @Column
    private String cpf;
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
    private String rg;
    @NotNull
    @NotEmpty
    @Column
    private String uf;
    @NotNull
    @NotEmpty
    @Column
    private String email;
    @NotNull
    @NotEmpty
    @Column
    private String cep;
    @NotNull
    @NotEmpty
    @Column
    private String telefoneCelular;

    @Column
    private String telefoneFixo;

    @Column
    private String linkedin;

    @Column
    private String curriculoLattes;
*/
    @OneToOne
    private Empresa empresa;
    //Possível senha
}
