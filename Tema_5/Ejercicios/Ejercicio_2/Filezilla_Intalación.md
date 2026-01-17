<h1 align="center">Filezilla - Instalación y configuración</h1>

## Instalar FileZilla Server.

- Instalo el Filezilla Server.

```bash
sudo apt install vsftpd
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_2/Imagenes/1.png?raw=true)

- Ahora inicio el servicio y compruebo que esté en funcionamiento.

```bash
sudo systemctl start vsftpd
sudo systemctl status vsftpd
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_2/Imagenes/2.png?raw=true)

---

## Configurar servidor.

- Para configurar el servidor me meto en el archivo `svftpd.conf`.

```bash
sudo nano /etc/vsftpd.conf
```

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_2/Imagenes/3.png?raw=true)

- Una vez dentro pongo la siguiente configuración para que el servidor escuche todas las interfaces.

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_2/Imagenes/4.png?raw=true)

- El siguiente comando es para el inicio automáticos del servicio.

```bash
sudo systemctl enable vsftpd
```
![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_2/Imagenes/5.png?raw=true)

- Ahora compruebo que el Filezilla escuche por el puerto 21.

```bash
sudo ss -tulpn | grep 21
```

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_2/Imagenes/6.png?raw=true)
