-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to add Categories.
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------




-- ---------------------------------------------------------------------------
-- Connection to the Database
-- ---------------------------------------------------------------------------
\c evaluation_it


INSERT INTO evaluation_it.QCM(categories_id, title, description, level, language, creation_date, duration) VALUES

-- ---------------------------------------------------------------------------
-- Famille "Aide � la D�cision"
-- ---------------------------------------------------------------------------
/* (1, 'BO XI 3.0 Web Intelligence avanc�', 'Il n''y a pas de description disponible pour ce test.',3 , 'fr', now(), 20),
(1, 'BO XI 3.0 Web Intelligence interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(1, 'DataStage PX d�butant', 'Ce questionnaire permet d''�valuer les comp�tences des candidats de niveau d�butant sur la technologie '
        'IBM InfoSphere DataStage Parallel Extender (DataStage PX) ou DataStage Enterprise Edition.', 1, 'fr', now(), 15),
(1, 'DataStage PX interm�diaire', 'Ce questionnaire permet d''�valuer les comp�tences des candidats de niveau d�butant sur la technologie '
        'IBM InfoSphere DataStage Parallel Extender (DataStage PX) ou DataStage Enterprise Edition.', 2, 'fr', now(), 15),
(1, 'DataStage PX lvl3', 'Ce test permet d''�valuer les comp�tences des candidats de niveau expert sur la technologie IBM InfoSphere '
        'DataStage Parallel Extender (DataStage PX) ou DataStage Enterprise Edition.', 3, 'fr', now(), 15),

(1, 'Informatica Power Center 8 interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(1, 'SAS Base interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(1, 'SAS Reports d�butant', 'Ce test v�rifie les capacit�s de base de SAS et permet de tester les connaissances sur la programmation de '
        'base et gestion des rapports.', 1, 'fr', now(), 15),
(1, 'SAS d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 20),


(1, 'Talend interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),
(1, 'Talend d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 20),

-- ---------------------------------------------------------------------------
-- Famille "Analyse, Architecture, Concepetion des syst�mes"
-- ---------------------------------------------------------------------------
(2, 'Analyse d''affaires d�butant', 'Ce test permet de v�rifier les connaissances des candidats sur la compr�hension des besoins de '
    'changement de l''entreprise, l''�valuation de l''impact de ces changements, et leurs capacit�s � saisir, analyser '
    'et documenter les exigences en tant qu''analyste d''affaires d�butant.', 1, 'fr', now(), 25),
(2, 'Analyse d''affaires interm�diaire', 'Ce test v�rifie les connaissances d''�licitation, de documentation, de gestion des exigences et de '
           'conception le syst�me en tant qu''analyste d''affaires interm�diaire.', 2, 'fr', now(), 30),

-- ---------------------------------------------------------------------------
-- Famille "Applications Mobiles"
-- ---------------------------------------------------------------------------
(3, 'Android d�butant', 'Ce test vous permet de v�rifier des comp�tences pour les d�veloppeurs d�butants sur le d�veloppement '
      'Android.', 1, 'fr', now(), 30),
(3, 'Android interm�diaire', 'Ce test vous permet de v�rifier des comp�tences sur le d�veloppement Android, pour les d�veloppeurs '
     'interm�diaires ou exp�riment�s', 2, 'fr', now(), 30),
(3, 'IOS d�butant', 'Ce test vous permet de v�rifier des comp�tences d�butants sur le d�veloppement iOS.', 1, 'fr', now(), 10),
(3, 'IOS interm�diaire', 'Ce test vous permet de v�rifier des comp�tences de sur le d�veloppement iOS.', 2, 'fr', now(), 12),
(3, 'IOS avanc�', 'Il n''y a pas de description disponible pour ce test.', 3, 'fr', now(), 15),
(3, 'Windows 8 Metro interm�diaire ', 'Ce test vous permet de v�rifier des comp�tences de sur le d�veloppement Windows 8, il est destin� '
      'pour les d�veloppeurs qui ont d�j� cr�� une propre application pour le Windows Store.', 2, 'fr', now(), 20),

-- ---------------------------------------------------------------------------
-- Famille "Bases De donne�s"
-- ---------------------------------------------------------------------------
(4, 'D�veloppement Oracle interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),
(4, 'D�veloppement Oracle avanc�', 'Il n''y a pas de description disponible pour ce test.', 3, 'fr', now(), 20),
(4, 'D�veloppement SQL Server d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(4, 'D�veloppement SQL Server interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(4, 'MySQL DBA d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(4, 'Oracle 11g generic interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(4, 'Oracle DBA d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 25),
(4, 'PL-SQL interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(4, 'SQL et PL-SQL interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),
(4, 'SQL d�butant', 'Ce test vous permet de v�rifier des comp�tences de niveau d�butant du langage SQL.', 1, 'fr', now(), 25),
(4, 'SQL interm�diaire', 'Ce test vous permet de v�rifier des comp�tences de niveau moyen du langage SQL.', 2, 'fr', now(), 15),

-- ---------------------------------------------------------------------------
-- Famille "Conception et D�veloppement Web"
-- ---------------------------------------------------------------------------
(5, 'ActionScript 2.0 d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'ActionScript 2.0 interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),

(5, 'Angular.js interm�diaire', 'Ce test a le but de v�rifier les comp�tences interm�diaires en programmation Angular.js '
    'des candidats.', 2, 'fr', now(), 15),

(5, 'Backbone.js interm�diaire', 'Ce test permet de v�rifier les comp�tences de niveau interm�diaire en programmation Backbone.js et le '
    'fonctionnement interne de ce framework.', 2, 'fr', now(), 15),

(5, 'Bootstrap avanc�', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'Bootstrap interm�diaire', 'Ce test Bootstrap vous permet de tester les connaissances des candidats sur les composants et l�usage de '
    'base de Bootstrap, en couvrant aussi les composants CSS et la fonctionnalit� JS h�rit�e du framework. '
    'Ce test vise �galement � v�rifier si les candidats savent utiliser Bootstrap correctement, s�ils '
    'de Bootstrap et qu�ils peuvent �tre productifs en utilisant ce framework.', 2, 'fr', now(), 10),

(5, 'CSS avanc�', 'Ce test est con�u pour �valuer les comp�tences avanc�es de cr�er des mises en page complexes, '
    'compatibles avec les navigateurs modernes', 3, 'fr', now(), 20),
(5, 'CSS interm�diaire', 'Ce test vous permet d��valuer les connaissances interm�diaires sur le d�veloppement CSS dans la '
    'construction et l�impl�mentation des interfaces utilisateur de haute qualit�.', 2, 'fr', now(), 15),
(5, 'CSS d�butant', 'Ce test est con�u pour �valuer les comp�tences de base de cr�er des interfaces utilisateur de haute '
    'qualit�, en s''assurant que chaque pixel est parfait visuellement et interactivement.', 1, 'fr', now(), 30),

(5, 'CSS3 interm�diaire', 'Ce quiz �value les connaissances interm�diaires de CSS 3 et vous permet d��valuer les capacit�s des '
    'candidats de travailler avec des animations, transitions et transformations 3D.', 2, 'fr', now(), 20),

(5, 'D�veloppement Web Front End int�rm�diaire', 'Ce test est destin� � l''�valuation des comp�tences de niveau moyen en HTML5, CSS et JavaScript. Il permet '
    'd''�valuer la capacit� de cr�er des interfaces utilisateur de haute qualit� et compatibles multinavigateurs, '
    'en utilisant des technologies modernes et des fonctions interactives. '
    'Connaissances mesur�es: les �l�ments et les attributs HTML5, les propri�t�s et les s�lecteurs CSS, la '
    'syntaxe, les �v�nements et les op�rateurs JavaScript.', 2, 'fr', now(), 30),

(5, 'ExtJS interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),

(5, 'Flex 3 AIR d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'Flex 3 AIR interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(5, 'Flex 3.x-ActionScript 3 d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),

(5, 'HTML4 d�butant', 'Ce test est destin� � l''�valuation des comp�tences de niveau d�butant du langage HTML, les capacit�s de '
    'cr�er des pages web statiques, en utilisant une mise en page pr�d�finie.', 1, 'fr', now(), 15),
(5, 'HTML4 interm�diaire', 'Ce test est destin� � l''�valuation des comp�tences de niveau interm�diaire du langage HTML, les capacit�s de '
    'cr�er des pages web statiques, en utilisant une mise en page pr�d�finie.', 2, 'fr', now(), 15),

(5, 'HTML5 quiz niveau d�butant', 'Ce test est destin� � l''�valuation des comp�tences de niveau d�butant en ce qui concerne le langage HTML5 '
    '(HyperText Markup Language 5).', 1, 'fr', now(), 15),
(5, 'HTML5 interm�diaire', 'Ce test est destin� � l''�valuation des comp�tences de niveau interm�diaire en ce qui concerne le langage HTML5 '
    '(HyperText Markup Language 5).', 2, 'fr', now(), 20),

(5, 'JavaScript d�butant', 'Ce questionnaire permet de tester les connaissances de JavaScript de base et interm�diaires.', 1, 'fr', now(), 15),
(5, 'JavaScript interm�diaire', 'Ce quiz permet de tester les connaissances interm�diaires en programmation JavaScript.', 2, 'fr', now(), 15),

(5, 'jQuery quiz niveau d�butant', 'Ce test est destin� � l''�valuation des comp�tences de niveau d�butant en ce qui concerne la '
    'biblioth�que jQuery. Le candidat doit avoir des connaissances de base en JavaScript, HTML et CSS '
    'pour compl�ter le test.', 1, 'fr', now(), 20),
(5, 'jQuery interm�diaire', 'Ce test est destin� � l''�valuation des comp�tences de niveau moyen en ce qui concerne la '
    'biblioth�que jQuery. Une connaissance de base du langage HTML et CSS est n�cessaire pour '
    'compl�ter le test, pour permettre � l''utilisateur de cr�er des pages web dynamiques.', 2, 'fr', now(), 15),

(5, 'Node.js interm�diaire', 'Ce test est destin� � �valuer les comp�tences interm�diaires des candidats en programmation Node.js.', 2, 'fr', now(), 15),

(5, 'Optimisation du site web d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'Optimisation du site web interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(5, 'PhoneGap interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(5, 'Sencha interm�diaire', 'Ce test permet d''�valuer les connaissances g�n�rales de Sencha Touch dans la cr�ation et le travail avec '
    'des applications mobiles non natives, en utilisant des comp�tences en d�veloppement HTML5, CSS3 et '
    'JavaScript.', 2, 'fr', now(), 10),
(5, 'Sencha avanc�', 'Il n''y a pas de description disponible pour ce test.', 3, 'fr', now(), 15),

(5, 'XHTML d�butant', 'Ce test vise � �valuer les comp�tences de niveau d�butant des candidats en ce qui concerne le '
    'd�veloppement d�un code plus propre pour les sites web compatibles avec des � crossbrowsers �.', 1, 'fr', now(), 15),

(5, 'XSLT d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
*/

-- ----------------------------------------------------------------------------
-- Famille "Culture G�n�rale"
-- ----------------------------------------------------------------------------
(6, 'Algorithmes interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 12),
(6, 'POO d�butant', 'Ce test est destin� � �valuer les comp�tences de base des candidats, test�es par le biais de questions '
    'th�oriques ainsi que pratiques avec des exemples de code.', 1, 'fr', now(), 10),
(6, 'Test d''aptitudes logiques', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 30),

-- -----------------------------------------------------------------------------
-- Famille "D�veloppement de Jeux"
-- -----------------------------------------------------------------------------
(7, 'Unity3D  d�butant', 'Ce test �value les comp�tences de base des candidats sur Unity 3D et C#. Le test couvre les principales '
    'parties d''Unity connues par un d�veloppeur dans sa premi�re ann�e d''exp�rience.', 1, 'fr', now(), 25),
(7, 'Unity3D interm�diaire', 'Ce test permet d��valuer les connaissances interm�diaires en Unity3D avec C#. Les tests ciblent la '
    'connaissance des diff�rences petites, mais essentielles entre les fonctions / �v�nements similaires.', 2, 'fr', now(), 30),

-- ----------------------------------------------------------------------------
-- Famille "Graphisme et Design"
-- ----------------------------------------------------------------------------
(8, 'Adobe Photoshop d�butant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(8, 'Adobe Photoshop interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 12),

(8, 'Illustrator interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(8, 'InDesign interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(8, 'Quark 6 interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),

-- ----------------------------------------------------------------------------
-- Famille "JAVA-J2EE"
-- ----------------------------------------------------------------------------
(8, 'SQL et PL-SQL interm�diaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),


--('dotNET');
