package com.example.ReservasSalas.Repositories;

import com.example.ReservasSalas.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para acceder a los datos de los usuarios.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Encuentra un usuario por su nombre de usuario.
     *
     * @param username el nombre de usuario.
     * @return el usuario con el nombre de usuario especificado.
     */
    User findByUsername(String username);

}
