CREATE TABLE cliente (
	mat SERIAL,
	nome VARCHAR(255),
	profissao VARCHAR(100),
	endereco VARCHAR(255),
	sexo VARCHAR(30),
	email VARCHAR(100),
	telefone VARCHAR(20),
	PRIMARY KEY (mat)
	);

CREATE TABLE dependente (
	id SERIAL,
	mat_cliente INT,
	nome VARCHAR(255),
	endereco VARCHAR(255),
	sexo VARCHAR(30),	
	email VARCHAR(100),
	PRIMARY KEY (id),
	FOREIGN KEY (mat_cliente) REFERENCES cliente(mat)
	);

 CREATE TABLE categoria (
   id SERIAL,
   nome VARCHAR(200),
   PRIMARY KEY (id)
 );

CREATE TABLE filme (
  cod SERIAL,
  titulo VARCHAR(200),
  ano INT,
  num_oscars INT,
  id_categoria INT,
  PRIMARY KEY (cod),
  FOREIGN KEY (id_categoria) REFERENCES categoria (id)
	);

CREATE TABLE copia (
  oid SERIAL,
  fabricante VARCHAR(200),
  cod_filme INT,
  PRIMARY KEY (oid),
  FOREIGN KEY (cod_filme) REFERENCES filme(cod)
  );

CREATE TABLE vhs (
  oid_copia INT,
  data_grav DATE,
  PRIMARY KEY (oid_copia),
  FOREIGN KEY (oid_copia) REFERENCES copia(oid)
  );

CREATE TABLE dvd (
  oid_copia INT,
  zonas VARCHAR(100),
  idiomas VARCHAR(255),
  PRIMARY KEY (oid_copia),
  FOREIGN KEY (oid_copia) REFERENCES copia(oid)
  );

CREATE TABLE profissional (
  id SERIAL,
  nome VARCHAR(255),
  foto TEXT,
  home_page TEXT,
  PRIMARY KEY (id)
  );

CREATE TABLE trabalham (
  cod_filme INT,
  id_profissional INT,
  PRIMARY KEY (cod_filme, id_profissional),
  FOREIGN KEY (cod_filme) REFERENCES filme(cod),
  FOREIGN KEY (id_profissional) REFERENCES profissional(id)
  );

CREATE TABLE ator (
  id_profissional INT,
  num_oscars INT,
  PRIMARY KEY (id_profissional),
  FOREIGN KEY (id_profissional) REFERENCES profissional(id)
  );


CREATE TABLE diretor (
  id_profissional INT,
  especialidades TEXT,
  PRIMARY KEY (id_profissional),
  FOREIGN KEY (id_profissional) REFERENCES profissional(id)
  );

CREATE TABLE aluga (
  mat_cliente INT,
  oid_copia INT,
  data_out DATE,
  data_in DATE,
  multa DECIMAL,
  PRIMARY KEY (mat_cliente, oid_copia, data_out),
  FOREIGN KEY (mat_cliente) references cliente(mat),
  FOREIGN KEY (oid_copia) REFERENCES copia(oid)
  );

CREATE TABLE reserva (
  mat_cliente INT,
  cod_filme INT,
  data_reserva DATE,
  PRIMARY KEY (mat_cliente, cod_filme, data_reserva),
  FOREIGN KEY (mat_cliente) references cliente(mat),
  FOREIGN KEY (cod_filme) REFERENCES filme(cod)
  );

CREATE TABLE opina (
  mat_cliente INT,
  cod_filme INT,
  opiniao TEXT,
  data_opiniao DATE,
  PRIMARY KEY (mat_cliente),
  FOREIGN KEY (mat_cliente) REFERENCES cliente(mat),
  FOREIGN KEY (cod_filme) REFERENCES filme(cod)
  );

CREATE TABLE gosta (
  mat_cliente INT,
  id_categoria INT,
  PRIMARY KEY (mat_cliente, id_categoria),
  FOREIGN KEY (mat_cliente) REFERENCES cliente(mat),
  FOREIGN KEY (id_categoria) REFERENCES categoria(id)
  );