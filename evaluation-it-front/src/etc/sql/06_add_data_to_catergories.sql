-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to add Categories.
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------

\c evaluation_it
INSERT INTO evaluation_it.CATEGORIES(title) VALUES ('Aide à la Décision'),
('Analyse, Architecture, Concepetion des systémes'),
('Applications Mobiles'),
('Bases De donneés'),
('Conception et Développement Web'),
('Culture Générale'),
('Développement de Jeux'),
('Graphisme et Design'),
('JAVA/J2EE'),
('Language Compilés'),
('Language dynamique'),
('Langues etrangéres'),
('Outils Bureautique'),
('PHP'),
('SAP'),
('Securité IT'),
('Systéme d''exploitation'),
('Télecommunication et systéme Embarqués'),
('Test Automation'),
('WinDev'),
('dotNET');