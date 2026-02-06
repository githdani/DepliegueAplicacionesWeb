<h1 align="center">Filezilla - Disponibilidad y buenas prácticas</h1>

## Límites de conexión.

- El control de conexiones evita la sobrecarga del servidor y reduce el riesgo de ataques por saturación.

| Recomendaciones                                   | Ejemplos                        | Beneficios                            |
| ------------------------------------------------- | ------------------------------- | ------------------------------------- |
| Limitar el número total de conexiones simultáneas | `max_clients=50`                | Evita la saturación del servicio      |
| Limitar conexiones por dirección IP               | `max_per_ip=5`                  | Reduce abusos y ataques automatizados |
| Definir tiempos de espera                         | `idle_session_timeout`          | Libera recursos inactivos             |
| Usar rangos de puertos pasivos controlados        | `pasv_min_port / pasv_max_port` | Mejora la estabilidad de conexiones   |

---

## Logs y auditoría.

- Los registros permiten auditar el uso del servidor y detectar incidentes de seguridad.

| Recomendaciones             | Ejemplos                      | Beneficios                        |
| --------------------------- | ----------------------------- | --------------------------------- |
| Activar logs detallados     | `xferlog_enable=YES`          | Seguimiento completo de actividad |
| Registrar intentos fallidos | Logins fallidos en `/var/log` | Detección de ataques              |
| Proteger archivos de log    | Permisos restringidos         | Evita manipulaciones              |
| Revisar logs periódicamente | Análisis manual o automático  | Mejora la seguridad               |

---

## Copias de seguridad.

- Las copias de seguridad aseguran la recuperación del servicio ante fallos o pérdida de datos.

| Recomendaciones                    | Ejemplos           | Beneficios                |
| ---------------------------------- | ------------------ | ------------------------- |
| Realizar copias periódicas         | Backups diarios    | Minimiza pérdida de datos |
| Incluir configuración del servidor | `/etc/vsftpd.conf` | Restauración rápida       |
| Automatizar backups                | `cron`             | Reduce errores humanos    |
| Almacenar copias externas          | Servidor remoto    | Protección ante desastres |

---

## Firewall y NAT.

- Una configuración adecuada del firewall es esencial para la seguridad y conectividad del servidor FTP.

| Recomendaciones                          | Ejemplos                   | Beneficios               |
| ---------------------------------------- | -------------------------- | ------------------------ |
| Usar FTPS o SFTP                         | TLS activo                 | Cifrado de datos         |
| Deshabilitar acceso anónimo              | `anonymous_enable=NO`      | Mayor seguridad          |
| Aplicar principio de mínimos privilegios | Usuarios limitados         | Reduce riesgos           |
| Mantener el sistema actualizado          | Actualizaciones periódicas | Corrige vulnerabilidades |
| Monitorizar el servicio                  | Herramientas de monitoreo  | Prevención de fallos     |

