#language: es
Característica: Obtener informacion de un libro por su ID

  Como usuario visitante en el sistema
  necesito validar que la opción de ver la información de los libros por su ID se encuentre disponible
  para poder identificar cada uno de los libros almacenados

  Escenario: Consultar informacion libros por id

    Dado el usuario quiere consultar la informacion de un libro por su id
    Cuando el usuario hace la peticion de obtener la informacion del libro por su id
    Entonces el usuario deberia obtener la informacion correspondiente al id del libro buscado y un codigo de respuesta 200
