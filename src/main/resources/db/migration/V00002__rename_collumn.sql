-- Rename column in the tg_user table.
ALTER TABLE tg_user
    CHANGE COLUMN isActive active BOOLEAN;