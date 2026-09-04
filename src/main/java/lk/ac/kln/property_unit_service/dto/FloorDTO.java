package lk.ac.kln.property_unit_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FloorDTO(
        @NotNull(message = "Floor number is mandatory")
        Integer floorNumber,

        @Size(max = 50, message = "Floor name must be less than or equal to 50 characters")
        String floorName
) {
}
