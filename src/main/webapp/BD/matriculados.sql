-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2025 a las 02:45:16
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `matriculados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnoweb`
--

CREATE TABLE `alumnoweb` (
  `codiEstdWeb` int(11) NOT NULL,
  `ndniEstdWeb` varchar(50) NOT NULL,
  `appaEstdWeb` varchar(50) NOT NULL,
  `apmaEstdWeb` varchar(50) NOT NULL,
  `nombEstdWeb` varchar(50) NOT NULL,
  `fechNaciEstdWeb` date NOT NULL,
  `logiEstd` varchar(100) NOT NULL,
  `passEstd` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `alumnoweb`
--

INSERT INTO `alumnoweb` (`codiEstdWeb`, `ndniEstdWeb`, `appaEstdWeb`, `apmaEstdWeb`, `nombEstdWeb`, `fechNaciEstdWeb`, `logiEstd`, `passEstd`) VALUES
(1, '87654321', 'García', 'Pérez', 'Juan', '2000-05-15', 'jgarcia', '$2a$12$gNBEAnKAy8m/gP/X/QLkKen643SHiGeIaRoeMC73jtVWnASsmH2iG'),
(2, '12345677', 'López', 'Martínez', 'María', '1999-08-22', 'mlopez', '$2a$10$OlQworq597EefCctkwPkruhCLE1a.1n2srXHKL8A8GAmJv3f9oSSu'),
(4, '71003310', 'Ortega', 'Espinoza', 'Gino', '2025-06-04', 'gino', '$2a$12$kKi30fJu1EeKHXZjXOL3Uu3P7cEoWAk9QkSc7JJwO0WazBIW5jNYW'),
(5, '12345678', 'Farfan', 'Espinoza', 'Aaron', '2025-06-05', 'aaron', '$2a$12$T/nDq5qmZSRXkfn/mki/g.tbtsYhxtHSL5PrRG1d3GZVzVVvagLsu');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `codiMedi` int(11) NOT NULL,
  `ndniMedi` varchar(8) DEFAULT NULL,
  `appaMedi` varchar(50) DEFAULT NULL,
  `apmaMedi` varchar(50) DEFAULT NULL,
  `nombMedi` varchar(50) DEFAULT NULL,
  `fechNaciMedi` date DEFAULT NULL,
  `logiMedi` varchar(100) DEFAULT NULL,
  `passMedi` varchar(500) DEFAULT NULL,
  `codigo2FA` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`codiMedi`, `ndniMedi`, `appaMedi`, `apmaMedi`, `nombMedi`, `fechNaciMedi`, `logiMedi`, `passMedi`, `codigo2FA`) VALUES
(1, '71003310', 'Ortega', 'Espinoza', 'Gino', '2025-06-10', 'gino', '1234', 'JBSWY3DPEHPK3PXP\r\n');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnoweb`
--
ALTER TABLE `alumnoweb`
  ADD PRIMARY KEY (`codiEstdWeb`),
  ADD UNIQUE KEY `ndniEstdWeb` (`ndniEstdWeb`),
  ADD UNIQUE KEY `logiEstd` (`logiEstd`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`codiMedi`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnoweb`
--
ALTER TABLE `alumnoweb`
  MODIFY `codiEstdWeb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `codiMedi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
