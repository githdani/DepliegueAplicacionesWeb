<h1 align="center">Tomcat - Integración Tomcat + Servidor web</h1>

## Configurar reverse proxy hacia Tomcat

- Habilito los **módulos** necesarios en Apache:
```bash
sudo a2enmod proxy
sudo a2enmod proxy_http
sudo a2enmod proxy_ajp 
sudo systemctl restart apache2
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_4/Imagenes/1.png?raw=true)

- Edito el **VirtualHost** de Apache.
```bash
sudo nano /etc/apache2/sites-available/000-default.conf
```
![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_4/Imagenes/2.png?raw=true)
![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_4/Imagenes/3.png?raw=true)

---

## Verificar configuración

- Ahora **verifico** si está bien la configuración del Apache:
```bash
sudo apache2ctl configtest
sudo systemctl restart apache2
```

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_4/Imagenes/4.png?raw=true)

- Y para comprobar que funciona he ido al navegador ***http://localhost/hello***

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_4/Imagenes/5.png?raw=true)
