package com.finacaqui.Financaqui.controller;

import com.finacaqui.Financaqui.dto.GastoRequestDTO;
import com.finacaqui.Financaqui.dto.GastoResponseDTO;
import com.finacaqui.Financaqui.dto.mapper.GastoMapper;
import com.finacaqui.Financaqui.model.Gasto;
import com.finacaqui.Financaqui.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gasto")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @Autowired
    private GastoMapper gastoMapper;

    @GetMapping
    public ResponseEntity<List<GastoResponseDTO>> listaTodos() {
        List<Gasto> gasto = gastoService.listaTodos();
        List<GastoResponseDTO> gastoResponseDTO = gastoMapper.toDTOList(gasto);
        return ResponseEntity.status(HttpStatus.OK).body(gastoResponseDTO);
    }

    @GetMapping("/{id}")
    public Gasto buscaPorId(@PathVariable(value = "id")Long id) {
        return gastoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<GastoResponseDTO> salvar(@RequestBody GastoRequestDTO gastoRequestDTO) {
        Gasto gasto = gastoMapper.toEntity(gastoRequestDTO);
        Gasto gastoSalvo = gastoService.salvar(gasto);
        GastoResponseDTO gastoResponseDTO = gastoMapper.toDTO(gastoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(gastoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@PathVariable(value = "id")Long id, @RequestBody GastoRequestDTO gastoRequestDTO) {
        try{
            Gasto gasto = gastoMapper.toEntity(gastoRequestDTO);
            Gasto gastoSalvo = gastoService.alterar(id, gasto);
            GastoResponseDTO gastoResponseDTO = gastoMapper.toDTO(gastoSalvo);
            return ResponseEntity.status(HttpStatus.OK).body(gastoResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id")Long id){
        try {
            gastoService.remover(id);
            return ResponseEntity.status(HttpStatus.OK).body("Gasto removido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
