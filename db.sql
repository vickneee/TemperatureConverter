DROP TABLE IF EXISTS temperature_log;

CREATE TABLE IF NOT EXISTS temperature_log (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    celsius FLOAT,
    fahrenheit FLOAT,
    kelvin FLOAT
);

SELECT * FROM temperature_log;