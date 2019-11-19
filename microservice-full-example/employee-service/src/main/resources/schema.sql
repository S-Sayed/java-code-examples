create table DEPARTMENT(
	id integer not null auto_increment,
	name char(100) not null,
	primary key(id)
);

create table EMPLOYEE
(
   id integer not null auto_increment,
   name varchar(255) not null,
   dept_id integer not null,
   primary key(id),
   foreign key (dept_id) references DEPARTMENT(id)
);