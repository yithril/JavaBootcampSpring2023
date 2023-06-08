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

/*
What are the order ids of the orders that ordered "Sasquatch Ale"? HINT:
Find the product id of "Sasquatch Ale" in a subquery and then use that
value to find the matching orders from the `order details` table. Because
the `order details` table has a space in its name, you will need to surround
it with back ticks in the FROM clause.
*/
SELECT orderId
FROM `order details`
WHERE productId = (SELECT productId FROM products WHERE productName = 'Sasquatch Ale')

/*
What is the name of the employee that sold order 10266?
*/
SELECT firstName, lastName
FROM employees
WHERE employeeID = (SELECT employeeID FROM orders WHERE orderId = 10266)

/*
What is the name of the customer that bought order 10266?
*/
SELECT contactName
FROM customers
WHERE customerID = (SELECT customerID FROM orders WHERE orderId = 10266)

#IN keyword
SELECT OrderID, ShipName, ShipAddress, ShipVia
FROM orders
WHERE ShipVia IN (SELECT ShipperID FROM shippers WHERE CompanyName = 'Federal Shipping' OR CompanyName = 'United Package')

SELECT * 
FROM products
WHERE ProductName IN ('Chai', 'Chang', 'Chocolade')
