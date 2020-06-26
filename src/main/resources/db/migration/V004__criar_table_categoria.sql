create table categoria (
    codigo int not null primary key auto_increment,
    nome varchar(70) not null,
    id_tipo int not null,
    ind_deletado boolean default false not null,
    constraint `fk_id_tipo` foreign key (id_tipo) references tipo(codigo)
)