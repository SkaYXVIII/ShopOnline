create table category(
    id int not null auto_increment,
    title varchar(100) not null,
    parent int not null ,
    primary key (id),
    foreign key (parent) references category(id)
);

create table items(
    id int auto_increment,
    name VARCHAR(50)   NOT NULL,
    price FLOAT not null,
    description varchar(100) not null,
    category int not null ,
    primary key (id),
    foreign key (category) references category(id)
);