SELECT * 
from texts t
left join emails e
on t.email_id=e.email_id
where t.action_date=DATE_ADD(e.signup_date,INTERVAL 1 DAY)
AND t.signup_action='Confirmed';
