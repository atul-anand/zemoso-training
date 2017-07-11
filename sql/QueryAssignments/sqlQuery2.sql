use sakila;
\! echo "Documentaries with Deleted Scenes."
select count(*) as documentaries 
    from film f
        join film_category fc
            on fc.film_id = f.film_id
        join category cat
            on cat.category_id = fc.category_id
	where cat.name = "Documentary"
    and FIND_IN_SET('Deleted Scenes',f.special_features);
    
\! echo "Number of Sci-Fi movies rented via Jon Stephens."
select count(distinct f.title) as titles 
    from store sr
        join staff sf
            on sf.store_id = sr.store_id
        join rental r
            on r.staff_id = sf.staff_id
        join inventory inv 
            on inv.inventory_id = r.inventory_id
        join film f
            on f.film_id = inv.film_id
        join film_category fc
            on fc.film_id = f.film_id
        join category cat
            on cat.category_id = fc.category_id
	where cat.name = "Sci-Fi"
    and sf.first_name = "Jon"
    and sf.last_name = "Stephens";

\! echo "Total Sales of Animated movies."
select sum(p.amount) as total_sales 
    from payment p
        join rental r 
            on r.rental_id = p.rental_id   
        join inventory inv
            on inv.inventory_id = r.inventory_id
        join film f
            on f.film_id = inv.film_id
        join film_category fc
            on fc.film_id = f.film_id
        join category cat
            on cat.category_id = fc.category_id
    where cat.name = "Animation";

\! echo "Top 3 movies rented by Patricia Johnson."
select cat.name as category, count(cat.category_id) as times_rented 
    from customer cust
        join rental r
            on r.customer_id = cust.customer_id
        join inventory inv
            on inv.inventory_id = r.inventory_id
        join film_category fc
            on fc.film_id = inv.film_id
        join category cat
            on cat.category_id = fc.category_id
	where cust.first_name = "PATRICIA"
    and cust.last_name = "JOHNSON"
    group by cat.category_id
    order by times_rented desc
    limit 3;
    
\! echo "Count of R rated movies rented by Susan Wilson."
select count(*) as movies 
    from customer cust
        join rental r
            on r.customer_id = cust.customer_id
        join inventory inv
            on inv.inventory_id = r.inventory_id
        join film f
            on f.film_id = inv.film_id
        join film_category fc
            on fc.film_id = f.film_id
        join category cat
            on cat.category_id = fc.category_id
	where cust.first_name = "SUSAN"
    and cust.last_name = "WILSON"
    and f.rating = "R";