# ReservasSalas API

Este proyecto es una API para la gestión de reservas de salas. Fue desarrollado utilizando Java y Spring Boot.

## Funcionalidades

- Gestión de usuarios: Crear, obtener, actualizar y eliminar usuarios.
- Gestión de habitaciones: Crear, obtener, actualizar y eliminar habitaciones.
- Gestión de reservas: Crear, obtener, actualizar y eliminar reservas.

## Requisitos

- Java 17
- Gradle
- H2 para la base de datos embebida
- Configurar el archivo de applitacion.properties, para poder dar las credenciales de la base de datos

## Cómo correr el proyecto

1. Clona el repositorio a tu máquina local usando `https://github.com/armindroid-eva/challenge-back-TPbadak`.
2. Navega a la carpeta del proyecto.
3. Ejecuta `./gradlew bootRun` para iniciar la aplicación.

La aplicación se ejecutará en `localhost:8080`.

## API Endpoints

### Usuarios

- `GET /users`: Obtiene todos los usuarios.
- `GET /users/{id}`: Obtiene un usuario por su ID.
- `GET /users/{id}/reservations`: Obtiene las reservaciones de un usuario
- `POST /users`: Crea un nuevo usuario.
- `PUT /users/{id}`: Actualiza un usuario existente.
- `DELETE /users/{id}`: Elimina un usuario por su ID.

### Habitaciones

- `GET /rooms`: Obtiene todas las habitaciones.
- `GET /rooms/{id}`: Obtiene una habitación por su ID.
- `POST /rooms`: Crea una nueva habitación.
- `PUT /rooms/{id}`: Actualiza una habitación existente.
- `DELETE /rooms/{id}`: Elimina una habitación por su ID.
- `GET /available?startTime=2024-01-01%2010:30&endTime=2024-01-01%2012:301` : Revisar las habitaciones disponibles en un rango de fecha

### Reservas

- `GET /reservations`: Obtiene todas las reservas.
- `GET /reservations/{id}`: Obtiene una reserva por su ID.
- `POST /reservations/user/{userId}`: Crea una nueva reserva para un usuario.
- `PUT /reservations/{id}`: Actualiza una reserva existente.
- `DELETE /reservations/{id}`: Elimina una reserva por su ID.


## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o realiza un pull request para sugerir cambios o mejoras.
