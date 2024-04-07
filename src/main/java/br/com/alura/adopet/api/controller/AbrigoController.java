package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.alura.adopet.api.dto.CadastrarPetDTO;
import br.com.alura.adopet.api.dto.ListarAbrigoDTO;
import br.com.alura.adopet.api.dto.ListarPetsDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.service.AbrigoService;
import br.com.alura.adopet.api.service.PetService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<ListarAbrigoDTO>> listar() {
        return ResponseEntity.ok(abrigoService.listarAbrigo());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarAbrigoDTO abrigoDTO) {
        try {
            abrigoService.cadastrar(abrigoDTO);
            return ResponseEntity.ok().build();
        } catch (ValidationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{idOuNome}/pets")
    public ResponseEntity<List<ListarPetsDTO>> listarPets(@PathVariable String idOuNome) {
        try {
            List<ListarPetsDTO> listPetsAbrigo = abrigoService.listarPetsDoAbrigo(idOuNome);
            return ResponseEntity.ok(listPetsAbrigo);
        } catch (ValidacaoException e) {
            return ResponseEntity.notFound().build();
    }
    }

    @PostMapping("/{idOuNome}/pets")
    @Transactional
    public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid CadastrarPetDTO petDTO) {
        try {
            Abrigo abrigo = abrigoService.carregarAbrigo(idOuNome);
            this.petService.cadastrarPet(abrigo, petDTO);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException e){
            return ResponseEntity.notFound().build();
        }

    }

}
