create table cliente(
    
    id bigint not null auto_increment,
    ativo tinyint not null,
    idtotalcontrol bigint not null,
    nomeCliente varchar(20) not null,

    primary key(id)

)