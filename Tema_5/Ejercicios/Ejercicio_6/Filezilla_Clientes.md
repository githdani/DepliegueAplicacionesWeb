<h1 align="center">Filezilla - Pruebas con clientes en línea de comandos</h1>

## Cliente usando ftp.

- Con `ftp localhost` conecto con el servidor.

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_6/Imagenes/1.png?raw=true)

---

## Cliente usando lftp.

- Primero tengo que instalarlo.

```bash
sudo apt install lftp -y
```

![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_6/Imagenes/2.png?raw=true)

- Una vez instalado puedo hacer la conexión con el servidor: `lftp ftp://anonymous@localhost`.

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_6/Imagenes/3.png?raw=true)

---

## Cliente usando curl.

- Con el curl de normal se utiliza solo para descargar archivos del servidor, para la conexion y descargar hay que poner lo siguiente:
```bash
curl ftp://anonymous@localhost/archivo_prueba.txt -o archivo_prueba.txt
```
![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_6/Imagenes/4.png?raw=true)

---

## Comandos y función.

| *Cliente* | *Comando*                                                                   | *Función*                  |
| -------   | -------------------------------------------------------------------------   | ------------------------   |
| ***ftp*** | `ftp localhost`                                                             | Conexión al servidor FTP   |
| ***ftp*** | `ls`                                                                        | Listar archivos            |
| ***ftp*** | `get archivo_prueba.txt`                                                    | Descargar archivo          |
| ***ftp*** | `put prueba.txt`                                                            | Subir archivo              |
| ***lftp***| `lftp ftp://anonymous@localhost`                                            | Conectar al servidor       |
| ***lftp***| `ls`                                                                        | Listar archivos            |
| ***lftp***| `get archivo_prueba.txt`                                                    | Descargar archivo          |
| ***curl***| `curl ftp://anonymous@localhost/archivo_prueba.txt -o archivo_prueba.txt`   | Descargar archivo FTP      |
