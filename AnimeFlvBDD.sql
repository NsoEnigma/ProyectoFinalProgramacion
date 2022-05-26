DROP DATABASE IF EXISTS AnimeFlvBDD;
CREATE DATABASE AnimeFlvBDD;
USE AnimeFlvBDD;

create table usuario(
    nombre varchar(200) primary key,
    email varchar(400),
    contrasena varchar(30),
    fechaNacimiento date
);

create table animes(
	nombre varchar(200) primary key,
    foreign key (temporada) references temporadas(numeroTemporada)
);

create table temporadas(
	nombre varchar(200) primary key,
	numeroTemporada int(3)
);