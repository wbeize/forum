create table curso(
    id bigint auto_increment not null,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key (id)
);

insert into curso values (1, 'girassol', 'girassol@email.com')