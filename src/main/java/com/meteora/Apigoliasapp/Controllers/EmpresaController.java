package com.meteora.Apigoliasapp.Controllers;
import com.meteora.Apigoliasapp.Dto.EmpresaDto;
import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

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
