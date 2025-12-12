<h1 align="center">Tomcat - Despliegue simple de una aplicación web</h1>

## Crear archivo WAR

- Primero creo una carpeta en la raíz llamada **hello** con el ***WEB-INF***, dentro de la carpeta creo un index.jsp con un html báscio dentro.
```bash
sudo mkdir -p hello/WEB-INF
sudo nano hello/index.jsp
```

![Captura 1]()
![Captura 2]()

- Ahora me muevo a la carpeta **hello** que había creado antes. Una vez dentro ya puedo crear el archivo ***WAR***.
```bash
cd hello
sudo jar cvf hello.war *
```

![Captura 3]()

---

## Carpeta webapps

- Ahora copio el archivo **WAR** a la carpeta ***webapps*** de Tomcat.
```bash
sudo cp hello.war /opt/tomcat9/webapps/
cd /opt/tomcat9/webapps/
ls
```

![Captura 4]()

---

## Despliegue del WAR

- Ya con el WAR en la carpeta webapps inicio el servicio Tomcat y en el navegador pongo ***http://localhost:8080/hello***

![Captura 5]()
![Captura 2]()
