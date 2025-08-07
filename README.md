El objetivo: Crear una API para un foro donde los usuarios puedan crear tópicos con dudas o sugerencias, y otros puedan responder e interactuar.

Herramientas: 
Usaremos Insomnia para probar la API (ya que no tendremos interfaz gráfica al inicio).
Spring boot - java 21

Funcionalidades:
Listar todos los tópicos existentes.
Crear nuevos tópicos (requiere autenticación).
Eliminar tópicos (requiere autenticación).
Autenticación: 
Se implementará una capa de seguridad con tokens JWT para proteger la creación, eliminación y actualización de tópicos.