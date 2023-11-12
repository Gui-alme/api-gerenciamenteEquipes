package school.sptech.gerenciamentoesportes.service.dto.atleta;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.sptech.gerenciamentoesportes.entities.Equipe;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroAtletaDto {

    @Size(min = 3, max = 255)
    private String nome;
    @Min(15)
    private int idade;
    @Size(min = 3, max = 255)
    private String posicao;
    @NotBlank
    private int idEquipe;
}
