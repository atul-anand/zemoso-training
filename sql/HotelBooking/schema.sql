-- Hotel Booking Database schema
-- Author: Atul Anand

-- Constraints
-- Customer can be first time user or loyal customer.
-- Customer can book from only only hotel at a time. A hotel can have many customers.

-- Hotel: Strong entity
-- Customer: Strong entity
-- Hotel_Customer: Weak entity

DROP SCHEMA IF EXISTS HotelBooking;
CREATE SCHEMA HotelBooking;
use HotelBooking;

-- 
-- Table Structure for table 'Hotel'
-- 

source ./hotel.sql;

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;

-- 
-- Table Structure for table 'Hotel-Customer Relation'
-- 

source ./hotel_customer.sql;