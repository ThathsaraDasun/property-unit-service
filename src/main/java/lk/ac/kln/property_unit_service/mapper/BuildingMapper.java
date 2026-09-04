package lk.ac.kln.property_unit_service.mapper;

import lk.ac.kln.property_unit_service.dto.BuildingRequestDTO;
import lk.ac.kln.property_unit_service.dto.BuildingResponseDTO;
import lk.ac.kln.property_unit_service.dto.FloorDTO;
import lk.ac.kln.property_unit_service.model.Building;
import lk.ac.kln.property_unit_service.model.Floor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingMapper {

    public Building toEntity(BuildingRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Building building = new Building();
        building.setBuildingCode(dto.buildingCode());
        building.setName(dto.name());
        building.setAddress(dto.address());

        if (dto.floors() != null) {
            for (FloorDTO floorDTO : dto.floors()) {
                Floor floor = new Floor();
                floor.setFloorNumber(floorDTO.floorNumber());
                floor.setFloorName(floorDTO.floorName());
                building.addFloor(floor);
            }
        }

        return building;
    }

    public BuildingResponseDTO toResponseDTO(Building entity) {
        if (entity == null) {
            return null;
        }

        List<FloorDTO> floorDTOs = null;
        if (entity.getFloors() != null) {
            floorDTOs = entity.getFloors().stream()
                    .map(floor -> new FloorDTO(floor.getFloorNumber(), floor.getFloorName()))
                    .collect(Collectors.toList());
        }

        return new BuildingResponseDTO(
                entity.getId(),
                entity.getBuildingCode(),
                entity.getName(),
                entity.getAddress(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                floorDTOs
        );
    }
}
