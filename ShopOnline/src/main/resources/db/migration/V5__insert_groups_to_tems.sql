SET foreign_key_checks = 0;
UPDATE items SET store_group_id = 1 WHERE id = 1;
UPDATE items SET store_group_id = 1 WHERE id = 4;
UPDATE items SET store_group_id = 2 WHERE id = 2;
UPDATE items SET store_group_id = 2 WHERE id = 3;
SET foreign_key_checks = 1;