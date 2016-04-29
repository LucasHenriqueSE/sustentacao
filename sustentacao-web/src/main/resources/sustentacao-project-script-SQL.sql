use sustentacao;

INSERT INTO TIPO_TAREFA VALUES(1, 'Chamado', '20:00', '05:00');
INSERT INTO TIPO_TAREFA VALUES(2, 'Solicitação', '16:00', '05:00');
INSERT INTO TIPO_TAREFA VALUES(3, 'Problema', '60:00', '05:00');
INSERT INTO TIPO_TAREFA VALUES(4, 'Projeto', '100:00', '05:00');

INSERT INTO STATUS VALUES(1, 'Aberto');
INSERT INTO STATUS VALUES(2, 'Em Atendimento');
INSERT INTO STATUS VALUES(3, 'Homologaçao');
INSERT INTO STATUS VALUES(4, 'Aguardando Publicação');
INSERT INTO STATUS VALUES(5, 'Fechado');

INSERT INTO PERFIL VALUES(1, 'Administrador');
INSERT INTO PERFIL VALUES(2, 'Usuario');

# USUARIOS - As senhas são 1234 #

INSERT INTO `sustentacao`.`usuario` (`ID`, `ATIVO`, `EMAIL`, `NOME`, `SENHA`, `PERFIL`) VALUES ('1', 1, 'lucas.henrique@fornax.com.br', 'Lucas Henrique de Sousa', '$2a$10$QOrMqBXkT5.peJlG.dsQOeuZwzUK//MxNArmCvP1UKglK8kFSONpO', '1');
INSERT INTO `sustentacao`.`usuario` (`ID`, `ATIVO`, `EMAIL`, `NOME`, `SENHA`, `PERFIL`) VALUES ('2', 1, 'danilo.righetto@fornax.com.br', 'Danilo Righetto', '$2a$10$QOrMqBXkT5.peJlG.dsQOeuZwzUK//MxNArmCvP1UKglK8kFSONpO', '1');
INSERT INTO `sustentacao`.`usuario` (`ID`, `ATIVO`, `EMAIL`, `NOME`, `SENHA`, `PERFIL`) VALUES ('3', 1, 'welington.ralmeida@gmail.com', 'Welington Almeida', '$2a$10$QOrMqBXkT5.peJlG.dsQOeuZwzUK//MxNArmCvP1UKglK8kFSONpO', '1');