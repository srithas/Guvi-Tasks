READ ME

TO RUN CODE:

Open folder in IDE
Start XAMPP: Apache and MySQL
In IDE run: PatientMedApptApplication.java
On browser go to http://localhost:8030/

SET UP DATABASE:

Start XAMPP: Apache and MySQL
On browser go to http://localhost/phpmyadmin/index.php
Create new database name patient_system
Create new table appointments with fields: id(PRIMARY KEY, bigint(20), AUTO_INCREMENT), date_time(datetime), doctor_name(varchar(100)), specialization(varchar(100)), is_booked(tinyint(1)), patient_id(FOREIGN KEY, bigint(20))
Create new table medications with fields: id(PRIMARY KEY, bigint(20), AUTO_INCREMENT), name(varchar(255)), dosage(varchar(255)), instructions(text), status(varchar(255))
Create new table patient with fields: id(PRIMARY KEY, bigint(20), AUTO_INCREMENT), firstName(varchar(255)), lastName(varchar(255)),  address(varchar(255)), phonenumber(varchar(255)), emname(varchar(255)), emnumber(varchar(255)), insurance(varchar(255)), age(int(11)), gender(varchar(10))


OVERVIEW:

Click User Registration 
Enter patient details and save
Click view to view patient details
Click edit to edit patient details
Click delete to delete patient
Click Appointment Details to book appointment
Select Book Appointment
Click Back to Home
Click Medication Management to view medications
Enter Medication details to add medication for doctor review
Click edit to edit medication details
Click delete to delete medication






