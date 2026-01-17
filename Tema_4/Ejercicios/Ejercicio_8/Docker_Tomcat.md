<h1 align="center">Tomcat - Tomcat en contenedores (Docker)</h1>

## Descargar imagen

- Para descargar la imagen oficial utilizo el siguiente comando:

```bash
docker pull tomcat:latest
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_8/Imagenes/1.png?raw=true)

- Lanzo el contenedor en el puerto 8080 y verifico que está en ejecución.

```bash
docker run -d \
  --name tomcat-docker \
  -p 8080:8080 \
  tomcat:latest

docker ps
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_8/Imagenes/2.png?raw=true)
![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_8/Imagenes/3.png?raw=true)

---

## Montar la web

- Copio el WAR que hice en otra actividad en la carpeta `/usr/local/tomcat/webapps/`.

```bash
docker cp hello.war tomcat-docker:/usr/local/tomcat/webapps/
```

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_8/Imagenes/4.png?raw=true)

- Ahora compruebo que puedo meterme en la web.

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_8/Imagenes/5.png?raw=true)

---

## Diferencias entre Tomcat nativo y Tomcat en contenedor

| *Aspecto*         | *Tomcat nativo*                     | *Tomcat en contenedor*           |
| ---------------- | --------------------------------- | ------------------------------ |
| ***Instalación***      | Manual (JDK, usuarios, servicios) | Automática mediante imagen     |
| ***Portabilidad***     | Baja                              | Muy alta                       |
| ***Aislamiento***      | Comparte SO                       | Aislado en contenedor          |
| ***Configuración***    | Directa sobre el sistema          | Mediante volúmenes y variables |
| ***Escalabilidad***    | Manual                            | Muy sencilla (réplicas)        |
| ***Consumo***          | Mayor                             | Más ligero                     |
| ***Reproducibilidad*** | Dependiente del sistema           | Totalmente reproducible        |
| ***Ideal para***       | Producción tradicional            | DevOps / Cloud / CI-CD         |
