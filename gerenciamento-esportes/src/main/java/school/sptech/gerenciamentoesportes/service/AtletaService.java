package school.sptech.gerenciamentoesportes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.gerenciamentoesportes.entities.Atleta;
import school.sptech.gerenciamentoesportes.service.dto.atleta.CadastroAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaSemEquipeDto;
import school.sptech.gerenciamentoesportes.service.dto.mapper.AtletaMapper;
import school.sptech.gerenciamentoesportes.repository.AtletaRepository;
import school.sptech.gerenciamentoesportes.repository.EquipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtletaService {

    private final AtletaRepository atletaRepository;
    private final EquipeRepository equipeRepository;
    public RespostaAtletaSemEquipeDto cadastrar(CadastroAtletaDto cadastroAtletaDto){
        Atleta atleta = AtletaMapper.toAtleta(cadastroAtletaDto);
        if(this.equipeRepository.existsById(atleta.getEquipe().getId())){
            this.atletaRepository.save(atleta);
            return AtletaMapper.toRespostaAtletaSemEquipeDto(atleta);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipe não existe");
    }

    public List<RespostaAtletaDto> buscarAtletas(){
        List<Atleta> atletas = this.atletaRepository.findAll();
        return AtletaMapper.toListRespostaAtletaDto(atletas);
    }


    public List<RespostaAtletaDto> buscarAtletasPorIdade(int idade) {
        List<Atleta> atletas = this.atletaRepository.findByIdade(idade);
        return AtletaMapper.toListRespostaAtletaDto(atletas);
    }

    public List<RespostaAtletaDto> buscarAtletasPorNome(String nome) {
        List<Atleta> atletas = this.atletaRepository.findByNome(nome);
        return AtletaMapper.toListRespostaAtletaDto(atletas);
    }

    public List<RespostaAtletaDto> buscarAtletasPorPosicao(String posicao) {
        List<Atleta> atletas = this.atletaRepository.findByPosicao(posicao);
        return AtletaMapper.toListRespostaAtletaDto(atletas);
    }

    public List<RespostaAtletaSemEquipeDto> buscarAtletaPelaEquipe(String equipe) {
        List<Atleta> atletas = this.atletaRepository.findByEquipeNome(equipe);
        return AtletaMapper.toListRespostaAtletaSemEquipeDto(atletas);
    }

    public RespostaAtletaSemEquipeDto atualizar(CadastroAtletaDto atletaRequest, int id) {
        Atleta atleta = AtletaMapper.toAtleta(atletaRequest);
        if(atletaRepository.existsById(id)){
            atleta.setId(id);
            atletaRepository.save(atleta);
            return AtletaMapper.toRespostaAtletaSemEquipeDto(atleta);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }
}
