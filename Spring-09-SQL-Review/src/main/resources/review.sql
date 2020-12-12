select *
from departments;

select *
from employees;

select *
from regions;

select employee_id, first_name, department
from employees;

select *
from employees
where department = 'Sports';

select *
from employees
where department like 'F%nit%';

select *
from employees
where salary >= 100000;

select *
from employees
where salary <= 100000;

select *
from employees
where salary >= 100000
  and department = 'Clothing';

select *
from employees
where salary >= 100000
  and department = 'Clothing'
  and region_id = 2;

select *
from employees
where department = 'Clothing'
   or salary > 90000;

SELECT *
FROM employees
WHERE salary < 40000
  and (department = 'Clothing'
    or department = 'Pharmacy');

select *
from employees
where not department <> 'Sports';

select *
from employees
where email is not NULL;

select *
from employees
where department = 'Sports'
   or department = 'First aid'
   or department = 'Toys'
   or department = 'Garden';

select *
from employees
where department IN ('Sports',
                     'First aid',
                     'Toys',
                     'Garden');

select *
from employees
where salary between 80000 and 100000;

--Write a query that returns the first name and email
-- of females that work in the tools department
--having a salary greater than 110,000
select first_name, email
from employees
where gender = 'F'
  and department = 'Tools'
  and salary >= 110.000;

--write a query that returns the first name and hire date of those employees who earn more than 165000
--as well those employees that work in the sports department and also happen to be a man
select first_name, hire_date
from employees
where salary >= 165000
   or (department = 'Sports' and gender = 'M');

select *
from employees
order by employee_id asc;

select distinct department
from employees;

select distinct department
from employees
    fetch first 3 rows only;

select salary as yearly_salary
from employees;

--write a query that displays the name and ages of the top 4 oldest students;
select *
from students
order by age desc
    fetch first 4 rows only;

--write a query that returns students based on the following criteria:
--The student must not be older than age 20
-- if their student_no is either between 3 and 5
--or their student_no is 7.
-- Your query should also return students older than age 20 but in that case they must
--have a student_no that is at least 4
select *
from students
where age <= 20 and (student_no between 3 and 5
    or student_no = 7)
   or (age > 20 and student_no > 3);

select upper(first_name) as firstname, lower(department) as DEPARTMENT
from employees;

select length(first_name)
from employees;

select trim('        Hello There    ');
select length('        Hello There    ');
select length(trim('        Hello There    '));

select first_name || ' ' || last_name as fullname
from employees;

select (salary > 140000)
from employees;

select (salary > 140000) as hihgly_paid
from employees
order by salary desc;

select department, (department like '%oth%')
from employees;

select avg(salary)
from employees;

select round(avg(salary), 2)
from employees
group by region_id;

select 'This is test data' test_data;

select substring('this is test data' from 1 for 4) as test_data;

select substring('this is test data' from 9) as test_data;

select department, replace(department, 'Grocery', 'clothing')
from departments;

select max(salary)
from employees;

select min(salary)
from employees;

select avg(salary)
from employees;

select round(avg(salary), 2)
from employees;

select count(employee_id)
from employees;

select count(email)
from employees;

select count(*)
from students;

select sum(salary)
from employees
where department = 'Clothing';

--write a query that returns all of the record and columns from the professors table
--but shortens the department names to only the first three characters in upper case
--department,1,3
select last_name, upper(substring(department from 1 for 3)) as department, salary, hire_date
from professors;

--write a query that returns the highest and lowest salary from
-- the professors table excluding the professor named 'Wilson'

select max(salary) as max_salary, min(salary) as min_salary
from professors
where last_name <> 'Wilson';

select count(*), department
from employees
group by department;

select department, sum(salary) as total_salary
from employees
group by department;

select department,
       min(salary)           as min_salary,
       max(salary)           as max_salary,
       round(avg(salary), 2) as avg_salary,
       count(*)              as total_number_employees
from employees
group by department;

select sum(salary) as total_salary, department
from employees
where region_id in (4, 5, 6, 7)
group by department;

select department, count(*)
from employees
group by department
order by department;

select department, count(*)
from employees
group by department
having count(*) < 35
   and department like 'A%'
order by department;

--show all uniqe domain and number of employees
select count(*), substring(email, position('@' in email) + 1) as email_domain
from employees
where email is not NULL
group by email_domain;

select e.department, d.department
from employees e,
     departments d;

select *
from employees
where department not in (select department from departments);

select a.*
from (select * from employees where salary > 150000) a;

select first_name, last_name, (select max(salary) from employees)
from employees;

select *
from departments;

--Return all employees that work in electronic division
select *
from employees
where department in
      (select department from departments where division = 'Electronics');

--Return all employees work in ASIA or CANADA make more than 130000
select *
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'))
  and salary > 130000;

--First name where work in Asia and Canada and how much less making from the highest employee in the company

select first_name, salary, (select max(salary) from employees) - salary as less_from_max, region_id
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'))
order by salary;

--write a query that returns all of those employees that work in the kids division AND
--the dates at which those employees were hired is greater than all of the hire_dates of employees
--who work in the maintanance department

select *
from employees
where department = any (select department
                        from departments
                        where division = 'Kids')
  and hire_date > all (select hire_date from employees where department = 'Maintenence');

--write a query that returns the names of those students that are taking the courses Physics and US history;
select *
from students;

select *
from student_enrollment;

select *
from courses;

select student_name
from students;

select student_name
from students
where student_no = any (select student_no
                        from student_enrollment
                        where course_no in
                              (select course_no from courses where course_title in ('Physics', 'US History')));

select first_name,
       salary,
       case
           when salary < 100000 then 'UNDER PAID'
           when salary > 100000 then 'PAID WELL'
           else 'UNPAID'
           end as category
from employees;

select category, count(*)
from (select first_name,
             case
                 when salary < 100000 then 'UNDER PAID'
                 when salary > 100000 and salary < 160000 then 'PAID WELL'
                 else 'EXECUTIVE'
                 end as category
      from employees) a
group by category;

select *
from employees;

select *
from regions;

select first_name, country, department
from employees e
         join regions r on e.region_id = r.region_id;

select first_name, email, division, d.department
from employees e,
     departments d,
     regions r
where e.department = d.department
  and e.region_id = r.region_id;

select first_name, country, d.department
from employees e
         inner join regions r on e.region_id = r.region_id
         inner join departments d on e.department = d.department;

select first_name, email, division
from employees e
         inner join departments d on e.department = d.department
where email is not NULL;

select first_name, email, division, country
from employees e
         inner join departments d on
    e.department = d.department
         inner join regions r on e.region_id = e.region_id
where email is not NULL;

select distinct department
from employees;
select distinct department
from departments;

select distinct e.department, d.department
from employees e
         left join departments d
                   on e.department = d.department;

select distinct e.department, d.department
from employees e
         right join departments d
                    on e.department = d.department;

select distinct e.department, d.department
from employees e
         full join departments d
                   on e.department = d.department;

select department
from employees
union
select department
from departments;

select department
from employees
union
select department
from departments
union
select country
from regions;

select department
from employees
union all
select department
from departments;

select department
from employees
    except
select department
from departments;





























