explain analyze
select *
from towns
where name = 'a4972728716b2e1aa3cfa47bf2c4d522';

create index idx_towns_name on towns(name);
drop index if exists idx_towns_name;

explain analyze
select *
from towns
where id='4';
