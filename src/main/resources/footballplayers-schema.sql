drop table if exists footballplayers CASCADE;
create table footballplayers
 (
 	id integer primary key auto_increment,
 	name varchar(255),
 	team_name varchar(255),
 	division varchar(255)
 );