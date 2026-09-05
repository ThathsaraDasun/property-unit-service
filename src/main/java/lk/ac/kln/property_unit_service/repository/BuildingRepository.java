package lk.ac.kln.property_unit_service.repository;

import lk.ac.kln.property_unit_service.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
