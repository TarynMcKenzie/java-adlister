USE adlister_db;

CREATE TABLE IF NOT EXISTS ads
(
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id    INT UNSIGNED NOT NULL,
    ad_title   VARCHAR(50) DEFAULT 'NONE',
    ad_description TEXT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);