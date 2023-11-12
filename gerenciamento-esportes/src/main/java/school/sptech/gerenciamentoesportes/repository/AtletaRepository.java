package school.sptech.gerenciamentoesportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.gerenciamentoesportes.entities.Atleta;

import java.util.List;
import java.util.Optional;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {

    List<Atleta> findByIdade(int idade);

    List<Atleta> findByNome(String nome);

    List<Atleta> findByPosicao(String posicao);

    List<Atleta> findByEquipeNome(String nome);

}
