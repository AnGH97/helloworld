SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'cart';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'category1';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'category2';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'category2_has_product';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'document';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'img';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'product';

SELECT CONCAT('private ', if(DATA_TYPE = 'int', 'int ', 'String '), LOWER(COLUMN_NAME), ';', if(COLUMN_COMMENT='', '', concat(' \t // ', COLUMN_COMMENT))) AS `value`
FROM information_schema.columns
WHERE table_schema = 'shoppingmall' AND table_name = 'user';

