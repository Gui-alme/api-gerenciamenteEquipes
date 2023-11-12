package school.sptech.gerenciamentoesportes.service.dto.equipe;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.sptech.gerenciamentoesportes.entities.Atleta;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroEquipeDto {

    @Size(min = 3, max = 255)
    private String nome;
    @Size(min = 3, max = 255)
    private String tecnico;
}
