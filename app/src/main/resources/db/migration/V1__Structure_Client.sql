CREATE TABLE orders (
 orderID         SERIAL,
 origin          SMALLINT,
 destination     SMALLINT,
 entryDate       DATE,
 departureDate   DATE
);

CREATE TABLE ordersProducts (
 orderID         SERIAL,
 productModelID  SERIAL
);

CREATE TABLE productModel (
 productModelID  SERIAL,
 name            VARCHAR(20),
 description     VARCHAR(250),
 weight          INT,
 x		 INT,
 y               INT,
 z               INT
);

CREATE TABLE productStack (
 productID       SERIAL,
 stock           INT,
 startDate       DATE,
 endDate         DATE,
 productModelID  INT,
 shelvesID       INT
);

CREATE TABLE shelves (
 shelvesID       SERIAL,
 capacity        INT,
 position        INT,
 warehouseID    INT
);

CREATE TABLE warehouse (
 warehouseID     SERIAL,
 nameWarehouse   VARCHAR(20),
 location        INT,
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
