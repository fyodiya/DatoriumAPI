--oldest pet
SELECT Name, Age FROM Pets ORDER BY Age DESC LIMIT 5;

--count by kind
SELECT Kind, COUNT(*) AS NumberOfPets 
FROM Pets 
GROUP BY Kind;

--pets and their owners
SELECT Pets.Name AS PetName, Pets.Kind, Pets.Age, Owners.Name AS OwnerName, Owners.Surname 
FROM Pets
JOIN Owners ON Pets.OwnerID = Owners.OwnerID;

--owners by city
SELECT City, COUNT(*) AS NumberOfOwners 
FROM Owners 
GROUP BY City;