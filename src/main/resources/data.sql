SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE PAGAMENTO;
TRUNCATE TABLE EXAME;
TRUNCATE TABLE CONSULTA;
TRUNCATE TABLE DENTISTA;
TRUNCATE TABLE PACIENTE;
TRUNCATE TABLE SALA_ATENDIMENTO;
TRUNCATE TABLE ESPECIALIDADE;

SET FOREIGN_KEY_CHECKS = 1;

-- ESPECIALIDADES
INSERT INTO ESPECIALIDADE (id_especialidade, nome_especialidade) VALUES
(1,'Ortodontia'),
(2,'Endodontia'),
(3,'Cirurgia'),
(4,'Implantodontia'),
(5,'Odontopediatria');

-- SALAS
INSERT INTO SALA_ATENDIMENTO (id_sala, numero_sala, bloco, status_sala) VALUES
(1,'101','A','Disponível'),
(2,'102','A','Disponível'),
(3,'103','A','Ocupada'),
(4,'201','B','Disponível'),
(5,'202','B','Ocupada'),
(6,'203','B','Disponível'),
(7,'301','C','Disponível'),
(8,'302','C','Ocupada');

-- DENTISTAS
INSERT INTO DENTISTA
(id_dentista,nome,cpf,cro,telefone,email,salario,id_especialidade)
VALUES
(1,'Carlos Silva','11111111111','CRO001','98990000001','carlos@clinica.com',5000,1),
(2,'Ana Souza','11111111112','CRO002','98990000002','ana@clinica.com',6000,1),
(3,'Marcos Lima','11111111113','CRO003','98990000003','marcos@clinica.com',5500,1),
(4,'Julia Rocha','11111111114','CRO004','98990000004','julia@clinica.com',6200,2),
(5,'Pedro Alves','11111111115','CRO005','98990000005','pedro@clinica.com',5800,2),
(6,'Bianca Melo','11111111116','CRO006','98990000006','bianca@clinica.com',6100,2),
(7,'Fernanda Costa','11111111117','CRO007','98990000007','fernanda@clinica.com',7000,3),
(8,'Lucas Mendes','11111111118','CRO008','98990000008','lucas@clinica.com',6500,3),
(9,'Rafael Dias','11111111119','CRO009','98990000009','rafael@clinica.com',6400,3),
(10,'Amanda Reis','11111111120','CRO010','98990000010','amanda@clinica.com',7200,4),
(11,'Daniel Castro','11111111121','CRO011','98990000011','daniel@clinica.com',7100,4),
(12,'Larissa Nunes','11111111122','CRO012','98990000012','larissa@clinica.com',7300,4),
(13,'Eduardo Lima','11111111123','CRO013','98990000013','eduardo@clinica.com',4800,5),
(14,'Patricia Gomes','11111111124','CRO014','98990000014','patricia@clinica.com',4900,5),
(15,'Camila Ribeiro','11111111125','CRO015','98990000015','camila@clinica.com',5000,5);

-- PACIENTES
INSERT INTO PACIENTE
(id_paciente,nome,cpf,data_nascimento,sexo,telefone,endereco,email)
VALUES
(1,'Paciente 01','22222222001','1999-01-10','M','98980000001','Rua A','p1@email.com'),
(2,'Paciente 02','22222222002','1998-02-12','F','98980000002','Rua B','p2@email.com'),
(3,'Paciente 03','22222222003','2000-03-14','M','98980000003','Rua C','p3@email.com'),
(4,'Paciente 04','22222222004','1997-04-18','F','98980000004','Rua D','p4@email.com'),
(5,'Paciente 05','22222222005','2001-05-20','M','98980000005','Rua E','p5@email.com'),
(6,'Paciente 06','22222222006','1996-06-22','F','98980000006','Rua F','p6@email.com'),
(7,'Paciente 07','22222222007','2002-07-25','M','98980000007','Rua G','p7@email.com'),
(8,'Paciente 08','22222222008','1995-08-30','F','98980000008','Rua H','p8@email.com'),
(9,'Paciente 09','22222222009','2003-09-12','M','98980000009','Rua I','p9@email.com'),
(10,'Paciente 10','22222222010','1994-10-10','F','98980000010','Rua J','p10@email.com'),
(11,'Paciente 11','22222222011','1998-11-11','M','98980000011','Rua K','p11@email.com'),
(12,'Paciente 12','22222222012','2001-12-12','F','98980000012','Rua L','p12@email.com'),
(13,'Paciente 13','22222222013','1997-01-13','M','98980000013','Rua M','p13@email.com'),
(14,'Paciente 14','22222222014','1999-02-14','F','98980000014','Rua N','p14@email.com'),
(15,'Paciente 15','22222222015','2000-03-15','M','98980000015','Rua O','p15@email.com'),
(16,'Paciente 16','22222222016','1998-04-16','F','98980000016','Rua P','p16@email.com'),
(17,'Paciente 17','22222222017','2002-05-17','M','98980000017','Rua Q','p17@email.com'),
(18,'Paciente 18','22222222018','1995-06-18','F','98980000018','Rua R','p18@email.com'),
(19,'Paciente 19','22222222019','2003-07-19','M','98980000019','Rua S','p19@email.com'),
(20,'Paciente 20','22222222020','1996-08-20','F','98980000020','Rua T','p20@email.com');

-- CONSULTAS
INSERT INTO CONSULTA
(id_consulta,data_consulta,hora_consulta,status_consulta,observacoes,id_paciente,id_dentista,id_sala)
VALUES
(1,'2026-01-10','09:00:00','Concluída','Rotina',1,1,1),
(2,'2026-01-12','10:00:00','Concluída','Canal',2,4,2),
(3,'2026-01-15','11:00:00','Concluída','Extração',3,7,3),
(4,'2026-01-20','14:00:00','Pendente','Implante',4,10,4),
(5,'2026-01-25','15:00:00','Concluída','Aparelho',5,13,5),
(6,'2026-02-02','09:30:00','Concluída','Limpeza',6,2,6),
(7,'2026-02-08','10:30:00','Concluída','Canal',7,5,7),
(8,'2026-02-12','11:30:00','Pendente','Cirurgia',8,8,8),
(9,'2026-02-15','13:00:00','Concluída','Implante',9,11,1),
(10,'2026-02-18','14:30:00','Concluída','Consulta infantil',10,14,2),
(11,'2026-03-01','09:00:00','Concluída','Rotina',11,3,3),
(12,'2026-03-05','10:00:00','Concluída','Canal',12,6,4),
(13,'2026-03-08','11:00:00','Pendente','Cirurgia',13,9,5),
(14,'2026-03-12','14:00:00','Concluída','Implante',14,12,6),
(15,'2026-03-18','15:00:00','Concluída','Infantil',15,15,7),
(16,'2026-04-01','09:00:00','Concluída','Rotina',16,1,8),
(17,'2026-04-04','10:00:00','Concluída','Canal',17,4,1),
(18,'2026-04-10','11:00:00','Pendente','Extração',18,7,2),
(19,'2026-04-14','13:00:00','Concluída','Implante',19,10,3),
(20,'2026-04-20','14:30:00','Concluída','Infantil',20,13,4),
(21,'2026-05-01','09:00:00','Concluída','Rotina',1,2,5),
(22,'2026-05-05','10:00:00','Concluída','Canal',2,5,6),
(23,'2026-05-10','11:00:00','Concluída','Extração',3,8,7),
(24,'2026-05-15','14:00:00','Concluída','Implante',4,11,8),
(25,'2026-05-20','15:00:00','Pendente','Aparelho',5,14,1),
(26,'2026-06-01','09:00:00','Concluída','Rotina',6,3,2),
(27,'2026-06-08','10:00:00','Concluída','Canal',7,6,3),
(28,'2026-06-15','11:00:00','Concluída','Cirurgia',8,9,4),
(29,'2026-06-20','14:00:00','Concluída','Implante',9,12,5),
(30,'2026-06-25','15:00:00','Concluída','Infantil',10,15,6);

-- EXAMES
INSERT INTO EXAME
(id_exame,tipo_exame,resultado,data_exame,id_consulta)
VALUES
(1,'Raio-X','Normal','2026-01-10',1),
(2,'Tomografia','Cárie detectada','2026-01-12',2),
(3,'Raio-X','Normal','2026-01-15',3),
(4,'Tomografia','Normal','2026-02-08',8),
(5,'Raio-X','Infecção','2026-03-08',13),
(6,'Tomografia','Normal','2026-04-10',18),
(7,'Raio-X','Fratura','2026-05-15',25),
(8,'Tomografia','Normal','2026-06-20',29);

-- PAGAMENTOS
INSERT INTO PAGAMENTO
(id_pagamento,valor,forma_pagamento,data_pagamento,status_pagamento,id_consulta)
VALUES
(1,200,'PIX','2026-01-10','Pago',1),
(2,350,'Cartão','2026-01-12','Pago',2),
(3,500,'Dinheiro','2026-01-15','Pago',3),
(4,1200,'PIX','2026-01-20','Pendente',4),
(5,700,'Cartão','2026-01-25','Pago',5),
(6,180,'PIX','2026-02-02','Pago',6),
(7,400,'Dinheiro','2026-02-08','Pago',7),
(8,800,'PIX','2026-02-12','Pendente',8),
(9,1500,'Cartão','2026-02-15','Pago',9),
(10,250,'Dinheiro','2026-02-18','Pago',10),
(11,200,'PIX','2026-03-01','Pago',11),
(12,350,'Cartão','2026-03-05','Pago',12),
(13,900,'PIX','2026-03-08','Pendente',13),
(14,1800,'Cartão','2026-03-12','Pago',14),
(15,300,'Dinheiro','2026-03-18','Pago',15),
(16,200,'PIX','2026-04-01','Pago',16),
(17,350,'Cartão','2026-04-04','Pago',17),
(18,600,'PIX','2026-04-10','Pendente',18),
(19,1400,'Cartão','2026-04-14','Pago',19),
(20,250,'Dinheiro','2026-04-20','Pago',20),
(21,220,'PIX','2026-05-01','Pago',21),
(22,380,'Cartão','2026-05-05','Pago',22),
(23,550,'Dinheiro','2026-05-10','Pago',23),
(24,1600,'PIX','2026-05-15','Pago',24),
(25,750,'Cartão','2026-05-20','Pendente',25),
(26,210,'PIX','2026-06-01','Pago',26),
(27,390,'Cartão','2026-06-08','Pago',27),
(28,950,'Dinheiro','2026-06-15','Pago',28),
(29,1700,'PIX','2026-06-20','Pago',29),
(30,280,'Cartão','2026-06-25','Pago',30);