<h1 align="center">Filezilla - Configuración de acceso anónimo</h1>

## Activar el acceso anónimo.

- Primero hay que netrar en el archivo `vsftpd.conf` para activarlo.
```bash
sudo nano /etc/vsftpd.conf
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_4/Imagenes/1.png?raw=true)

- Una vez dentro avtivo el ***anonymous_enable***.

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_4/Imagenes/2.png?raw=true)

---

## Limitar el directorio accesible.

- Sigo dentro del archivo de configuración para limitar un directorio para el usuario anónimo con la siguiente opción: ***anon_root***.

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_4/Imagenes/3.png?raw=true)

---

## Crear y configurar el directorio anónimo.

- Creo el directorio que antes puse que es para el usuario anónimo y lo configuro para solo lectura, también creo un archivo dentro.
```bash
sudo mkdir -p /srv/ftp/anonimo
sudo chown root:root /srv/ftp/anonimo
sudo chmod 755 /srv/ftp/anonimo
sudo nano /srv/ftp/anonimo/archivo_prueba.txt
```

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_4/Imagenes/4.png?raw=true)
![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_4/Imagenes/5.png?raw=true)

---

## Prueba de permisos.

Ahora hago una prueba de que los permisos estén bien configurados con las siguienetes ordenes:
- `get`: funciona porque es de lectura.
- `put`: falla porque no tiene permisos de escritura.

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_4/Imagenes/6.png?raw=true)
