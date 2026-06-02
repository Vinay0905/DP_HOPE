SELECT p.page_id 
FROM pages p 
LEFT OUTER JOIN page_likes as likes 
ON p.page_id =likes.page_id

WHERE likes.page_id IS NULL
order by page_id;