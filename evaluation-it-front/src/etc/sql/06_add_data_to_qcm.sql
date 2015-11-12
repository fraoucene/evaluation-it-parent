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
-- Famille "Aide à la Décision"
-- ---------------------------------------------------------------------------
/* (1, 'BO XI 3.0 Web Intelligence avancé', 'Il n''y a pas de description disponible pour ce test.',3 , 'fr', now(), 20),
(1, 'BO XI 3.0 Web Intelligence intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(1, 'DataStage PX débutant', 'Ce questionnaire permet d''évaluer les compétences des candidats de niveau débutant sur la technologie '
        'IBM InfoSphere DataStage Parallel Extender (DataStage PX) ou DataStage Enterprise Edition.', 1, 'fr', now(), 15),
(1, 'DataStage PX intermédiaire', 'Ce questionnaire permet d''évaluer les compétences des candidats de niveau débutant sur la technologie '
        'IBM InfoSphere DataStage Parallel Extender (DataStage PX) ou DataStage Enterprise Edition.', 2, 'fr', now(), 15),
(1, 'DataStage PX lvl3', 'Ce test permet d''évaluer les compétences des candidats de niveau expert sur la technologie IBM InfoSphere '
        'DataStage Parallel Extender (DataStage PX) ou DataStage Enterprise Edition.', 3, 'fr', now(), 15),

(1, 'Informatica Power Center 8 intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(1, 'SAS Base intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(1, 'SAS Reports débutant', 'Ce test vérifie les capacités de base de SAS et permet de tester les connaissances sur la programmation de '
        'base et gestion des rapports.', 1, 'fr', now(), 15),
(1, 'SAS débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 20),


(1, 'Talend intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),
(1, 'Talend débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 20),

-- ---------------------------------------------------------------------------
-- Famille "Analyse, Architecture, Concepetion des systémes"
-- ---------------------------------------------------------------------------
(2, 'Analyse d''affaires débutant', 'Ce test permet de vérifier les connaissances des candidats sur la compréhension des besoins de '
    'changement de l''entreprise, l''évaluation de l''impact de ces changements, et leurs capacités à saisir, analyser '
    'et documenter les exigences en tant qu''analyste d''affaires débutant.', 1, 'fr', now(), 25),
(2, 'Analyse d''affaires intermédiaire', 'Ce test vérifie les connaissances d''élicitation, de documentation, de gestion des exigences et de '
           'conception le système en tant qu''analyste d''affaires intermédiaire.', 2, 'fr', now(), 30),

-- ---------------------------------------------------------------------------
-- Famille "Applications Mobiles"
-- ---------------------------------------------------------------------------
(3, 'Android débutant', 'Ce test vous permet de vérifier des compétences pour les développeurs débutants sur le développement '
      'Android.', 1, 'fr', now(), 30),
(3, 'Android intermédiaire', 'Ce test vous permet de vérifier des compétences sur le développement Android, pour les développeurs '
     'intermédiaires ou expérimentés', 2, 'fr', now(), 30),
(3, 'IOS débutant', 'Ce test vous permet de vérifier des compétences débutants sur le développement iOS.', 1, 'fr', now(), 10),
(3, 'IOS intermédiaire', 'Ce test vous permet de vérifier des compétences de sur le développement iOS.', 2, 'fr', now(), 12),
(3, 'IOS avancé', 'Il n''y a pas de description disponible pour ce test.', 3, 'fr', now(), 15),
(3, 'Windows 8 Metro intermédiaire ', 'Ce test vous permet de vérifier des compétences de sur le développement Windows 8, il est destiné '
      'pour les développeurs qui ont déjà créé une propre application pour le Windows Store.', 2, 'fr', now(), 20),

-- ---------------------------------------------------------------------------
-- Famille "Bases De donneés"
-- ---------------------------------------------------------------------------
(4, 'Développement Oracle intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),
(4, 'Développement Oracle avancé', 'Il n''y a pas de description disponible pour ce test.', 3, 'fr', now(), 20),
(4, 'Développement SQL Server débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(4, 'Développement SQL Server intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(4, 'MySQL DBA débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(4, 'Oracle 11g generic intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(4, 'Oracle DBA débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 25),
(4, 'PL-SQL intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(4, 'SQL et PL-SQL intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),
(4, 'SQL débutant', 'Ce test vous permet de vérifier des compétences de niveau débutant du langage SQL.', 1, 'fr', now(), 25),
(4, 'SQL intermédiaire', 'Ce test vous permet de vérifier des compétences de niveau moyen du langage SQL.', 2, 'fr', now(), 15),

-- ---------------------------------------------------------------------------
-- Famille "Conception et Développement Web"
-- ---------------------------------------------------------------------------
(5, 'ActionScript 2.0 débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'ActionScript 2.0 intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),

(5, 'Angular.js intermédiaire', 'Ce test a le but de vérifier les compétences intermédiaires en programmation Angular.js '
    'des candidats.', 2, 'fr', now(), 15),

(5, 'Backbone.js intermédiaire', 'Ce test permet de vérifier les compétences de niveau intermédiaire en programmation Backbone.js et le '
    'fonctionnement interne de ce framework.', 2, 'fr', now(), 15),

(5, 'Bootstrap avancé', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'Bootstrap intermédiaire', 'Ce test Bootstrap vous permet de tester les connaissances des candidats sur les composants et l’usage de '
    'base de Bootstrap, en couvrant aussi les composants CSS et la fonctionnalité JS héritée du framework. '
    'Ce test vise également à vérifier si les candidats savent utiliser Bootstrap correctement, s’ils '
    'de Bootstrap et qu’ils peuvent être productifs en utilisant ce framework.', 2, 'fr', now(), 10),

(5, 'CSS avancé', 'Ce test est conçu pour évaluer les compétences avancées de créer des mises en page complexes, '
    'compatibles avec les navigateurs modernes', 3, 'fr', now(), 20),
(5, 'CSS intermédiaire', 'Ce test vous permet d’évaluer les connaissances intermédiaires sur le développement CSS dans la '
    'construction et l’implémentation des interfaces utilisateur de haute qualité.', 2, 'fr', now(), 15),
(5, 'CSS débutant', 'Ce test est conçu pour évaluer les compétences de base de créer des interfaces utilisateur de haute '
    'qualité, en s''assurant que chaque pixel est parfait visuellement et interactivement.', 1, 'fr', now(), 30),

(5, 'CSS3 intermédiaire', 'Ce quiz évalue les connaissances intermédiaires de CSS 3 et vous permet d’évaluer les capacités des '
    'candidats de travailler avec des animations, transitions et transformations 3D.', 2, 'fr', now(), 20),

(5, 'Développement Web Front End intérmédiaire', 'Ce test est destiné à l''évaluation des compétences de niveau moyen en HTML5, CSS et JavaScript. Il permet '
    'd''évaluer la capacité de créer des interfaces utilisateur de haute qualité et compatibles multinavigateurs, '
    'en utilisant des technologies modernes et des fonctions interactives. '
    'Connaissances mesurées: les éléments et les attributs HTML5, les propriétés et les sélecteurs CSS, la '
    'syntaxe, les événements et les opérateurs JavaScript.', 2, 'fr', now(), 30),

(5, 'ExtJS intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),

(5, 'Flex 3 AIR débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'Flex 3 AIR intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(5, 'Flex 3.x-ActionScript 3 débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),

(5, 'HTML4 débutant', 'Ce test est destiné à l''évaluation des compétences de niveau débutant du langage HTML, les capacités de '
    'créer des pages web statiques, en utilisant une mise en page prédéfinie.', 1, 'fr', now(), 15),
(5, 'HTML4 intermédiaire', 'Ce test est destiné à l''évaluation des compétences de niveau intermédiaire du langage HTML, les capacités de '
    'créer des pages web statiques, en utilisant une mise en page prédéfinie.', 2, 'fr', now(), 15),

(5, 'HTML5 quiz niveau débutant', 'Ce test est destiné à l''évaluation des compétences de niveau débutant en ce qui concerne le langage HTML5 '
    '(HyperText Markup Language 5).', 1, 'fr', now(), 15),
(5, 'HTML5 intermédiaire', 'Ce test est destiné à l''évaluation des compétences de niveau intermédiaire en ce qui concerne le langage HTML5 '
    '(HyperText Markup Language 5).', 2, 'fr', now(), 20),

(5, 'JavaScript débutant', 'Ce questionnaire permet de tester les connaissances de JavaScript de base et intermédiaires.', 1, 'fr', now(), 15),
(5, 'JavaScript intermédiaire', 'Ce quiz permet de tester les connaissances intermédiaires en programmation JavaScript.', 2, 'fr', now(), 15),

(5, 'jQuery quiz niveau débutant', 'Ce test est destiné à l''évaluation des compétences de niveau débutant en ce qui concerne la '
    'bibliothèque jQuery. Le candidat doit avoir des connaissances de base en JavaScript, HTML et CSS '
    'pour compléter le test.', 1, 'fr', now(), 20),
(5, 'jQuery intermédiaire', 'Ce test est destiné à l''évaluation des compétences de niveau moyen en ce qui concerne la '
    'bibliothèque jQuery. Une connaissance de base du langage HTML et CSS est nécessaire pour '
    'compléter le test, pour permettre à l''utilisateur de créer des pages web dynamiques.', 2, 'fr', now(), 15),

(5, 'Node.js intermédiaire', 'Ce test est destiné à évaluer les compétences intermédiaires des candidats en programmation Node.js.', 2, 'fr', now(), 15),

(5, 'Optimisation du site web débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(5, 'Optimisation du site web intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 20),

(5, 'PhoneGap intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(5, 'Sencha intermédiaire', 'Ce test permet d''évaluer les connaissances générales de Sencha Touch dans la création et le travail avec '
    'des applications mobiles non natives, en utilisant des compétences en développement HTML5, CSS3 et '
    'JavaScript.', 2, 'fr', now(), 10),
(5, 'Sencha avancé', 'Il n''y a pas de description disponible pour ce test.', 3, 'fr', now(), 15),

(5, 'XHTML débutant', 'Ce test vise à évaluer les compétences de niveau débutant des candidats en ce qui concerne le '
    'développement d’un code plus propre pour les sites web compatibles avec des « crossbrowsers ».', 1, 'fr', now(), 15),

(5, 'XSLT débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
*/

-- ----------------------------------------------------------------------------
-- Famille "Culture Générale"
-- ----------------------------------------------------------------------------
(6, 'Algorithmes intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 12),
(6, 'POO débutant', 'Ce test est destiné à évaluer les compétences de base des candidats, testées par le biais de questions '
    'théoriques ainsi que pratiques avec des exemples de code.', 1, 'fr', now(), 10),
(6, 'Test d''aptitudes logiques', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 30),

-- -----------------------------------------------------------------------------
-- Famille "Développement de Jeux"
-- -----------------------------------------------------------------------------
(7, 'Unity3D  débutant', 'Ce test évalue les compétences de base des candidats sur Unity 3D et C#. Le test couvre les principales '
    'parties d''Unity connues par un développeur dans sa première année d''expérience.', 1, 'fr', now(), 25),
(7, 'Unity3D intermédiaire', 'Ce test permet d’évaluer les connaissances intermédiaires en Unity3D avec C#. Les tests ciblent la '
    'connaissance des différences petites, mais essentielles entre les fonctions / évènements similaires.', 2, 'fr', now(), 30),

-- ----------------------------------------------------------------------------
-- Famille "Graphisme et Design"
-- ----------------------------------------------------------------------------
(8, 'Adobe Photoshop débutant', 'Il n''y a pas de description disponible pour ce test.', 1, 'fr', now(), 15),
(8, 'Adobe Photoshop intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 12),

(8, 'Illustrator intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(8, 'InDesign intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),
(8, 'Quark 6 intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),

-- ----------------------------------------------------------------------------
-- Famille "JAVA-J2EE"
-- ----------------------------------------------------------------------------
(8, 'SQL et PL-SQL intermédiaire', 'Il n''y a pas de description disponible pour ce test.', 2, 'fr', now(), 15),


--('dotNET');
