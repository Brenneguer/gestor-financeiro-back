create table usuario (
    codigo int not null primary key auto_increment,
    nome varchar(100) not null,
    sobrenome varchar(100),
    email varchar(100) not null,
    senha varchar(255)
);


insert into usuario (nome, sobrenome, email, senha) values
('Weuller', 'Brenneguer', 'wbrenneguer07@gmail.com', '123456');