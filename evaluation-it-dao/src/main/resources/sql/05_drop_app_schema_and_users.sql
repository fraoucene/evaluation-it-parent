-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to drop the APP schema
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------

-- Swith to APP database
\connect evaluation_it

-- Drop APP schema
DROP SCHEMA IF EXISTS evaluation_it CASCADE;

-- Drop app roles & users
-- Compte de connexion capable uniquement de realiser des selects
DROP USER IF EXISTS evaluation_it_sel;
-- Compte de connexion pour front office
DROP USER IF EXISTS evaluation_itt_frt;
-- Compte de connexion pour Datastage, et traitements Batchs
DROP USER IF EXISTS evaluation_it_tba;

DROP ROLE IF EXISTS evaluation_it_guests;
DROP ROLE IF EXISTS evaluation_it_users;

-- Drop schema owner
DROP USER IF EXISTS evaluation_it;