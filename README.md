# DistributedSystems

## Distribited Systems Project
###### Written by Keith Higgins (G00334157)
For my distributed systems module in college I had to develop a booking systems for cars using the following technologies:

    - JAX-RS/Jersey
    - Jave RMI
    - JAXB
    - Apache Tomcat

Outlined below are instructions on how to use the project files contained within this repository.

---

### How to use this repository

1. Ensure you have Java 1.8 as it only works with this jave runtime as of now.
2. Git clone this repository and import into eclipse.
3. Start up Wamp
4. Import my sql file "carbookingsystem.sql"
5. Open eclipse
6. Right click on RMI2 project and Run As > Java Application
7. In the console it will output "server ready" when ready.
8. Right click on RestTJersey project and Run As > Run on Server > Chose tomcat 7
9. In your browser/eclipse browser go to http://localhost:8080/RestJersey/, this will bring you to my index page

```
### Features

1. Get Booking - Returns the xml of all bookings from the database.
2. Add Booking - Allows the user to add bookings using the fields 
-> CustID , CarReg, HireDate, Return date *Note date must be in format e.g "2018-12-09"* 
3. Delete Booking - Deletes booking by order id.
4. Updae Booking - Updates the booking based on Customerid 
-> user can change carReg, hireDate and return date *Note date must be in format e.g "2018-12-09"*
```


``` 
### Extra Features

1. Can search by order by typing in the address bar - http://localhost:8080/RestJersey/webapi/myresource/Searchbooking/{Order id E.g 2}
```
### Screenshots

Main Page:
![alt text](https://github.com/KeithH4666/DistributedSystems/blob/master/Screenshots/Mainpage.JPG)

Get Orders:
![alt text](https://github.com/KeithH4666/DistributedSystems/blob/master/Screenshots/getbookings.JPG)

Add order:
![alt text](https://github.com/KeithH4666/DistributedSystems/blob/master/Screenshots/addorder.JPG)

Delete order:
![alt text](https://github.com/KeithH4666/DistributedSystems/blob/master/Screenshots/delete.JPG)

Update order:
![alt text](https://github.com/KeithH4666/DistributedSystems/blob/master/Screenshots/update.JPG?raw=true)

### What to improve

If I had more time, I would have have added multiple tables and model classes and used join features in my sql statements.
However I was very proud to have an order table and order model working flawlessly in my project.

```
### Conclusion
```

I would like to thank my lecturer Dr. Patrick Mannion for all his help throughout my course.
Without his labs and extra guidence I wouldn't have the knowledge to finish this project.
By completing this project it had given me a huge amount of knowledge of how RMI and rest servers work.
I look forward to using these technologies in the future.

