package com.example.ReservasSalas.Services;

import com.example.ReservasSalas.Model.Room;
import com.example.ReservasSalas.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar la lógica de negocio de las salas.
 */
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    /**
     * Obtiene todas las habitaciones.
     *
     * @return una lista de todas las habitaciones.
     */
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    /**
     * Obtiene una habitación por su ID.
     *
     * @param id el ID de la habitación.
     * @return la habitación con el ID especificado, o null si no se encuentra.
     */
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    /**
     * Crea una nueva habitación.
     *
     * @param room la habitación a crear.
     * @return la habitación creada.
     */
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    /**
     * Actualiza una habitación existente.
     *
     * @param room la habitación con los datos actualizados.
     * @return la habitación actualizada.
     */
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    /**
     * Elimina una habitación por su ID.
     *
     * @param id el ID de la habitación a eliminar.
     */
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

}
