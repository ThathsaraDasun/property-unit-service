package lk.ac.kln.property_unit_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public record BuildingRequestDTO(
        @NotBlank(message = "Building code is mandatory")
        @Size(max = 50, message = "Building code must be less than or equal to 50 characters")
        String buildingCode,

        @NotBlank(message = "Name is mandatory")
        @Size(max = 255, message = "Name must be less than or equal to 255 characters")
        String name,

        @NotBlank(message = "Address is mandatory")
        @Size(max = 255, message = "Address must be less than or equal to 255 characters")
        String address,

        @Valid
        List<FloorDTO> floors
) {
}
