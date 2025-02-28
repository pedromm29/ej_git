DROP DATABASE IF EXISTS gestion_eventos;
CREATE DATABASE gestion_eventos;
USE gestion_eventos;

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Organizador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(255) NOT NULL
);

CREATE TABLE Categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Ubicacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE Evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    organizador_id INT NOT NULL,
    categoria_id INT NOT NULL,
    ubicacion_id INT NOT NULL,
    FOREIGN KEY (organizador_id) REFERENCES Organizador(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (ubicacion_id) REFERENCES Ubicacion(id)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE Inscripcion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    evento_id INT NOT NULL,
    fecha_registro DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (evento_id) REFERENCES Evento(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);