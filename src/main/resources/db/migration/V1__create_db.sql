CREATE TABLE client (
id  IDENTITY PRIMARY KEY,
name VARCHAR(200) NOT NULL CHECK(LENGTH(name)>=3)
);

CREATE TABLE planet (
id  VARCHAR PRIMARY KEY CHECK('%[^A-Z0-9]%'),
name VARCHAR(500) NOT NULL CHECK(LENGTH(name)>=1)
);

CREATE TABLE ticket (
id IDENTITY PRIMARY KEY,
created_at TIMESTAMP WITH TIME ZONE;
client_id BIGINT FOREIGN KEY NOT NULL REFERENCES client(id);
from_planet_id  FOREIGN KEY REFERENCES planet(id);
to_planet_id  FOREIGN KEY REFERENCES planet(id);
);