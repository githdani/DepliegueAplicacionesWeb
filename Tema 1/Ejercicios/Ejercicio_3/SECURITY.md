# Práctica de seguridad y accesibilidad en el control de versiones

## Explicación del .gitignore

El archivo ***.gitignore***, es un archivo de texto que le dice a Git qué archivos o carpetas *ignorar* en un proyecto.

Generalmente se coloca en la *raíz* del proyecto en el que vamos a trabajar y cualquier entrada en ese archivo se **ignorará en todo el proyecto de Git**.

La configuración de mi ***.gitignore*** y el **por qué** he elegido esos archivos:

| Archivos con contraseñas  |  |
| ------------- |-------------|
| ***.env***     | Archivo de variables de entorno, puede contener claves API o contraseñas de Bases de Datos.     |
| ***.key***     | Puede contener datos como certificados digitales, licencias, etc.     |
| ***.pem***      |  Puede contener certificados digitales, claves privadas, etc.    |

| Archivos temporales  |  |
| ------------- |-------------|
| ***.tmp***     | Archivos temporales generados por programas de forma provisional.     |
| ***.cache***     |   Datos que se guardan para acelerar procesos que se regeneran automáticamente por eso no deben guardarse en GitHub.   |
| ***.lock***      |   Archivos de bloqueo que evitan que dos procesos usen lo mismo a la vez.   |

| Binarios y compilados  |  |
| ------------- |-------------|
| ***.exe***     |  Archivo ejecutable en Windows, no es portable entre sistemas.    |
| ***.dll***     |  Librerías dinámicas en Windows, no se debe guardar porque se generan en la compilación.    |
| ***.so***      |  Librerías compartidas en Linux, el mismo por qué de los .dll    |
| ***.o***       |  Archivos objeto generados por compiladores, no sirven en el repositorio. |
| ***.out***     |  Salida compilada que se genera al compilar. |

| Configuraciones locales  |  |
| ------------- |-------------|
| ***.DS_Store*** | Metadatos de las preferencias visuales de una carpeta en MacOs, solo sirven en un pc mac.     |
| ***Thumbs.db*** | Miniaturas de imagenes en Windows, no aporta nada al repositorio.     |
| ***.log***      | Archivos de registro de errores o procesos que solo son útiles en local.     |
| ***.config***   | Información de la configuración local de alguna aplicación.   |
| ***.idea/***    | Carpeta de configuración de entornos de desarrollo.  |
| ***.vscode/***  | Carpeta de configuración de Visual Studio Code. |

## Buenas prácticas de seguridad.

* **Ramas protegidas:**

