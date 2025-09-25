# Primeros pasos con GitHub
Hecho por: _Daniel Ávila Contento_
## ¿Qué es GitHub y para que sirve?
GitHub es una plataforma basada en la nube donde puedes **almacenar, compartir y trabajar** junto con otros usuarios para escribir código.

Almacenar en un ***repositorio*** en GitHub te permite lo siguiente:
* Presentar y compartir el trabajo.
* Seguir y administrar los cambios en el código.
* Dejar que otros usuarios revisen el código y realicen sugerencias para mejorarlo.
* Colaborar en un proyecto compartido, sin preocuparse de que los cambios afectarán al trabajo de los colaboradores antes de que esté listo.

Todo esto es posible gracias al software de código abierto Git, en el que se basa GitHub.
## Pasos a seguir.
Para crear un _nuevo repositorio_ le damos al botón **New**. Una vez dentro tenemos que rellenar los campos:
* ***Repository Name:*** donde pondremos el nombre que queremos para el repositorio.
* ***Description:*** podemos poner una descripción.
* ***Visibility:***  si queremos que sea público o privado, en este caso elijo público.
* Y podemos marcar la opción de que genere un ***README*** en el repositorio.

![Captura 1](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/1.png)

Ahora para subir un archivo al repositorio le damos a ***ADD FILE*** y acto seguido a ***UPLOAD FILES***.

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/2.png)

Subimos el archivo arrastrandolo hasta el recuadro (en este caso he subido ***holamundo.php***), ponemos una pequeña descripción al ***commit*** para saber en un futuro que hemos subido o cambiado. Al hacer todo esto le damos a **Commit changes** y se guarda.

![Captura 3](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/3.png)

![Captura 4](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/4.png)

> Para ver el historial de cambios que hacemos le damos a la pestaña ***Commits***.

![Commits](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/commits.png)
### Crear una rama y administrarla

Podemos trabajar en diferentes versiones del proyecto sin afectar a la ***rama principal*** creando ***nuevas ramas***.

Hacemos clic en el ***main*** del repositorio y en el menú desplegable le damos a ***Create branch***. Ahí ponemos el nombre a la rama (yo le pongo ***Prueba***) y se crea.

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/5.png)

Ahora para fusionar los cambios de esta rama a la rama principal vamos a la pestaña ***Pull Request***.

![Captura 7](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/7.png)

Le damos a ***New Pull Request*** y una vez dentro donde pone base elegimos la rama principal **main** y en el compare la rama **Prueba**, así los cambios que haya en la rama Prueba se guardarán tambien en la rama principal main al darle a ***Create Pull Request***.

![Captura 8](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/8.png)

Te llevará a una pestaña en la que puedes poner una **descripción** de la fusión.

![Captura 9](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/9.png)

Ahora con todo **revisado** le damos a ***Merge Pull Request*** para que termine de hacer la fusión.

![Captura 10](https://raw.githubusercontent.com/githdani/DepliegueAplicacionesWeb/refs/heads/main/Tema%201/Ejercicios/Ejercicio%201/Imagenes%20Git/10.png)

## Conclusión

***GitHub*** es muy útil para guardar **proyectos y compartirlos**, ya sea un trabajo para la empresa o personalmente como portfolio en un *Curriculum Vitae*.
