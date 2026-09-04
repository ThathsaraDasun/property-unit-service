package lk.ac.kln.property_unit_service.controller;

import jakarta.validation.Valid;
import lk.ac.kln.property_unit_service.dto.BuildingRequestDTO;
import lk.ac.kln.property_unit_service.dto.BuildingResponseDTO;
import lk.ac.kln.property_unit_service.mapper.BuildingMapper;
import lk.ac.kln.property_unit_service.model.Building;
import lk.ac.kln.property_unit_service.repository.BuildingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/buildings")
public class BuildingController {

    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;

    public BuildingController(BuildingRepository buildingRepository, BuildingMapper buildingMapper) {
        this.buildingRepository = buildingRepository;
        this.buildingMapper = buildingMapper;
    }

    @PostMapping
    public ResponseEntity<BuildingResponseDTO> createBuilding(@Valid @RequestBody BuildingRequestDTO requestDTO) {
        Building building = buildingMapper.toEntity(requestDTO);
        Building savedBuilding = buildingRepository.save(building);
        BuildingResponseDTO responseDTO = buildingMapper.toResponseDTO(savedBuilding);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BuildingResponseDTO>> getAllBuildings() {
        List<Building> buildings = buildingRepository.findAll();
        List<BuildingResponseDTO> responseDTOs = buildings.stream()
                .map(buildingMapper::toResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }
}
