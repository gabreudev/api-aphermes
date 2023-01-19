package com.meteora.Apigoliasapp.service;

import com.meteora.Apigoliasapp.Dto.request.CadastroEstagiarioDTO;
import com.meteora.Apigoliasapp.Dto.request.EmpresaIdDTO;
import com.meteora.Apigoliasapp.Dto.response.EstagiarioDto;
import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import com.meteora.Apigoliasapp.Error.NotFoundException;
import com.meteora.Apigoliasapp.Repositories.EmpresaRepository;
import com.meteora.Apigoliasapp.Repositories.EstagiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstagiarioService {

    @Autowired
    private EstagiarioRepository estagiarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EstagiarioDto> listaEstagiarios() {
        List<Estagiario> estagiario = estagiarioRepository.findAll();
        return convert(estagiario);
    }

    public EstagiarioDto cadastrarEstagiario(CadastroEstagiarioDTO estagiarioDTO) {
        Estagiario estagiario = new Estagiario(estagiarioDTO.getNome());
        estagiario = estagiarioRepository.save(estagiario);
        return new EstagiarioDto(estagiario);
    }

    public EstagiarioDto setarEmpresa(Long id, EmpresaIdDTO empresaDTO) {


        Empresa empresa = empresaRepository.findById(empresaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Estagiario estagiario = estagiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estagiario não encontrado"));
        estagiario.setEmpresa(empresa);


        empresaRepository.save(empresa);
        estagiario = estagiarioRepository.save(estagiario);

        return new EstagiarioDto(estagiario);
    }

    public Object BuscaPorNome(String nome) {

        List<Estagiario> estagiario = estagiarioRepository.findByNome(nome);
        if (estagiario.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum estagiário encontrado");

        return estagiario;
    }
    public Estagiario atualizarDados(Long id, Estagiario estagiario) {

            if (!estagiarioRepository.existsById(id)) {
                throw new NotFoundException("Id invalido");
            }
            estagiario.setId(id);
            estagiario = estagiarioRepository.save(estagiario);
            return estagiario;
    }
    public ResponseEntity<Void> apagarConta(Long id){
        if (!estagiarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estagiarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    private List<EstagiarioDto> convert (List<Estagiario> estagiarios) {
        return  estagiarios.stream().map(EstagiarioDto::new).collect(Collectors.toList());
    }
}
