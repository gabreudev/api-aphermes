package com.meteora.Apigoliasapp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Getter
@Setter
@Table
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @Column
    private String nome;

  @JsonIgnore
  @OneToMany(mappedBy = "empresa")
    private List<Estagiario> estagiario = new ArrayList<>();

    //Possivel senha
            public Empresa(String nome)  {
                this.nome = nome;
            }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estagiario=" + estagiario +
                '}';
    }
}
