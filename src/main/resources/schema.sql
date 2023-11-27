CREATE TABLE SCHEDULED_DUE_PAYMENT (
                                       ID BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       DUE_DAY_NOMINAL INT,
                                       END_DATE DATE,
                                       STATUS VARCHAR(255)
);
