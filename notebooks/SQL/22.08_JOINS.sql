--Calculate total Sales by City
SELECT Owners.City, SUM(Procedures.Price) AS TotalSales
FROM Sales
LEFT JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode
LEFT JOIN Pets ON Sales.PetID = Pets.PetID
LEFT JOIN Owners ON Owners.OwnerID = Pets.OwnerID
GROUP BY Owners.City
ORDER BY TotalSales DESC;

--Calculate total Sales by Pet Kind
SELECT Pets.Kind, SUM(Procedures.Price) AS TotalSales
FROM Sales
LEFT JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode
LEFT JOIN Pets ON Sales.PetID = Pets.PetID
GROUP BY Pets.Kind
ORDER BY TotalSales DESC;

--Calculate total Sales by City and Pet Kind
SELECT Owners.City, Pets.Kind, SUM(Procedures.Price) AS TotalSales
FROM Sales
LEFT JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode
LEFT JOIN Pets ON Sales.PetID = Pets.PetID
LEFT JOIN Owners ON Owners.OwnerID = Pets.OwnerID
GROUP BY Owners.City, Pets.Kind
ORDER BY TotalSales DESC;

--Calculate Average sales by City
SELECT Owners.City, AVG(Procedures.Price) AS AvgSales
FROM Sales
LEFT JOIN Procedures ON Sales.ProcedureCode = Procedures.ProcedureCode
LEFT JOIN Pets ON Sales.PetID = Pets.PetID
LEFT JOIN Owners ON Owners.OwnerID = Pets.OwnerID
GROUP BY Owners.City
ORDER BY AvgSales DESC;

--If you have additional time, explore relationships with SQLight

