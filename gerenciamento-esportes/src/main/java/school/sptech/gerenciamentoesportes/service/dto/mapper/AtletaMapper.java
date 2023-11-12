package school.sptech.gerenciamentoesportes.service.dto.mapper;

import school.sptech.gerenciamentoesportes.entities.Atleta;
import school.sptech.gerenciamentoesportes.entities.Equipe;
import school.sptech.gerenciamentoesportes.service.dto.atleta.CadastroAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaSemEquipeDto;

import java.util.List;

public class AtletaMapper {

    public static Atleta toAtleta(CadastroAtletaDto cadastroAtletaDto){
        Atleta atleta = new Atleta();
        atleta.setNome(cadastroAtletaDto.getNome());
        atleta.setIdade(cadastroAtletaDto.getIdade());
        atleta.setPosicao(cadastroAtletaDto.getPosicao());
        Equipe equipe = new Equipe();
        equipe.setId(cadastroAtletaDto.getIdEquipe());
        atleta.setEquipe(equipe);
        return atleta;
    }

    public static RespostaAtletaSemEquipeDto toRespostaAtletaSemEquipeDto(Atleta atleta){
        RespostaAtletaSemEquipeDto resposta = new RespostaAtletaSemEquipeDto();
        resposta.setIdade(atleta.getIdade());
        resposta.setNome(atleta.getNome());
        resposta.setPosicao(atleta.getPosicao());
        return resposta;
    }

    public static List<RespostaAtletaSemEquipeDto> toListRespostaAtletaSemEquipeDto(List<Atleta> atletas){
        List<RespostaAtletaSemEquipeDto> listaAtletas = atletas.stream().map(AtletaMapper::toRespostaAtletaSemEquipeDto).toList();
        return listaAtletas;
    }

    public static RespostaAtletaDto toRespostaAtletaDto(Atleta atleta){
        RespostaAtletaDto respostaAtletaDto = new RespostaAtletaDto();
        respostaAtletaDto.setIdade(atleta.getIdade());
        respostaAtletaDto.setNome(atleta.getNome());
        respostaAtletaDto.setPosicao(atleta.getPosicao());
        respostaAtletaDto.setEquipe(EquipeMapper.toRespostaEquipeAtletaDto(atleta.getEquipe()));
        return respostaAtletaDto;
    }

    public static List<RespostaAtletaDto> toListRespostaAtletaDto(List<Atleta> atletas){
        List<RespostaAtletaDto> listaResposta = atletas.stream().map(AtletaMapper::toRespostaAtletaDto).toList();
        return listaResposta;
    }

}
