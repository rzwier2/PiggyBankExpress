use piggybank;

INSERT INTO user VALUES ('00001', '1000', '60000');

INSERT INTO transaction VALUES ('99999', '00001', 'Sports', 'Baseball Glove', '350.00', STR_TO_DATE('11-05-2019', '%d-%m-%Y'));
INSERT INTO transaction VALUES ('99998', '00001', 'Food', 'Fried Chicken', '22.00', STR_TO_DATE('11-01-2019', '%d-%m-%Y'));
INSERT INTO transaction VALUES ('99997', '00001', 'Gas', 'Exxon', '35.42', STR_TO_DATE('11-9-2012', '%d-%m-%Y'));
INSERT INTO transaction VALUES ('99996', '00001', 'Clothes', 'Socks', '12.99', STR_TO_DATE('12-01-2012', '%d-%m-%Y'));

