<h1 align="center">Filezilla - Documentación final</h1>

## Instalación del servidor.

- El servicio FTP se instaló en un sistema Ubuntu utilizando el servidor **vsftpd**, un servidor FTP ligero y seguro.

```bash
sudo apt update
sudo apt install vsftpd
````

- El servicio se configuró para iniciarse automáticamente al arrancar el sistema.

---

## Configuración básica.

La configuración principal se realizó en el archivo `/etc/vsftpd.conf`, definiendo parámetros como:

* Puerto de escucha
* Activación de usuarios locales
* Permisos de escritura
* Directorio raíz de los usuarios FTP

El servicio se reinició tras cada cambio para aplicar la configuración.

---

## Usuarios y permisos.

Se creó un grupo de usuarios con permisos limitados y se asociaron usuarios al mismo.

* Cada usuario tiene un directorio raíz definido.
* Se aplicó el principio de mínimos privilegios.
* Los permisos de lectura, escritura y borrado se controlaron mediante permisos del sistema de archivos.

Esto permite una gestión segura y organizada del acceso al servidor FTP.

---

## Seguridad (FTPS).

Se configuró **FTPS explícito** mediante un certificado TLS para cifrar las conexiones FTP.

* Se generó un certificado autofirmado.
* Se obligó a los usuarios a usar conexión segura.
* Se verificó el cifrado desde el cliente FileZilla.

El uso de FTPS protege credenciales y datos transferidos.

---

## Modos activo y pasivo.

Se configuró un rango de puertos pasivos para mejorar la compatibilidad con firewalls y NAT.

* **Modo activo:** el servidor inicia la conexión de datos.
* **Modo pasivo:** el cliente inicia ambas conexiones.

El modo pasivo se considera más adecuado en redes con firewall.

---

## Clientes utilizados.

Se realizaron pruebas de conexión con clientes en línea de comandos y gráficos:

### Clientes CLI-

* `ftp`: conexión básica y pruebas de autenticación.
* `lftp`: cliente avanzado con soporte FTPS.
* `curl`: descarga de archivos desde el servidor FTP.

### Clientes gráficos.

* **FileZilla Client**

Este cliente permitió realizar transferencias bidireccionales y verificar el estado de las conexiones.

---

## Integración web.

El servidor FTP se integró con el servidor web (Apache / Nginx) vinculando el acceso FTP al **DocumentRoot**.

* Los archivos web se subieron por FTP.
* El contenido se sirvió automáticamente vía HTTP.
* Se verificó el acceso desde el navegador.

Este método permite publicar contenido web mediante FTP.

---

## Recomendaciones de administración.

Para un entorno de producción se recomiendan las siguientes buenas prácticas:

* Limitar conexiones simultáneas.
* Activar y revisar logs periódicamente.
* Realizar copias de seguridad.
* Usar FTPS o SFTP en lugar de FTP sin cifrar.
* Configurar correctamente firewall y NAT.
* Mantener el sistema actualizado.

