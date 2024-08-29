USE HumanFriends;

CREATE TABLE animal_clas
(
	id INT not null PRIMARY KEY, 
	class_name VARCHAR(20)
);

INSERT INTO animal_clas (class_name)
VALUES 
('PackAnimals'),
('Pets'); 

SELECT * FROM animal_clas;

CREATE TABLE animal_type(
	id INT PRIMARY KEY  ,
    name_clas VARCHAR(50) NOT NULL,
    animal_id INT not null,
    FOREIGN KEY (animals_id) REFERENCES animal_clas(id) ON DELETE cascade ON UPDATE CASCADE
);

INSERT INTO animal_type (name_clas, animal_id)
VALUES
('Dog', 2),
('Cat', 2), 
('Hamster',2),
('Horse', 1),
('Camel', 1),
('Donkey', 1);

SELECT * FROM animal_type;

CREATE TABLE dog(
	id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    type INT NOT NULL,
	datebirth DATE NOT NULL,
    commands VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animal_type(id) ON DELETE cascade ON UPDATE CASCADE
);

CREATE TABLE cat(
	id SERIAL PRIMARY KEY ,
    name VARCHAR(50)  NOT NULL,
    type INT NOT NULL,
	datebirth DATE NOT NULL,
    commands VARCHAR(50),
    FOREIGN KEY (type) REFERENCES animal_type(id) ON DELETE cascade ON UPDATE CASCADE
);

CREATE TABLE hamster(
	id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    type INT NOT NULL,
	datebirth DATE NOT NULL,
    commands VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animal_type(id) ON DELETE cascade ON UPDATE CASCADE
);

CREATE TABLE horse(
	id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    type INT NOT NULL,
	datebirth DATE NOT NULL,
    commands VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animal_type(id) ON DELETE cascade ON UPDATE CASCADE
);

CREATE TABLE camel(
	id SERIAL PRIMARY KEY ,
    name INT NOT NULL,
    type VARCHAR(50) NOT NULL,
	datebirth DATE NOT NULL,
    commands VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animal_type(id) ON DELETE cascade ON UPDATE CASCADE
);

CREATE TABLE donkey(
	id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    type INT NOT NULL,
	datebirth DATE NOT NULL,
    commands VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES animal_type(id) ON DELETE cascade ON UPDATE CASCADE);
    
# заполняем данные домашних животных
#таблица с данными собак
INSERT INTO dog (name, type, databirth, commands)
VALUES 
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll');

# Таблица с данными кошек
INSERT INTO cat (name, type, databirth, commands) VALUES 
( 'Wriskers', 2, "2019-05-15", 'Sit, Pounce'),
('Smudge', 2, '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', 2, '2020-06-30', 'Meow, Scratch, jump');

# таблица с данными хамяков
INSERT INTO hamster (name, type, databirth, commands) VALUES
('Hammy', 3, '2021-03-10', 'Roll, Hibe'),
('Peanut', 3, '2021-08-01', 'Roll, Splin');

# ЗАПОЛНЯЕМ ДАННЫМИ ТАБЛИЦЫ ВЬЮЧИХ ЖИВОТНЫХ:
# таблица с данными лошадей 
INSERT INTO horse (name, type, databirth, commands)VALUES 
('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
('Biaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop');

# таблица с данными верблюдов
INSERT INTO camel (name, type, databirth, commands) VALUES 
('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
('Sahara', 'Camel', '2015-08-14', 'Walk, Run');

# таблица с данными ослов
INSERT INTO donkey (name, type, databirth, commands)VALUES 
('Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray');

# - Удалить записи о верблюдах и объединить таблицы лошадей и ослов
DELETE FROM camel;
select name, type, databirth, commands FROM donkey
	union select name, type, databirth, commands FROM horse;
    
# - Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
/
CREATE TABLE animal_all
AS (SELECT name, type, comands, databirth
	FROM dog WHERE databirth >= CURDATE( )-3YEAR);

CREATE TEMPORARY TABLE animals_all AS 
SELECT *,  TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) age FROM horse
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM donkey
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM dog
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM cat
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM hamster;

create temporary table young_animals AS
select * From animals_all  WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

select * from young_animals;

# - Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

drop table animal_all;

CREATE TEMPORARY TABLE animals_all AS 
SELECT *,  TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) age FROM horse
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM donkey
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM dog
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM cat
UNION SELECT *, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS age FROM hamster;


