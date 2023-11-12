package school.sptech.gerenciamentoesportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.gerenciamentoesportes.entities.Equipe;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

    List<Equipe> findByTecnico(String tecnico);

    List<Equipe> findByNome(String nome);

}
