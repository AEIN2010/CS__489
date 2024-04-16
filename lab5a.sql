CREATE TABLE Dentist (
    Dentist_ID INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50),
    Contact_Phone_Number VARCHAR(15),
    Email VARCHAR(100),
    Specialization VARCHAR(100)
);

CREATE TABLE Patient (
    Patient_ID INT PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50),
    Contact_Phone_Number VARCHAR(15),
    Email VARCHAR(100),
    Mailing_Address VARCHAR(255),
    Date_of_Birth DATE
);

CREATE TABLE Surgery_Location (
    Location_ID INT PRIMARY KEY,
    Name VARCHAR(100),
    Address VARCHAR(255),
    Telephone_Number VARCHAR(15)
);

CREATE TABLE Appointment (
    Appointment_ID INT PRIMARY KEY,
    Dentist_ID INT,
    Patient_ID INT,
    Date DATE,
    Time TIME,
    Location_ID INT,
    FOREIGN KEY (Dentist_ID) REFERENCES Dentist(Dentist_ID),
    FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
    FOREIGN KEY (Location_ID) REFERENCES Surgery_Location(Location_ID)
);




-- Dentist Table
INSERT INTO Dentist (Dentist_ID, First_Name, Last_Name, Contact_Phone_Number, Email, Specialization)
VALUES
(1, 'John', 'Smith', '123-456-7890', 'john.smith@example.com', 'General Dentistry'),
(2, 'Emily', 'Johnson', '234-567-8901', 'emily.johnson@example.com', 'Orthodontics'),
(3, 'Michael', 'Williams', '345-678-9012', 'michael.williams@example.com', 'Endodontics');

-- Patient Table
INSERT INTO Patient (Patient_ID, First_Name, Last_Name, Contact_Phone_Number, Email, Mailing_Address, Date_of_Birth)
VALUES
(1, 'Sarah', 'Brown', '456-789-0123', 'sarah.brown@example.com', '123 Main St, Anytown, USA', '1990-05-15'),
(2, 'David', 'Miller', '567-890-1234', 'david.miller@example.com', '456 Oak Ave, Othertown, USA', '1985-10-20'),
(3, 'Emma', 'Wilson', '678-901-2345', 'emma.wilson@example.com', '789 Maple Ln, Anycity, USA', '1998-03-30');

-- Surgery Location Table
INSERT INTO Surgery_Location (Location_ID, Name, Address, Telephone_Number)
VALUES
(1, 'South West Dental', '123 Main St, Anytown, USA', '123-456-7890'),
(2, 'City Center Dental', '456 Oak Ave, Othertown, USA', '234-567-8901'),
(3, 'Central Dental', '789 Maple Ln, Anycity, USA', '345-678-9012');

-- Appointment Table
INSERT INTO Appointment (Appointment_ID, Dentist_ID, Patient_ID, Date, Time, Location_ID)
VALUES
(1, 1, 1, '2024-04-16', '09:00', 1),
(2, 2, 2, '2024-04-17', '10:30', 2),
(3, 3, 3, '2024-04-18', '11:15', 3),
(4, 1, 2, '2024-04-19', '14:00', 1),
(5, 2, 3, '2024-04-20', '15:45', 2);


SELECT * FROM Dentist ORDER BY Last_Name;


SELECT Appointment.*, Patient.* 
FROM Appointment 
INNER JOIN Patient ON Appointment.Patient_ID = Patient.Patient_ID 
WHERE Appointment.Dentist_ID = 1;



SELECT Appointment.*, Surgery_Location.* 
FROM Appointment 
INNER JOIN Surgery_Location ON Appointment.Location_ID = Surgery_Location.Location_ID;




SELECT Appointment.*, Dentist.* 
FROM Appointment 
INNER JOIN Dentist ON Appointment.Dentist_ID = Dentist.Dentist_ID 
WHERE Appointment.Patient_ID = 1 AND Appointment.Date = '2024-04-16';


