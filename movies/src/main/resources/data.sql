insert into movie_type values(default,'romcom');
insert into movie_type values(default,'comedy');
insert into movie_type values(default,'thriller');
insert into movie_type values(default,'drama');

insert into movie (id, isbn, title, type_id) values (default, '3456', 'Gypsy', 1);
insert into movie (id, isbn, title, type_id) values (default, '4567', 'Avatar', 3);
insert into movie (id, isbn, title, type_id) values (default, '5678', 'Christmas Vacation', 2);


insert into book_type values(default,'romance');
insert into book_type values(default,'thriller');
insert into book_type values(default,'crime');
insert into book_type values(default,'nonfiction');

insert into book (id, title, author, type_id) values (default, 'The Hobbit', 'Thomas', 1);
insert into book (id, title, author, type_id) values (default, '2001', 'Bill', 3);
insert into book (id, title, author, type_id) values (default, 'bible', 'Bryan', 4)