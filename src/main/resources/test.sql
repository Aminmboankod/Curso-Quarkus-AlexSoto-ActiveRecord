DROP TABLE IF EXISTS developer;
-- Crear la tabla developer
CREATE TABLE developer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);
-- Insertar 10 datos aleatorios en la tabla developer
INSERT INTO developer (name, age)
VALUES ('John Doe', 28),
    ('Jane Smith', 35),
    ('Michael Johnson', 42),
    ('Emily Davis', 31),
    ('David Anderson', 29),
    ('Sarah Wilson', 36),
    ('Robert Thompson', 33),
    ('Jennifer Martinez', 27),
    ('William Davis', 38),
    ('Jessica Lee', 26);