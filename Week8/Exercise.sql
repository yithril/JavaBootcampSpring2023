/*
#1
List the product id, product name, unit price and category name of all
products. Order by category name and within that, by product name

product id, product name, unit price are from products
category is from categories
*/

SELECT products.productID, products.productName, products.unitPrice, categories.CategoryName 
FROM products 
JOIN categories ON products.CategoryID = categories.CategoryID
ORDER BY categories.CategoryName, products.ProductName

/*
#2
List the product id, product name, unit price and supplier name of all products that cost more than $75.  Order by product name.
*/

SELECT p.productId, p.productName, p.unitPrice, s.companyName
FROM products p
JOIN suppliers s ON p.supplierID = s.supplierID
WHERE p.unitPrice > 75
ORDER BY p.productName

/*
#3
List the product id, product name, unit price, category name, and supplier name of every product.  Order by product name.
*/
SELECT p.productID, p.productName, p.unitPrice, c.CategoryName, s.CompanyName
FROM products p
JOIN categories c ON p.CategoryID = c.CategoryID
JOIN suppliers s ON p.SupplierID = s.SupplierID
ORDER BY p.productName

/*
#5
List the order id, ship name, ship address, and shipping company name of
every order that shipped to Germany
*/
SELECT *
FROM orders o
JOIN shippers s ON s.shipperId = o.shipVia
WHERE o.shipcountry = 'Germany'




