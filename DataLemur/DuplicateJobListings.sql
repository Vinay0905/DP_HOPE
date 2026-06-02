WITH cte as 
(SELECT company_id,title,description,
COUNT(job_id) as job_count
FROM job_listings
GROUP BY company_id,title,description
HAVING count(DISTINCT job_id)>1)

SELECT count(DISTINCT company_id)as co_w_duplicate_jobs
from cte;