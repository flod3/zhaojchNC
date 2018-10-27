create table bd_pwd(
 pk_pwd char(10) primary key,
 username varchar(100),
 password varchar(100)
);


create table bd_menu(
  pk_menu char(10) primary key,
  code varchar(20) not null unique,
  name varchar(100),
  father_menu varchar(20),
  level int
);

insert into bd_menu (pk_menu, code, name, father_menu, level) values ('123','1','fuck',null,0);