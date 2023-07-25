create table professor (id  serial not null, cargo varchar(255), email varchar(255), nome varchar(255), salario numeric(19, 2), setor varchar(255), primary key (id));
INSERT INTO PROFESSOR (nome,email,cargo,salario,setor) VALUES ('p1','a@b.com','gerente',1,'TECNOLOGIA');
