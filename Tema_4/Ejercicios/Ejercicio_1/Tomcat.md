<h1 align="center">Tomcat: investigación y descripción</h1>

<h2 align="center">Catalina</h2>

Catalina es el nombre del contenedor de servlets del **Jakarta Tomcat** desde la versión 4x. Fue desarrollado bajo el Proyecto Jakarta de la Apache Software Foundation. **Tomcat** implementa las especificaciones de 
**Sun Microsystems** para **_servlets_** y **Java Server Pages** ***(JSP)***, las cuales son importantes tecnologías web basadas en **Java**.

El contenedor de servlets de Tomcat fue rediseñado como **Catalina** en la versión 4x de **Tomcat**. El arquitecto de **Catalina** fue ***Craig McClanahan***.

---

<h2 align="center">Coyote</h2>

El elemento **Conector HTTP/1.1 de Coyote** representa un componente ***Conector*** compatible con el protocolo **HTTP/1.1**. Permite a **Catalina** funcionar como un servidor web independiente, además de ejecutar 
servlets y páginas JSP. Una instancia específica de este componente escucha las conexiones en un **puerto TCP** específico del servidor. Se pueden configurar uno o más Conectores como parte de un único Servicio , cada 
uno reenviando al Motor asociado para procesar la solicitud y generar la respuesta.

Al iniciar el servidor, este Conector creará varios subprocesos de procesamiento de solicitudes. Cada solicitud entrante requiere un subproceso mientras dure dicha solicitud. Si se reciben más solicitudes simultáneas 
de las que pueden gestionar los subprocesos de procesamiento de solicitudes disponibles, se crearán subprocesos adicionales hasta el máximo configurado.

---

<h2 align="center">Jasper</h2>

Jasper es el motor de procesamiento de **páginas JSP (JavaServer Pages)** integrado en Tomcat. Es el componente encargado de traducir las páginas JSP a **servlets Java**, compilar esos servlets y gestionarlos en 
tiempo de ejecución. Cuando un usuario solicita una JSP, Jasper revisa si ha cambiado desde la última compilación y, de ser necesario, la vuelve a traducir y compilar automáticamente. 

También incluye funciones de validación, manejo de expresiones EL, soporte para etiquetas personalizadas y optimizaciones para mejorar el rendimiento. Jasper es la pieza interna de Tomcat que convierte el código JSP 
en Java ejecutable y garantiza que las aplicaciones web basadas en JSP funcionen correctamente.

---

<h2 align="center">Manager y Host Manager</h2>

***Tomcat Manager*** es una aplicación web incluida con Tomcat que permite administrar aplicaciones desplegadas en el servidor. Mediante una interfaz web o comandos, permite _desplegar, actualizar, detener, iniciar y 
eliminar_ aplicaciones sin necesidad de reiniciar Tomcat.

***Tomcat Host Manager*** está orientado a la gestión de virtual hosts dentro del servidor. Su función principal es permitir _crear, modificar y eliminar hosts virtuales_ de forma dinámica, facilitando alojar 
múltiples sitios o aplicaciones en una misma instancia de Tomcat.

---

<h2 align="center">Estructura básica de directorios</h2>

Los directorios que se listan a continuación se encuentran ubicados en `/usr/local/tomcat-5.5/`

- ***bin***:  contiene los scripts de arrancar/parar.

- ***conf***:  contiene varios ficheros de configuración incluyendo server.xml (el fichero de configuración principal de Tomcat) y web.xml que configura los valores por defecto para las distintas aplicaciones
desplegadas en Tomcat.

- ***lib***: contiene varios ficheros jar que son utilizados por Tomcat, estos ficheros deben ser añadidos al classpath de Tomcat.

Estos son los principales, puede haber otros que generalmente no se modifican, como:

- ***work***  generado automáticamente por Tomcat, este es el sitio donde Tomcat sitúa los ficheros intermedios (como las páginas JSP compiladas) durante su trabajo. Si borramos este directorio mientras se está
ejecutando Tomcat no podremos ejecutar páginas JSP.

- ***classes***:  podemos crear este directorio para añadir clases adicionales al classpath. Cualquier clase que añadamos a este directorio encontrará un lugar en el classpath de Tomcat.

---

<h2 align="center">Flujo interno de funcionamientos</h2>

**Tomcat** funciona como un servidor web y contenedor de servlets que recibe peticiones **HTTP** a través de sus ***Connectors***, los cuales aceptan la solicitud del cliente y la entregan al motor interno llamado 
Catalina. **Catalina** organiza el procesamiento usando una estructura jerárquica de contenedores.

Cada **contenedor** cumple una función: los Host representan dominios virtuales y los Context representan aplicaciones web. Cuando llega una petición, **Tomcat** determina a qué ***Host y Context*** pertenece y la 
dirige al servlet correspondiente mediante el **Servlet Container**. El despliegue de aplicaciones puede realizarse automáticamente colocando **WARs** en el directorio webapps, o de forma manual con el **Manager**.

Durante el despliegue, **Tomcat** crea el Contexto, carga los servlets, analiza web.xml, inicializa recursos y deja la aplicación lista para procesar peticiones.
