package com.meteora.Apigoliasapp.Repositories;
import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstagiarioRepository extends JpaRepository<Estagiario, Long> {
 //  List<Estagiario> findByCidade(String cidade);
 List<Estagiario> findByNome(String nome);
}
