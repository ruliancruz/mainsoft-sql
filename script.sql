-- Script criação de tabelas:

CREATE TABLE equipamento
(
	id_equip SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR (30) NOT NULL,
	modelo VARCHAR (40),
	fabricante VARCHAR (40),
	data_aquisicao DATE NOT NULL
);

CREATE TABLE peca
(
	id_peca SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR (30) NOT NULL,
	modelo VARCHAR (40),
	fabricante VARCHAR (40),
	id_equip INT REFERENCES equipamento (id_equip) NOT NULL
);

CREATE TABLE funcionario
(
	id_func SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR (30) NOT NULL
);

CREATE TABLE manutencao
(
	id_manu SERIAL PRIMARY KEY NOT NULL,
	data_inicio TIMESTAMP without time zone,
	data_conclusao TIMESTAMP without time zone,
	manu_iniciada VARCHAR (10) NOT NULL,
	manu_concluida VARCHAR (10) NOT NULL,
	descricao TEXT,
	tipo_manu TEXT NOT NULL,
	id_equip INT REFERENCES equipamento (id_equip) NOT NULL,
	id_func INT REFERENCES funcionario (id_func) NOT NULL
);

CREATE TABLE manutencao_corretiva
(
	id_manu SERIAL PRIMARY KEY NOT NULL REFERENCES manutencao (id_manu),
	causa_falha TEXT
);

CREATE TABLE manutencao_preventiva
(
	id_manu SERIAL PRIMARY KEY NOT NULL REFERENCES manutencao (id_manu),
	data_agendamento TIMESTAMP without time zone NOT NULL,
	periodicidade TEXT
);


-- Script de adição de inserções:

INSERT INTO equipamento (id_equip, nome, modelo, fabricante, data_aquisicao)
VALUES (1, 'Maquina-1', 'FT200', 'Itaipava', '07-03-2002'), (2, 'Maquina-2', 'GT513', NULL, '10-05-2002');

INSERT INTO peca (id_peca, nome, modelo, fabricante, id_equip)
VALUES (1, 'Martelo', 'grande', 'Skcoll', 1), (2,'parafusadeira', NULL, 'Vonder', 2);

INSERT INTO funcionario (id_func, nome)
VALUES (1, 'Roberto'), (2, 'Paulo'), (3, 'Afonso');

INSERT INTO manutencao (id_manu, data_inicio, data_conclusao, manu_iniciada, manu_concluida, descricao, tipo_manu, id_equip, id_func)
VALUES (1, '09-12-2015 09:25:30', '09-12-2015 15:20:30', true, true, 'precisa de substituição', 'Preventiva', 1, 1), (2, '12-12-2015 11:30:18', NULL, true, false, 'troca de parafusos', 'Corretiva', 2, 2), (3, '14-12-2015 17:20:19', NULL, true, false, 'substituição da fonte de alimentação', 'Corretiva', 1, 3), (4, '09-01-2016 05:25:20', '09-01-2016 15:00:00', true, true, 'precisa de substituição', 'Preventiva', 1, 1);

INSERT INTO manutencao_corretiva (id_manu, causa_falha)
VALUES (1, 'vazamento'), (3, NULL);

INSERT INTO manutencao_preventiva (id_manu, data_agendamento, periodicidade)
VALUES (2, '09-12-2015 05:20:00', 'mensalmente'), (4, '09-01-2016 05:20:00', 'semanalmente');

-- Implementação de Views:

CREATE VIEW relatorio AS
SELECT id_manu, data_inicio, data_conclusao, tipo_manu, eq.nome, concat(pe.nome,'-',pe.modelo) AS pecaF, id_func FROM manutencao INNER JOIN equipamento eq ON eq.id_equip = manutencao.id_equip INNER JOIN peca pe ON pe.id_equip = eq.id_equip WHERE id_manu >= 01;

SELECT * FROM relatorio;


-- Implementação de Stored:

CREATE OR REPLACE PROCEDURE substituicao (
	nova_peca VARCHAR,
	id_informe INT
)
LANGUAGE plpgsql
AS $$
BEGIN
	UPDATE peca
	SET nome = nova_peca
	WHERE id_peca = id_informe;
	COMMIT;
END;$$;

--CALL substituicao ('marreta', 1);
--DROP PROCEDURE IF EXISTS substituicao;


-- Implementação de Trigger:

CREATE FUNCTION trigger_manutencao()
    RETURNS TRIGGER
    LANGUAGE plpgsql
    AS $$
	BEGIN
    	INSERT INTO manutencao (NEW.id_manu, NEW.data_inicio, NEW.data_conclusao, NEW.manu_iniciada, NEW.manu_concluida, NEW.descricao, NEW.tipo_manu, NEW.id_equip, NEW.id_func)
    	VALUES (1, NULL, NULL, 'true', 'false', 'enferrujado', 'completa', 1, 2);
    	RETURN NEW;
	END; $$;

CREATE TRIGGER after_manutencao_update
	AFTER UPDATE
	ON manutencao
	FOR EACH STATEMENT
	EXECUTE PROCEDURE trigger_manutencao();

--DROP TRIGGER IF EXISTS after_manutencao_update ON manutencao RESTRICT;

-- Outra implementação de Trigger:

CREATE FUNCTION trigger_equipamento()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
INSERT INTO equipamento(new.id_equip, new.nome, new.modelo, new.fabricante, new.data_aquisicao)
VALUES (1, 'maquina-1', 'ft200', 'itaicava', '09-01-2016');
RETURN new;
END;$$;

CREATE TRIGGER before_equipamento_update  
BEFORE UPDATE
ON equipamento
FOR EACH ROW
EXECUTE PROCEDURE trigger_equipamento();

--DROP TRIGGER IF EXISTS before_equipamento_update ON equipamento RESTRICT;

-- Updates:

--UPDATE equipamento SET nome = '', modelo = '', fabricante = '', data_aquisicao = '' WHERE id_equip = 1;
--UPDATE funcionario SET nome = '' WHERE id_func = 1;
--UPDATE peca SET nome = '', modelo = '', id_equip = '' WHERE id_peca = 1;
--UPDATE manutencao SET id_equip = 2, id_func = 1, data_inicio = '', data_conclusao = '', manu_iniciada = '', manu_concluida = '', tipo_manu = '', descricao = '' WHERE id_manu = 1;
--UPDATE manutencao_corretiva SET causa_falha = '' WHERE id_manu = 1;
--UPDATE manutencao_preventiva SET data_agendamento = '', periodicidade = '' WHERE id_manu = 1;

-- Deletes:

--DELETE FROM funcionario WHERE id_func = 1;
--DELETE FROM equipamento WHERE id_equip = 1;
--DELETE FROM peca WHERE id_peca = 1;
--DELETE FROM manutencao_corretiva WHERE id_manu = 1;
--DELETE FROM manutencao_preventiva WHERE id_manu = 1;
--DELETE FROM manutencao WHERE id_manu = 1;