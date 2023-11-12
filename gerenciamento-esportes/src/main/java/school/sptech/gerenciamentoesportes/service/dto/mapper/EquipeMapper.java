package school.sptech.gerenciamentoesportes.service.dto.mapper;

import school.sptech.gerenciamentoesportes.entities.Equipe;
import school.sptech.gerenciamentoesportes.service.dto.equipe.CadastroEquipeDto;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeDto;

import java.util.List;

public class EquipeMapper {

    public static Equipe toEquipe(CadastroEquipeDto cadastroEquipeDto){
        Equipe equipe = new Equipe();
        equipe.setNome(cadastroEquipeDto.getNome());
        equipe.setTecnico(cadastroEquipeDto.getTecnico());
        return equipe;
    }

    public static RespostaEquipeAtletaDto toRespostaEquipeAtletaDto(Equipe equipe){
        RespostaEquipeAtletaDto resposta = new RespostaEquipeAtletaDto();
        resposta.setNome(equipe.getNome());
        resposta.setTecnico(equipe.getTecnico());
        return resposta;
    }

    public static RespostaEquipeDto toRespostaEquipeDto(Equipe equipe){
        RespostaEquipeDto respostaEquipeDto = new RespostaEquipeDto();
        respostaEquipeDto.setNome(equipe.getNome());
        respostaEquipeDto.setTecnico(equipe.getTecnico());
        respostaEquipeDto.setAtletas(AtletaMapper.toListRespostaAtletaSemEquipeDto(equipe.getAtletas()));
        return respostaEquipeDto;
    }

    public static List<RespostaEquipeDto> toListRespostaEquipeDto(List<Equipe> equipes){
        List<RespostaEquipeDto> listaResposta = equipes.stream().map(EquipeMapper::toRespostaEquipeDto).toList();
        return listaResposta;
    }


}
