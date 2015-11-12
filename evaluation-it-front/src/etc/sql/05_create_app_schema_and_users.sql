-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to create a APP schema
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------

-- Create APP schema owner
CREATE USER evaluation_it WITH LOGIN ENCRYPTED PASSWORD 'evaluation_it' IN ROLE guests;

-- Create app roles & users
CREATE ROLE evaluation_it_guests IN ROLE guests;
CREATE ROLE evaluation_it_users IN ROLE evaluation_it_guests;

-- Compte de connexion capable uniquement de realiser des selects
CREATE USER evaluation_it_sel WITH LOGIN ENCRYPTED PASSWORD 'evaluation_it_sel' IN ROLE evaluation_it_guests;
ALTER USER evaluation_it_sel SET search_path to 'evaluation_it';

-- Compte de connexion pour front office
CREATE USER evaluation_it_frt WITH LOGIN ENCRYPTED PASSWORD 'evaluation_it_frt' IN ROLE evaluation_it_users;
ALTER USER evaluation_it_frt SET search_path to 'evaluation_it';

-- Compte de connexion pour Datastage, et traitements Batchs
CREATE USER evaluation_it_tba WITH LOGIN ENCRYPTED PASSWORD 'evaluation_it_tba' IN ROLE evaluation_it_users;
ALTER USER evaluation_it_tba SET search_path to 'evaluation_it';

-- Swith to APP database
\connect evaluation_it

-- Create & secure APP schema
CREATE SCHEMA AUTHORIZATION evaluation_it;
REVOKE ALL PRIVILEGES ON SCHEMA PUBLIC FROM PUBLIC;
REVOKE ALL PRIVILEGES ON SCHEMA evaluation_it FROM PUBLIC;

-- Switch user to schema owner
SET SESSION AUTHORIZATION 'evaluation_it';

-- Grant schema usage
GRANT USAGE ON SCHEMA evaluation_it TO evaluation_it_guests;

-- Grant default privileges on tables & sequences
ALTER DEFAULT PRIVILEGES IN SCHEMA evaluation_it GRANT SELECT ON TABLES TO evaluation_it_guests;
ALTER DEFAULT PRIVILEGES IN SCHEMA evaluation_it GRANT SELECT ON SEQUENCES TO evaluation_it_guests;

ALTER DEFAULT PRIVILEGES IN SCHEMA evaluation_it GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO evaluation_it_users;
ALTER DEFAULT PRIVILEGES IN SCHEMA evaluation_it GRANT USAGE ON SEQUENCES TO evaluation_it_users;
