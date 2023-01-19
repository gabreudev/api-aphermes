package com.meteora.Apigoliasapp.Entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class Estagiario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @Column
    private String nome;
   @ManyToOne
   @JoinColumn(name = "empresa_id")
   private Empresa empresa;

   public Estagiario(String nome) {
       this.nome = nome;
   }

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
