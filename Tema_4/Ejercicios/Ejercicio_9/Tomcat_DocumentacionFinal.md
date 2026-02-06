<h1 align="center">Tomcat - Documentación final</h1>

## Arquitectura básica de Tomcat.

Apache Tomcat es un contenedor de servlets y JSP basado en una arquitectura modular. Sus principales componentes son:

- **_Catalina_**: núcleo del contenedor de servlets.
- **_Coyote_**: conector HTTP que gestiona las peticiones cliente-servidor.
- **_Jasper_**: motor de compilación y ejecución de JSP.
- **_Webapps_**: aplicaciones web desplegadas (WAR o directorios).
- **_Connectors_**: reciben peticiones externas (HTTP/HTTPS/AJP).
- **_Engine / Host / Context_**: jerarquía interna para la gestión de aplicaciones.

La estructura básica sigue el modelo:
```

Cliente → Conector → Engine → Host → Context → Aplicación

```

---

## Configuración del servidor.

La configuración de Tomcat se realiza principalmente mediante archivos XML:

- `server.xml`: configuración de conectores, puertos, hilos y timeouts.
- `web.xml`: configuración global de aplicaciones web.
- `context.xml`: recursos como bases de datos y parámetros por contexto.
- `tomcat-users.xml`: usuarios y roles para autenticación.

Se ajustaron parámetros para mejorar el rendimiento bajo carga:
- `maxThreads`
- `acceptCount`
- `connectionTimeout`

---

## Integración con servidor web.

Se integró Tomcat con **Apache HTTP Server** mediante **reverse proxy**:

- Apache recibe las peticiones HTTP.
- Apache redirige las peticiones dinámicas a Tomcat.
- Tomcat procesa la aplicación y devuelve la respuesta.

Ventajas:
- Mayor rendimiento
- Mejor seguridad
- Separación de responsabilidades
- Posibilidad de balanceo de carga

---

## Seguridad aplicada.

Se implementaron varias medidas de seguridad:

- Definición de **usuarios y roles** en `tomcat-users.xml`.
- Restricción de acceso a **Manager y Host Manager**.
- Autenticación basada en roles (`manager-gui`, `admin-gui`).
- Configuración de **HTTPS** mediante:
  - Generación de un keystore
  - Conector SSL en `server.xml`
- Uso de puertos seguros y limitación de interfaces administrativas.

---

## Pruebas de rendimiento.

Se realizaron pruebas de carga con **ApacheBench**:

- 1000 peticiones
- 50 peticiones concurrentes

Resultados:
- Mejora del número de peticiones por segundo tras los ajustes.
- Reducción del tiempo medio de respuesta.
- Disminución de los picos de latencia.
- Ninguna petición fallida en ambos escenarios.

Esto demuestra que la optimización de hilos y conectores mejora el rendimiento global.

---

## Recomendaciones de administración.

Buenas prácticas recomendadas:

- No usar el usuario `admin` por defecto.
- Restringir el acceso a interfaces administrativas.
- Monitorizar logs (`catalina.out`, `localhost.log`).
- Ajustar hilos según la carga real.
- Usar HTTPS siempre en producción.
- Realizar copias de seguridad de la configuración.
- Reiniciar Tomcat tras cambios críticos.

---

## Despliegue en contenedores (Docker).

Se utilizó la imagen oficial de Tomcat en Docker:

- Despliegue rápido y reproducible.
- Aplicaciones montadas en `/usr/local/tomcat/webapps`.
- Exposición del puerto 8080.
- Posibilidad de montar volúmenes para persistencia.

Ventajas frente a Tomcat nativo:
- Mayor portabilidad
- Aislamiento del sistema
- Facilidad de escalado
- Ideal para entornos cloud y DevOps
