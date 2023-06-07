/*
SUM, AVG, MIN, MAX, COUNT are all AGGREGATE functions
*/

#Notice the difference in the next two questions
#How many countries do we ship to?
SELECT COUNT(DISTINCT(ShipCountry))
FROM orders

#What countries do we ship to?
SELECT DISTINCT(ShipCountry)
From orders

#How many orders are there in the orders table?
SELECT COUNT(*)
FROM orders

#What is the average Freight per country that is not Canada, with an average freight is above 55
SELECT AVG(Freight) AS Freight, ShipCountry
FROM orders
WHERE ShipCountry <> 'Canada'
GROUP BY ShipCountry
HAVING AVG(Freight) > 55

