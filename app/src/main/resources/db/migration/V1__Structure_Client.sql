CREATE TABLE orders (
 orderID         SERIAL,
 origin          SMALLINT,
 destination     SMALLINT,
 entryDate       DATE,
 departureDate   DATE
);

CREATE TABLE productModel (
 productModelID  SERIAL,
 name            VARCHAR(20),
 description     VARCHAR(250),
 weight          INT,
 x		           INT,
 y               INT,
 z               INT
);

CREATE TABLE ordersProducts (
 orderID         INT,
 productModelID  INT
);

CREATE TABLE shelf (
 shelfID         SERIAL,
 capacity        INT,
 position        INT,
 warehouseID     INT
);

CREATE TABLE productsLocation (
  orderID         INT,
  productModelID  INT,
  shelfID         INT,
  warehouseID     INT
);

CREATE TABLE productStack (
 productID       SERIAL,
 stock           INT,
 productModelID  INT,
 shelfID         INT,
 warehouseID     INT
);

CREATE TABLE warehouse (
 warehouseID     SERIAL,
 name            VARCHAR(20),
 location        INT
);

ALTER TABLE orders
  ADD CONSTRAINT ORDER_PK PRIMARY KEY (orderID);

ALTER TABLE productModel
  ADD CONSTRAINT PRODUCTMODEL_PK PRIMARY KEY (productModelID);

ALTER TABLE ordersProducts
  ADD CONSTRAINT ORDERSPRODUCTS_ORDER_FK FOREIGN KEY (orderID) REFERENCES orders (orderID),
  ADD CONSTRAINT ORDERSPRODUCTS_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID),
  ADD CONSTRAINT ORDERSPRODUCTS_PK PRIMARY KEY (orderID, productModelID);

ALTER TABLE warehouse
  ADD CONSTRAINT WAREHOUSE_PK PRIMARY KEY (warehouseID);

ALTER TABLE shelf
  ADD CONSTRAINT SHELF_WAREHOUSE_FK FOREIGN KEY (warehouseID) REFERENCES warehouse (warehouseID),
  ADD CONSTRAINT SHELF_PK PRIMARY KEY (shelfID, warehouseID);

ALTER TABLE productsLocation
  ADD CONSTRAINT PRODUCTSLOCATION_ORDER_FK FOREIGN KEY (orderID) REFERENCES orders (orderID),
  ADD CONSTRAINT PRODUCTSLOCATION_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID),
  ADD CONSTRAINT PRODUCTSLOCATION_SHELF_FK FOREIGN KEY (shelfID, warehouseID) REFERENCES shelf (shelfID, warehouseID),
  ADD CONSTRAINT PRODUCTSLOCATION_PK PRIMARY KEY (orderID, productModelID, shelfID, warehouseID);

ALTER TABLE productStack
  ADD CONSTRAINT PRODUCTSTACK_PK PRIMARY KEY (productID),
  ADD CONSTRAINT PRODUCTSTACK_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID),
  ADD CONSTRAINT PRODUCTSTACK_SHELF_FK FOREIGN KEY (shelfID, warehouseID) REFERENCES shelf (shelfID, warehouseID);
