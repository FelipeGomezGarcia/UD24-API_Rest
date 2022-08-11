
DROP table IF EXISTS trabajador;

create table trabajador(
	id int auto_increment,
	nombre varchar(250),
	empleo varchar(250),
	salario integer,
	fecha date
);

insert into trabajador (nombre, empleo, salario,fecha)values('Jose','programador',2400, NOW());