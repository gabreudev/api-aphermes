package com.meteora.Apigoliasapp.Controllers;

import com.meteora.Apigoliasapp.Dto.request.EmpresaIdDTO;
import com.meteora.Apigoliasapp.Dto.response.EstagiarioDto;
import com.meteora.Apigoliasapp.Dto.request.CadastroEstagiarioDTO;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import com.meteora.Apigoliasapp.Error.NotFoundException;
import com.meteora.Apigoliasapp.service.EstagiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estagiario")
public class EstagiarioController {
    @Autowired
    private EstagiarioService estagiarioService;

    @GetMapping("/listar")
    public Object listaEstagiarios() {

        List<EstagiarioDto> estagiariosDTO = estagiarioService.listaEstagiarios();
        if (estagiariosDTO.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum estagiario registrado");

        return ResponseEntity.ok().body(estagiariosDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<EstagiarioDto> cadastrarEstagiario(@RequestBody CadastroEstagiarioDTO estagiarioDTO) {

        EstagiarioDto estagiario = estagiarioService.cadastrarEstagiario(estagiarioDTO);

        return ResponseEntity.ok().body(estagiario);
    }

    @PutMapping("/addEmpresa/{id}")
    public ResponseEntity<EstagiarioDto> setarEmpresa(@PathVariable Long id, @RequestBody EmpresaIdDTO empresaDTO) {

        EstagiarioDto estagiarioDto = estagiarioService.setarEmpresa(id,empresaDTO);
        if(estagiarioDto == null)
            throw new NotFoundException("error");
        return ResponseEntity.ok().body(estagiarioDto);
    }
    @GetMapping("/buscarEstagiario/{nome}")
    public ResponseEntity<Object> buscaEstagiarioPorNome(@PathVariable String nome){

        Object estagiarioDto = estagiarioService.BuscaPorNome(nome);
            //throw new NotFoundException("Nenhum estagiario encontrado");

        return ResponseEntity.ok().body(estagiarioDto);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Estagiario> atualizarDados(@PathVariable Long id, @RequestBody Estagiario estagiario) {

        Estagiario estagiarioAtualizado = estagiarioService.atualizarDados(id, estagiario);

        return ResponseEntity.ok(estagiarioAtualizado);
    }
    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        String responseEntity = String.valueOf(estagiarioService.apagarConta(id));
        return responseEntity;
      }

















    /*






    //@GetMapping("/buscarEstagiario/{cidade}")
   // public List<EstagiarioDto> listaPorCidade(@PathVariable("cidade") String cidade) {
     //   List<Estagiario> estagiario = estagiarioRepository.findByCidade(cidade);
  //   //   return EstagiarioDto.convert(estagiario);
  //  }*/
//


}
