package com.example.ReservasSalas.Repositories;

import com.example.ReservasSalas.Model.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio para accdeder a los datos de las reservaciones.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**
     * Encuentra todas las reservaciones de un solicitante específico.
     *
     * @param applicantName el nombre del solicitante.
     * @return una lista de reservaciones del solicitante.
     */
    List<Reservation> findByApplicantName(String applicantName);

    /**
     * Encuentra todas las reservaciones dentro de un rango de tiempo.
     *
     * @param startTime la hora de inicio del rango.
     * @param endTime   la hora de fin del rango.
     * @return una lista de reservaciones dentro del rango de tiempo.
     */
    @Query("SELECT res FROM Reservation res WHERE (res.startTime <= :endTime AND res.endTime >= :startTime)")
    List<Reservation> findReservationsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * Elimina una reservación por su ID.
     *
     * @param id el ID de la reservación a eliminar.
     */
    @Modifying
    @Transactional
    void deleteById(Long id);

}
