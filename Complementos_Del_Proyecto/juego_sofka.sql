-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2022 a las 20:24:19
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juego_sofka`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(1) NOT NULL,
  `id_dificultad` int(1) NOT NULL,
  `id_ronda` int(1) NOT NULL,
  `nom_categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `id_dificultad`, `id_ronda`, `nom_categoria`) VALUES
(1, 1, 1, 'FACIL'),
(2, 2, 2, 'INTERMEDIO'),
(3, 3, 3, 'MEDIO'),
(4, 4, 4, 'DIFICIL'),
(5, 5, 5, 'EXPERTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dificultad`
--

CREATE TABLE `dificultad` (
  `id_dificultad` int(1) NOT NULL,
  `nom_dificultad` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dificultad`
--

INSERT INTO `dificultad` (`id_dificultad`, `nom_dificultad`) VALUES
(1, 'FACIL'),
(2, 'INTERMEDIO'),
(3, 'MEDIO'),
(4, 'DIFICIL'),
(5, 'EXPERTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id_jugador` int(6) NOT NULL,
  `nom_jugador` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `id_partida` int(6) NOT NULL,
  `id_jugador` int(6) NOT NULL,
  `acumulado` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `id_pregunta` int(2) NOT NULL,
  `id_categoria` int(1) NOT NULL,
  `interrogante` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`id_pregunta`, `id_categoria`, `interrogante`) VALUES
(1, 1, 'La función ALTER en lenguaje sql que hace?\r\n'),
(2, 1, '¿Qué requieres para alojar tu sitio web en un servidor?\r\n'),
(3, 1, '¿Un ejemplo de sitio web estático es:?\r\n'),
(4, 1, '¿En donde se almacena la información que esta disponible en internet?\r\n'),
(5, 1, 'Es una de las características del paradigma de la POO\r\n'),
(6, 2, 'Un administrador de bases de datos mantiene la información:\r\n'),
(7, 2, 'Accesibilidad, Usabilidad, y __________ son tres factores principales para el diseño de un sitio web\r\n'),
(8, 2, 'El modelo que se enfoca en la interactividad de la interfaz del usuario es el modelo del:\r\n'),
(9, 2, '¿En que partes del MVC se ejecuta el Back-End\r\n\r\n'),
(10, 2, 'Que estructura corresponde a la estructura de decisión \r\n'),
(11, 3, 'En la extracción de información, las bases de datos deben estar normalizadas para que el repositorio:\r\n'),
(12, 3, '¿Qué significa el posicionamiento de un sitio web?\r\n'),
(13, 3, 'De esta manera se debe comenzar un archivo en HTL5:\r\n'),
(14, 3, 'Encargado de procesar todas las instrucciones que se definen en un lenguaje de programación\r\n'),
(15, 3, '[0,5,3,7,9], ¿Qué posición de arreglo ocupa el numero 3\r\n'),
(16, 4, 'En una BD relacional, para acceder al contenido de una tabla debes:\r\n'),
(17, 4, '¿Qué significa HTML?\r\n'),
(18, 4, 'El modelo cliente servidor se utiliza cunado: \r\n'),
(19, 4, 'Para el inicio de sesión se requiere un campo para el usuario y otro para la contraseña, estos deben de ser:\r\n'),
(20, 4, 'Es la capacidad que tiene una persona para analizar y resolver problemas\r\n'),
(21, 5, 'Cual es la función de un SCRIPT en una base de datos\r\n'),
(22, 5, '¿Qué NO se considera mantenimiento web?\r\n'),
(23, 5, 'Una forma valida para añadir coloren en HTML Y CSS ES:\r\n'),
(24, 5, 'Son los operadores lógicos de Conjunción y negación\r\n'),
(25, 5, 'Es el nombre técnico que se le da a un bloque de instrucciones escrito en un o lenguaje de programación\r\n');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id_respuesta` int(4) NOT NULL,
  `solucion` varchar(100) NOT NULL,
  `respuesta` int(1) NOT NULL,
  `id_pregunta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`id_respuesta`, `solucion`, `respuesta`, `id_pregunta`) VALUES
(1, 'Modifica la estructura de una tabla u objeto', 1, 1),
(2, 'Inserta datos a una tabla', 0, 1),
(3, 'Borra datos de una tabla', 0, 1),
(4, 'Intercambia datos entre tablas', 0, 1),
(5, 'Contratar un hosting\r\n', 1, 2),
(6, 'Crear una pagina web con php\r\n', 0, 2),
(7, 'Tener un sitio web\r\n', 0, 2),
(8, 'Tener un servidor\r\n', 0, 2),
(9, 'Blog web\r\n', 1, 3),
(10, 'Tienda virtual\r\n\r\n', 0, 3),
(11, 'Amazon\r\n\r\n', 0, 3),
(12, 'Red social\r\n\r\n', 0, 3),
(13, 'Servidores\r\n', 1, 4),
(14, 'Discos duros\r\n', 0, 4),
(15, 'La nube\r\n', 0, 4),
(16, 'Una pagina de internet\r\n', 0, 4),
(17, 'Ajusta el lenguaje al problema\r\n', 1, 5),
(18, 'ajusta el problema al lenguaje\r\n', 0, 5),
(19, 'Programación estructurada\r\n', 0, 5),
(20, 'programación secuencial \r\n', 0, 5),
(21, 'Segura y disponible para algunos usuarios de la empresa\r\n', 1, 6),
(22, 'Mejorar la calidad\r\n', 0, 6),
(23, 'guardar información\r\n', 0, 6),
(24, 'Montar servidores\r\n', 0, 6),
(25, 'posicionamiento\r\n', 1, 7),
(26, 'funcionalidad\r\n', 0, 7),
(27, 'interoperabilidad\r\n', 0, 7),
(28, 'Todas las anteriores\r\n', 0, 7),
(29, 'Diseñador\r\n', 1, 8),
(30, 'Programador\r\n', 0, 8),
(31, 'Analista \r\n', 0, 8),
(32, 'Artista', 0, 8),
(33, 'Modelo-Controlador\r\n', 1, 9),
(34, 'Modelo-Vista\r\n', 0, 9),
(35, 'Vista-Controlador\r\n', 0, 9),
(36, 'De igual forma y en sentido contrario\r\n', 0, 9),
(37, 'if-else\r\n', 1, 10),
(38, 'do-while\r\n', 0, 10),
(39, 'for-each\r\n', 0, 10),
(40, 'for-each\r\n', 0, 10),
(41, 'Cumpla con el objetico de predicción\r\n', 1, 11),
(42, 'se vea ordenado\r\n', 0, 11),
(43, 'No se repitan los datos\r\n', 0, 11),
(44, 'sea entendible\r\n', 0, 11),
(45, 'Optimizar y dar de alta el sitio en motores de búsqueda\r\n', 1, 12),
(46, 'Estar en cualquier navegador\r\n', 0, 12),
(47, 'Utilizar bien las etiquetas html\r\n', 0, 12),
(48, 'que sea responsivo\r\n', 0, 12),
(49, '<!DOCTYPE HTML>\r\n', 1, 13),
(50, '<HTML>\r\n', 0, 13),
(51, '< public class HTML { >\r\n', 0, 13),
(52, '<HEAD>\r\n', 0, 13),
(53, 'Interprete\r\n', 1, 14),
(54, '500', 0, 14),
(55, 'El lenguaje\r\n\r\n', 0, 14),
(56, 'El paradigma', 0, 14),
(57, '2\r\n', 1, 15),
(58, '3', 0, 15),
(59, '4', 0, 15),
(60, '1', 0, 15),
(61, 'Utilizar índices para referencial la información\r\n', 1, 16),
(62, 'Hacer un join\r\n', 0, 16),
(63, 'Usar un where\r\n', 0, 16),
(64, 'Usar un select\r\n', 0, 16),
(65, 'Hyper Text Markup Lenguage\r\n', 1, 17),
(66, 'Hyper Text Markup Lenguash\r\n', 0, 17),
(67, 'Lengua de marcado de super texto\r\n', 0, 17),
(68, 'Modelar paginas web\r\n', 0, 17),
(69, 'Los equipos requieren acceder a una pagina alojada en un servidor\r\n', 1, 18),
(70, 'Requerimientos de una petición \r\n', 0, 18),
(71, 'Las maquinas se conectan a la nube\r\n', 0, 18),
(72, 'Todas las anteriores\r\n', 0, 18),
(73, 'Text para el usuario,Password para la contraseña\r\n', 1, 19),
(74, 'Password para el usuario, Text para la contraseña\r\n', 0, 19),
(75, 'Ambos de tipo Text\r\n', 0, 19),
(76, 'Ampos de tipo Password\r\n', 0, 19),
(77, 'Razonamiento\r\n', 1, 20),
(78, 'Conocimientos en Lenguajes de programación\r\n', 0, 20),
(79, 'Conocimiento Back-end\r\n', 0, 20),
(80, 'Ser desarrollador Ful Stack\r\n', 0, 20),
(81, 'Saber como esta constituida una base de datos\r\n', 1, 21),
(82, 'Crear lineas de codigo\r\n', 0, 21),
(83, 'Programar\r\n', 0, 21),
(84, 'Extraer información\r\n', 0, 21),
(85, 'Rediseño grafico de toda la pagina\r\n', 1, 22),
(86, 'Modificar el todo el back-end\r\n', 0, 22),
(87, 'Mejorar funcionalidades\r\n', 0, 22),
(88, 'Examinar arquitectura web\r\n', 0, 22),
(89, 'RGB(255,0,0)\r\n', 1, 23),
(90, 'Color rojo\r\n', 0, 23),
(91, 'pintar(Rojo)\r\n', 0, 23),
(92, 'Todas las anteriores\r\n', 0, 23),
(93, 'AND Y NOT\r\n', 1, 24),
(94, '[ ] y =!\r\n', 0, 24),
(95, '&& y ||\r\n', 0, 24),
(96, 'True y False\r\n', 0, 24),
(97, 'Codigo fuente\r\n', 1, 25),
(98, 'Funcion\r\n', 0, 25),
(99, 'Bloque de código\r\n', 0, 25),
(100, 'Conjunto de líneas de código\r\n', 0, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda`
--

CREATE TABLE `ronda` (
  `id_ronda` int(1) NOT NULL,
  `premio` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ronda`
--

INSERT INTO `ronda` (`id_ronda`, `premio`) VALUES
(1, 10),
(2, 20),
(3, 30),
(4, 40),
(5, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda-partida`
--

CREATE TABLE `ronda-partida` (
  `id_ronda` int(1) NOT NULL,
  `id_partida` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`),
  ADD KEY `fk_id_categoria` (`id_dificultad`),
  ADD KEY `fk_id_ronda` (`id_ronda`);

--
-- Indices de la tabla `dificultad`
--
ALTER TABLE `dificultad`
  ADD PRIMARY KEY (`id_dificultad`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id_jugador`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`id_partida`),
  ADD KEY `fk_id_jugador` (`id_jugador`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`id_pregunta`),
  ADD KEY `fk_id_categoria` (`id_categoria`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id_respuesta`),
  ADD KEY `fk_id_pregunta` (`id_pregunta`);

--
-- Indices de la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`id_ronda`);

--
-- Indices de la tabla `ronda-partida`
--
ALTER TABLE `ronda-partida`
  ADD PRIMARY KEY (`id_ronda`,`id_partida`),
  ADD KEY `fk_id_ronda` (`id_ronda`),
  ADD KEY `fk_id_partida` (`id_partida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `dificultad`
--
ALTER TABLE `dificultad`
  MODIFY `id_dificultad` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `id_partida` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `id_pregunta` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id_respuesta` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `ronda`
--
ALTER TABLE `ronda`
  MODIFY `id_ronda` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`id_dificultad`) REFERENCES `dificultad` (`id_dificultad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categoria_ibfk_2` FOREIGN KEY (`id_ronda`) REFERENCES `ronda` (`id_ronda`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id_jugador`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `pregunta` (`id_pregunta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ronda-partida`
--
ALTER TABLE `ronda-partida`
  ADD CONSTRAINT `ronda-partida_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id_partida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ronda-partida_ibfk_2` FOREIGN KEY (`id_ronda`) REFERENCES `ronda` (`id_ronda`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
