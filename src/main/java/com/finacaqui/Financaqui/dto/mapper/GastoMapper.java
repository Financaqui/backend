package com.finacaqui.Financaqui.dto.mapper;

import com.finacaqui.Financaqui.dto.GastoRequestDTO;
import com.finacaqui.Financaqui.dto.GastoResponseDTO;
import com.finacaqui.Financaqui.model.Gasto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GastoMapper {

    @Autowired
    private ModelMapper gastoMapper;

    public Gasto toEntity(GastoRequestDTO dto) {
        return gastoMapper.map(dto, Gasto.class);
    }

    public GastoResponseDTO toDTO(Gasto entity) {
        return gastoMapper.map(entity, GastoResponseDTO.class);
    }

    public List<GastoResponseDTO> toDTOList(List<Gasto> gasto) {
        return gasto.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
