TRUNCATE table employee cascade;

insert into employee(id, first_name, last_name, role)
values(10, 'Bob', 'Dan', 'HR'),
      (11, 'Jane', 'John', 'Accountant');