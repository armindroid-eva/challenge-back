package com.example.ReservasSalas.Controllers;

import com.example.ReservasSalas.Model.Reservation;
import com.example.ReservasSalas.Services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Obtiene todas las reservaciones.
     *
     * @return una lista de todas las reservaciones.
     */
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    /**
     * Obtiene una reservación por su ID.
     *
     * @param id el ID de la reservación.
     * @return la reservación con el ID especificado, o un error 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    /**
     * Obtiene todas las reservaciones de un usuario por su nombre.
     *
     * @param applicantName el nombre del usuario.
     * @return una lista de todas las reservaciones del usuario.
     */
    @GetMapping("/user/{applicantName}")
    public List<Reservation> getReservationByUser(@PathVariable String applicantName) {
        return reservationService.getReservationsByUser(applicantName);
    }

    /**
     * Crea una nueva reservación para un usuario.
     *
     * @param reservation la reservación a crear.
     * @param userId      el ID del usuario.
     * @return la reservación creada.
     */
    @PostMapping("/user/{userId}")
    public Reservation createReservation(@RequestBody Reservation reservation, @PathVariable Long userId) {
        return reservationService.createReservation(reservation, userId);
    }

    /**
     * Actualiza una reservación existente.
     *
     * @param id          el ID de la reservación.
     * @param reservation la reservación actualizada.
     * @return la reservación actualizada.
     */
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationService.updateReservation(reservation);
    }

    /**
     * Elimina una reservación por su ID.
     *
     * @param id el ID de la reservación.
     * @return un código de estado 204 si la reservación se eliminó correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
