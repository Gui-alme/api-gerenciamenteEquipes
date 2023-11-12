package school.sptech.gerenciamentoesportes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.gerenciamentoesportes.service.dto.equipe.CadastroEquipeDto;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeAtletaDto;
import school.sptech.gerenciamentoesportes.service.dto.equipe.RespostaEquipeDto;
import school.sptech.gerenciamentoesportes.service.EquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipes")
@RequiredArgsConstructor
public class EquipeController {

    private final EquipeService equipeService;

    @PostMapping
    public ResponseEntity<RespostaEquipeAtletaDto> cadastrar(@RequestBody CadastroEquipeDto requestEquipe){
        RespostaEquipeAtletaDto equipeAtletaDto = this.equipeService.cadastrar(requestEquipe);
        return ResponseEntity.status(201).body(equipeAtletaDto);
    }

    @GetMapping
    public ResponseEntity<List<RespostaEquipeDto>> buscarEquipes(){
        List<RespostaEquipeDto> respostaEquipeDtos = this.equipeService.buscarEquipes();
        if(respostaEquipeDtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(respostaEquipeDtos);
    }

    @GetMapping("/tecnico")
    public ResponseEntity<List<RespostaEquipeDto>> buscarEquipesPorTecnico(@RequestParam String tecnico){
        List<RespostaEquipeDto> respostaEquipeDtos = this.equipeService.buscarEquipesPorTecnico(tecnico);
        if(respostaEquipeDtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(respostaEquipeDtos);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<RespostaEquipeDto>> buscarEquipesPorNome(@RequestParam String nome){
        List<RespostaEquipeDto> respostaEquipeDtos = this.equipeService.buscarEquipesPorNome(nome);
        if(respostaEquipeDtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(respostaEquipeDtos);
    }


}
