-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to drop tables and sequences
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------

-- Swith to APP database
\connect evaluation_it

DROP TABLE IF EXISTS evaluation_it.CATEGORIES CASCADE;
DROP TABLE IF EXISTS evaluation_it.QCM CASCADE;
DROP TABLE IF EXISTS evaluation_it.QUESTIONS CASCADE;
DROP TABLE IF EXISTS evaluation_it.CHOICES CASCADE;

DROP SEQUENCE IF EXISTS evaluation_it.seq_categories CASCADE;
DROP SEQUENCE IF EXISTS evaluation_it.seq_qcm CASCADE;
DROP SEQUENCE IF EXISTS evaluation_it.seq_questions CASCADE;
DROP SEQUENCE IF EXISTS evaluation_it.seq_choices CASCADE;
