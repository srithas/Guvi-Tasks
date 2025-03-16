READ ME

TO RUN CODE:

Open folder in IDE
Start XAMPP: Apache and MySQL
In IDE run: BusTicketingApplication.java
On browser go to http://localhost:8070/

SET UP DATABASE:

Start XAMPP: Apache and MySQL
On browser go to http://localhost/phpmyadmin/index.php
Create new database name bus_ticketing
Create new table passenger with fields: id(PRIMARY KEY, int(11), AUTO_INCREMENT), email(varchar(100)), firstname(varchar(255)), lastname(varchar(255)), password(varchar(255))
Create new table routes with fields: id(PRIMARY KEY, int(11), AUTO_INCREMENT), departure(varchar(255)), destination(varchar(255)), dep_time(varchar(255)), ari_time(varchar(255)), pricing(decimal(10,2))
Create new table bookings with fields: id(PRIMARY KEY, int(11), AUTO_INCREMENT), passenger_id(FOREIGN KEY, int(11)), route_id(FOREIGN KEY, int(11)), seat_preference(varchar(50)), payment_method(varchar(50)), card_number(varchar(16)), expiry_date(varchar(7)), cvv(varchar(4))


OVERVIEW:

Click Register for new passenger 
Enter passenger details and save
Click login 
Enter passenger login info
Click Profile to view profile
Click Edit Profile to make changes to profile
Click Dashboard to return to homepage
Click Bookings History to view previous bookings
Enter departure location and destination location and click check routes
Click Book to book a specific route
Enter Booking Form details and click submit
Click Tickets to view e-tickets
Click accept to accept the ticket







