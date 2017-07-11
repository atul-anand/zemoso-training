use sakila;
\! echo "Documentaries with Deleted Scenes."
select count(*) from film,film_category,category
	where film.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and category.name = "Documentary"
    and film.special_features like '%Deleted Scenes%';
    
\! echo "Number of Sci-Fi movies rented via Jon Stephens."
select count(distinct film.title) as title from store,staff,rental,inventory,film,film_category,category
	where store.store_id = staff.store_id
    and staff.staff_id = rental.staff_id
    and rental.inventory_id = inventory.inventory_id
    and inventory.film_id = film.film_id
    and film.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and category.name = "Sci-Fi"
    and staff.first_name = "Jon"
    and staff.last_name = "Stephens";

\! echo "Total Sales of Animated movies."
select sum(payment.amount) as total_sales from payment,staff,rental,inventory,film,film_category,category
    where payment.rental_id = rental.rental_id
    and rental.inventory_id = inventory.inventory_id
    and inventory.film_id = film.film_id
    and film.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and category.name = "Animation";

\! echo "Top 3 movies rented by Patricia Johnson."
select category.name, count(category.category_id) as times_rented from customer,rental,inventory,film_category,category
	where customer.customer_id = rental.customer_id
    and rental.inventory_id = inventory.inventory_id
	and inventory.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and customer.first_name = "PATRICIA"
    and customer.last_name = "JOHNSON"
    group by category.category_id
    order by times_rented desc
    limit 3;
    
\! echo "Count of R rated movies rented by Susan Wilson."
select count(*) from customer,rental,inventory,film,film_category,category
	where customer.customer_id = rental.customer_id
    and rental.inventory_id = inventory.inventory_id
	and inventory.film_id = film_category.film_id
    and film.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and customer.first_name = "SUSAN"
    and customer.last_name = "WILSON"
    and film.rating = "R";