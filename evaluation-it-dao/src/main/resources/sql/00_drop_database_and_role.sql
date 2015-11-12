-- Project evaluation_it
-- ---------------------------------------------------------------------------
-- SQL Script to drop the APP database
-- ---------------------------------------------------------------------------
-- COMMANDS IN THIS SCRIPT SHOULD BE EXECUTED WITH SUPERUSER
-- psql -U postgres -f SQL_SCRIPT
-- ---------------------------------------------------²------------------------

-- Drop app database
DROP DATABASE IF EXISTS evaluation_it;

-- Drop default roles
DROP ROLE IF EXISTS guests;

