#crecion de base datos
CREATE DATABASE tiendagenerica;

#seleccion y uso de base de datos
USE tiendagenerica;

#creacion de tabla para modulo de usuarios
CREATE TABLE usuarios (
    cedula_usuario BIGINT PRIMARY KEY,
    email_usuario VARCHAR(255) NOT NULL,
    nombre_usuario VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    usuario VARCHAR(255) NOT NULL
);

#Insertar datos en la tabla de usuarios
INSERT INTO usuarios VALUES(001, 'roca230313@gmail.com', 'Diego Rodriguez', 'admin123456', 'admininicial');#El primer usuario debe manejar credenciales de admin
INSERT INTO usuarios VALUES(002, 'jnikomc@hotmail.com', 'Nicolas Munoz', 'pass', 'user');
INSERT INTO usuarios VALUES(003, 'email1@gmail.com', 'Andres Rodriguez', 'pass2', 'user2');

#Creacion de un indice unico en usuario para que no se repitan valores de usuario(llave unica)
CREATE UNIQUE INDEX usurio_unico
ON usuarios(usuario);