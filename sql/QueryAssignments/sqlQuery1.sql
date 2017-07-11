use sakila;
\! echo "Comedy movies with PG-13 rating.";
select film.title, film.rating from film,film_category,category 
	where film.film_id = film_category.film_id 
	and category.category_id = film_category.category_id 
	and category.name = "Comedy"
    and film.rating = "PG-13";

\! echo "Top 3 rented Horror movies";
select film.title,count(film.film_id) as times_rented from rental,inventory,film,film_category,category
	where rental.inventory_id = inventory.inventory_id
    and inventory.film_id = film.film_id
    and film.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and category.name = "Horror"
    group by film.film_id
    order by times_rented desc 
    limit 3;

\! echo "Indian customers who rented Sports movies";
select customer.* from country,city,address,customer,rental,inventory,film_category,category 
	where country.country = "India"
    and country.country_id = city.country_id
    and city.city_id = address.city_id
    and address.address_id = customer.address_id
    and customer.customer_id = rental.customer_id
    and rental.inventory_id = inventory.inventory_id
    and inventory.film_id = film_category.film_id
    and film_category.category_id = category.category_id
    and category.name = "Sports";

\! echo "Canadian customers who rented movies of Nick Wahlberg";
select customer.* from country,city,address,customer,rental,inventory,film_actor,actor
	where country.country = "Canada"
    and country.country_id = city.country_id
    and city.city_id = address.city_id
    and address.address_id = customer.address_id
    and customer.customer_id = rental.customer_id
    and rental.inventory_id = inventory.inventory_id
    and inventory.film_id = film_actor.film_id
    and film_actor.actor_id = actor.actor_id
    and actor.first_name = "NICK"
    and actor.last_name = "WAHLBERG";

\! echo "Number of movies in which Sean Williams acted."
select count(*) from film,film_actor,actor 
	where film_actor.actor_id = actor.actor_id
    and film_actor.film_id = film.film_id
    and actor.first_name = "SEAN"
    and actor.last_name = "WILLIAMS";