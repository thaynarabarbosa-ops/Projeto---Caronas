CREATE DATABASE caronas_ifsp;

USE caronas_ifsp;

CREATE TABLE usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(50),
    tipo VARCHAR(20)
);

CREATE TABLE rotas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    motorista_id INT,
    origem VARCHAR(100),
    destino VARCHAR(100),
    horario DATETIME,
    vagas INT,
    FOREIGN KEY (motorista_id) REFERENCES usuarios(id)
);

CREATE TABLE solicitacoes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    rota_id INT,
    passageiro_id INT,
    status VARCHAR(20),
    FOREIGN KEY (rota_id) REFERENCES rotas(id),
    FOREIGN KEY (passageiro_id) REFERENCES usuarios(id)
);

CREATE TABLE avaliacoes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    avaliador INT,
    avaliado INT,
    estrelas INT,
    comentario VARCHAR(255),
    FOREIGN KEY (avaliador) REFERENCES usuarios(id),
    FOREIGN KEY (avaliado) REFERENCES usuarios(id)
);
