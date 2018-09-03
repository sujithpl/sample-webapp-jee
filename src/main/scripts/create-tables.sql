// Order Table
CREATE TABLE ORDERS(
ORDER_ID BIGINT PRIMARY KEY,
CUSTOMER_ID VARCHAR(15) NOT NULL
)

// Order Item Table
CREATE TABLE ORDER_ITEMS(
ITEM_ID INT PRIMARY KEY,
PRODUCT_ID VARCHAR(10) NOT NULL,
QUANTITY INT NOT NULL,
PRODUCT_NAME VARCHAR(50) NOT NULL,
PRODUCT_PRICE DECIMAL(10, 2) NOT NULL,
ORDER_NUMBER BIGINT NOT NULL
)

// Define relationship
ALTER TABLE ORDER_ITEMS
    ADD FOREIGN KEY (ORDER_NUMBER) 
    REFERENCES ORDERS(ORDER_NUMBER)