create table cliente(
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

create table produto(
IdProd int generated always as identity (start with 1, increment by 1) primary key,
NomeProd varchar(30) not null,
Fabricante varchar(30) not null,
TipoProd varchar(30) not null,
Quantidade int,
Status boolean,
Valor float
);

create table ItensPedidos(
IdItem int generated always as identity (start with 1, increment by 1) primary key,
IdCli int,
IdProd int,
Quantidade int,
SubTotal float,
foreign key (IdCli) references cliente(IdCli),
foreign key (IdProd) references produto(IdProd)
);

create table pedido(
IdPedido int generated always as identity (start with 1, increment by 1) primary key,
IdItem int,
DataComp Date,
Nome varchar (50),
NomeProd varchar(30),
Valor float,
foreign key (IdItem) references ItensPedidos(IdItem)
);