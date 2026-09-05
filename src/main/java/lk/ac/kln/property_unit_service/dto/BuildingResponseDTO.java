package lk.ac.kln.property_unit_service.dto;

import java.time.LocalDateTime;
import java.util.List;

public record BuildingResponseDTO(
        Long id,
        String buildingCode,
        String name,
        String address,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<FloorDTO> floors
) {
}
