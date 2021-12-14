CREATE TABLE `USER` (
                        `user_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `email` varchar(100) NOT NULL,
                        `name` varchar(100) NOT NULL,
                        `nickname` varchar(50) DEFAULT NULL,
                        `salt` varchar(10) DEFAULT NULL,
                        `password` varchar(100) NOT NULL,
                        `enabled` bit(1) NOT NULL,
                        `phone` varchar(16) DEFAULT NULL,
                        `address` text,
                        `reg_date` datetime NOT NULL default now(),
                        `mod_date` datetime NOT NULL default now()
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ROLE` (
                        `role_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `USER_ROLE` (
                             `user_no` bigint(20) NOT NULL,
                             `role_no` bigint(20) NOT NULL,
                             PRIMARY KEY (`user_no`,`role_no`),
                             CONSTRAINT fk_USER_ROLE_role_no FOREIGN KEY (`role_no`) REFERENCES `ROLE` (`role_no`),
                             CONSTRAINT fk_USER_ROLE_user_no FOREIGN KEY (`user_no`) REFERENCES `USER` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `COUPON` (
                          `coupon_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `coupon_name` varchar(50) NOT NULL DEFAULT '0',
                          `content` varchar(200) NOT NULL DEFAULT '0',
                          `discount_rate` float(4,1) NOT NULL DEFAULT '0',
  `reg_date` datetime NOT NULL default now(),
  `mod_date` datetime NOT NULL default now()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `USER_COUPON` (
                               `seq` bigint(20) NOT NULL AUTO_INCREMENT,
                               `user_no` bigint(20) NOT NULL DEFAULT '0',
                               `coupon_no` bigint(20) NOT NULL DEFAULT '0',
                               `date_used` datetime DEFAULT NULL,
                               `date_start` datetime NOT NULL,
                               `date_end` datetime NOT NULL,
                               `reg_date` datetime NOT NULL default now(),
                               `mod_date` datetime NOT NULL default now(),
                               PRIMARY KEY (`seq`),
                               CONSTRAINT FK_USER_COUPON_coupon_no FOREIGN KEY (`coupon_no`) REFERENCES `COUPON` (`coupon_no`),
                               CONSTRAINT FK_USER_COUPON_user_no FOREIGN KEY (`user_no`) REFERENCES `USER` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `HOTEL` (
                         `hotel_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `name` varchar(100) NOT NULL,
                         `address` varchar(200) NOT NULL,
                         `phone` varchar(16) NOT NULL,
                         `level` int(1) NOT NULL DEFAULT '0',
                         `rating` float(2,1) NOT NULL DEFAULT '0',
  `thumbnail` varchar(500) NOT NULL DEFAULT '',
  `reg_date` datetime NOT NULL default now(),
  `mod_date` datetime NOT NULL default now()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FOOD` (
                        `food_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `hotel_no` bigint(20) NOT NULL,
                        `food_name` varchar(50) NOT NULL DEFAULT '',
                        `food_picture` varchar(500) NOT NULL DEFAULT '',
                        CONSTRAINT FK_FOOD_hotel_no FOREIGN KEY (`hotel_no`) REFERENCES `HOTEL` (`hotel_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `NEWS` (
                        `news_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `title` varchar(50) NOT NULL,
                        `content` text NOT NULL,
                        `picture` varchar(500) NOT NULL DEFAULT '',
                        `reg_date` datetime NOT NULL default now(),
                        `mod_date` datetime NOT NULL default now()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `REVIEW` (
                          `review_no` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `user_no` bigint(20) NOT NULL DEFAULT '0',
                          `hotel_no` bigint(20) NOT NULL DEFAULT '0',
                          `rating` float(2,1) NOT NULL DEFAULT '0',
  `text` text NOT NULL,
  `picture` varchar(500) NOT NULL DEFAULT '',
  `reg_date` datetime NOT NULL default now(),
  `mod_date` datetime NOT NULL default now(),
  CONSTRAINT FK_REVIEW_hotel_no FOREIGN KEY (`hotel_no`) REFERENCES `HOTEL` (`hotel_no`),
  CONSTRAINT FK_REVIEW_user_no FOREIGN KEY (`user_no`) REFERENCES `USER` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;