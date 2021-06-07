-- BOOK_CLASSIFICATION

INSERT INTO BOOK_CLASSIFICATION (code, name) values ('FICTION', 'Fiction');
INSERT INTO BOOK_CLASSIFICATION (code, name) values ('COMIC', 'Comic');
INSERT INTO BOOK_CLASSIFICATION (code, name) values ('PROGRAMMING', 'Programming');
INSERT INTO BOOK_CLASSIFICATION (code, name) values ('HEALTH', 'Health');

-- PROMOTION

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE5', 5, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE10', 10, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE15', 15, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE20', 20, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE25', 25, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE30', 30, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE35', 35, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE40', 40, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE45', 45, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE50', 50, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE55', 55, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE60', 60, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE65', 65, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);

INSERT INTO PROMOTION(CODE, PERCENTAGE, START_DATE, END_DATE) values ('SALE70', 70, CURRENT_TIMESTAMP - 5, CURRENT_TIMESTAMP + 30);


-- PROMOTION_CLASSIFICATIONS

INSERT INTO PROMOTION_CLASSIFICATIONS (PROMOTION_CODE, CLASSIFICATIONS_CODE) values ('SALE10', 'FICTION');
INSERT INTO PROMOTION_CLASSIFICATIONS (PROMOTION_CODE, CLASSIFICATIONS_CODE) values ('SALE30', 'PROGRAMMING');