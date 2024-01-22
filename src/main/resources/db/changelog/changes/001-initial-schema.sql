create table crud_user
(
    id serial PRIMARY KEY,
    age integer,
    first_name varchar(255),
    last_name varchar(255)
);

create table department
(
    id serial PRIMARY KEY,
    name varchar(255) not null unique
);

create table salary
(
    id serial PRIMARY KEY,
    salary_sum numeric(38, 2)
);

create table employee
(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255),
    department_id integer references department(id),
    salary_id integer references salary(id)
);

