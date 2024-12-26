-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-12-2024 a las 18:09:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_empleados`
--

CREATE TABLE `datos_empleados` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `FECHAINICIO` date DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `datos_empleados`
--

INSERT INTO `datos_empleados` (`ID`, `APELLIDO`, `CARGO`, `FECHAINICIO`, `NOMBRE`, `SALARIO`) VALUES
(1, 'López', 'Cajero', '2022-03-15', 'Ramón', 8500.5),
(2, 'Pérez', 'Gerente', '2020-06-01', 'Juan', 15000.75),
(3, 'García', 'Vendedor', '2021-11-20', 'Ana', 9000.25),
(4, 'Ramírez', 'Repartidor', '2023-01-10', 'Carlos', 8000),
(5, 'Hernández', 'Supervisor', '2019-08-25', 'Luis', 12000.3),
(6, 'Martínez', 'Cajero', '2022-12-01', 'Sofía', 8500.6),
(7, 'Gómez', 'Vendedor', '2021-07-14', 'Daniel', 8800.15),
(8, 'Torres', 'Repartidor', '2023-05-06', 'Lucía', 7900.4),
(9, 'Morales', 'Cajero', '2020-03-18', 'Diego', 10000),
(10, 'Castro', 'Cajero', '2022-09-10', 'Carmen', 8600.8),
(11, 'Flores', 'Vendedor', '2021-01-22', 'Miguel', 9100.5),
(12, 'Ríos', 'Supervisor', '2018-11-30', 'Valeria', 12500.75),
(13, 'Mendoza', 'Repartidor', '2023-02-28', 'Jorge', 8000.25),
(14, 'Reyes', 'Vendedor', '2020-07-04', 'Fernanda', 9300.6),
(15, 'Ruiz', 'Cajero', '2019-05-15', 'Emilio', 10500.1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datos_empleados`
--
ALTER TABLE `datos_empleados`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datos_empleados`
--
ALTER TABLE `datos_empleados`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
