create table tipo (
    codigo int not null primary key auto_increment,
    tipo varchar(20) not null
);
insert into tipo (tipo) values 
    ('Receita'),
    ('Despesa');