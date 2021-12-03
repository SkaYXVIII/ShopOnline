drop table if exists items;
create table items(
    id int primary key auto_increment,
    name VARCHAR(50)   NOT NULL,
    price FLOAT not null,
    description varchar(100) not null
)