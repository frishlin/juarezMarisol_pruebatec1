# juarezMarisol_pruebatec1
HAB - Prueba técnica 1
# Sistema de Gestión de Empleados

Este proyecto es una aplicación para la gestión de empleados que permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) en una base de datos MySQL. 
La aplicación está desarrollada en Java utilizando JPA con EclipseLink y se ejecuta mediante Maven.

---

## Requisitos

- **Java JDK 17** o superior.
- **Maven 3.6** o superior.
- **MySQL Server**.
- **NetBeans 17** (opcional, pero recomendado para ejecución).

---

## Configuración de la Base de Datos

1. **Creación de la Base de Datos**
   Conéctate a tu servidor MySQL y crea la base de datos necesaria con el siguiente comando:
   ```sql
   CREATE DATABASE empleados;

2. **Selecciona la base de datos con el comando**
USE empleados;

3. **Algunos datos que pueden ser insertados con la siguiente línea de código**
INSERT INTO datos_empleados (id, nombre, apellido, cargo, salario, fechainicio) VALUES
(0, 'María', 'López', 'Cajero', 8500.50, '2022-03-15'),
(0, 'Juan', 'Pérez', 'Gerente', 15000.75, '2020-06-01'),
(0, 'Ana', 'García', 'Vendedor', 9000.25, '2021-11-20'),
(0, 'Carlos', 'Ramírez', 'Repartidor', 8000.00, '2023-01-10'),
(0, 'Luis', 'Hernández', 'Supervisor', 12000.30, '2019-08-25'),
(0, 'Sofía', 'Martínez', 'Cajero', 8500.60, '2022-12-01'),
(0, 'Daniel', 'Gómez', 'Vendedor', 8800.15, '2021-07-14'),
(0, 'Lucía', 'Torres', 'Repartidor', 7900.40, '2023-05-06'),
(0, 'Diego', 'Morales', 'Cajero', 10000.00, '2020-03-18'),
(0, 'Carmen', 'Castro', 'Cajero', 8600.80, '2022-09-10'),
(0, 'Miguel', 'Flores', 'Vendedor', 9100.50, '2021-01-22'),
(0, 'Valeria', 'Ríos', 'Supervisor', 12500.75, '2018-11-30'),
(0, 'Jorge', 'Mendoza', 'Repartidor', 8000.25, '2023-02-28'),
(0, 'Fernanda', 'Reyes', 'Vendedor', 9300.60, '2020-07-04'),
(0, 'Emilio', 'Ruiz', 'Cajero', 10500.10, '2019-05-15');
