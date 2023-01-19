package com.meteora.Apigoliasapp.Dto.response;

import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EmpresaListEstagiariosDTO{

 private final List<EstagiarioDto> estagiarios;


 public EmpresaListEstagiariosDTO(Empresa empresa) {
    this.estagiarios = convert(empresa.getEstagiario());
 }

    private List<EstagiarioDto> convert (List<Estagiario> estagiarios) {
        return  estagiarios.stream().map(EstagiarioDto::new).collect(Collectors.toList());
    }

}
