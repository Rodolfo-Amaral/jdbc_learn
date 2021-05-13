CREATE TABLE departamento (
	ID serial PRIMARY KEY,
	NOME VARCHAR ( 60 ) UNIQUE NOT NULL
);
CREATE TABLE vendedor (
  ID serial NOT NULL,
  Nome varchar ( 60 ) NOT NULL,
  Email varchar ( 100 ) NOT NULL,
  Data_Nascimento DATE NOT NULL,
  Salario_Base NUMERIC NOT NULL,
  Id_dpt INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (Id_dpt) REFERENCES departamento (ID)
);

INSERT INTO departamento (Nome) VALUES 
  ('Computadores'),
  ('Eletrônicos'),
  ('Fashion'),
  ('Livros');

INSERT INTO vendedor (Nome, Email, Data_Nascimento, Salario_Base, Id_dpt) VALUES 
  ('Antônio Banderas','ab@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Adelaide Amaral','maria_adelaide@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Fluido','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Gal Costa','galcosta@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Nelio Alves','nelioalvesfalando@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Hugo Homemdieque','hugjack@gmail.com','1997-03-04 00:00:00',3000,2);