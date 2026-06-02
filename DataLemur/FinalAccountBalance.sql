SELECT account_id,
sum(
CASE
  WHEN transaction_type='Deposit' THEN amount
  ELSE -amount
END) AS balance_amount

FROM transactions
GROUP BY account_id;