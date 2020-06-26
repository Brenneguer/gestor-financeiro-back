create table conta_a_pagar (
    codigo int not null primary key auto_increment,
	titulo varchar(60) not null,
	data_vencimento date,
	data_pagamento date,
	valor real,
	id_categoria int,
	ind_pago boolean default false,
	ind_deletado boolean default false,
    constraint foreign key (id_categoria) references categoria(codigo)
)