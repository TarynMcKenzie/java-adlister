USE adlister_db;

CREATE TABLE IF NOT EXISTS users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50)  NOT NULL,
    email    VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);