### Instructions
For this task, you are given a `schema.sql` file that represents the database of a bookstore. Load this file into a MySQL database (or you can use a MySQL sandbox service like https://www.db-fiddle.com/) and write a MySQL query that will return the requested data.

Write your query in the `1_SQL/final_answer.sql` file.

### Task
The year 2019 just ended and the bookstore is tasked with releasing 2019’s best selling books. Make a query to retrieve the top 10 books with the most purchases in the year 2019. Include also the author (with their name in one column) and the number of purchases for that book. The list should be ordered with the most purchased book on top.

Sample Output:

```
+------------+--------+----------------+
| Book Title | Author | # of Purchases |
+------------+--------+----------------+
|    ...     |  ...   |      ...       |
+------------+--------+----------------+
```