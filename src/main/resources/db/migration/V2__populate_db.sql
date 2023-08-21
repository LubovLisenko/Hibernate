INSERT INTO client (name) VALUES
	('Love'),
    ('Experience'),
    ('Happy'),
    ('Healthy'),
    ('Money'),
    ('Space'),
    ('Star'),
    ('Brain'),
    ('Sun'),
    ('Rain');

INSERT INTO planet (id, name) VALUES
	('N1', 'Earth'),
    ('N2', 'Mars'),
    ('N3', 'Venus'),
    ('N4', 'Mercury'),
    ('N5', 'Jupiter');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
   (1,'N1','N2'),
   (2,'N2','N3'),
   (3,'N3','N4'),
   (4,'N4','N5'),
   (5,'N5','N1'),
   (6,'N1','N2'),
   (7,'N1','N2'),
   (8,'N3','N5'),
   (9,'N4','N5'),
   (10,'N2','N4');

