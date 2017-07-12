use sakila;
\! echo "Comedy movies with PG-13 rating.";
select f.title, f.rating 
    from film f
        join film_category fc 
            on fc.film_id = f.film_id
        join category cat 
            on cat.category_id = fc.category_id
    where cat.name = "Comedy"
    and f.rating = "PG-13";

\! echo "Top 3 rented Horror movies";
select f.title,count(f.film_id) as times_rented 
    from rental r
        join inventory inv 
            on inv.inventory_id = r.inventory_id
        join film f 
            on f.film_id = inv.film_id
        join film_category fc 
            on fc.film_id = f.film_id
        join category cat
            on cat.category_id = fc.category_id
    where cat.name = "Horror"
    group by f.film_id
    order by times_rented desc 
    limit 3;

\! echo "Indian customers who rented Sports movies";
select cust.* 
    from country cnt
        join city c
            on c.country_id = cnt.country_id
        join address ad
            on ad.city_id = c.city_id
        join customer cust
            on cust.address_id = ad.address_id
        join rental r
            on r.customer_id = cust.customer_id
        join inventory inv
            on inv.inventory_id = r.inventory_id
        join film_category fc
            on fc.film_id = inv.film_id
        join category cat
            on cat.category_id = fc.category_id
    where cnt.country = "India"
    and cat.name = "Sports";

\! echo "Canadian customers who rented movies of Nick Wahlberg";
select cust.* 
    from country cnt
        join city c
            on c.country_id = cnt.country_id
        join address ad
            on ad.city_id = c.city_id
        join customer cust
            on cust.address_id = ad.address_id
        join rental r
            on r.customer_id = cust.customer_id
        join inventory inv
            on inv.inventory_id = r.inventory_id
        join film_actor fa
            on fa.film_id = inv.film_id
        join actor a
            on a.actor_id = fa.actor_id
    where cnt.country = "Canada"
    and a.first_name = "NICK"
    and a.last_name = "WAHLBERG";

\! echo "Number of movies in which Sean Williams acted."
select count(*) 
    from film f
        join film_actor fa 
            on fa.film_id = f.film_id
        join actor a
            on a.actor_id = fa.actor_id
    where a.first_name = "SEAN"
    and a.last_name = "WILLIAMS";