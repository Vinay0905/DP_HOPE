SELECT 
sum(CASE WHEN device_type = 'laptop' then 1 else 0 end) as laptop_views,
sum(CASE WHEN device_type IN ('tablet','phone') then 1 else 0 end) as mobile_views
FROM viewership;