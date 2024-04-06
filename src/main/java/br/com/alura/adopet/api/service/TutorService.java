package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizarDadosTutorDTO;
import br.com.alura.adopet.api.dto.CadastroTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public void cadastrarTutor (CadastroTutorDTO tutorDTO){
        boolean contatosJaCadastrados = tutorRepository.existsByTelefoneOrEmail(tutorDTO.telefone(), tutorDTO.email());

        if (!contatosJaCadastrados) {
            tutorRepository.save(new Tutor(tutorDTO));
        } else {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }
    }

    public void atualizarTutor(AtualizarDadosTutorDTO tutorDTO) {
        Tutor tutor = tutorRepository.getReferenceById(tutorDTO.id());
        tutor.atualizarTutor(tutorDTO);
    }
}
