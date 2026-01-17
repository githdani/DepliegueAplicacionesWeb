<h1 align="center">Filezilla - Creación de usuarios y grupos</h1>

## Usuarios y grupo.

- Primero creo el grupo para los usuarios.

```bash
sudo groupadd ftpgrupo
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_3/Imagenes/1.png?raw=true)

- Ahora creo los dos usuarios para el grupo.

```bash
sudo useradd -m -g ftpgrupo -s /usr/sbin/nologin ftpuser1
sudo useradd -m -g ftpgrupo -s /usr/sbin/nologin ftpuser2
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_3/Imagenes/2.png?raw=true)

---

## Directorio raíz.

- Creo el directorio para el grupo, le asigo el propietario y drupo, y los permisos

```bash
sudo mkdir -p /srv/ftp/ftpgrupo
sudo chown root:ftpgrupo /srv/ftp/ftpgrupo
sudo chmod 770 /srv/ftp/ftpgrupo
```
- `7` → root: lectura, escritura, ejecución

- `7` → grupo: lectura, escritura y ejecución

- `0` → otros: sin acceso

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_3/Imagenes/3.png?raw=true)

- Configuro `vsftpd.conf` para usar el directorio.

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_3/Imagenes/4.png?raw=true)
![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_3/Imagenes/5.png?raw=true)

---

## Límites de conexión.

- Dentro del archivo configuro un límite global de 10 clientes y por ip solo dos conexiones.

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_3/Imagenes/6.png?raw=true)
