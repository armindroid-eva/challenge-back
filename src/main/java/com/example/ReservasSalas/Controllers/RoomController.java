package com.example.ReservasSalas.Controllers;

import com.example.ReservasSalas.Model.Room;
import com.example.ReservasSalas.Repositories.RoomRepository;
import com.example.ReservasSalas.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomService roomService, RoomRepository roomRepository) {
        this.roomService = roomService;
        this.roomRepository = roomRepository;
    }

    /**
     * Obtiene las habitaciones disponibles en un rango de tiempo.
     *
     * @param startTime la hora de inicio del rango.
     * @param endTime   la hora de fin del rango.
     * @return una lista de las habitaciones disponibles.
     */
    @GetMapping("/available")
    public List<Room> getAvailableRooms(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);
        return roomRepository.findAvailableRooms(start, end);
    }

    /**
     * Obtiene todas las habitaciones.
     *
     * @return una lista de todas las habitaciones.
     */
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    /**
     * Obtiene una habitación por su ID.
     *
     * @param id el ID de la habitación.
     * @return la habitación con el ID especificado, o un error 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    /**
     * Crea una nueva habitación.
     *
     * @param room la habitación a crear.
     * @return la habitación creada.
     */
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    /**
     * Actualiza una habitación.
     *
     * @param id   el ID de la habitación.
     * @param room la habitación actualizada.
     * @return la habitación actualizada.
     */
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setId(id);
        return roomService.updateRoom(room);
    }

    /**
     * Elimina una habitación.
     *
     * @param id el ID de la habitación.
     */
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}
