-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to add Categories.
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------

\c evaluation_it
INSERT INTO evaluation_it.CATEGORIES(title) VALUES ('Aide � la D�cision'),
('Analyse, Architecture, Concepetion des syst�mes'),
('Applications Mobiles'),
('Bases De donne�s'),
('Conception et D�veloppement Web'),
('Culture G�n�rale'),
('D�veloppement de Jeux'),
('Graphisme et Design'),
('JAVA/J2EE'),
('Language Compil�s'),
('Language dynamique'),
('Langues etrang�res'),
('Outils Bureautique'),
('PHP'),
('SAP'),
('Securit� IT'),
('Syst�me d''exploitation'),
('T�lecommunication et syst�me Embarqu�s'),
('Test Automation'),
('WinDev'),
('dotNET');