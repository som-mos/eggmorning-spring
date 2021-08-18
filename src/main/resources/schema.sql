CREATE SCHEMA `quickguide` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `user` (
  `seq` int(11) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

CREATE TABLE `authority` (
  `seq` int(11) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- INSERT INTO `quickguide`.`users` (`seq`, `enabled`, `password`, `username`) VALUES ('1', 1, '1234', 'test');
INSERT INTO `quickguide`.`user` (`seq`, `enabled`, `password`, `username`) VALUES ('1', 1, '$2a$10$5rWSd1pL7FIbB1RVmM.2c.hXGowUjz0T/V1I.GlWGY7lVg4AKPxvu', 'test');
INSERT INTO `quickguide`.`authority` (`seq`, `authority`, `username`) VALUES ('1', 'USER', 'test');
