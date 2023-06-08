INSERT INTO products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
VALUES('Chocolate Milk', null, 1, '12 boxes per carton', 26.50, 100, 60, 15, 0)

DELETE 
FROM products
WHERE ProductID = 81

#update product #80 to banana milk
UPDATE products
SET ProductName = 'Banana Milk'
WHERE ProductID = 80

SELECT * FROM products wHERE supplierID = 4

#update products that have a supplier ID of 4
UPDATE products
SET UnitsInStock = 200
WHERE SupplierID = 4

#warehouse has items, product ids, units in stock, address, country
#typical naming convention for a primary key is TABLE_NAME + ID
CREATE TABLE warehouse(
	WarehouseID int NOT NULL AUTO_INCREMENT,
	Address varchar(40) NOT NULL,
    Country varchar(20) NOT NULL,
    PRIMARY KEY(WarehouseID)
)

ALTER TABLE warehouse
ADD EfficiencyRating int

DROP TABLE warehouse

ALTER TABLE warehouse
DROP EfficiencyRating
