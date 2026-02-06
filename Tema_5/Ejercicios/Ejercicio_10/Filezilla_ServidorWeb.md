<h1 align="center">Filezilla - Integración de FTP con servidor web</h1>

## Configurar un directorio FTP vinculado a un DocumentRoot (Apache / Nginx).

- Desde el fichero `vsftpd.conf` modifico el **local_root** poniendo la carpeta del html del *Apache*.

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_10/Imagenes/1.png?raw=true)

---

## Subir archivo HTML.

- Creo un archivo html llamado prueba.

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_10/Imagenes/2.png?raw=true)

- Lo subo desde Filezilla Client con un usuario que le he dado permisos para esa carpeta.

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_10/Imagenes/3.png?raw=true)

- Ya subido en `/var/www/html` se puede acceder al html desde un navegador.

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_10/Imagenes/4.png?raw=true)
