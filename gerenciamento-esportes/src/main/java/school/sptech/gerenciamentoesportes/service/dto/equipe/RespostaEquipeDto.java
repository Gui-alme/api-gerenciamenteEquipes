package school.sptech.gerenciamentoesportes.service.dto.equipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaSemEquipeDto;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaEquipeDto {

    private String nome;
    private String tecnico;
    private List<RespostaAtletaSemEquipeDto> atletas;

}
