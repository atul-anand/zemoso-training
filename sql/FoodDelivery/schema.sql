-- Food Delivery Database schema
-- Author: Atul Anand

-- Constraints
-- Delivery person must have an order. He can have more than one orders at the same time.
-- Customer can book from only only restaurant at a time.
-- An order can have items from only one restaurant. A restaurant can have multiple orders from different customers at the same time.

-- Customer: Strong entity
-- Restaurant: Strong entity
-- Delivery_Boy: Weak entity
-- Order: Weak entity

DROP SCHEMA IF EXISTS Delivery;
CREATE SCHEMA Delivery;
use Delivery;

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;

-- 
-- Table Structure for table 'Restaurant'
-- 

source ./restaurant.sql;

-- 
-- Table Structure for table 'Delivery Boy'
-- 

source ./delivery_boy.sql;

-- 
-- Table Structure for table 'Order'
-- 

source ./order.sql;

-- 
-- Trigger for ensuring order count for the delivery boy.
-- 

source ./trigger_orders.sql;

