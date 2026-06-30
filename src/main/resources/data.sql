SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE PAGAMENTO;
TRUNCATE TABLE EXAME;
TRUNCATE TABLE CONSULTA;
TRUNCATE TABLE DENTISTA;
TRUNCATE TABLE PACIENTE;
TRUNCATE TABLE SALA_ATENDIMENTO;
TRUNCATE TABLE ESPECIALIDADE;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO ESPECIALIDADE (id_especialidade, nome_especialidade) VALUES
(1, 'Ortodontia'),
(2, 'Endodontia'),
(3, 'Cirurgia');

INSERT INTO SALA_ATENDIMENTO (id_sala, numero_sala, bloco, status_sala) VALUES
(1, '101', 'A', 'Disponível'),
(2, '102', 'A', 'Ocupada'),
(3, '103', 'B', 'Disponível');

INSERT INTO DENTISTA (
    id_dentista,
    nome,
    cpf,
    cro,
    telefone,
    email,
    salario,
    id_especialidade
) VALUES
(1, 'Carlos Silva', '11111111111', 'CRO123', '98999999999', 'carlos@email.com', 5000.00, 1),
(2, 'Ana Souza', '22222222222', 'CRO456', '98988888888', 'ana@email.com', 6000.00, 2),
(3, 'Marcos Lima', '33333333333', 'CRO789', '98977777777', 'marcos@email.com', 5500.00, 3);

INSERT INTO PACIENTE (
    id_paciente,
    nome,
    cpf,
    data_nascimento,
    sexo,
    telefone,
    endereco,
    email
) VALUES
(1, 'Felipe Freitas', '44444444444', '2004-05-10', 'M', '98999999999', 'Rua A', 'felipe@email.com'),
(2, 'Maria Oliveira', '55555555555', '1998-08-20', 'F', '98988888888', 'Rua B', 'maria@email.com'),
(3, 'João Pereira', '66666666666', '1995-02-15', 'M', '98977777777', 'Rua C', 'joao@email.com'),
(4, 'Lucas Santos', '77777777777', '2000-10-12', 'M', '98966666666', 'Rua D', 'lucas@email.com');

INSERT INTO CONSULTA (
    id_consulta,
    data_consulta,
    hora_consulta,
    status_consulta,
    observacoes,
    id_paciente,
    id_dentista,
    id_sala
) VALUES
(1, '2026-06-10', '09:00:00', 'Concluída', 'Limpeza', 1, 1, 1),
(2, '2026-06-15', '10:00:00', 'Concluída', 'Canal', 2, 2, 2),
(3, '2026-07-01', '14:00:00', 'Pendente', 'Aparelho', 1, 1, 1),
(4, '2026-07-05', '15:30:00', 'Concluída', 'Extração', 3, 3, 3);

INSERT INTO EXAME (
    id_exame,
    tipo_exame,
    resultado,
    data_exame,
    id_consulta
) VALUES
(1, 'Raio-X', 'Normal', '2026-06-10', 1),
(2, 'Tomografia', 'Cárie detectada', '2026-06-15', 2);

INSERT INTO PAGAMENTO (
    id_pagamento,
    valor,
    forma_pagamento,
    data_pagamento,
    status_pagamento,
    id_consulta
) VALUES
(1, 200.00, 'PIX', '2026-06-10', 'Pago', 1),
(2, 350.00, 'Cartão', '2026-06-15', 'Pago', 2),
(3, 180.00, 'Dinheiro', '2026-07-01', 'Pendente', 3),
(4, 500.00, 'PIX', '2026-07-05', 'Pago', 4);