package school.sptech.gerenciamentoesportes.service.dto.atleta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAtletaSemEquipeDto {

    private String nome;
    private int idade;
    private String posicao;
}
