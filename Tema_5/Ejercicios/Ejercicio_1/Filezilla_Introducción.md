<h1 align="center">Filezilla - Introducción y arquitectura</h1>

## FTP vs FTPS vs SFTP

- ***FTP (File Transfer Protocol):*** protocolo de transferencia de archivos sin cifrado. Usa dos conexiones: control y datos.

- ***FTPS (FTP Secure):*** extensión de FTP que añade cifrado mediante SSL/TLS. Mantiene la misma arquitectura que FTP.

- ***SFTP (SSH File Transfer Protocol):*** protocolo diferente a FTP. Funciona sobre SSH, utiliza un solo canal cifrado y no
separa control y datos.

---

## Arquitectura cliente–servidor.

**FTP** sigue un modelo *cliente–servidor*.

- El ***cliente*** FTP inicia la conexión.

- El ***servidor*** FTP espera conexiones entrantes.

- Se establecen dos canales independientes: *canal de control y canal de datos*.

---

## Puertos implicados.

- ***Puerto 21:*** canal de control *(siempre)*.

- ***Puerto 20:*** canal de datos en modo activo.

- ***Rango de puertos altos (ej. 50000–51000):*** canal de datos en modo pasivo.

---

## Esquema del flujo de conexión FTP.

- ***Canal de control:*** se usa para comandos y respuestas (USER, PASS, LIST, RETR, etc).

```
Cliente FTP                  Servidor FTP
     |                             |
     |---- Conexión TCP (21) ----->|
     |                             |
     |<--- Respuestas y comandos --|
     |                             |
```

- ***Canal de datos:*** se usa para transferir archivos y listados de directorios.

```
Cliente FTP                  Servidor FTP
     |                             |
     |==== Conexión de DATOS =====>|
     |   (archivos / listados)     |
     |                             |
```

---

## Modo activo vs modo pasivo.

***Modo pasivo:*** el cliente inicia ambas conexiones.

*Características:*
- El servidor abre un puerto alto y lo comunica al cliente.

- El cliente inicia la conexión de datos.

- Es el modo más usado actualmente y compatible con firewalls.

```
Cliente FTP                  Servidor FTP
     |                             |
     |---- Control (21) ---------->|
     |                             |
     |---- Datos (puerto alto) --->|
     |    (Cliente → Servidor)     |
```

***Modo activo:*** el servidor inicia la conexión de datos hacia el cliente.

*Características:*
- El cliente indica al servidor en qué puerto escuchar.

- El servidor conecta desde su puerto 20.

- Puede fallar si el cliente está detrás de un firewall o NAT.

```
Cliente FTP                  Servidor FTP
     |                             |
     |---- Control (21) ---------->|
     |                             |
     |<--- Datos (20) -------------|
     |    (Servidor → Cliente)     |
```
