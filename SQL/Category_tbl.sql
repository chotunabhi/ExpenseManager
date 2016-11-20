use ExpenseManager;

drop table if exists categories;

create table categories(
	category_id int,
    category_name varchar(100),
    category_level int,
    parent_category_id int,
    user_id varchar(255),
    primary key (category_id,user_id)
--     constraint FK_category_ser_id foreign key(user_id) references user_details(email_id)
); 
