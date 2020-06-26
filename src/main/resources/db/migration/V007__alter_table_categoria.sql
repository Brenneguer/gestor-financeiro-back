alter table categoria add column id_usuario int after id_tipo, add constraint `fk_id_usuario_categoria` foreign key (id_usuario) references usuario(codigo);
alter table conta_a_pagar add column id_usuario int after titulo, add constraint `fk_id_usuario_conta_a_pagar` foreign key (id_usuario) references usuario(codigo);;
alter table conta_a_receber add column id_usuario int after titulo, add constraint `fk_id_usuario_conta_a_receber` foreign key (id_usuario) references usuario(codigo);;