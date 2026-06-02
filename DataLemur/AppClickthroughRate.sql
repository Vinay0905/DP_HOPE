with cte as(
SELECT app_id,
SUM(CASE
  WHEN event_type ='impression'THEN 1
  ELSE 0 
END) as num_imp,
SUM(CASE
  WHEN event_type ='click'THEN 1
  ELSE 0 
END) as num_clk
FROM events
WHERE extract(year from timestamp)='2022'
GROUP BY app_id)

SELECT app_id,round(100.0*num_clk/num_imp,2) as ctr
from cte;