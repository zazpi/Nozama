CREATE TABLE orders (
 orderID         INT,
 origin          VARCHAR(30),
 destination     VARCHAR(30),
 entryDate       DATE,
 departureDate   DATE           
);

CREATE TABLE ordersProducts (
 orderID         INT,
 productModelID  INT
);

CREATE TABLE productModel (
 productModelID  INT,
 nameModel       VARCHAR(20),
 description     VARCHAR(250),
 x		 DECIMAL(5,2),
 y               DECIMAL(5,2), 
 z               DECIMAL(5,2)
);

CREATE TABLE productStack (
 productID       INT,
 stock           INT,
 startDate       DATE,
 endDate         DATE,
 productModelID  INT,
 shelvesID       INT
);

CREATE TABLE shelves (
 shelvesID       INT,
 capacity        INT,
 position        INT,
 warehouseID    INT
);

CREATE TABLE warehouse (
 warehouseID     INT,
 nameWarehouse   VARCHAR(20),
 location        VARCHAR(30),
 warehouseSize   INT
);

ALTER TABLE orders
ADD CONSTRAINT ORDER_PK PRIMARY KEY (orderID);

ALTER TABLE warehouse
ADD CONSTRAINT WAREHOUSE_PK PRIMARY KEY (warehouseID);

ALTER TABLE productModel
ADD CONSTRAINT PRODUCTMODEL_PK PRIMARY KEY (productModelID);

ALTER TABLE shelves
ADD CONSTRAINT SHELVES_PK PRIMARY KEY (shelvesID),
ADD CONSTRAINT SHELVES_WAREHOUSE_FK FOREIGN KEY (warehouseID) REFERENCES warehouse (warehouseID);

ALTER TABLE ordersProducts
ADD CONSTRAINT ORDERSPRODUCTS_ORDER_FK FOREIGN KEY (orderID) REFERENCES orders (orderID),
ADD CONSTRAINT ORDERSPRODUCTS_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID);

ALTER TABLE productStack
ADD CONSTRAINT PRODUCTSTACK_PK PRIMARY KEY (productID, startDate, endDate),
ADD CONSTRAINT PRODUCTSTACK_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID),
ADD CONSTRAINT PRODUCTSTACK_SHELVES_FK FOREIGN KEY (shelvesID) REFERENCES shelves (shelvesID);

