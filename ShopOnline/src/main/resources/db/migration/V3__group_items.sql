create table store_groups
(
    id          int primary key auto_increment,
    description varchar(100) not null
);
alter table items add column store_group_id int null;
alter table items
    add foreign key (store_group_id) references store_groups (id);