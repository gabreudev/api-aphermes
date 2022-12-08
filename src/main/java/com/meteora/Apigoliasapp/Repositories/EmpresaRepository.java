package com.meteora.Apigoliasapp.Repositories;
import com.meteora.Apigoliasapp.Dto.EmpresaDto;
import com.meteora.Apigoliasapp.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository <Empresa, Long>{
    EmpresaDto findByNome(String nome);
}
