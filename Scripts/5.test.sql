SELECT * FROM title;

SELECT empname, empno
  FROM employee e
  JOIN title t
    ON e.title = t.tno
 where tno = 5;

select tname, count(*) as ėŽėė
  from title t left join employee e on t.tno = e.title 
  group by tno;

   
   
    