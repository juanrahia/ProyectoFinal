drop database if exists  gestor_claves;
create database if not exists  gestor_claves;


use gestor_claves;

drop table if exists categoria;
create table if not exists categoria(
	id_cat int auto_increment primary key,
	categoria varchar(20)
);

create table if not exists entrada(
	id_clave int auto_increment primary key,
	nombre varchar(20),
	usuario varchar(20) not null,
	clave varchar(20) not null,
	pagina_web varchar(100),
	favorito boolean,
	id_cat int,
	fecha date,
	cuota decimal(8,2),

	foreign key(id_cat) references categoria(id_cat)
);

insert categoria(categoria) values ('Trabajo');
insert categoria(categoria) values ('Informática');
insert categoria(categoria) values ('Ocio');
insert categoria(categoria) values ('Fotografia');


insert entrada(nombre, usuario, clave, pagina_web, favorito,id_cat, fecha,cuota)values
('Los Remedios', 'juan', '1234', 'www.ieslosremedios', true, 1, '2013-09-12', 20),
('Xataka', 'juan', '1234', 'www.xataka.com', false, 3, '2013-10-12', 00),
('Microsiervos', 'juan', '1234', 'www.microsiervos.com', true, 3, '2014-03-12', 00),
('OjoDigital', 'juan', '1234', 'www.ojodigital.com', true, 4, '2011-03-12', 13);
