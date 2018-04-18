/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  asuncionez
 * Created: 18/04/2018
 */


create database Inventario;
use Inventario;
create table Categoria(
idCategoria int not null auto_increment primary key,
nombreCategoria varchar(30) not null,
descripcionCategoria varchar(50) not null
);

create table Producto(
idProducto int not null auto_increment primary key,
nombreProducto varchar(30) not null,
descripcionProducto varchar(100) not null,
precioUnitario double not null,
existencia int not null,
idCategoria int not null,
foreign key (idCategoria) references Categoria(idCategoria) on update cascade on delete cascade
);

insert into Categoria values(1,'Electrónica', 'Productos del Departamento de Electrónica'),
(2,'Línea Blanca', 'Productos del Departamento de Línea Blanca'),
(3,'Computación', 'Productos del Departamento de Computación');

insert into Producto values(1,'Televisor Sony','Sony Bravia 4K',5000,100,1),
(2,'Televisor LG','Lg full HD Smart',5000,50,1),
(3,'DVD','Sony',1000,100,1),
(4,'Refrigerador Mabe','Refrigerador 14 Pies Mabe con Despachador Silver',6990,100,2),
(5,'Estufa Acros','Estufa Acros 30 Silver',5290,100,2),
(6,'Minisplit','Minisplit Frío/Calor Rheem RC2G-12H1',6599,100,2),
(7,'Desktop Dell','Desktop Dell Alienware Area 51 Intel Core i7 16 GB RAM 2TB más 256 SSD',83999,100,3),
(8,'CPU Gamer','CPU Gamer Intel Core i5 7400, Gáficos Nvidia GTX 1050 Ti 4GB, 8GB RAM, D.D. 1TB',14680,100,3),
(9,'Laptop Dell','Laptop Dell Alienware 17 Intel Core i7 8 GB RAM 1 TB',59999,100,3);