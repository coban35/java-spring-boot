package com.app.drone.repository;

import com.app.drone.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    List<Drone> findAll();

    Optional<Drone> findById(Long id);

    Drone save(Drone drone);

    List<Drone> saveAll(Iterable drone);

    void deleteById(Long id);

    @Query(value = "SELECT * FROM DRONE D WHERE D.USER_ID IS NULL", nativeQuery = true)
    List<Drone> getAvailableDroneList();

    @Query(value = "SELECT * FROM DRONE d WHERE d.USER_ID = :userId", nativeQuery = true)
    List<Drone> droneListByUserId(@Param("userId") Long userId);

}
