CREATE TABLE tb_utilisateurs (
  id_utilisateur BIGSERIAL PRIMARY KEY NOT NULL,
  email_utilisateur VARCHAR(70) NOT NULL,
  mot_passe_utilisateur VARCHAR(50) NOT NULL
);

INSERT INTO tb_utilisateurs (email_utilisateur, mot_passe_utilisateur) VALUES ('desmoulin.federico@gmail.com', 'MotPasse');
INSERT INTO tb_utilisateurs (email_utilisateur, mot_passe_utilisateur) VALUES ('desmoulin.mathieu@gmail.com', 'MotPasse');
