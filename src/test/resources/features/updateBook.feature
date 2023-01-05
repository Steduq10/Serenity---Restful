#language: es
Característica: Update Booking

  Como un usuario  registrado con permisos de admin
  necesito validar que la función de "update booking" esté habilitada
  para poder garantizar que  con perfil de admin puedo realizar esta acción

  Escenario: Actualizar registro de un libro

    Dado a que el usuario se encuentra registrado con un perfil con permisos de admin
    Cuando el usuario hace una peticion de actualizacion de un registro de un libro
    Entonces el usuario debera ver un codigo de respuesta 200 y la informacion del libro actualizado
