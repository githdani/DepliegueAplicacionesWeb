# Iniciación a la virtualización

### Captura de la guest additions instalada.
![Captura 13](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/13.png?raw=true)

### Instalación de Docker en Ubuntu

1. Descargamos el **docker-desktop-amd64.deb** en la página oficial de ***Docker***.
![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/1.png?raw=true)

2. Ya descargado nos metemos en la terminal para actualizar el sistema operativo y los paquetes instalados con el siguiente comando:

`sudo apt update && sudo apt upgrade -y`

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/2.png?raw=true)

3. Instalo dependencias:

`sudo apt install ca-certificates curl gnupg -y`

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/3.png?raw=true)

4. Añado el repositorio de Docker:

`curl -fsSL https://get.docker.com | sudo sh`

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/4.png?raw=true)

5. Instalo Docker Desktop:

`sudo apt install ./docker-desktop-amd64.deb -y`

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/5.png?raw=true)

6. Verifico que Docker funciona correctamente:

`sudo docker --version`

`sudo docker run hello-world`

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/6.png?raw=true)

7. Busco las imágenes disponibles:

`sudo docker search nginx`

![Captura 7](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/7.png?raw=true)

`sudo docker search tomcat`

![Captura 8](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/8.png?raw=true)

8. Descargo e inicio los contenedores:

`sudo docker run -d -p 8080:80 --name webserver nginx`

![Captura 9](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/9.png?raw=true)

`docker run -d -p 8081:8080 --name appserver tomcat`

![Captura 10](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/10.png?raw=true)

9. Verifico que los contenedores estén activos:

`sudo docker ps`

![Captura 11](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/11.png?raw=true)

10. Compruebo que se abren en el navegador:
![Captura 12](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_2/Ejercicios/Ejercicio_1/Capturas/12.png?raw=true)
