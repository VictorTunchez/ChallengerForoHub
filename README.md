El objetivo: Crear una API para un foro donde los usuarios puedan crear tópicos con dudas o sugerencias, y otros puedan responder e interactuar.

Herramientas: 
Usaremos Insomnia para probar la API.
Spring boot - java 21

Funcionalidades:
Listar todos los tópicos existentes.
Crear nuevos tópicos (requiere autenticación).
Eliminar tópicos (requiere autenticación).
Actualizar topicos (requiere autenticacion).
Detallar un topico (requiere autenticacion).

Autenticación: 
Se implementará una capa de seguridad con tokens JWT para proteger la creación, eliminación, actualización y detalles de tópicos.

Formato de las urls y json:
Listar: GET http://localhost:8080/topicos

IniciarSesion: POST http://localhost:8080/login
{
"email": "cualquiera@gmail.com",
"contrasena":"123456"  
}
//Tener en cuenta que la contraseña debe estar encriptada por Bcrypt 
//Al loguernos este nos devolvera el token que debemos pasar por el auth de tipo Bearer Token en cada request (excepto el de listar)

Registrar: POST http://localhost:8080/topicos
{
"idUsuario": 1,
"mensaje": "Estoy de acuerdo con el contenido explicado",
"nombreCurso": "Https en la web",
"titulo": "Https seguro"
}

Eliminar: DELETE http://localhost:8080/topicos/3

Actualizar: PUT http://localhost:8080/topicos/3
{
"titulo": "Actulizacion del titulo"
}

Detallar: GET http://localhost:8080/topicos/1

