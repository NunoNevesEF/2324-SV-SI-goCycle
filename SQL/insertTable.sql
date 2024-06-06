BEGIN;

-- Inserindo dados na tabela pessoa
INSERT INTO pessoa (telefone, morada, cc, nome, email, nacionalidade)
VALUES
(123456789, 'Rua das Flores, 123', 123456789, 'João Silva', 'joao.silva@example.com', 'PT'),
(987654321, 'Avenida dos Aliados, 456', 987654321, 'Maria Oliveira', 'maria.oliveira@example.com', 'PT'),
(555444333, 'Praça da Liberdade, 789', 555444333, 'Carlos Sousa', 'carlos.sousa@example.com', 'BR');

-- Inserindo dados na tabela loja
INSERT INTO loja (telefone, email, endereco, localidade, gestor)
VALUES
(222333444, 'loja1@example.com', 'Rua Comercial, 12', 'Porto', 1),
(333444555, 'loja2@example.com', 'Avenida Central, 34', 'Lisboa', 2);

-- Inserindo dados na tabela dispositivo
INSERT INTO dispositivo (bateria, latitude, longitude)
VALUES
(75.5, 41.1579, -8.6291),
(80.2, 38.7169, -9.1390),
(100.2,23.4321, -4.3490);

-- Inserindo dados na tabela bicicleta
INSERT INTO bicicleta (modelo, peso, marca, estado, sis_mudancas, atr_disc, vel_max, autonomia, gps)
VALUES
('Modelo Clássico', 15000, 'Marca X', 'livre', '18', 'C', NULL, NULL, 1),
('Modelo Clássico', 17000, 'Marca W', 'ocupado', '33', 'A', NULL, NULL, 3),
('Modelo Elétrico', 20000, 'Marca Y', 'livre', '24', 'E', 25.0, 100.0, 2);

-- Inserindo dados na tabela reserva
INSERT INTO reserva (dtinicio, dtfim, valor, bicicleta)
VALUES
('2024-06-01 10:00:00', '2024-06-03 10:00:00', 50.00, 1),
('2024-06-02 09:00:00', '2024-06-04 09:00:00', 75.00, 2);

-- Inserindo dados na tabela clientereserva
INSERT INTO clientereserva (reserva, loja, cliente)
VALUES
(1, 1, 3),
(2, 2, 1);

COMMIT;
