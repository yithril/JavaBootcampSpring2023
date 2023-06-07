#inner join
#What is the average freight of orders broken down by employee
SELECT AVG(o.Freight) AS AvgFreight, e.EmployeeID, e.FirstName, e.LastName
FROM orders o
JOIN employees e ON e.EmployeeID = o.EmployeeID
GROUP BY o.EmployeeID
ORDER BY AvgFreight DESC


#Get the Company Name and Contact for each Order as well as the first and last name of the employee responsible.
SELECT c.CompanyName, c.ContactName, e.FirstName, e.LastName, o.Freight, o.OrderDate, o.ShipName, o.ShipAddress
FROM orders o
JOIN customers c ON o.CustomerID = c.CustomerID
JOIN employees e ON e.EmployeeID = o.EmployeeID
