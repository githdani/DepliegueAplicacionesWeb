<h1 align="center">Tomcat -Pruebas de funcionamiento</h1>

## Primera prueba de rendimiento.

- Para acceder a las interfaces hay que poner las siguientes URLs.
```bash
http://localhost:8080/manager/html
http://localhost:8080/host-manager/html
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_6/Imagenes/1.png?raw=true)
![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_6/Imagenes/2.png?raw=true)

---

## Funciones principales.

| Función                         | *Tomcat Manager* | *Tomcat Host Manager* | *Descripción*                                                           |
| ------------------------------- | -------------- | ------------------- | --------------------------------------------------------------------- |
| ***Despliegue***                  | ✔              | ✖                   | Permite desplegar aplicaciones web (`.war`) sin reiniciar Tomcat      |
| ***Recarga***                     | ✔              | ✖                   | Recarga una aplicación para aplicar cambios de configuración o código |
| ***Parada / Arranque***           | ✔              | ✖                   | Detiene o inicia aplicaciones individuales                            |
| ***Eliminación***                 | ✔              | ✖                   | Elimina aplicaciones desplegadas                                      |
| ***Creación de hosts virtuales*** | ✖              | ✔                   | Crea y gestiona dominios virtuales                                    |
| ***Modificación de hosts***       | ✖              | ✔                   | Cambia parámetros de hosts existentes                                 |
| ***Monitorización***              | ✔              | ✖                   | Muestra sesiones activas y estado de las apps                         |


---

## Ficha descriptiva.

| Herramienta                   | *Tomcat Manager*                     | *Tomcat Host Manager*               |
| ----------------------------- | ----------------------------------- | --------------------------------- |
| ***Función principal***         | Administración de aplicaciones web  | Administración de hosts virtuales |
| ***URL de acceso***             | `/manager/html`                     | `/host-manager/html`              |
| ***Rol requerido***             | `manager-gui`                       | `admin-gui`                       |
| ***Nivel de gestión***          | Aplicaciones                        | Infraestructura                   |
| ***Permite despliegue WAR***    | Sí                                  | No                                |
| ***Permite recarga de apps***   | Sí                                  | No                                |
| ***Permite parada de apps***    | Sí                                  | No                                |
| ***Permite creación de hosts*** | No                                  | Sí                                |
| ***Uso típico***                | Gestionar apps sin reiniciar Tomcat | Alojar múltiples dominios         |
