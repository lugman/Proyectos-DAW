-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 15-02-2018 a las 23:44:19
-- Versión del servidor: 5.5.57-0+deb7u1
-- Versión de PHP: 5.4.45-0+deb7u11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dawanair_lugman`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Asientos`
--

CREATE TABLE IF NOT EXISTS `Asientos` (
  `_id` int(11) NOT NULL,
  `Posicion` varchar(50) NOT NULL,
  `cod_usuario` int(11) NOT NULL,
  `cod_vuelo` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Precio` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Asientos`
--

INSERT INTO `Asientos` (`_id`, `Posicion`, `cod_usuario`, `cod_vuelo`, `fecha`, `Precio`) VALUES
(48, '7', 41, 22, '2018-02-15 17:41:36', 0),
(49, '1', 41, 22, '2018-02-15 17:41:36', 0),
(50, '4', 41, 22, '2018-02-15 17:41:36', 0),
(51, '5', 41, 22, '2018-02-15 17:41:51', 0),
(52, '2', 41, 22, '2018-02-15 17:41:51', 0),
(53, '8', 41, 22, '2018-02-15 17:41:51', 0),
(54, '11', 41, 22, '2018-02-15 17:41:52', 0),
(55, '14', 41, 22, '2018-02-15 17:41:52', 0),
(56, '26', 41, 22, '2018-02-15 17:45:53', 0),
(57, '29', 41, 22, '2018-02-15 17:45:53', 0),
(58, '32', 41, 22, '2018-02-15 17:45:53', 0),
(59, '10', 41, 22, '2018-02-15 17:46:53', 0),
(60, '17', 41, 22, '2018-02-15 17:46:53', 0),
(61, '13', 41, 22, '2018-02-15 17:47:16', 0),
(62, '16', 41, 22, '2018-02-15 17:47:16', 0),
(63, '23', 41, 22, '2018-02-15 17:47:29', 0),
(64, '25', 41, 22, '2018-02-15 17:47:30', 0),
(65, '6', 41, 22, '2018-02-15 17:47:38', 0),
(66, '12', 41, 22, '2018-02-15 17:47:38', 0),
(67, '9', 41, 22, '2018-02-15 17:47:38', 0),
(68, '21', 41, 22, '2018-02-15 17:49:36', 0),
(69, '24', 41, 22, '2018-02-15 17:49:36', 0),
(70, '27', 41, 22, '2018-02-15 17:49:42', 0),
(71, '31', 41, 22, '2018-02-15 17:49:42', 0),
(72, '33', 41, 22, '2018-02-15 17:49:42', 0),
(73, '30', 41, 22, '2018-02-15 17:50:03', 0),
(74, '36', 41, 22, '2018-02-15 17:50:03', 0),
(75, '34', 41, 22, '2018-02-15 17:50:03', 0),
(76, '37', 41, 22, '2018-02-15 17:50:20', 0),
(77, '3', 40, 8, '2018-02-15 18:02:47', 0),
(78, '28', 40, 7, '2018-02-15 18:21:31', 0),
(79, '25', 40, 7, '2018-02-15 18:32:58', 0),
(80, '4', 40, 7, '2018-02-15 18:32:58', 0),
(81, '7', 40, 7, '2018-02-15 18:32:58', 0),
(82, '3', 40, 7, '2018-02-15 18:33:23', 0),
(83, '2', 40, 7, '2018-02-15 18:33:34', 0),
(84, '5', 40, 7, '2018-02-15 18:33:34', 0),
(85, '8', 40, 7, '2018-02-15 18:33:34', 0),
(86, '11', 40, 7, '2018-02-15 18:33:35', 0),
(87, '14', 40, 7, '2018-02-15 18:33:35', 0),
(88, '17', 40, 7, '2018-02-15 18:33:35', 0),
(89, '2', 40, 10, '2018-02-15 18:33:55', 0),
(90, '5', 40, 10, '2018-02-15 18:33:55', 0),
(91, '8', 40, 10, '2018-02-15 18:33:55', 0),
(92, '11', 40, 10, '2018-02-15 18:33:55', 0),
(93, '14', 40, 10, '2018-02-15 18:33:55', 0),
(94, '17', 40, 10, '2018-02-15 18:33:55', 0),
(95, '1', 40, 10, '2018-02-15 18:34:39', 0),
(96, '10', 40, 10, '2018-02-15 18:34:39', 0),
(97, '3', 40, 22, '2018-02-15 18:34:56', 0),
(98, 'Vip 4', 40, 22, '2018-02-15 18:35:39', 0),
(99, 'Vip 3', 40, 22, '2018-02-15 18:35:39', 0),
(100, 'Vip 2', 40, 22, '2018-02-15 18:35:39', 0),
(101, 'Vip 1', 40, 22, '2018-02-15 18:35:39', 0),
(102, '22', 40, 22, '2018-02-15 18:35:40', 0),
(103, '28', 40, 22, '2018-02-15 18:35:40', 0),
(104, '35', 40, 22, '2018-02-15 18:35:40', 0),
(105, '38', 40, 22, '2018-02-15 18:35:40', 0),
(106, '15', 40, 22, '2018-02-15 18:35:51', 0),
(107, '18', 40, 22, '2018-02-15 18:35:51', 0),
(109, '12', 4, 7, '2018-02-15 22:41:01', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Ciudad`
--

CREATE TABLE IF NOT EXISTS `Ciudad` (
  `_Id` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Foto` varchar(50) NOT NULL,
  `Descripcion` text NOT NULL,
  `cod_pais` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Ciudad`
--

INSERT INTO `Ciudad` (`_Id`, `Nombre`, `Foto`, `Descripcion`, `cod_pais`) VALUES
(13, 'Valencia', '', '', 459),
(14, 'Barcelona', '', '', 459),
(15, 'Madrid', '', '', 459),
(16, 'Paris', '', '', 330),
(17, 'Marsella', '', '', 330),
(18, 'Lille', '', '', 330),
(19, 'Tokio', '', '', 368),
(20, 'Osaka', '', '', 368),
(21, 'Hiroshima', '', '', 368),
(22, 'Moscow', '', '', 339),
(23, 'New york', '', '', 487),
(24, 'Chicago', '', '', 487),
(25, 'Boston', '', '', 487),
(26, 'Hawai', '', '', 487),
(27, 'Milan', '', '', 364);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pais`
--

CREATE TABLE IF NOT EXISTS `Pais` (
  `_Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=503 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Pais`
--

INSERT INTO `Pais` (`_Id`, `Name`) VALUES
(262, 'Afghanistan'),
(263, 'Albania'),
(264, 'Algeria'),
(265, 'American Samoa'),
(266, 'Andorra'),
(267, 'Angola'),
(268, 'Anguilla'),
(269, 'Antarctica'),
(270, 'Argentina'),
(271, 'Armenia'),
(272, 'Aruba'),
(273, 'Australia'),
(274, 'Austria'),
(275, 'Azerbaijan'),
(276, 'Bahamas'),
(277, 'Bahrain'),
(278, 'Bangladesh'),
(279, 'Barbados'),
(280, 'Belarus'),
(281, 'Belgium'),
(282, 'Belize'),
(283, 'Benin'),
(284, 'Bermuda'),
(285, 'Bhutan'),
(286, 'Bolivia'),
(287, 'Bosnia and Herzegovina'),
(288, 'Botswana'),
(289, 'Bouvet Island'),
(290, 'Brazil'),
(291, 'British Indian Ocean Territory'),
(292, 'Brunei Darussalam'),
(293, 'Bulgaria'),
(294, 'Burkina Faso'),
(295, 'Burundi'),
(296, 'Cambodia'),
(297, 'Cameroon'),
(299, 'Cape Verde'),
(300, 'Cayman Islands'),
(301, 'Central African Republic'),
(302, 'Chad'),
(303, 'Chile'),
(304, 'China'),
(305, 'Christmas Island'),
(306, 'Cocos (Keeling) Islands'),
(307, 'Colombia'),
(308, 'Comoros'),
(309, 'Congo'),
(310, 'Cook Islands'),
(311, 'Costa Rica'),
(312, 'Croatia (Hrvatska)'),
(313, 'Cuba'),
(314, 'Cyprus'),
(315, 'Czech Republic'),
(316, 'Denmark'),
(317, 'Dominica'),
(318, 'East Timor'),
(319, 'Ecuador'),
(320, 'Egypt'),
(322, 'Equatorial Guinea'),
(323, 'Eritrea'),
(324, 'Estonia'),
(325, 'Ethiopia'),
(326, 'Falkland Islands (Malvinas)'),
(327, 'Faroe Islands'),
(328, 'Fiji'),
(329, 'Finland'),
(330, 'France'),
(331, 'France, Metropolitan'),
(332, 'French Guiana'),
(333, 'French Polynesia'),
(334, 'French Southern Territories'),
(335, 'Gabon'),
(336, 'Gambia'),
(337, 'Georgia'),
(338, 'Germany'),
(339, 'Ghana'),
(340, 'Gibraltar'),
(298, 'Glen'),
(342, 'Greece'),
(343, 'Greenland'),
(344, 'Grenada'),
(345, 'Guadeloupe'),
(346, 'Guam'),
(347, 'Guatemala'),
(341, 'Guernsey'),
(348, 'Guinea'),
(349, 'Guinea-Bissau'),
(350, 'Guyana'),
(351, 'Haiti'),
(352, 'Heard and Mc Donald Islands'),
(353, 'Honduras'),
(354, 'Hong Kong'),
(355, 'Hungary'),
(356, 'Iceland'),
(357, 'India'),
(359, 'Indonesia'),
(360, 'Iran (Islamic Republic of)'),
(361, 'Iraq'),
(362, 'Ireland'),
(358, 'Isle of Man'),
(363, 'Israel'),
(364, 'Italy'),
(365, 'Ivory Coast'),
(367, 'Jamaica'),
(368, 'Japan'),
(369, 'Jordan'),
(370, 'Kazakhstan'),
(371, 'Kenya'),
(372, 'Kiribati'),
(373, 'Korea, Democratic People''s Republic of '),
(374, 'Korea, Republic of'),
(375, 'Kosovo'),
(376, 'Kuwait'),
(377, 'Kyrgyzstan'),
(378, 'Latvia'),
(379, 'Lebanon'),
(380, 'Lesotho'),
(381, 'Liberia'),
(382, 'Libyan Arab Jamahiriya'),
(383, 'Liechtenstein'),
(384, 'Lithuania'),
(385, 'Luxembourg'),
(386, 'Macau'),
(387, 'Macedonia'),
(388, 'Madagascar'),
(389, 'Malawi'),
(390, 'Malaysia'),
(391, 'Maldives'),
(392, 'Mali'),
(393, 'Malt'),
(394, 'Marshall Islands'),
(395, 'Martinique'),
(396, 'Mauritania'),
(397, 'Mauritius'),
(398, 'Mayotte'),
(437, 'Meeting'),
(399, 'Mexico'),
(400, 'Micronesia, Federated States of'),
(401, 'Moldova, Republic of'),
(402, 'Monaco'),
(403, 'Mongolia'),
(404, 'Montenegro'),
(405, 'Montserrat'),
(406, 'Morocco'),
(407, 'Mozambique'),
(408, 'Myanmar'),
(409, 'Namibia'),
(410, 'Nauru'),
(411, 'Nepal'),
(412, 'Netherlands'),
(413, 'Netherlands Antilles'),
(414, 'New Caledonia'),
(415, 'New Zealand'),
(416, 'Nicaragua'),
(417, 'Niger'),
(418, 'Nigeria'),
(419, 'Niue'),
(420, 'Norfolk Island'),
(421, 'Northern Mariana Islands'),
(422, 'Norway'),
(423, 'Oman'),
(424, 'Pakistan'),
(425, 'Palau'),
(426, 'Palestine'),
(427, 'Panama'),
(428, 'Papua New Guinea'),
(429, 'Paraguay'),
(430, 'Peru'),
(431, 'Philippines'),
(432, 'Pitcairn'),
(433, 'Poland'),
(434, 'Portugal'),
(435, 'Puerto Rico'),
(436, 'Qatar'),
(438, 'Romania'),
(439, 'Russia'),
(440, 'Rwanda'),
(441, 'Saint Kitts and Nevis'),
(442, 'Saint Lucia'),
(443, 'Saint Vincent and the Grenadines'),
(444, 'Samoa'),
(445, 'San Marino'),
(446, 'Sao Tome and Principe'),
(447, 'Saudi Arabia'),
(448, 'Senegal'),
(449, 'Serbia'),
(450, 'Seychelles'),
(451, 'Sierra Leone'),
(452, 'Singapore'),
(453, 'Slovakia'),
(454, 'Slovenia'),
(455, 'Solomon Islands'),
(456, 'Somalia'),
(457, 'South Africa'),
(458, 'South Georgia South Sandwich Islands'),
(459, 'Spain'),
(460, 'Sri Lanka'),
(462, 'St Pierre and Miquelon'),
(461, 'St. Helena'),
(463, 'Sudan'),
(464, 'Suriname'),
(465, 'Svalbard and Jan Mayen Islands'),
(466, 'Swaziland'),
(366, 'Sweater'),
(467, 'Sweden'),
(468, 'Switzerland'),
(469, 'Syrian Arab Republic'),
(470, 'Taiwan'),
(471, 'Tajikistan'),
(472, 'Tanzania, United Republic of'),
(473, 'Thailand'),
(321, 'The Savior'),
(474, 'Togo'),
(475, 'Tokelau'),
(476, 'Tonga'),
(477, 'Trinidad and Tobago'),
(478, 'Tunisia'),
(479, 'Turkey'),
(480, 'Turkmenistan'),
(481, 'Turks and Caicos Islands'),
(482, 'Tuvalu'),
(483, 'Uganda'),
(484, 'Ukraine'),
(485, 'United Arab Emirates'),
(486, 'United Kingdom'),
(487, 'United States'),
(488, 'United States minor outlying islands'),
(489, 'Uruguay'),
(490, 'Uzbekistan'),
(491, 'Vanuatu'),
(492, 'Vatican City State'),
(493, 'Venezuela'),
(494, 'Vietnam'),
(495, 'Virgin Islands (British)'),
(496, 'Virgin Islands (U.S.)'),
(497, 'Wallis and Futuna Islands'),
(498, 'Western Sahara'),
(499, 'Yemen'),
(500, 'Zaire'),
(501, 'Zambia'),
(502, 'Zimbabwe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Reservan`
--

CREATE TABLE IF NOT EXISTS `Reservan` (
  `_Id` int(11) NOT NULL,
  `_cod_usuario` int(11) NOT NULL,
  `_cod_vuelo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE IF NOT EXISTS `Usuarios` (
  `_Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Pais` varchar(25) NOT NULL,
  `Usuario` varchar(25) NOT NULL,
  `Contrasenia` varchar(50) NOT NULL,
  `_cod_ciudad` int(12) DEFAULT NULL,
  `id_google` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`_Id`, `Nombre`, `Apellidos`, `Telefono`, `Email`, `Sexo`, `Pais`, `Usuario`, `Contrasenia`, `_cod_ciudad`, `id_google`) VALUES
(4, 'Admin', 'Admin ', '6666', 'Admin@gmail.com', 'man', '', 'Admin', '123456', 22, ''),
(36, 'Lugman Sami', 'Mansilla', '633161997', 'lugmansamiss@gmail.com', 'man', '', 'Usuario1', '123456', 13, ''),
(37, 'Lugman', 'jussn', '146554584', 'lugmansami@gmail.com', 'woman', '', 'lugmi', '12345', 22, ''),
(40, 'Lugman', 'ahmad mansilla', '', 'lugmansito@gmail.com', '', '', '', '', NULL, ''),
(41, 'Lugman', 'Ahmad Mansilla', '', 'lugmanmansilla@gmail.com', '', '', '', '', NULL, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Vuelo`
--

CREATE TABLE IF NOT EXISTS `Vuelo` (
  `_Id` int(11) NOT NULL,
  `Origen` int(10) NOT NULL,
  `Destino` int(10) NOT NULL,
  `Plazas_totales` int(11) NOT NULL,
  `Plazas_ocupadas` int(11) NOT NULL,
  `Con_hoteol` bit(1) NOT NULL,
  `Hotel` varchar(80) NOT NULL,
  `Clase` varchar(20) NOT NULL,
  `Fecha_salida` datetime NOT NULL,
  `Fecha_llegada` datetime NOT NULL,
  `Ida_y_vuelta` bit(1) NOT NULL,
  `Compania` varchar(50) NOT NULL,
  `Precio` int(8) NOT NULL,
  `Fecha_regreso` datetime NOT NULL,
  `Foto` varchar(50) NOT NULL,
  `Descripcion` text CHARACTER SET utf8mb4 NOT NULL,
  `Estrellas` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Vuelo`
--

INSERT INTO `Vuelo` (`_Id`, `Origen`, `Destino`, `Plazas_totales`, `Plazas_ocupadas`, `Con_hoteol`, `Hotel`, `Clase`, `Fecha_salida`, `Fecha_llegada`, `Ida_y_vuelta`, `Compania`, `Precio`, `Fecha_regreso`, `Foto`, `Descripcion`, `Estrellas`) VALUES
(7, 14, 26, 70, 10, b'1', 'Hotel 1', 'Bunisses', '2018-02-20 11:00:00', '2018-02-21 15:00:00', b'0', 'ae', 570, '0000-00-00 00:00:00', 'img/hawai.jpg', 'Milán ​ es la mayor Área Metropolitana de Italia y el segundo municipio de Italia por población, capital de la Ciudad metropolitana de Milán.', 5),
(8, 14, 27, 120, 60, b'1', 'Hotel 2', 'Economic', '2018-02-21 09:00:00', '2018-02-21 11:00:00', b'0', 'ana', 400, '0000-00-00 00:00:00', 'img/milan.jpg', 'Milán ​ es la mayor Área Metropolitana de Italia y el segundo municipio de Italia por población, capital de la Ciudad metropolitana de Milán.', 0),
(9, 13, 17, 120, 60, b'1', 'Hotel 2', 'Economic', '2018-02-23 09:00:00', '2018-02-21 23:00:00', b'0', 'ana', 400, '0000-00-00 00:00:00', 'img/paris.jpeg', 'Milán ​ es la mayor Área Metropolitana de Italia y el segundo municipio de Italia por población, capital de la Ciudad metropolitana de Milán.', 0),
(10, 13, 24, 120, 60, b'1', 'Hotel 2', 'Economic', '2018-02-21 09:00:00', '2018-02-21 11:00:00', b'0', 'ana', 400, '0000-00-00 00:00:00', 'img/dubai.png', 'Milán ​ es la mayor Área Metropolitana de Italia y el segundo municipio de Italia por población, capital de la Ciudad metropolitana de Milán.', 0),
(11, 13, 21, 120, 60, b'1', 'Hotel 2', 'Economic', '2018-02-21 09:00:00', '2018-02-21 11:00:00', b'1', 'ana', 400, '0000-00-00 00:00:00', 'img/giza.png', 'Milán ​ es la mayor Área Metropolitana de Italia y el segundo municipio de Italia por población, capital de la Ciudad metropolitana de Milán.', 0),
(13, 13, 23, 120, 60, b'1', 'Hotel 2', 'Economic', '2018-02-21 09:00:00', '2018-02-21 11:00:00', b'0', 'ana', 400, '0000-00-00 00:00:00', 'img/grecia.jpg', 'Milán ​ es la mayor Área Metropolitana de Italia y el segundo municipio de Italia por población, capital de la Ciudad metropolitana de Milán.', 0),
(22, 16, 14, 2, 0, b'1', 'Csa', 'Economic', '2018-01-09 01:01:00', '0000-00-00 00:00:00', b'0', ' ', 2, '0000-00-00 00:00:00', '', 'ana', 0),
(24, 15, 17, 13, 0, b'1', 'molon', 'Economic', '2018-02-23 02:05:00', '2018-02-23 04:01:00', b'1', '2018-02-23 00:00', 26, '0000-00-00 00:00:00', 'img/hawai.jpg', 'ana', 0),
(26, 13, 13, 1, 0, b'0', 'name hotel', 'Economic', '2019-01-01 00:00:00', '2018-02-16 00:00:00', b'0', ' ', 25, '0000-00-00 00:00:00', '', 'ae', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Asientos`
--
ALTER TABLE `Asientos`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `cod_vuelo` (`cod_vuelo`),
  ADD KEY `cod_usuario` (`cod_usuario`);

--
-- Indices de la tabla `Ciudad`
--
ALTER TABLE `Ciudad`
  ADD PRIMARY KEY (`_Id`),
  ADD KEY `cod_pais` (`cod_pais`);

--
-- Indices de la tabla `Pais`
--
ALTER TABLE `Pais`
  ADD PRIMARY KEY (`_Id`),
  ADD UNIQUE KEY `Name_2` (`Name`),
  ADD KEY `Name` (`Name`);

--
-- Indices de la tabla `Reservan`
--
ALTER TABLE `Reservan`
  ADD PRIMARY KEY (`_Id`,`_cod_usuario`,`_cod_vuelo`),
  ADD KEY `_cod_usuario` (`_cod_usuario`),
  ADD KEY `_cod_vuelo` (`_cod_vuelo`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`_Id`),
  ADD KEY `_cod_ciudad` (`_cod_ciudad`);

--
-- Indices de la tabla `Vuelo`
--
ALTER TABLE `Vuelo`
  ADD PRIMARY KEY (`_Id`),
  ADD KEY `Origen` (`Origen`),
  ADD KEY `Destino` (`Destino`),
  ADD KEY `Origen_2` (`Origen`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Asientos`
--
ALTER TABLE `Asientos`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=110;
--
-- AUTO_INCREMENT de la tabla `Ciudad`
--
ALTER TABLE `Ciudad`
  MODIFY `_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de la tabla `Pais`
--
ALTER TABLE `Pais`
  MODIFY `_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=503;
--
-- AUTO_INCREMENT de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT de la tabla `Vuelo`
--
ALTER TABLE `Vuelo`
  MODIFY `_Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Asientos`
--
ALTER TABLE `Asientos`
  ADD CONSTRAINT `Asientos_ibfk_1` FOREIGN KEY (`cod_vuelo`) REFERENCES `Vuelo` (`_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Asientos_ibfk_2` FOREIGN KEY (`cod_usuario`) REFERENCES `Usuarios` (`_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Ciudad`
--
ALTER TABLE `Ciudad`
  ADD CONSTRAINT `Ciudad_ibfk_2` FOREIGN KEY (`cod_pais`) REFERENCES `Pais` (`_Id`);

--
-- Filtros para la tabla `Reservan`
--
ALTER TABLE `Reservan`
  ADD CONSTRAINT `Reservan_ibfk_1` FOREIGN KEY (`_cod_usuario`) REFERENCES `Usuarios` (`_Id`),
  ADD CONSTRAINT `Reservan_ibfk_2` FOREIGN KEY (`_cod_vuelo`) REFERENCES `Vuelo` (`_Id`);

--
-- Filtros para la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD CONSTRAINT `Usuarios_ibfk_1` FOREIGN KEY (`_cod_ciudad`) REFERENCES `Ciudad` (`_Id`);

--
-- Filtros para la tabla `Vuelo`
--
ALTER TABLE `Vuelo`
  ADD CONSTRAINT `Vuelo_ibfk_2` FOREIGN KEY (`Origen`) REFERENCES `Ciudad` (`_Id`),
  ADD CONSTRAINT `Vuelo_ibfk_3` FOREIGN KEY (`Destino`) REFERENCES `Ciudad` (`_Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
