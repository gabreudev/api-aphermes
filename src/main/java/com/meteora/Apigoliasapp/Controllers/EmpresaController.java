package com.meteora.Apigoliasapp.Controllers;
import com.meteora.Apigoliasapp.Dto.request.CadastroEmpresaDTO;
import com.meteora.Apigoliasapp.Dto.request.CadastroEstagiarioDTO;
import com.meteora.Apigoliasapp.Dto.response.EmpresaDto;
import com.meteora.Apigoliasapp.Dto.response.EmpresaListEstagiariosDTO;
import com.meteora.Apigoliasapp.Dto.response.EstagiarioDto;
import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaListEstagiariosDTO> lisarEstagiarios(@PathVariable Long id) {

        EmpresaListEstagiariosDTO empresaDTO = empresaService.listarEstagiarios(id);

        return ResponseEntity.ok().body(empresaDTO);

    }
    @GetMapping("/listar")
    public ResponseEntity<List<EmpresaDto>> listaEstagiarios() {

        List<EmpresaDto> empresasDtos = empresaService.listaEmpresas();

        return ResponseEntity.ok().body(empresasDtos);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<EmpresaDto> cadastrarEmpresa(@RequestBody CadastroEmpresaDTO empresaDTO) {

        EmpresaDto empresa = empresaService.cadastrarEmpresa(empresaDTO);

        return ResponseEntity.ok().body(empresa);
    }
    @GetMapping("/buscarEmpresa/{nome}")
    public ResponseEntity<EmpresaDto> buscaEmpresaPorNome(@PathVariable String nome){

        EmpresaDto empresaDto = empresaService.BuscaPorNome(nome);

        return ResponseEntity.ok().body(empresaDto);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Empresa> atualizarDados(@PathVariable Long id, @RequestBody Empresa empresa) {

        Empresa empresaAtualizada = empresaService.atualizarDados(id, empresa);

        return ResponseEntity.ok(empresaAtualizada);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        String responseEntity = String.valueOf(empresaService.apagarConta(id));
        return responseEntity;
    }



}











/*
    @PostMapping("/cadastrar")
    public Empresa cadastrarEmpresa(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Empresa> atualizarDados(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (!empresaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresa.setId(id);
        empresa = empresaRepository.save(empresa);
        return ResponseEntity.ok(empresa);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!empresaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/buscarEmpresa/{nome}")
    public EmpresaDto listaEmpresa(@PathVariable("nome") String nome) {
        Empresa empresa = empresaRepository.findByNome(nome);
        EmpresaDto empresaDto = new EmpresaDto(empresa);
        return empresaDto;
    }
}
*/
