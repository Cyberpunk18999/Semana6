# Semana 6
En esta semana numero 6 se nos encargo realizar una app con autenticación a través de una base de datos en Realtime Database de Firebase, esta base de datos, tiene como datos de autentificación el correo electrónico y la contraseña del usuario, los cuales se guardaran en la sección de autenticación de Firebase para futuros inicios de sesión en la app, y luego de ingresar estos datos, el usuario debería ser redirigido al Activity llamado MenuActivity en el cual de momento hará funciones simples como cerrar sesión de la cuenta de la app.

## Activitys del proyecto
En esta ocasión, debido a la organización que tiene el proyecto, este va a contar con 4 diferentes activitys y cada uno tiene sus respectivos xml de diseños, estos son:

-LoginActivity: Este activity se encargará de las funciones de inicio de sesión y la autentificación de de datos del usuario con ayuda de la autenticación de la base de datos del Firebase vinculado a la app creada.

-RegisterActivity: Este activity se encargará del registro de los datos de nuevos usuarios a tiempo real gracias al Realtime Database de Firebase, los cuales después se transferirán automáticamente a la autenticación de Firebase para futuros inicios de sesión.

-MenuActivity: Este activity es principalmente el menú principal en donde a través de los otros activitys serán redirigidos a este, este menú te permite utilizar una calculadora de costo de despacho y también permite cerrar la sesion. 

-DespachoActivity: Este Activity es básicamente una calculadora que calcula el costo de despacho dependiendo del precio de compra, y de la ubicación del usuario.

## Historias de usuario (Suposiciones)

