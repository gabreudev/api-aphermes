package com.meteora.Apigoliasapp.Controllers;

import com.meteora.Apigoliasapp.Dto.EstagiarioDto;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import com.meteora.Apigoliasapp.Repositories.EstagiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estagiario")
public class EstagiarioController {
    @Autowired
    private EstagiarioRepository estagiarioRepository;

    @GetMapping("/listar")
    public List<EstagiarioDto> listaEstagiarios() {
        List<Estagiario> estagiario = estagiarioRepository.findAll();
        return EstagiarioDto.convert(estagiario);
    }

    @PostMapping("/cadastrar")
    public Estagiario cadastrarEstagiario(@RequestBody Estagiario estagiario) {
        return estagiarioRepository.save(estagiario);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Estagiario> atualizarDados(@PathVariable Long id, @RequestBody Estagiario estagiario) {
        if (!estagiarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estagiario.setId(id);
        estagiario = estagiarioRepository.save(estagiario);
        return ResponseEntity.ok(estagiario);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!estagiarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estagiarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }/*
    @GetMapping("/buscarEstagiario/{cidade}")
    public List<EstagiarioDto> listaPorCidade(@PathVariable("cidade") String cidade) {
        List<Estagiario> estagiario = estagiarioRepository.findByCidade(cidade);
        return EstagiarioDto.convert(estagiario);
    }*/
}
