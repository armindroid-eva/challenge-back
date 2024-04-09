package com.example.ReservasSalas.Services;

import com.example.ReservasSalas.Model.Reservation;
import com.example.ReservasSalas.Model.User;
import com.example.ReservasSalas.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para manejar la lógica de negocio de los usuarios.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return una lista de todos los usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id el ID del usuario.
     * @return el usuario con el ID especificado, o null si no se encuentra.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param user el usuario a crear.
     * @return el usuario creado.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param user el usuario con los datos actualizados.
     * @return el usuario actualizado.
     */
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario a eliminar.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
 
    /**
     * Obtiene las reservaciones de un usuario específico.
     *
     * @param userId el ID del usuario.
     * @return una lista de reservaciones del usuario, o null si el usuario no se encuentra.
     */
    public List<Reservation> getUserReservations(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getReservations();
        }
        return null;
    }
}
