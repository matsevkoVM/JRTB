-- Rename column in the tg_user table.
ALTER TABLE tg_user
    CHANGE COLUMN chatId chat_id VARCHAR(100);