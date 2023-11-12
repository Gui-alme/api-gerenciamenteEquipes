package school.sptech.gerenciamentoesportes.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.gerenciamentoesportes.service.dto.atleta.CadastroAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.atleta.RespostaAtletaSemEquipeDto;
import school.sptech.gerenciamentoesportes.service.AtletaService;

import java.util.List;

@RestController
@RequestMapping("/atletas")
@RequiredArgsConstructor
public class AtletaController {

    private final AtletaService atletaService;

    @PostMapping
    public ResponseEntity<RespostaAtletaSemEquipeDto> cadastrar(@RequestBody CadastroAtletaDto cadastroAtleta){
        RespostaAtletaSemEquipeDto respostaAtletaSemEquipeDto = atletaService.cadastrar(cadastroAtleta);
        return ResponseEntity.status(201).body(respostaAtletaSemEquipeDto);
    }

    @GetMapping
    public ResponseEntity<List<RespostaAtletaDto>> buscarAtletas(){
        List<RespostaAtletaDto> listaRespostas = atletaService.buscarAtletas();
        if(listaRespostas.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaRespostas);
    }

    @GetMapping("/idade")
    public ResponseEntity<List<RespostaAtletaDto>> buscarAtletasPorIdade(@RequestParam int idade){
        List<RespostaAtletaDto> listaResposta = atletaService.buscarAtletasPorIdade(idade);
        if(listaResposta.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaResposta);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<RespostaAtletaDto>> buscarAtletasPorNome(@RequestParam String nome){
        List<RespostaAtletaDto> listaResposta = atletaService.buscarAtletasPorNome(nome);
        if(listaResposta.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaResposta);
    }

    @GetMapping("/posicao")
    public ResponseEntity<List<RespostaAtletaDto>> buscarAtletasPorPosicao(@RequestParam String posicao){
        List<RespostaAtletaDto> listaResposta = atletaService.buscarAtletasPorPosicao(posicao);
        if(listaResposta.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaResposta);
    }

    @GetMapping("/equipe")
    public ResponseEntity<List<RespostaAtletaSemEquipeDto>> buscarAtletasPelaEquipe(@RequestParam String equipe){
        List<RespostaAtletaSemEquipeDto> listaResposta = atletaService.buscarAtletaPelaEquipe(equipe);
        if(listaResposta.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaResposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaAtletaSemEquipeDto> atualizarAtleta(@RequestBody CadastroAtletaDto atletaRequest, @PathVariable int id){
        RespostaAtletaSemEquipeDto atletaSemEquipeDto = atletaService.atualizar(atletaRequest, id);
        return ResponseEntity.status(200).body(atletaSemEquipeDto);
    }

}
