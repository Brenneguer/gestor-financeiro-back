create table conta_a_receber (
    codigo int not null primary key auto_increment,
    titulo varchar(60) not null,
    data_recebimento date,
    valor real not null,
    id_categoria int,
    ind_recebido boolean default false,
    ind_deletado boolean default false,
    constraint `fk_id_categoria` foreign key (id_categoria) references categoria(codigo)
)