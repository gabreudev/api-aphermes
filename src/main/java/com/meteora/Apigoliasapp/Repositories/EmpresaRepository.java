package com.meteora.Apigoliasapp.Repositories;
import com.meteora.Apigoliasapp.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepository extends JpaRepository <Empresa, Long>{
    Empresa findByNome(String nome);

    @Query("select e from Empresa e left join fetch e.estagiario where e.id =:id")
    Empresa findEmpresaFetchEstagiarios(@Param("id") Long id);
}
