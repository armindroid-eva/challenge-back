package com.example.ReservasSalas.Controllers;

import com.example.ReservasSalas.Model.Reservation;
import com.example.ReservasSalas.Model.User;
import com.example.ReservasSalas.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return una lista de todos los usuarios.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id el ID del usuario.
     * @return el usuario con el ID especificado, o un error 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    /**
     * Obtiene todas las reservaciones de un usuario por su ID.
     *
     * @param id el ID del usuario.
     * @return una lista de todas las reservaciones del usuario.
     */
    @GetMapping("/{id}/reservations")
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable Long id) {
        List<Reservation> reservations = userService.getUserReservations(id);
        if (reservations == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservations);
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param user el usuario a crear.
     * @return el usuario creado.
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param id   el ID del usuario.
     * @param user el usuario actualizado.
     * @return el usuario actualizado.
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
