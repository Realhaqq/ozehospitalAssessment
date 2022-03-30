CREATE TABLE `patient` (`id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `name` varchar(40) NOT NULL,
                         `age` varchar(15) NOT NULL,]
                         `created_at` timestamp DEFAULT NOW(),
                         `last_visit_date` timestamp DEFAULT NOW(),
                         PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;