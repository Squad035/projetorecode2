-- Criação e estrutura do banco

CREATE database edios;

use edios;

CREATE TABLE doador (
id_doador INTEGER PRIMARY KEY auto_increment,
nome VARCHAR(100),
email VARCHAR(100)
);

CREATE TABLE escola (
id_escola INTEGER PRIMARY KEY auto_increment,
nomeEscola VARCHAR(100)
);

CREATE TABLE aluno (
id_aluno INTEGER PRIMARY KEY auto_increment,
nome VARCHAR(100),
idade INTEGER,
sexo VARCHAR(10),
id_escola INTEGER,
id_endereco INTEGER,
FOREIGN KEY(id_escola) REFERENCES escola (id_escola)
);

CREATE TABLE equipamento (
id_equipamento INTEGER PRIMARY KEY auto_increment,
descricao VARCHAR(250),
id_doador INTEGER,
id_escola INTEGER,
FOREIGN KEY(id_doador) REFERENCES doador (id_doador),
FOREIGN KEY(id_escola) REFERENCES escola (id_escola)
);

CREATE TABLE endereco (
id_endereco INTEGER PRIMARY KEY auto_increment,
rua VARCHAR(250),
bairro VARCHAR(100),
numero INTEGER,
cidade VARCHAR(100),
estado VARCHAR(100)
);

ALTER TABLE aluno ADD FOREIGN KEY(id_endereco) REFERENCES endereco (id_endereco);


-- Inserindo

insert into doador(nome, email) values ("Josefa","josega@gmail.com");
