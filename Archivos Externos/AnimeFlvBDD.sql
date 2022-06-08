DROP DATABASE IF EXISTS AnimeFlvBDD;
CREATE DATABASE AnimeFlvBDD;
USE AnimeFlvBDD;

create table usuario(
    nombre varchar(200) primary key,
    email varchar(400),
    contrasena varchar(30),
	anioNacimiento int(4),
    fechaNacimiento date
);

create table anime(
	nombre varchar(200) primary key,
    portada blob,
    descripcion varchar(200)
    
);

create table temporadas(
	nombre varchar(200),
	numeroTemporada int(3),
    usuario varchar(200),
    fechaEstreno date,
    descripcion varchar(200),
	portada blob,
    anime varchar(200),
    foreign key (anime) references anime(nombre),
    foreign key (usuario) references usuario(nombre),
    primary key(numeroTemporada,anime)
);

create table capitulo(
	nombre varchar(200),
    link varchar(200),
    numeroCapitulo int(3),
    descripcion varchar(200),
    portada blob,
    temporada varchar(200),
	foreign key (anime2) references anime(nombre),
    foreign key (usuario2) references usuario(nombre),
    primary key(numeroCapitulo,anime)
    
);

create table ova(
	nombre varchar(200),
    link varchar(200),
    numeroOva int(3),
    descripcion varchar(200),
    portada blob,
    temporada varchar(200),
	foreign key (anime3) references anime(nombre),
    foreign key (usuario3) references usuario(nombre),
    primary key(numeroOva,anime)
    
);

create table noticia(
	nombre varchar(200),
	descripcion varchar(200)
);