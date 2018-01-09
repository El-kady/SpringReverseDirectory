CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) NOT NULL,
  `user_id` int(11),
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number` (`phone_number`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;