<h1 align="center">Archivos Tomcat</h1>

Para localizar los archivos importantes de **Tomcat** hay que meterse en la carpeta ***conf*** de **Tomcat**.
```bash
cd /opt/tomcat/conf
ls -l
```
![Captura 1]()

---

## conf/server.xml

Es el archivo de configuración **principal** del servidor Tomcat. Controla _cómo arranca y se comporta_ el servidor en su conjunto.
Define **Conectores** que escuchan peticiones HTTP/AJP, configura _Service, Engine, Host y Realm_, y configura recursos a nivel global.

Los **elementos** que se pueden configurar son los siguientes:
| Elemento      | Descripción                                              |
| ------------- | -------------------------------------------------------- |
| `<Server>`    | Puerto de apagado, servicios del servidor                |
| `<Service>`   | Agrupa `Connector` + `Engine`                            |
| `<Connector>` | Puertos (8080), protocolo (HTTP/1.1, AJP), SSL, timeouts |
| `<Engine>`    | Procesa las peticiones que llegan por los conectores     |
| `<Host>`      | Hosts virtuales, directorio de aplicaciones              |
| `<Realm>`     | Tipo de autenticación (JDBCRealm, MemoryRealm…)          |
| `<Executor>`  | Pools de hilos globales                                  |

---

## conf/web.xml

Es el **descriptor** de despliegue global. Afecta a _todas las aplicaciones web desplegadas_.
Define **comportamiento** por defecto de _servlets y filtros_, y configura **parámetros comunes** para todas las apps.

Los **elementos** que se pueden configurar son los siguientes:
| Elemento           | Descripción                        |
| ------------------ | ---------------------------------- |
| `<servlet>`        | Configuración de servlets globales |
| `<filter>`         | Filtros aplicados a todas las apps |
| `<mime-mapping>`   | Mapas de tipo MIME                 |
| `<session-config>` | Tiempo de expiración de sesión     |
| `<listener>`       | Listeners globales                 |
| `<error-page>`     | Páginas de error por defecto       |

---

## conf/tomcat-users.xml

Define **usuarios, contraseñas y roles** para la interfaz de administración:
- /manager/html
- /host-manager/html

Los **elementos** que se pueden configurar son los siguientes:
| Elemento       | Descripción                                          |
| -------------- | ---------------------------------------------------- |
| `<role>`       | Roles: `manager-gui`, `admin-gui`, `manager-script`… |
| `<user>`       | Usuarios y contraseñas                               |
| `<user roles>` | Qué puede hacer cada usuario                         |

Un ejemplo de configuración:
```bash
<role rolename="manager-gui"/>
<user username="admin" password="secreto" roles="manager-gui"/>
```

---

## conf/context.xml

Configura el **contexto** de las aplicaciones web a **nivel global**.
Define recursos de base de datos **(DataSource)**, parámetros de contexto y configura _sesiones, cookies, rutas de acceso, cross context, etc_.

Los **elementos** que se pueden configurar son los siguientes:
| Elemento            | Descripción                                |
| ------------------- | ------------------------------------------ |
| `<Context>`         | Atributos comunes a todas las aplicaciones |
| `<Resource>`        | Pools JDBC, JNDI, conexiones               |
| `<WatchedResource>` | Archivos que Tomcat vigila para reiniciar  |
| `<Manager>`         | Gestión de sesiones                        |
| `<Loader>`          | Configuración del classloader              |
| `<Environment>`     | Variables accesibles por JNDI              |

---

## Mapa visual de dependencias.

                 ┌────────────────┐
                 │  server.xml    │
                 │ (config global)│
                 └───────┬────────┘
                         │
                 ┌───────▼────────┐
                 │     Host        │
                 │ (virtual hosts) │
                 └───────┬────────┘
                         │
                 ┌───────▼────────┐
                 │   context.xml   │
                 │(config apps JNDI│
                 │  sesiones, etc.)│
                 └───────┬────────┘
                         │
                 ┌───────▼────────┐
                 │    web.xml      │
                 │ (config global  │
                 │   de servlets)  │
                 └───────┬────────┘
                         │
                 ┌───────▼────────┐
                 │ WEB-INF/web.xml │
                 │ (cada app)      │
                 └─────────────────┘


                 ┌────────────────┐
                 │ tomcat-users   │
                 │ (roles/usuarios│
                 │  del Manager)  │
                 └────────────────┘
