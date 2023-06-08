SELECT orders.orderDate, orders.ShippedDate, orders.Freight, employees.FirstName, employees.LastName, customers.CompanyName
FROM northwind.orders
JOIN employees ON employees.EmployeeID = orders.EmployeeID
JOIN customers ON orders.CustomerID = customers.CustomerID