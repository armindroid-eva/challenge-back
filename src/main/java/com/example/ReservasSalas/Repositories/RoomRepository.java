package com.example.ReservasSalas.Repositories;

import com.example.ReservasSalas.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio para acceder a los datos de las salas.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    /**
     * Encuentra las salas disponibles en un rango de tiempo.
     *
     * @param startDate la hora de inicio del rango.
     * @param endDate   la hora de fin del rango.
     * @return una lista de salas disponibles en el rango de tiempo.
     */
    @Query("SELECT r FROM Room r WHERE r NOT IN (SELECT res.room FROM Reservation res WHERE res.startTime < :endDate AND res.endTime > :startDate)")
    List<Room> findAvailableRooms(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
