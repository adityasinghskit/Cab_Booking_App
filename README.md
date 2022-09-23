# Cab Booking Application
Hi! This is a basic REST api which is can be used for online cab booking service.
## Introduction
A collaborative project and was made by a team of 6 student studying in [Masai School](https://www.masaischool.com/), a coding and skill building school. Our objective was to create a basic REST api for online cab booking service with login, customer, admin, driver, cab, trip booking modules.

## Tech Stack
![view - Documentation](https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=gitea)
![view - Documentation](https://img.shields.io/badge/Hibernate-blue?style=for-the-badge&logo=hibernate)
![view - Documentation](https://img.shields.io/badge/Mysql-ffca3a?style=for-the-badge&logo=mysql)
![view - Documentation](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven)
![view - Documentation](https://img.shields.io/badge/Swagger-white?style=for-the-badge&logo=swagger)
![view - Documentation](https://img.shields.io/badge/Spring_Boot-purple?style=for-the-badge&logo=appveyor)

## Acknowledgement
Sincere thanks to all faculty and staff members of Masai School who made all of this possible. Without their efforts we would not have completed this project.
Especially [Ratan sir](https://www.linkedin.com/in/ratan-lal-gupta-79a4a7240/), [Abhinav sir](https://www.linkedin.com/in/abhinavgujral/).

## Problem Statement
To Create an Application for Online Cab Booking 
Customer should be able to view the list of available cabs.
Customer should be able to book cab for desired location from a certain location. 
Admin should be able to perform below operations:
1. Cab Management 
2. Driver Management
3. Booking Management

## Modules
1. Login Module
2. Admin Module
3. Customer Module
4. Driver Management Module
5. Cab Management Module
6. Booking Management Module


## Swagger-ui represantation
![Cab_Booking_Swapper](https://user-images.githubusercontent.com/68966858/185415047-fb410006-16e9-44f6-b7df-647b02491db8.jpg)

## Cab Booking Application ER diagram
![cab_booking_3](https://user-images.githubusercontent.com/68966858/185020617-92914a9c-b5e2-4b3b-aa36-dc6a26454cba.jpeg)

# Functions of Admin, Cutomer, Driver
## Through admin we can : 
1. Can Log in/Log out of the system.<br>
2. Admin can View/Edit/Delete taxis into the system.<br>
3. Admin can View/Confirm/Cancel booking done by the User.<br>
4. Can check payments done by User.<br>
5. Can check the availability of cabs and drivers.<br>
6. Can manage driver staff.<br>
7. Can change the charge.<br>
8. Can change password.<br>

## Through Customer we can:
1. Can Log in/Log out of the system.
2. Can Manage “My profile”.<br>
3. Can search for cab.<br>
4. Users can Book/Cancel cabs.<br>
5. Can change password.<br>

## Through Driver we can:
1. Add a driver in the system.
2. Update driver details.
3. Delete a driver from the system.
4. Get the list of all drivers.
5. Get the list of all best available(rated>=4.5) drivers.

## Running the application locally
To run the application:
1. clone the repo
2. Import the project in Spring Tool Suit software.
3. Change the Mysql database login credentials, also change the port no to your liking.
4. Run as a Spring boot app.
5. Go to the browser and type URL:
```
http://localhost:8888/swagger-ui.html
```
In this I have used port 8888.<br>
6. Now you will see swagger ui for the API and you can test API directly from there.
## Test data
TO ADD DRIVER<br>
{
  "address": {
    "city": "Ajmer",
    "pincode": "305001",
    "state": "Rajasthan"
  },
  "available": true,
  "cab": {
    "carType": "sedan",
    "ratePerKm": 10
  },
  "email": "abc@email.com",
  "licenseNo": 136137,
  "mobile": "9928228503",
  "password": "abcdef",
  "rating": 1,
  "username": "Aditya"
}

TO ADD CUSTOMER<br>

{
  "address": {
    "city": "jaipur",
    "pincode": "783739",
    "state": "Raj"
  },
  "email": "abc@mail.com",
  "journey_status": true,
  "mobile": "9999999999",
  "password": "abcdef",
  "username": "xzy"
}

TO ADD TRIP<br>

{
  "customerId": 4,
  "driver": {
    "userId": 0
  },
  "from_location": "ajmer",
  "fromdate_time": "2022-08-17",
  "km": 120,
  "payment": true,
  "to_location": "Jaipur",
  "todate_time": "2022-08-18",
  "totalamount": 1200
}

TO ADD ADMIN<br>

{
  "address": {
    "city": "jnda",
    "pincode": "298429",
    "state": "kasa"
  },
  "email": "stranaa@dkd.com",
  "mobile": "9999999999",
  "password": "12344",
  "username": "dadka"
}

