CREATE TABLE orders (
 orderID         SERIAL,
 destination     INT,
 entryDate       DATE,
 subOrder        INT
);

CREATE TABLE subOrders (
 suborderID      SERIAL,
 orderID         INT,
 origin          INT,
 departureDate   DATE
);

CREATE TABLE productModel (
 productModelID  SERIAL,
 name            VARCHAR(100),
 description     VARCHAR(250),
 weight          INT,
 x		           INT,
 y               INT,
 z               INT
);

CREATE TABLE ordersProducts (
 subOrderID         INT,
 productModelID  INT
);

CREATE TABLE shelf (
 shelfID         INT,
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

CREATE TABLE productStackHistory (
 productID       SERIAL,
 stock           INT,
 productModelID  INT,
 warehouseID     INT,
 startDate       DATE
);

CREATE TABLE warehouse (
 warehouseID     SERIAL,
 name            VARCHAR(20),
 location        INT
);

CREATE SEQUENCE product_seq START 1;

ALTER TABLE orders
  ADD CONSTRAINT ORDER_PK PRIMARY KEY (orderID);

ALTER TABLE subOrders
  ADD CONSTRAINT SUB_ORDER_PK PRIMARY KEY (subOrderID),
  ADD CONSTRAINT ORDERSSUBS_ORDER_FK FOREIGN KEY (orderID) REFERENCES orders (orderID);

ALTER TABLE productModel
  ADD CONSTRAINT PRODUCTMODEL_PK PRIMARY KEY (productModelID);

ALTER TABLE ordersProducts
  ADD CONSTRAINT ORDERSPRODUCTS_ORDER_FK FOREIGN KEY (subOrderID) REFERENCES subOrders (subOrderID),
  ADD CONSTRAINT ORDERSPRODUCTS_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID),
  ADD CONSTRAINT ORDERSPRODUCTS_PK PRIMARY KEY (subOrderID, productModelID);

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

ALTER TABLE productStackHistory
  ADD CONSTRAINT PRODUCTSTACKHISTORY_PK PRIMARY KEY (productID),
  ADD CONSTRAINT PRODUCTSTACKHISTORY_PRODUCTMODEL_FK FOREIGN KEY (productModelID) REFERENCES productModel (productModelID),
  ADD CONSTRAINT PRODUCTSTACKHISTORY_WAREHOUSE_FK FOREIGN KEY (warehouseID) REFERENCES warehouse (warehouseID);

ALTER TABLE subOrders
  ADD CONSTRAINT ORDERS_WAREHOUSE_FK FOREIGN KEY (origin) REFERENCES warehouse (warehouseID);
