# create

# insert into employees values (1, 'Павло', 'Біліневич', 25);
# insert into employees values (default, 'Юрій', 'Гордієнко', 40);
# insert into employees values (default, 'Вадим', 'Єфіменко', 26);
# insert into employees values (default, 'Ярослав', 'Косотухін', 22);
# insert into employees values (default, 'Єлизавета', 'Костенко', 22);
# insert into employees values (default, 'Олександр', 'Москалюк', 19);
# insert into employees values (default, 'Максим', 'Олійник', 21);
# insert into employees values (default, 'Микита', 'Посохов', 30);
# insert into employees values (default, 'Артур', 'Шамрай', 22);

# read

# find all
# select * from employees;
# select id, age from employees;
# select * from employees where id = 1;
# select * from employees where age < 30 and age > 25;
# select * from employees where age in (21, 22);
# select * from employees where first_name like 'ю%';
# select * from employees where first_name like '%м';
# select * from employees where first_name like '%р%' and first_name not like '%р';

# update

      # update employees set age = 19 where id = 1;

# delete

# select * from employees;
# delete from employees where id = 10;
# delete from employees where id in (10, 8);
