/*
What is the product name(s) of the most expensive products?  HINT:  Find the max price in a subquery and then use that value to 
find products whose price equals that value. 

The first step is figure out what is the max price of my products
Take that price, and figure out what products have that price
*/

#main query
SELECT *
FROM products
#this is the subquery
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM products)

#this evaluates to, or eventually becomes this query
SELECT *
FROM products
#this is the subquery
WHERE UnitPrice = 263.5000

/*
What is the order id, shipping name and shipping address of all orders shipped via "Federal Shipping"?  
HINT:  Find the shipper id of "Federal Shipping" in a subquery and then use that value to find the orders that used that shipper.
*/

SELECT OrderID, ShipName, ShipAddress
FROM orders
#subquery to find the id of shipping company with the name of Federal Shipping
WHERE ShipVia = (SELECT ShipperID FROM shippers WHERE CompanyName = 'Federal Shipping')

#this gives the same result
SELECT OrderID, ShipName, ShipAddress
FROM orders
JOIN shippers ON orders.ShipVia = shippers.ShipperID
WHERE shippers.CompanyName = 'Federal Shipping'



