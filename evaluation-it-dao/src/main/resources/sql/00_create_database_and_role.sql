-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to create a APP database.
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------------------------------

-- Create & secure app database
CREATE DATABASE evaluation_it WITH OWNER DEFAULT ENCODING 'UTF8';
REVOKE ALL PRIVILEGES ON DATABASE evaluation_it FROM PUBLIC;

-- Create default roles
CREATE ROLE guests;
GRANT CONNECT, TEMPORARY ON DATABASE evaluation_it TO guests;
