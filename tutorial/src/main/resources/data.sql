CREATE TABLE IF NOT EXISTS category (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


INSERT INTO category(name) VALUES ('Eurogames');
INSERT INTO category(name) VALUES ('Ameritrash');
INSERT INTO category(name) VALUES ('Familiar');



CREATE TABLE IF NOT EXISTS author (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality varchar(4) NOT NULL
);
INSERT INTO author(name, nationality) VALUES ('Alan R. Moon', 'US');
INSERT INTO author(name, nationality) VALUES ('Vital Lacerda', 'PT');
INSERT INTO author(name, nationality) VALUES ('Simone Luciani', 'IT');
INSERT INTO author(name, nationality) VALUES ('Perepau Llistosella', 'ES');
INSERT INTO author(name, nationality) VALUES ('Michael Kiesling', 'DE');
INSERT INTO author(name, nationality) VALUES ('Phil Walker-Harding', 'US');


CREATE TABLE IF NOT EXISTS game(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id) ,
    FOREIGN KEY (author_id) REFERENCES author(id)
);
INSERT INTO game(title, age, category_id, author_id) VALUES ('On Mars', '14', 1, 2);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Aventureros al tren', '8', 3, 1);
INSERT INTO game(title, age, category_id, author_id) VALUES ('1920: Wall Street', '12', 1, 4);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Barrage', '14', 1, 3);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO game(title, age, category_id, author_id) VALUES ('Azul', '8', 3, 5);

CREATE TABLE IF NOT EXISTS clients(
    id int AUTO_INCREMENT primary key,
    name varchar(255) not null
);


insert into clients(name) values ('Federico');
insert into clients(name) values ('María');
insert into clients(name) values ('Ignacio');
insert into clients(name) values ('Lucas');
insert into clients(name) values ('Lilia');
insert into clients(name) values ('Angela');


CREATE TABLE IF NOT EXISTS loan(
    id int primary key AUTO_INCREMENT,
    game_id int not null,
    client_id int not null,
    start_date Date not null,
    end_date Date not null,
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (game_id) REFERENCES game(id)

);
