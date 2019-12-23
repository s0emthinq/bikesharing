-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 23 2019 г., 15:30
-- Версия сервера: 8.0.15
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `bikesharing`
--

-- --------------------------------------------------------

--
-- Структура таблицы `bikes`
--

CREATE TABLE `bikes` (
  `id` int(11) NOT NULL,
  `latitude` double(6,4) NOT NULL,
  `longitude` double(6,4) NOT NULL,
  `cost_per_hour` double NOT NULL,
  `status` int(45) NOT NULL,
  `id_organisation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `bikes`
--

INSERT INTO `bikes` (`id`, `latitude`, `longitude`, `cost_per_hour`, `status`, `id_organisation`) VALUES
(1, 53.8503, 27.4531, 2, 1, 1),
(15, 53.9339, 27.5533, 2, 0, 1),
(18, 53.9379, 27.4610, 2, 0, 1),
(19, 53.8837, 27.5834, 2, 1, 1),
(20, 53.9020, 27.6460, 2, 1, 1),
(21, 53.9499, 27.4736, 2, 0, 1),
(22, 53.9442, 27.4776, 2, 0, 1),
(23, 53.9084, 27.5214, 2, 0, 1),
(24, 53.9132, 27.5098, 2, 0, 1),
(25, 53.9417, 27.5123, 2, 0, 1),
(29, 53.8523, 27.5725, 2, 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `cards`
--

CREATE TABLE `cards` (
  `id` int(11) NOT NULL,
  `serial_number` varchar(45) NOT NULL,
  `balance` double(9,2) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cards`
--

INSERT INTO `cards` (`id`, `serial_number`, `balance`, `id_user`) VALUES
(1, '0000000000000000', 0.10, 6),
(2, '1111111111111111', 5.00, 5),
(3, '2222222222222222', 25.00, 6),
(4, '3333333333333333', 1.56, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_bike` int(11) NOT NULL,
  `begin_time` varchar(45) NOT NULL,
  `end_time` varchar(45) NOT NULL,
  `cost` double(5,2) NOT NULL,
  `return_time` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `debt` double(5,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `id_card` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id`, `id_user`, `id_bike`, `begin_time`, `end_time`, `cost`, `return_time`, `debt`, `status`, `id_card`) VALUES
(35, 6, 15, '17:31', '23:15', 11.47, '17:31', NULL, 1, 4),
(36, 6, 15, '17:34', '22:04', 9.00, '17:34', NULL, 1, 3),
(37, 6, 25, '17:43', '22:04', 8.70, '17:44', NULL, 1, 1),
(38, 6, 25, '17:58', '18:59', 2.03, '17:59', NULL, 1, 1),
(39, 6, 25, '17:59', '19:00', 2.03, '18:00', NULL, 1, 1),
(40, 6, 15, '19:24', '20:24', 2.00, '19:24', NULL, 1, 1),
(41, 6, 23, '19:25', '20:24', 1.97, '19:25', NULL, 1, 4),
(50, 6, 25, '14:00', '14:01', 0.03, '14:02', 0.03, 1, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `organisations`
--

CREATE TABLE `organisations` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `balance` double(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `organisations`
--

INSERT INTO `organisations` (`id`, `name`, `balance`) VALUES
(1, 'AvsievichWheelsCorporation', 1269.13);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role` int(3) NOT NULL,
  `status` int(1) NOT NULL,
  `image` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `email`, `role`, `status`, `image`) VALUES
(5, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@rambler.ru', 1, 0, 'E:\\login\\src\\main\\webapp\\img\\images.png'),
(6, 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'user@rambler.ru', 0, 0, 'E:\\login\\src\\main\\webapp\\img\\images.png'),
(7, 'vlad', 'd701fde59d74f76803087b6632186caf', 'vlad@rambler.ru', 0, 0, 'E:\\login\\src\\main\\webapp\\img\\images.png'),
(8, 'vladislav', 'f68438be30a21e34d7d5dc9a71dec40a', 'vladislav@gmail.com', 0, 0, 'E:\\login\\src\\main\\webapp\\img\\images.png'),
(9, 'natali', '716c153621f76922708404b68c339701', 'natali@gmail.com', 0, 0, 'E:\\login\\src\\main\\webapp\\img\\images.png');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `bikes`
--
ALTER TABLE `bikes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bikes_ibfk_1` (`id_organisation`);

--
-- Индексы таблицы `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orders_ibfk_1` (`id_bike`),
  ADD KEY `orders_ibfk_2` (`id_user`),
  ADD KEY `id_card` (`id_card`);

--
-- Индексы таблицы `organisations`
--
ALTER TABLE `organisations`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `bikes`
--
ALTER TABLE `bikes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT для таблицы `cards`
--
ALTER TABLE `cards`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT для таблицы `organisations`
--
ALTER TABLE `organisations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `bikes`
--
ALTER TABLE `bikes`
  ADD CONSTRAINT `bikes_ibfk_1` FOREIGN KEY (`id_organisation`) REFERENCES `organisations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `cards`
--
ALTER TABLE `cards`
  ADD CONSTRAINT `cards_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_bike`) REFERENCES `bikes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`id_card`) REFERENCES `cards` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
