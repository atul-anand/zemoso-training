-- E-Commerce Database schema
-- Author: Atul Anand

-- Constraints
-- Every item should correspond to a supplier.
-- One supplier can have more than one items.
-- A customer can have one order at the same time. 
-- One order can have multiple items from multiple brands.

-- Customer: Strong entity
-- Item: Strong entity
-- Supplier: Strong entity
-- Order: Strong entity 
-- Supplier-Item: Strong entity
-- Order-Item: Strong entity
-- Customer-Order: Strong entity

DROP SCHEMA IF EXISTS ECommerce;
CREATE SCHEMA ECommerce;
use ECommerce;

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;

-- 
-- Table Structure for table 'Item'
-- 

source ./item.sql;

-- 
-- Table Structure for table 'Supplier'
-- 

source ./supplier.sql;

-- 
-- Table Structure for table 'Order'
-- 

source ./order.sql;

-- 
-- Table Structure for table 'Supplier-Item Relation'
-- 

source ./supplier_item.sql;

-- 
-- Table Structure for table 'Order-Item Relation'
-- 

source ./order_item.sql;

-- 
-- Table Structure for table 'Customer-Order Relation'
-- 

source ./customer_order.sql;

-- 
-- Trigger for ensuring order price while adding item to the order.
-- 

source ./trigger_items.sql;

-- 
-- Trigger for ensuring order time for a customer.
-- 

source ./trigger_orders.sql;
