create database Biblioteca_DB

use Biblioteca DB

create table Categoria(
	categoria_id serial Primary key ,
	nombre varchar(100),
	archivo varchar(100)
);

insert into Categoria (nombre, archivo) values 
('Ficción','ficcion.pdf'),
('Misterio','misterio.pdf'),
('Romance','romance.pdf'),
('Ciencia Ficción','ciencia_ficcion.pdf'),
('Fantasía','fantasia.pdf'),
('No Ficción','no_ficcion.pdf'),
('Biografía','biografia.pdf'),
('Historia','historia.pdf'),
('Arte','arte.pdf'),
('Cocina','cocina.pdf');

select * from Categoria;

create table Autor(
	autor_id serial primary key ,
	nombre varchar(255) not null,
	fecha_nacimiento date,
	pais varchar(255)
);

insert into Autor (nombre, fecha_nacimiento, pais) values
('J.K Rowling','1965-07-31','Reino Unido'),
('George Orwell','1903-06-25','Reino Unido'),
('Jane Austen','1775-12-16','Reino Unido'),
('Stephen King','1947-09-21','Estados Unidos'),
('Gabriel Garcia Marquez','1927-03-06','Colombia');


create table Libro (
	libro_id serial primary key ,
	nombre varchar(255) not null,
	autor_id int,
	categoria_id int,
	precio decimal(10,2),
	estado varchar(20),
	
	foreign key (autor_id) references Autor(autor_id),
	foreign key (categoria_id) references Categoria(categoria_id)
);