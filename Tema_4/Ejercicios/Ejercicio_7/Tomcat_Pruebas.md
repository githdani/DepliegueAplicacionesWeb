<h1 align="center">Tomcat - Pruebas de funcionamiento</h1>

## Primera prueba de rendimiento.

La prueba la realizo con ApacheBench bajo las siguientes condiciones:
- 1000 peticiones totales.
- 50 peticiones concurrentes.

```bash
ab -n 1000 -c 50 http://localhost:8080/hello/
```

![Captura 1](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_7/Imagenes/1.png?raw=true)
![Captura 2](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_7/Imagenes/2.png?raw=true)

### Resultados obtenidos

| Métrica | Valor |
|--------|-------|
| Concurrency Level | 50 |
| Time taken for tests | 1.576 s |
| Complete requests | 1000 |
| Failed requests | 0 |
| Requests per second | 634.41 req/s |
| Time per request (mean) | 78.814 ms |
| Transfer rate | 172.85 KB/s |

### Tiempos de conexión (ms)

| Fase | Mínimo | Media | Mediana | Máximo |
|-----|--------|-------|---------|--------|
| Connect | 0 | 0.8 | 0 | 14 |
| Processing | 9 | 53 | 49 | 480 |
| Waiting | 8 | 48 | 44 | 477 |
| Total | 9 | 54 | 49 | 484 |

Antes de realizar ajustes en la configuración de Tomcat, la web mostró un rendimiento correcto sin errores durante la 
ejecución de las pruebas. El tiempo medio de respuesta es inferior a 80 ms, aunque se detectaron picos de latencia cercanos 
a los 480 ms, lo que indica margen de mejora mediante optimización del servidor.

---

## Ajustes en Tomcat

Modifico los parámetros del conector HTTP en el archivo `server.xml`::
- Gestión de hilos (maxThreads).
- Hilos disponibles en espera.
- Tiempo de espera de conexión.

![Captura 3](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_7/Imagenes/3.png?raw=true)
![Captura 4](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_7/Imagenes/4.png?raw=true)

---

## Segunda prueba de rendimiento.

- Ejecuto nuevamente la prueba de carga con las mismas condiciones.

```bash
ab -n 1000 -c 50 http://localhost:8080/hello/
```

![Captura 5](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_7/Imagenes/1.png?raw=true)
![Captura 6](https://github.com/githdani/DepliegueAplicacionesWeb/blob/main/Tema_4/Ejercicios/Ejercicio_7/Imagenes/5.png?raw=true)

### Resultados obtenidos

| Métrica | Valor |
|--------|-------|
| Concurrency Level | 50 |
| Time taken for tests | 1.475 s |
| Complete requests | 1000 |
| Failed requests | 0 |
| Requests per second | 677.86 req/s |
| Time per request (mean) | 73.762 ms |
| Transfer rate | 184.69 KB/s |

### Tiempos de conexión (ms)

| Fase | Mínimo | Media | Mediana | Máximo |
|-----|--------|-------|---------|--------|
| Connect | 0 | 0.9 | 0 | 18 |
| Processing | 2 | 57 | 49 | 340 |
| Waiting | 1 | 49 | 43 | 313 |
| Total | 2 | 58 | 49 | 342 |

### Distribución de tiempos de respuesta

| Percentil | Tiempo (ms) |
|-----------|-------------|
| 50% | 49 |
| 66% | 65 |
| 75% | 70 |
| 80% | 76 |
| 90% | 91 |
| 95% | 116 |
| 98% | 157 |
| 99% | 211 |
| 100% | 342 |

---

## Comparativa de rendimiento (antes vs después)

| Métrica | Antes | Después | Variación |
|-------|-------|---------|-----------|
| Requests per second | 634.41 | 677.86 | ↑ +6.85% |
| Time per request (mean) | 78.81 ms | 73.76 ms | ↓ -6.4% |
| Tiempo total de prueba | 1.576 s | 1.475 s | ↓ |
| Tiempo máximo | 484 ms | 342 ms | ↓ -29% |
| Failed requests | 0 | 0 | = |

Tras ajustar los parámetros del servidor Tomcat, se observa una mejora en el rendimiento de la web. El número 
de peticiones atendidas por segundo aumentó, el tiempo medio de respuesta se redujo y los picos de latencia disminuyeron 
significativamente. Esto demuestra que una configuración adecuada del servidor tiene un impacto en su capacidad de 
respuesta y estabilidad.

