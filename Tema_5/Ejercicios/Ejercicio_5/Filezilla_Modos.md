<h1 align="center">Filezilla - Pruebas en modo activo y pasivo</h1>

## Configuración del modo pasivo.

- Dentro del `vsftpd.conf` pongo la siguiente configuración para activarlo y sus puertos.

```bash
sudo nano /etc/vsftpd.conf
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_5/Imagenes/1.png?raw=true)
![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_5/Imagenes/2.png?raw=true)

---

## Modo pasivo.

- Ahora hago una prueba en modo pasivo para ver como funciona. Pongo la orden `passive` para forzar el modo on.

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_5/Imagenes/3.png?raw=true)

---

## Modo activo.

- La prueba en modo activo, pongo la orden `passive off` para forzar el modo off.

![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_5/Ejercicios/Ejercicio_5/Imagenes/4.png?raw=true)

---

## Diferencias.

| Característica                   | *Modo Activo*  | *Modo Pasivo*  |
| ------------------------------   | -------------- | -------------- |
| *Quién inicia conexión de datos* | Servidor       | Cliente        |
| *Uso de puertos*                 | Dinámicos      | Rango definido |
| *Compatibilidad con firewall*    | Baja           | Alta           |
| *Uso en redes modernas*          | No recomendado | Recomendado    |
| *Seguridad*                      | Menor          | Mayor control  |
