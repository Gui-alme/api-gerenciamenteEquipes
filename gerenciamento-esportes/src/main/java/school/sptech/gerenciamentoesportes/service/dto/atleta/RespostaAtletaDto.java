package school.sptech.gerenciamentoesportes.service.dto.atleta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeAtletaDto;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAtletaDto {

    private String nome;
    private int idade;
    private String posicao;
    private RespostaEquipeAtletaDto equipe;

}
