<h1 align="center">HTTPS en Apache</h1>

En este documento explicaré un poco lo que es HTTPS, su importancia en el uso web, explicaré los certificados 
y después configuraré en una máquina con Ubuntu el HTTPS en Apache.

<h2 align="center">Indice</h2>

1.  [HTTPS y su importancia](#https-y-su-importancia)
    
2.  [Tipos de certificados SSL/TLS](#tipos-de-certificados-ssltls)
    
3.  [Habilitar SSL/TLS](#habilitar-ssltls)
    
4.  [Ejecución técnica](#ejecución-técnica)
    
    -   4.1 [Instalar y verificar Apache2](#1-instalar-y-verificar-el-estado-de-apache2)
        
    -   4.2 [Habilitar módulos SSL y headers](#2-habilitar-los-módulos-ssl-y-headers)
        
    -   4.3 [Generar un certificado SSL/TLS autofirmado](#3-generar-un-certificado-ssltls-autofirmado)
        
    -   4.4 [Configurar VirtualHost para HTTPS](#4-configurar-un-virtualhost-para-https-puerto-443)
        
    -   4.5 [Redirección HTTP → HTTPS](#5-redirección-automática-de-http--https)
        
    -   4.6 [Reiniciar Apache y validar](#6-reiniciar-apache-y-validar-la-implementación)
        
5.  [Conclusión](#conclusión)
    
6.  [Bibliografía](#bibliografía)

   
<h2 align="center">HTTPS y su importancia</h2>

***HTTPS*** es la versión segura de ***HTTP*** que **cifra** la información transmitida entre el navegador y el servidor web, protegiéndola de interceptaciones y manipulaciones. Su importancia radica en proteger datos   
sensibles como contraseñas y datos financieros, mejorar la confianza del usuario y el posicionamiento en los motores de búsqueda (SEO), además de asegurar la confidencialidad y la integridad de los datos durante la 
navegación.

El funcionamiento del protocolo ***HTTPS*** está basado en un principio muy sencillo: los certificados. Estos certificados son los SSL, que son certificados más antiguos de un sistema desarrollado para garantizar la 
comunicación segura entre servidor y cliente, o los TLS, que son sus sucesores, más modernos y seguros.

<h2 align="center">Tipos de certificados SSL/TLS</h2>

- **Certificado autofirmado:** lo crea el propio dueño del servidor y no está validado por una autoridad confiable, por eso los navegadores muestran advertencias. Se usa principalmente para pruebas o entornos internos.
  
- **Certificado de una CA confiable:** lo emite una Autoridad Certificadora reconocida, por lo que los navegadores lo aceptan sin alertas. Es el tipo adecuado para sitios web públicos y producción.

<h2 align="center">Habilitar SSL/TLS</h2>

Para habilitar SSL/TLS en Apache2 en Ubuntu, normalmente necesitas cargar y activar el siguiente módulo:

- **ssl:** es el módulo principal que permite a Apache manejar conexiones HTTPS usando SSL/TLS.

<h2 align="center">Ejecución técnica</h2>

## 1. Instalar y verificar el estado de Apache2

Como yo ya lo instalé anteriormente solo pondré el siguiente comando para verificar si está activo el servicio:

```bash
systemctl status apache2
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/1.png?raw=true)

---

## 2. Habilitar los módulos SSL y headers

Para habilitar los módulos SSL y headers solo necesito poner los dos siguientes comandos:
```bash
sudo a2enmod ssl
sudo a2enmod headers
```

Reinicio Apache para aplicar los cambios:

```bash
sudo systemctl restart apache2
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/2.png?raw=true)

---

## 3. Generar un certificado SSL/TLS autofirmado

Instalo el openssl para generar certificados:

```bash
sudo apt install openssl
```

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/3.png?raw=true)

Generar el certificado autofirmado válido por 1 año:

```bash
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048
-keyout /etc/ssl/private/apache-selfsigned.key
-out /etc/ssl/certs/apache-selfsigned.crt
```

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/4.png?raw=true)
![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/5.png?raw=true)

---

## 4. Configurar un VirtualHost para HTTPS (puerto 443)

Creo y edito el archivo del VirtualHost SSL para que el puerto sea 443:

```bash
sudo nano /etc/apache2/sites-available/virtual-ssl.conf
```

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/6.png?raw=true)
![Captura 7](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/6.png?raw=true)

Habilitar el nuevo VirtualHost y recargar el servicio:

```bash
sudo a2ensite virtual-ssl.conf
```

![Captura 8](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/8.png?raw=true)

---

## 5. Redirección automática de HTTP → HTTPS

Editar el sitio para que redirigieraa HTTPS:

```bash
sudo nano /etc/apache2/sites-available/virtual-ssl.conf
```

![Captura 9](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/9.png?raw=true)

---

## 6. Reiniciar Apache y validar la implementación

Reiniciar:

```bash
sudo systemctl restart apache2
```

Verifico con curl, en este caso a mi no me ha conseguido verificar la página:

```bash
curl -I -k https://danidaw.com
```

![Captura 10](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/10.png?raw=true)
![Captura 11](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_2/imagenes/11.png?raw=true)

---
## Conclusión

Es necesario utilizar HTTPS para la seguridad de tu web y de los usuarios que accedan a la web.
Pero si que es verdad que lo veo complicado de configurar bien para que funcione.

## Bibliografía

- [Certificado y HTTPS](https://www.digitalocean.com/community/tutorials/how-to-create-a-self-signed-ssl-certificate-for-apache-in-ubuntu-18-04-es)

