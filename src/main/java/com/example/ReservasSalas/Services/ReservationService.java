package com.example.ReservasSalas.Services;

import com.example.ReservasSalas.Model.Reservation;
import com.example.ReservasSalas.Model.User;
import com.example.ReservasSalas.Repositories.ReservationRepository;
import com.example.ReservasSalas.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio para manejar la lógica de negocio de las reservaciones.
 */
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    /**
     * Obtiene todas las reservaciones.
     *
     * @return una lista de todas las reservaciones.
     */
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * Obtiene una reservación por su ID.
     *
     * @param id el ID de la reservación.
     * @return la reservación con el ID especificado, o null si no se encuentra.
     */
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    /**
     * Crea una nueva reservación.
     *
     * @param reservation la reservación a crear.
     * @param userId      el ID del usuario que realiza la reservación.
     * @return la reservación creada, o null si el usuario no se encuentra.
     * @throws IllegalArgumentException si la hora de inicio de la reservación es después de la hora de fin.
     */
    public Reservation createReservation(Reservation reservation, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            LocalDateTime startTime = reservation.getStartTime();
            LocalDateTime endTime = reservation.getEndTime();
            if (startTime.isAfter(endTime)) {
                throw new IllegalArgumentException("Start time must be before end time");
            }
            reservation.setUser(user);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    /**
     * Actualiza una reservación existente.
     *
     * @param reservation la reservación con los datos actualizados.
     * @return la reservación actualizada.
     */
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     * Elimina una reservación por su ID.
     *
     * @param id el ID de la reservación a eliminar.
     */
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    /**
     * Obtiene las reservaciones de un solicitante específico.
     *
     * @param applicantName el nombre del solicitante.
     * @return una lista de reservaciones del solicitante.
     */
    public List<Reservation> getReservationsByUser(String applicantName) {
        return reservationRepository.findByApplicantName(applicantName);
    }

    /**
     * Encuentra todas las reservaciones dentro de un rango de tiempo.
     *
     * @param startTime la hora de inicio del rango.
     * @param endTime   la hora de fin del rango.
     * @return una lista de reservaciones dentro del rango de tiempo.
     */
    public List<Reservation> findReservationsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return reservationRepository.findReservationsWithinTimeRange(startTime, endTime);
    }

}
