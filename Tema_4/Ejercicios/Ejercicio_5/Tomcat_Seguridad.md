<h1 align="center">Tomcat - Configuración de seguridad en Tomcat</h1>

## Roles y usuarios en Tomcat.

- Edito el archivo tomcat-users.xml para definir los roles y los usuarios, dando permisos de administrador en tomcat.
```bash
sudo nano /opt/tomcat/conf/tomcat-users.xml
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/1.png?raw=true)
![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/2.png?raw=true)

---

## Restringir el acceso al Manager.

- Creo el archivo manager.xml para restringir el acceso.
```bash
sudo nano /opt/tomcat/conf/Catalina/localhost/manager.xml
```
![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/3.png?raw=true)
![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/4.png?raw=true)

---

## Configurar HTTPS con un keystore y un conector SSL.

- Creo el certificado SSL.
```bash
sudo keytool -genkeypair \
  -alias tomcat \
  -keyalg RSA \
  -keysize 2048 \
  -keystore /opt/tomcat/conf/keystore.jks \
  -validity 365
```

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/5.png?raw=true)

- Edito el archivo server.xml para añadir un conector con HTTPS.
```bash
sudo nano /opt/tomcat/conf/server.xml
```

![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/6.png?raw=true)
![Captura 7](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/7.png?raw=true)

- Ahora intento conectarme una vez reiniciado el servicio Tomcat pero da error de que no encuentra la dirección.

![Captura 8](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_5/Imagenes/8.png?raw=true)
