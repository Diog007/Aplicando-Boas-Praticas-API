package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDTO;
import br.com.alura.adopet.api.dto.CadastrarPetDTO;
import br.com.alura.adopet.api.dto.ListarAbrigoDTO;
import br.com.alura.adopet.api.dto.ListarPetsDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private PetRepository petRepository;

    public List<ListarAbrigoDTO> listarAbrigo(){
        List<Abrigo> abrigos = abrigoRepository.findAll();
        return abrigos.stream()
                .map(ListarAbrigoDTO::new)
                .collect(Collectors.toList());
    }

    public void cadastrar (CadastrarAbrigoDTO abrigoDTO){
        boolean cadastros = abrigoRepository.existsByNomeOrTelefoneOrEmail(abrigoDTO.nome(), abrigoDTO.telefone(), abrigoDTO.email());

        if (!cadastros){
            abrigoRepository.save(new Abrigo(abrigoDTO));
        }else {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }
    }

    public List<ListarPetsDTO> listarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);

        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(ListarPetsDTO::new)
                .toList();
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = abrigoRepository.findById(id);
        } catch (NumberFormatException exception) {
            optional = abrigoRepository.findByNome(idOuNome);
        }

        return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
    }


}
