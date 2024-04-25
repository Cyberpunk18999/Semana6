# Semana 6
En esta semana numero 6 se nos encargo realizar una app con autenticación a través de una base de datos en Realtime Database de Firebase, esta base de datos, tiene como datos de autentificación el correo electrónico y la contraseña del usuario, los cuales se guardaran en la sección de autenticación de Firebase para futuros inicios de sesión en la app, y luego de ingresar estos datos, el usuario debería ser redirigido al Activity llamado MenuActivity en el cual de momento hará funciones simples como cerrar sesión de la cuenta de la app.

## Activitys del proyecto
En esta ocasión, debido a la organización que tiene el proyecto, este va a contar con 4 diferentes activitys y cada uno tiene sus respectivos xml de diseños, estos son:

-LoginActivity: Este activity se encargará de las funciones de inicio de sesión y la autentificación de de datos del usuario con ayuda de la autenticación de la base de datos del Firebase vinculado a la app creada.

-RegisterActivity: Este activity se encargará del registro de los datos de nuevos usuarios a tiempo real gracias al Realtime Database de Firebase, los cuales después se transferirán automáticamente a la autenticación de Firebase para futuros inicios de sesión.

-MenuActivity: Este activity es principalmente el menú principal en donde a través de los otros activitys serán redirigidos a este, este menú te permite utilizar una calculadora de costo de despacho y también permite cerrar la sesion. 

-DespachoActivity: Este Activity es básicamente una calculadora que calcula el costo de despacho dependiendo del precio de compra, y de la ubicación del usuario.

## Historias de usuario (Suposiciones)
A continuacion se mostraran 5 historias de usuarios, las cuales hablan de la experiencia que han obtenido algunos usuarios con esta nueva app.

-Esteban: es el administrador de la distribuidora de alimentos y utiliza la versión de Android Lollipop en su dispositivo. Se asegura de que la aplicación esté funcionando correctamente en su dispositivo y supervisa las ventas y despachos desde la base de datos en tiempo real. Posibles mejoras: la distribuidora podría considerar actualizar el dispositivo de Esteban a una versión más reciente de Android para garantizar un rendimiento óptimo de la aplicación y mejorar la seguridad

-Eva: es una joven trabajadora que necesita hacer una cotizacion del costo del despacho dependiendo del precio de su compra. Descarga la aplicación de la distribuidora de alimentos para ahorrar tiempo. Se registra fácilmente con su cuenta de Gmail y realiza una cotizacion de mas de 50 mil pesos.Agradece la opción de despacho a domicilio gratuito dentro de su radio de 20 km y queda impresionada por lo conveniente que resulta. Sin embargo, Eva encuentra que sería útil tener un sistema de recomendaciones de productos basado en sus compras anteriores, así como la capacidad de programar entregas recurrentes para artículos que compra con frecuencia, como leche y pan.

-Luis: es un cliente frecuente de la distribuidora de alimentos y se ha acostumbrado a realizar sus despachos a través de la aplicación. Se registra con su cuenta de Gmail y cotiza regularmente productos para su hogar. Le gusta cómo la aplicación almacena su ubicación GPS para facilitar futuras compras y despachos.

-Carlos:  es un estudiante universitario que vive solo y no tiene tiempo para ir al supermercado. Decide utilizar la aplicación para comprar algunos productos esenciales. Su compra no alcanza los 25 mil pesos, por lo que se le cobra una tarifa por el despacho. Aunque inicialmente le parece un poco caro, valora la comodidad de recibir los alimentos en su puerta y decide seguir utilizando el servicio.

-Juan: es el dueño de un minimarket y utiliza la aplicacion para poder comprar y cotizar el despacho hacia su negocio. Inicia sesion con su correo y contraseña y le resulta muy practico, pero lo que encuentra que debe mejorar la aplicacion es, agregar la opcion de guardar alimentos favoritos para futuras compras y cotizaciones, y de esta manera hacer el uso de esta app mas facil.




