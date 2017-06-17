create table cliente (
    IdCli int generated always as identity (start with 1, increment by 1) primary key,
    Nome varchar(50) not null,
    Sexo varchar (20),
    Status boolean,
    DataNasc Date not null,
    EstadoCivil varchar(30) not null,
    CPF varchar (30) not null,
    Tel varchar (30),
    Cel varchar (30),
    Email varchar(30),
    Logradouro varchar(50) not null,
    Numero varchar(30) not null,
    Complemento varchar(30),
    CEP varchar(10) not null,
    Bairro varchar(30) not null,
    Cidade varchar(30) not null,
    Estado varchar(30) not null
);

create table produto (
    IdProd int generated always as identity (start with 5000, increment by 5) primary key,
    NomeProd varchar(30) not null,
    Fabricante varchar(30) not null,
    TipoProd varchar(30) not null,
    Quantidade int,
    Status boolean,
    Valor float,
    Garantia int,
    DataFab Date
);

create table pedido (
    IdPedido int generated always as identity (start with 1300, increment by 3) primary key,
    IdCli int,
    DataComp Date,
    Valor float,
    foreign key (IdCli) references cliente(IdCli)
);

create table ItensPedidos (
    IdItem int generated always as identity (start with 2000, increment by 2) primary key,
    IdProd int,
    IdPedido int,
    Quantidade int,
    SubTotal float,
    foreign key (IdProd) references produto(IdProd),
    foreign key (idPedido) references pedido(IdPedido)
);