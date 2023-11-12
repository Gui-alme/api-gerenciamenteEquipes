package school.sptech.gerenciamentoesportes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.gerenciamentoesportes.entities.Equipe;
import school.sptech.gerenciamentoesportes.service.dto.equipe.CadastroEquipeDto;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeDto;
import school.sptech.gerenciamentoesportes.service.dto.mapper.EquipeMapper;
import school.sptech.gerenciamentoesportes.repository.EquipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipeService {

    private final EquipeRepository equipeRepository;

    public RespostaEquipeAtletaDto cadastrar(CadastroEquipeDto cadastroEquipeDto){
        Equipe equipe = EquipeMapper.toEquipe(cadastroEquipeDto);
        this.equipeRepository.save(equipe);
        return EquipeMapper.toRespostaEquipeAtletaDto(equipe);
    }


    public List<RespostaEquipeDto> buscarEquipes() {
        List<Equipe> equipes = this.equipeRepository.findAll();
        return EquipeMapper.toListRespostaEquipeDto(equipes);
    }

    public List<RespostaEquipeDto> buscarEquipesPorTecnico(String tecnico) {
        List<Equipe> equipes = this.equipeRepository.findByTecnico(tecnico);
        return EquipeMapper.toListRespostaEquipeDto(equipes);
    }

    public List<RespostaEquipeDto> buscarEquipesPorNome(String nome) {
        List<Equipe> equipes = this.equipeRepository.findByNome(nome);
        return EquipeMapper.toListRespostaEquipeDto(equipes);
    }
}
