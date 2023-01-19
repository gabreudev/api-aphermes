package com.meteora.Apigoliasapp.service;

import com.meteora.Apigoliasapp.Dto.request.CadastroEmpresaDTO;
import com.meteora.Apigoliasapp.Dto.request.CadastroEstagiarioDTO;
import com.meteora.Apigoliasapp.Dto.request.EmpresaIdDTO;
import com.meteora.Apigoliasapp.Dto.response.EmpresaDto;
import com.meteora.Apigoliasapp.Dto.response.EmpresaListEstagiariosDTO;
import com.meteora.Apigoliasapp.Dto.response.EstagiarioDto;
import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import com.meteora.Apigoliasapp.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    public List<EmpresaDto> listarEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return convert(empresas);
    }


    public EmpresaListEstagiariosDTO listarEstagiarios(Long id) {

        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empresa não encontrada"));

        return new EmpresaListEstagiariosDTO(empresa);
    }
    public List<EmpresaDto> listaEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return convert(empresas);
    }

    public EmpresaDto cadastrarEmpresa(CadastroEmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa(empresaDTO.getNome());
        empresa = empresaRepository.save(empresa);
        return new EmpresaDto(empresa);
    }

    public EmpresaDto BuscaPorNome(String nome) {

        Empresa empresa = empresaRepository.findByNome(nome);
        // throw new RuntimeException("Estagiario não encontrado");

        return new EmpresaDto(empresa);
    }
    public Empresa atualizarDados(Long id, Empresa empresa) {

        if (!empresaRepository.existsById(id)) {
            //   return throw new RuntimeException("Estagiario não encontrado"));
        }
        empresa.setId(id);
        empresa = empresaRepository.save(empresa);
        return empresa;
    }
    public ResponseEntity<Void> apagarConta(Long id){
        if (!empresaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private List<EmpresaDto> convert (List<Empresa> empresas) {
        return  empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
    }

}
