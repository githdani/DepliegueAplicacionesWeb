<h1 align="center">Filezilla - Configuración de FTP seguro (FTPS)</h1>

## Generar un certificado TLS.

- Primero genero un certificado TLS.
```bash
sudo openssl req -x509 -nodes -days 365 \
-newkey rsa:2048 \
-keyout /etc/ssl/private/vsftpd.key \
-out /etc/ssl/certs/vsftpd.crt
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_8/Imagenes/1.png?raw=true)

---

## Configuración FileZilla Server para FTPS explícito.

- Para configurar el TLS tengo que editar el `vsftpd.conf` y poner lo siguiente.
```bash
sudo nano /etc/vsftpd.conf

ssl_enable=YES

rsa_cert_file=/etc/ssl/certs/vsftpd.crt
rsa_private_key_file=/etc/ssl/private/vsftpd.key

ssl_tlsv1=YES
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_8/Imagenes/2.png?raw=true)
![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_8/Imagenes/3.png?raw=true)

- Luego en el Filezilla Client para que la conexión utilice TLS, en el Cifrado selecciono que requiera TLS explícito.

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_8/Imagenes/4.png?raw=true)

- Después salta una alerta de que hay que aceptar el certificado, solo la primera vez.

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_8/Imagenes/5.png?raw=true)

---

## Obligar el uso de conexión segura para usuarios.

- Para esto hay que volver al archivo `vsftpd.conf` y poner lo siguiente:
```bash
force_local_login_ssl=YES
```

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_8/Imagenes/6.png?raw=true)
