create database PROYECTO;
USE PROYECTO;

Create table usuario(
codigo int primary key auto_increment,
usuario varchar(30) not null,
contra varchar(30) not null
);

create table solicitante(
codigoSolicitante int primary key auto_increment,
nombre varchar (30)
);
INSERT INTO solicitante (nombre) VALUES
('Maria Querevalu'),
('Emanuel Leiva'),
('Alexandra Vilchez'),
('Gabriela Rojas'),
('Victor Borja');

CREATE TABLE incidente(
  codigoIncidente INT PRIMARY KEY auto_increment,
  Descripcion VARCHAR(100),
  Impacto VARCHAR(20),
  Estado VARCHAR(20)
); 

INSERT INTO incidente (codigoincidente, Descripcion, Impacto, Estado)
VALUES
  (1,  'Caída del servidor', 'Alto', 'Resuelto'),
  (2,  'Robo de datos confidenciales', 'Crítico', 'En proceso'),
  (3,  'Virus en la red corporativa', 'Moderado', 'Resuelto'),
  (4,  'Interrupción del servicio de correo electrónico', 'Alto', 'En proceso'),
  (5,  'Ataque de denegación de servicio (DDoS)', 'Crítico', 'Resuelto');
  
  CREATE TABLE ubicacion(
  codigoUbicacion INT PRIMARY KEY auto_increment,
  distrito varchar (40)
  );
  
  INSERT INTO ubicacion (codigoUbicacion,distrito) values (1,'Callao'),
  (2,'Miraflores'),
  (3,'Los Olivos');
  
 CREATE TABLE informe(
  codigoInforme INT PRIMARY KEY AUTO_INCREMENT,
  codigoSolicitante INT,
  codigoUbicacion INT,
  fechaSolicitud DATETIME,
  numeroInforme CHAR(9),
  codigoIncidente INT,
  recomendaciones VARCHAR(100),
  FOREIGN KEY (codigoSolicitante) REFERENCES solicitante(codigoSolicitante),
  FOREIGN KEY (codigoUbicacion) REFERENCES ubicacion(codigoUbicacion),
  FOREIGN KEY (codigoIncidente) REFERENCES incidente(codigoIncidente)
);

 INSERT INTO informe (codigoSolicitante, codigoUbicacion , numeroInforme, fechaSolicitud, codigoIncidente,recomendaciones)
VALUES
  (1, 1, 1001, '2023-06-01 09:00:00', 5,'Implementar un mejor servicio de DDos'),
  (2, 2, 1002, '2023-06-05 14:30:00', 3, 'Implementar un mejor antivirus para el sistema'),
  (3, 3, 1003, '2023-06-10 11:45:00', 2, 'Estar con el grupo en todo, Hasta el final del proyecto' );

select  i.codigoinforme ,s.nombre, u.distrito ,i.fechaSolicitud, i.numeroInforme, e.Descripcion, e.Impacto, e.estado, i.recomendaciones from informe i inner join solicitante s on s.codigoSolicitante = i.codigoSolicitante
inner join ubicacion u on i.codigoUbicacion = u.codigoUbicacion
inner join incidente e on e.codigoincidente = i.codigoincidente order by codigoinforme asc