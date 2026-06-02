SELECT 
user_id,
DATEDIFF(MAX(DATE(post_date)),MIN(DATE(post_date)))as days_between
FROM posts 
WHERE YEAR(post_date)=2021
GROUP BY user_id
HAVING COUNT(post_id)>1;