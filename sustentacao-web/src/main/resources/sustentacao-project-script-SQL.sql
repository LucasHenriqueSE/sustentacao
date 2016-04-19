SELECT * FROM sustentacao.usuario;

insert into usuario (ATIVO, EMAIL, LOGIN, NOME, SENHA, CODIGO_PERFIL) values (1, 'danilo@teste.com.br', 'danilo', 'Danilo', '1234', 1);
insert into usuario (ATIVO, EMAIL, LOGIN, NOME, SENHA, CODIGO_PERFIL) values (1, 'lucas@teste.com.br', 'lucas', 'Lucas', '1234', 1);
insert into usuario (ATIVO, EMAIL, LOGIN, NOME, SENHA, CODIGO_PERFIL) values (1, 'welington@teste.com.br', 'welington', 'Welington', '1234', 1);

use sustentacao;

INSERT INTO TIPO_TAREFA VALUES(1, 'Chamado', '20:00', '05:00');
INSERT INTO TIPO_TAREFA VALUES(2, 'Solicitação', '16:00', '05:00');
INSERT INTO TIPO_TAREFA VALUES(3, 'Problema', '60:00', '05:00');
INSERT INTO TIPO_TAREFA VALUES(4, 'Projeto', '100:00', '05:00');


INSERT INTO STATUS VALUES(1, 'Aberto');
INSERT INTO STATUS VALUES(2, 'Em Atendimento');
INSERT INTO STATUS VALUES(3, 'Homologação');
INSERT INTO STATUS VALUES(4, 'Aguardando Publicação');
INSERT INTO STATUS VALUES(5, 'Fechado');

INSERT INTO PERFIL VALUES(1, 'Administrador');
INSERT INTO PERFIL VALUES(2, 'Usuario');



<!-- USUARIOS -->

INSERT INTO `sustentacao`.`usuario` (`ID`, `ATIVO`, `EMAIL`, `LOGIN`, `NOME`, `SENHA`, `PERFIL`) VALUES ('1', 1, 'lucas.henrique@fornax.com.br', 'LucasHenrique', 'Lucas Henrique de Sousa', '$2a$10$QOrMqBXkT5.peJlG.dsQOeuZwzUK//MxNArmCvP1UKglK8kFSONpO', '1')
INSERT INTO `sustentacao`.`usuario` (`ID`, `ATIVO`, `EMAIL`, `LOGIN`, `NOME`, `SENHA`, `PERFIL`) VALUES ('2', 1, 'danilo.righetto@fornax.com.br', 'DaniloRighetto', 'Danilo Righetto', '$2a$10$QOrMqBXkT5.peJlG.dsQOeuZwzUK//MxNArmCvP1UKglK8kFSONpO', '1')
