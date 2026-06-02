SELECT u.city,COUNT(*) as total_orders

FROM trades t
left JOIN users u
on t.user_id=u.user_id
WHERE t.status='Completed'
GROUP BY u.city
ORDER BY total_orders DESC
LIMIT 3;