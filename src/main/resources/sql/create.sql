create table if not exists users(
    id bigserial primary key,
    user_name varchar(125),
    age int,
    email varchar(125)
);