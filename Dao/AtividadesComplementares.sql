--"jdbc:postgresql://localhost:5432/AtividadesComplementares","postgres", "admin"
-- TABELAS
CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE modalidade (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE documentacao_comprobatoria (
    id SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL
);

CREATE TABLE horas_por_atividade (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

CREATE TABLE atividade_complementar (
    id SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL,
    documentacao_id INT NOT NULL,
    horas_por_atividade_id INT NOT NULL,
    limite_maximo INT NOT NULL,
    modalidade_id INT NOT NULL,
    FOREIGN KEY (documentacao_id) REFERENCES documentacao_comprobatoria(id),
    FOREIGN KEY (horas_por_atividade_id) REFERENCES horas_por_atividade(id),
    FOREIGN KEY (modalidade_id) REFERENCES modalidade(id)
);

CREATE TABLE requerimento (
    id SERIAL PRIMARY KEY,
    aluno_id INT NOT NULL,
    data_requerimento DATE DEFAULT CURRENT_DATE NOT NULL,
    status VARCHAR(30) DEFAULT 'em avaliação' NOT NULL,
    data_validacao DATE,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

CREATE TABLE parecer (
    id SERIAL PRIMARY KEY,
    requerimento_id INT NOT NULL,
    texto TEXT NOT NULL,
    data_parecer DATE DEFAULT CURRENT_DATE NOT NULL,
    FOREIGN KEY (requerimento_id) REFERENCES requerimento(id)
);

CREATE TABLE atividade_realizada (
    id SERIAL PRIMARY KEY,
    requerimento_id INT NOT NULL,
    atividade_id INT NOT NULL,
    horas_apresentadas INT NOT NULL,
    documento TEXT NOT NULL,
    FOREIGN KEY (requerimento_id) REFERENCES requerimento(id),
    FOREIGN KEY (atividade_id) REFERENCES atividade_complementar(id)
);

CREATE TABLE validacao_atividade (
    id SERIAL PRIMARY KEY,
    atividade_realizada_id INT NOT NULL,
    horas_validadas INT NOT NULL,
    parecer_id INT NOT NULL,
    FOREIGN KEY (atividade_realizada_id) REFERENCES atividade_realizada(id),
    FOREIGN KEY (parecer_id) REFERENCES parecer(id)
);

-- MODALIDADES
INSERT INTO modalidade (nome) VALUES
('Ensino'),
('Extensão'),
('Pesquisa e Inovação'),
('Complementação');

-- DOCUMENTAÇÃO COMPROBATÓRIA
INSERT INTO documentacao_comprobatoria (descricao) VALUES
('Certificado ou declaração de conclusão'),
('Certificado ou declaração de participação'),
('Declaração de participação'),
('Documento assinado pelo presidente da banca ou coordenador de curso'),
('Declaração da instituição promotora'),
('Declaração de apresentação'),
('Texto'),
('Declaração do empregador'),
('Declaração do empregador ou Carteira Profissional'),
('Cópia do artigo ou aceite'),
('Cópia da ficha catalográfica'),
('Cópia da ficha catalográfica e capa do capítulo'),
('Certificado ou declaração de participação'),
('Declaração de premiação'),
('Registro da propriedade intelectual'),
('Declaração do líder do grupo'),
('Certificado ou declaração de participação'),
('Declaração de instituição promotora'),
('Cópia da declaração'),
('Declaração da instituição'),
('Declaração do Coordenador do Curso'),
('Declaração do dirigente da empresa'),
('Certificado, declaração e/ou endereço eletrônico do resultado classificatório'),
('Declaração assinada pelo responsável');

-- HORAS POR ATIVIDADE
INSERT INTO horas_por_atividade (descricao) VALUES
('Conforme documento comprobatório'),
('4 horas por atividade'),
('1 hora por atividade'),
('2 horas por atividade'),
('3 horas por atividade'),
('4 horas por atividade'),
('50 horas por mês'),
('25 horas por mês'),
('10 horas por item'),
('50 por item'),
('5 horas por atividade'),
('15 horas por atividade'),
('100 horas por atividade'),
('4 horas por mês de participação'),
('10 horas por semestre'),
('10 horas por item');

-- ATIVIDADES COMPLEMENTARES
INSERT INTO atividade_complementar (descricao, documentacao_id, horas_por_atividade_id, limite_maximo, modalidade_id) VALUES
-- Ensino
('Disciplinas cursadas com aproveitamento, não previstas no currículo do curso.', 1, 1, 80, 1),
('Semana acadêmica dos cursos, quando não obrigatória.', 2, 1, 40, 1),
('Participação em atividades de monitoria.', 3, 1, 70, 1),
('Atividades realizadas em laboratórios e/ou oficinas do Instituto.', 3, 2, 40, 1),
('Visita Técnica relacionada à área.', 3, 2, 40, 1),
('Participação em cursos de qualificação na área afim do curso com certificado de aproveitamento.', 2, 1, 80, 1),
('Participação como ouvintes em bancas de projetos integradores de assuntos relacionados à área.', 4, 3, 20, 1),
('Participação como ouvintes em bancas de TCC, dissertações ou teses de assuntos relacionados à área.', 4, 4, 20, 1),
('Desenvolvimento de material didático ou instrucional.', 5, 5, 30, 1),
('Instrutor de cursos abertos à comunidade.', 5, 1, 70, 1),
-- Extensão
('Participação em programa ou projeto de extensão.', 3, 1, 60, 2),
('Apresentação de projeto de extensão.', 6, 6, 20, 2),
('Participação em ações sociais cívicas e comunitárias.', 3, 6, 40, 2),
('Texto em jornal ou revista da área.', 7, 6, 40, 2),
('Intercâmbio com instituições de ensino no Brasil ou no exterior.', 3, 7, 100, 2),
('Estágio não-obrigatório na área do curso, formalizado pelo IFSC.', 8, 8, 100, 2),
('Exercício profissional com vínculo empregatício, desde que na área do curso.', 9, 7, 100, 2),
-- Pesquisa e Inovação
('Participação em programa ou projeto de pesquisa relacionados à área.', 3, 1, 60, 3),
('Apresentação de projeto de pesquisa relacionado à área.', 6, 6, 20, 3),
('Autoria e coautoria em artigo publicado em Periódico na área afim.', 10, 9, 30, 3),
('Livro na área afim.', 11, 10, 100, 3),
('Capítulo de livro na área afim.', 12, 9, 30, 3),
('Publicação em Anais de Evento Técnico Científico.', 10, 11, 30, 3),
('Apresentação de trabalho em Evento Técnico Científico.', 13, 6, 20, 3),
('Participação de Programa de Iniciação Científica.', 3, 1, 60, 3),
('Participação como palestrante, conferencista, integrante de mesa-redonda, ministrante de mini-curso em evento científico.', 13, 12, 60, 3),
('Prêmios concedidos por instituições acadêmicas, científicas e profissionais.', 14, 12, 60, 3),
('Participação na criação de produto, processo ou propriedade intelectual.', 15, 13, 200, 3),
('Participação em grupo de pesquisa certificado.', 16, 14, 60, 3),
-- Complementação
('Participação em congressos, jornadas, simpósios, fóruns, seminários, encontros, palestras, festivais e similares, com certificado de aproveitamento e/ou frequência.', 17, 6, 20, 4),
('Comissão organizadora de congressos, jornadas, simpósios, fóruns, seminários, encontros, palestras, festivais e similares.', 18, 9, 20, 4),
('Premiação em eventos que tenham relação com os objetos de estudo do curso.', 3, 9, 30, 4),
('Curso de língua estrangeira.', 17, 1, 80, 4),
('Premiação em atividades esportivas como representante do Instituto.', 19, 12, 60, 4),
('Representação estudantil em colegiado, grêmio estudantil, centro acadêmico, comissão de formatura, associação esportiva e afins.', 20, 14, 40, 4),
('Representação de turma (inclui a participação em conselhos de classe).', 21, 15, 30, 4),
('Participação em Empresa Júnior.', 22, 14, 40, 4),
('Classificação em concursos culturais.', 23, 16, 20, 4),
('Participação em projetos sociais, trabalho voluntário em entidades vinculadas a compromissos sociopolíticos.', 24, 1, 20, 4),
('Desenvolvimento de atividades socioculturais, artísticas e esportivas (coral, música, dança, bandas, vídeos, cineclubes, teatro, entre outros eventos sociais).', 24, 1, 20, 4);
--
INSERT INTO aluno (nome) VALUES
('Ana Beatriz Fernandes'),
('Carlos Eduardo Silva'),
('Mariana Souza Lima'),
('Lucas Gabriel Almeida'),
('Fernanda Oliveira Santos');

INSERT INTO requerimento (aluno_id, data_requerimento, status) VALUES
(1, '2025-04-20', 'em avaliação'),
(2, '2025-04-18', 'deferido'),
(3, '2025-04-15', 'indeferido'),
(4, '2025-04-22', 'em avaliação'),
(5, '2025-04-21', 'em avaliação');

INSERT INTO atividade_realizada (requerimento_id, atividade_id, horas_apresentadas, documento) VALUES
(1, 2, 10, 'uploads/documento_ana_atividade2.pdf'),
(1, 5, 8, 'uploads/documento_ana_atividade5.pdf'),
(2, 7, 6, 'uploads/documento_carlos_atividade7.pdf'),
(2, 9, 4, 'uploads/documento_carlos_atividade9.pdf'),
(3, 13, 12, 'uploads/documento_mariana_atividade13.pdf'),
(4, 18, 20, 'uploads/documento_lucas_atividade18.pdf'),
(5, 28, 15, 'uploads/documento_fernanda_atividade28.pdf');
--
INSERT INTO parecer (requerimento_id, texto, data_parecer) VALUES
(2, 'Atividades validadas conforme regulamento, documentação consistente.', '2025-04-19'),
(3, 'Requerimento indeferido por ausência de assinatura no comprovante.', '2025-04-17');

INSERT INTO validacao_atividade (atividade_realizada_id, horas_validadas, parecer_id) VALUES
(3, 6, 1), -- Atividade de Carlos validada
(4, 4, 1), -- Outra atividade de Carlos validada
(5, 8, 2); -- Atividade de Mariana validada parcialmente (por exemplo)

