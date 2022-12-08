package com.meteora.Apigoliasapp.Repositories;
import com.meteora.Apigoliasapp.Dto.EstagiarioDto;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstagiarioRepository extends JpaRepository<Estagiario, Long> {
    List<EstagiarioDto> findByEstagio();
}
