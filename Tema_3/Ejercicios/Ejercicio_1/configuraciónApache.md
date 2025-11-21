<h1 align="center">Configuración de Apache</h1>

![Apache](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/apache.png?raw=true)

En este documento redactaré la instalación del Apache en Ubuntu y después su configuración para lanzar una web.

---

<h2 align="center">Palabras claves</h2>

`Apache` - `Servidor web` - `Ubuntu` - `VirtualHost` - `DocumentRoot` - `sites-available` - `Firewall` - `/etec/hosts`

---

<h2 align="center">Indice</h2>

1.  [Instalación de Apache](#instalación-de-apache)
    
2.  [Configuración](#configuración)
    
    -   2.1 [Crear sitio web](#1-crear-sitio-web)
        
    -   2.2 [Configuración del archivo VirtualHost](#2-configuración-del-archivo-virtualhost)
        
    -   2.3 [Activación del archivo VirtualHost](#3-activación-del-archivo-virtualhost)

    -   2.4 [Corrección del error](#4-corrección-del-error)
        
3.  [Conclusión](#conclusión)
    
4.  [Bibliografía](#bibliografía)

---

<h2 align="center">Instalación de Apache</h2>

Para empezar a instalar el Apache en ubuntu hay que poner el siguiente comando en la terminal:

```bash
sudo apt install apache2
```

Después le damos permisos para que utilice el firewall:

```bash
sudo ufw allow 'Apache'
```

Ya se puede iniciar el Apache:

```bash
sudo systemctl start apache2
```

---

<h2 align="center">Configuración</h2>

## 1. Crear sitio web

De primeras me creo la carpeta para la web y me meto dentro de esa carpeta:

```bash
sudo mkdir /var/www/gci/
cd /var/www/gci/
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_1.png?raw=true)

Una vez dentro creo un archivo html:

```bash
nano index.html
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_2.png?raw=true)
![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_3.png?raw=true)

---

## 2. Configuración del archivo VirtualHost

Primero me meto en la carpeta de ***sites-availble*** de Apache, copio el archivo default de Apache para crear el archivo gci.conf para mi web y acto seguido me meto a editarlo:

```bash
cd /etc/apache2/sites-available/
sudo cp 000-default.conf gci.conf
sudo nano gci.conf
```

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_4.png?raw=true)
![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_5.png?raw=true)

---

## 3. Activación del archivo VirtualHost

Después de configurar el archivo VirtualHost de la web tengo que activarlo con el siguiente comando:

```bash
sudo a2ensite gci.conf
```

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_6.png?raw=true)

Al activarlo pide que hagamos un ***reload*** al servicio Apache para que vargue la web:

```bash
sudo service apache2 reload
```

![Captura 7](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_7.png?raw=true)

Ahora supuestamente debería cargarse la web poniendo la url en el navegador pero va a fallar como en la siguiente imagen:

![Captura 8](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_8.png?raw=true)

---

## 4. Corrección del error

Ahora hay que abrir el archivo hosts del sistema para editarlo y poner la web nueva:

```bash
sudo nano /etc/hosts
```

![Captura 9](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_9.png?raw=true)
![Captura 10](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_10.png?raw=true)

Vuelvo a hacer el reload del servicio apache y ahora si funcinará la web:

![Captura 11](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_11.png?raw=true)

Hice una prueba en otro dispositivo en la misma red pero solo entra en la web default de apache.

![Captura 12](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_3/Ejercicios/Ejercicio_1/imagenes/Screenshot_12.png?raw=true)

---

<h2 align="center">Conclusión</h2>

La instalación del Apache es fácil de seguir y muy simple de entender, pero la configuración empieza a complicarse sobretodo para buscar por qué falla en el último paso.
Una vez arreglado funciona bien en local pero en otros dispositivos sigue sin ir y por más que busque no encuentro como arreglarlo.

---

<h2 align="center">Bibliografía</h2>

- [Instalación y configuración](https://ubuntu.com/tutorials/install-and-configure-apache#1-overview)
