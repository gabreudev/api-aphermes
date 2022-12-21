package com.meteora.Apigoliasapp.Entities;

import com.meteora.Apigoliasapp.Dto.EmpresaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity

@Getter
@Setter
//@Data
@Table
public class Estagiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @Column
    private String nome;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "empresa_id")
   private Empresa empresa;

   /* @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    //Possível senha
    */

    @Override
    public String toString() {
        return "Estagiario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
