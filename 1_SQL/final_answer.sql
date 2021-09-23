USE bookstore_development;
/* Write your query below: */
select books.title as 'Book Title',
	   concat(authors.first_name, ' ', authors.last_name) as 'Author',
       count(*) as '# of Purchases'
from authors, books, purchases
where authors.id = books.author_id 
and purchases.book_id = books.id 
group by books.id, books.title, concat(authors.first_name, ' ', authors.last_name)
order by count(*) desc;