DROP DATABASE IF EXISTS AnimeFlvBDD;
CREATE DATABASE AnimeFlvBDD;
USE AnimeFlvBDD;

create table anime(
	nombre varchar(200) primary key,
    descripcion varchar(400),
    numeroTemporada int(3),
    fechaEstreno date,
    imagenRuta varchar(200)
);

INSERT INTO anime VALUES ('Tokyo Ghoul','Un mundo dividido en humanos y ghouls los cuales son temidos por comer carne humana. Kaneki un humano normal conoce a una chica que le cambiaria la vida por completo',2,'2002-10-03','./imagenes/tkg.jpg');
INSERT INTO anime VALUES ('Naruto','Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale.',2,'2016-01-13','./imagenes/naruto.jpg');
INSERT INTO anime VALUES ('Spy x Family','La División de Inteligencia de Westalis (WISE) envía a su mejor espía, "Twilight", en una misión ultrasecreta para vigilar los movimientos de Donovan Desmond, quien dirige el Partido Nacional por la Unidad de Ostania',1,'2014-07-04','./imagenes/2-scaled.jpg');
INSERT INTO anime VALUES ('Konosuba','Esta popular comedia de mundos alternativos gira en torno a Kazuma Satou, un hikkikomori fan a muerte de los videojuegos, el anime y el manga.',2,'2022-04-09','./imagenes/konosuba.jpg');


create table temporada(
    nombre varchar(200) primary key,
    numeroTemporada int(3),
    descripcion varchar(400),
    fechaEstreno date,
    anime varchar(200),
    imagenRuta varchar(200)
);

INSERT INTO temporada VALUES ('Naruto',1,'Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale.','2002-10-03','Naruto','./imagenes/naruto.jpg');
INSERT INTO temporada VALUES ('Naruto Shippuden',2,'Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale.','2007-02-15','Naruto','./imagenes/naruto2.jpg');

INSERT INTO temporada VALUES ('Konosuba',1,'Esta popular comedia de mundos alternativos gira en torno a Kazuma Satou, un hikkikomori fan a muerte de los videojuegos, el anime y el manga.','2016-01-13','Konosuba','./imagenes/konosuba.jpg');
INSERT INTO temporada VALUES ('Konosuba Season 2',2,'Esta popular comedia de mundos alternativos gira en torno a Kazuma Satou, un hikkikomori fan a muerte de los videojuegos, el anime y el manga.','2017-01-12','Konosuba','./imagenes/konosuba2.jpg');

INSERT INTO temporada VALUES ('Tokyo Ghoul',1,'Un mundo dividido en humanos y ghouls los cuales son temidos por comer carne humana. Kaneki un humano normal conoce a una chica que le cambiaria la vida por completo','2014-07-04','Tokyo Ghoul','./imagenes/tkg.jpg');
INSERT INTO temporada VALUES ('Tokyo Ghoul √A',2,'Un mundo dividido en humanos y ghouls los cuales son temidos por comer carne humana. Kaneki un humano normal conoce a una chica que le cambiaria la vida por completo','2018-01-09','Tokyo Ghoul','./imagenes/tkg2.jpg');

INSERT INTO temporada VALUES ('Spy x Family',1,'La División de Inteligencia de Westalis (WISE) envía a su mejor espía, "Twilight", en una misión ultrasecreta para vigilar los movimientos de Donovan Desmond, quien dirige el Partido Nacional por la Unidad de Ostania','2022-04-09','Spy x Family','./imagenes/2-scaled.jpg');

create table capitulo(
	nombre varchar(200),
    link varchar(200) primary key,
    numeroCapitulo int(3),
    descripcion varchar(200),
    fechaEmision date,
    temporada varchar(200),
    imagenRuta varchar(200)
    
);

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/naruto-1',1,'Capitulo 1 de la temporada 1 de Naruto','2002-10-03','Naruto','./imagenes/cap1Naruto.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/naruto-2',2,'Capitulo 2 de la temporada 1 de Naruto','2002-10-10','Naruto','./imagenes/cap2Naruto.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/naruto-3',3,'Capitulo 3 de la temporada 1 de Naruto','2002-10-17','Naruto','./imagenes/cap3Naruto.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/naruto-4',4,'Capitulo 4 de la temporada 1 de Naruto','2002-10-24','Naruto','./imagenes/cap4Naruto.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/naruto-5',5,'Capitulo 5 de la temporada 1 de Naruto','2002-10-31','Naruto','./imagenes/cap5Naruto.jpg');

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/naruto-shippuden-hd-1',1,'Capitulo 1 de la temporada 2 de Naruto','2007-02-15','Naruto Shippuden','./imagenes/cap1Narutos.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/naruto-shippuden-hd-2',2,'Capitulo 2 de la temporada 2 de Naruto','2007-02-22','Naruto Shippuden','./imagenes/cap2Narutos.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/naruto-shippuden-hd-3',3,'Capitulo 3 de la temporada 2 de Naruto','2007-03-06','Naruto Shippuden','./imagenes/cap3Narutos.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/naruto-shippuden-hd-4',4,'Capitulo 4 de la temporada 2 de Naruto','2007-03-13','Naruto Shippuden','./imagenes/cap4Narutos.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/naruto-shippuden-hd-5',5,'Capitulo 5 de la temporada 2 de Naruto','2007-03-20','Naruto Shippuden','./imagenes/cap5Narutos.jpg');

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-1',1,'Capitulo 1 de la temporada 1 de Konosuba','2016-01-20','Konosuba','./imagenes/cap1Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-2',2,'Capitulo 2 de la temporada 1 de Konosuba','2016-01-27','Konosuba','./imagenes/cap2Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-3',3,'Capitulo 3 de la temporada 1 de Konosuba','2016-02-03','Konosuba','./imagenes/cap3Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-4',4,'Capitulo 4 de la temporada 1 de Konosuba','2016-02-10','Konosuba','./imagenes/cap4Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-5',5,'Capitulo 5 de la temporada 1 de Konosuba','2016-02-17','Konosuba','./imagenes/cap5Konosuba.jpg');

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-2-1',1,'Capitulo 1 de la temporada 2 de Konosuba','2017-01-12','Konosuba Season 2','./imagenes/cap1s2Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-2-2',2,'Capitulo 2 de la temporada 2 de Konosuba','2017-01-19','Konosuba Season 2','./imagenes/cap2s2Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-2-3',3,'Capitulo 3 de la temporada 2 de Konosuba','2017-01-26','Konosuba Season 2','./imagenes/cap3s2Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-2-4',4,'Capitulo 4 de la temporada 2 de Konosuba','2017-02-03','Konosuba Season 2','./imagenes/cap4s2Konosuba.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-2-5',5,'Capitulo 5 de la temporada 2 de Konosuba','2017-02-10','Konosuba Season 2','./imagenes/cap5s2Konosuba.jpg');

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/tokyo-ghoul-1',1,'Capitulo 1 de la temporada 1 de Tokyo Ghoul','2014-07-04','Tokyo Ghoul','./imagenes/cap1tkg.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/tokyo-ghoul-2',2,'Capitulo 2 de la temporada 1 de Tokyo Ghoul','2014-07-09','Tokyo Ghoul','./imagenes/cap2tkg.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/tokyo-ghoul-3',3,'Capitulo 3 de la temporada 1 de Tokyo Ghoul','2014-07-16','Tokyo Ghoul','./imagenes/cap3tkg.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/tokyo-ghoul-4',4,'Capitulo 4 de la temporada 1 de Tokyo Ghoul','2014-07-23','Tokyo Ghoul','./imagenes/cap4tkg.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/tokyo-ghoul-5',5,'Capitulo 5 de la temporada 1 de Tokyo Ghoul','2014-07-30','Tokyo Ghoul','./imagenes/cap5tkg.jpg');

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/tokyo-ghoul-2-1',1,'Capitulo 1 de la temporada 2 de Tokyo Ghoul','2018-01-09','Tokyo Ghoul √A','./imagenes/cap1tkg2.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/tokyo-ghoul-2-2',2,'Capitulo 2 de la temporada 2 de Tokyo Ghoul','2018-01-16','Tokyo Ghoul √A','./imagenes/cap2tkg2.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/tokyo-ghoul-2-3',3,'Capitulo 3 de la temporada 2 de Tokyo Ghoul','2018-01-23','Tokyo Ghoul √A','./imagenes/cap3tkg2.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/tokyo-ghoul-2-4',4,'Capitulo 4 de la temporada 2 de Tokyo Ghoul','2018-01-30','Tokyo Ghoul √A','./imagenes/cap4tkg2.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/tokyo-ghoul-2-5',5,'Capitulo 5 de la temporada 2 de Tokyo Ghoul','2018-02-06','Tokyo Ghoul √A','./imagenes/cap5tkg2.jpg');

INSERT INTO capitulo VALUES ('Capitulo 1','https://www3.animeflv.net/ver/spy-x-family-1',1,'Capitulo 1 de la temporada 1 de Spy x Family','2022-04-09','Spy x Family','./imagenes/cap1sxf.jpg');
INSERT INTO capitulo VALUES ('Capitulo 2','https://www3.animeflv.net/ver/spy-x-family-2',2,'Capitulo 2 de la temporada 1 de Spy x Family','2022-04-16','Spy x Family','./imagenes/cap2sxf.jpg');
INSERT INTO capitulo VALUES ('Capitulo 3','https://www3.animeflv.net/ver/spy-x-family-3',3,'Capitulo 3 de la temporada 1 de Spy x Family','2022-04-23','Spy x Family','./imagenes/cap3sxf.jpg');
INSERT INTO capitulo VALUES ('Capitulo 4','https://www3.animeflv.net/ver/spy-x-family-4',4,'Capitulo 4 de la temporada 1 de Spy x Family','2022-04-30','Spy x Family','./imagenes/cap4sxf.jpg');
INSERT INTO capitulo VALUES ('Capitulo 5','https://www3.animeflv.net/ver/spy-x-family-5',5,'Capitulo 4 de la temporada 1 de Spy x Family','2022-05-07','Spy x Family','./imagenes/cap5sxf.jpg');

create table ova(
	nombre varchar(200) primary key,
    link varchar(200),
    numeroOva int(3),
    descripcion varchar(200),
    temporada varchar(200),
    fechaEstreno date,
    imagenRuta varchar(200)
);

INSERT INTO ova VALUES ('Kono Subarashii Sekai ni Shukufuku wo!','https://www3.animeflv.net/ver/kono-subarashii-sekai-ni-shukufuku-wo-kurenai-densetsu-1',1,'Kazuma Satou es un chico de preparatoria otaku y hikikomori que no suele salir de casa, pero cuando lo hace, un fatídico (y ridículo) accidente acaba con su vida. ','Konosuba','2019-08-30','./imagenes/konosubaOva.jpg');

INSERT INTO ova VALUES ('Naruto Shippuden Sunny Side Battle','https://www3.animeflv.net/ver/naruto-shippuden-sunny-side-battle-1',1,'Debido a la ausencia de Sasuke, aparece un nuevo personaje llamado Sai el cual retoma su lugar.','Naruto','2014-05-11','./imagenes/narutoOva.jpg');
INSERT INTO ova VALUES ('Honoo no Chuunin Shiken Naruto vs Konohamaru','https://www3.animeflv.net/ver/honoo-no-chuunin-shiken-naruto-vs-konohamaru-1',2,'Pasados dos años y medio de entrenamiento con Jiraiya, Naruto Uzumaki regresa a la aldea oculta de la hoja, donde se reúne con sus viejos amigos y conforma de nuevo el Equipo 7.','Naruto','2011-06-28','./imagenes/narutosOva1.jpg');

INSERT INTO ova VALUES ('Tokyo Ghoul: Jack','https://www3.animeflv.net/ver/tokyo-ghoul-jack-1',1,'Kaneki y Hide, dos compañeros de clase, llegan a la conclusión de que si nadie ha visto nunca a esos necrófagos es porque toman la apariencia de seres humanos para ocultarse.','Tokyo Ghoul','2015-04-30','./imagenes/tkgOva1.jpg');
INSERT INTO ova VALUES ('Tokyo Ghoul: "Pinto"','https://www3.animeflv.net/ver/tokyo-ghoul-pinto-1',2,'Dos años después del ataque del CCG al Anteiku, la ciudad de Tokio cambia drásticamente debido a la influencia del CCG.','Tokyo Ghoul','2016-02-12','./imagenes/tkgOva2.jpg');

INSERT INTO ova VALUES ('Spy x Family Ova','https://www3.animeflv.net/anime/spy-x-family',1,'La idea es "crear una familia en una semana para infiltrarse en las reuniones sociales organizadas por la escuela de élite a la que asiste el hijo de Desmond".','Spy x Family','2022-06-27','./imagenes/sxfOva.jpg');

create table usuario(
    nombre varchar(200) primary key,
    email varchar(400),
    contrasena varchar(30),
	anioNacimiento int(4),
    fechaNacimiento date
);
