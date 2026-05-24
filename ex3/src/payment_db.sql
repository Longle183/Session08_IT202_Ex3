CREATE DATABASE payment_db;

USE payment_db;

CREATE TABLE transactions (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,

                              transaction_code VARCHAR(255),

                              amount DOUBLE NOT NULL,

                              currency VARCHAR(50),

                              type VARCHAR(100)
);

INSERT INTO transactions (
    transaction_code,
    amount,
    currency,
    type
)
VALUES
    (NULL, 500000, 'VND', 'DOMESTIC'),

    (NULL, 200, 'USD', 'INTERNATIONAL'),

    ('TXN999', 100, 'USD', 'REFUND');