CREATE TABLE `staff` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `name` varchar(40) NOT NULL,
                         `uuid` varchar(15) NOT NULL,]
                         `registrationDate` timestamp DEFAULT NOW(),
                         `updated_at` timestamp DEFAULT NOW(),
                         PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;