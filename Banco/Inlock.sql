CREATE DATABASE NatuterraDrinks;

USE NatuterraDrinks;


CREATE TABLE Produto(
	IdProduto		INT PRIMARY KEY NOT NULL auto_increment,
    NomeProduto		VARCHAR (255) NOT NULL,
    Valor			DECIMAL NOT NULL,
    Quantidade		INT NOT NULL,
    Peso			DECIMAL NOT NULL,
    Validade		DATE NOT NULL
);


CREATE TABLE TipoUsuario(
	IdTipo		INT PRIMARY KEY NOT NULL auto_increment,
    TituloTipo	VARCHAR (100)
);

drop table Usuario;
CREATE TABLE Usuario(
	IdUsuario 		INT NOT NULL auto_increment,
    IdTipo			INT,
	NomeUsuario		VARCHAR (255) NOT NULL,
    Email			VARCHAR (255) NOT NULL,
    Senha			VARCHAR (20) NOT NULL,
    CPF				CHAR	(14) NOT NULL,
    Endereco		VARCHAR (255) NOT NULL,
					PRIMARY KEY (IdUsuario),
    			    FOREIGN KEY (IdTipo) REFERENCES TipoUsuario(IdTipo)
);


CREATE TABLE Entrega(
	IdEntrega		INT NOT NULL auto_increment,
					PRIMARY KEY(IdEntrega),
	TempoEntrega	DATE NOT NULL,
    IdProduto		INT,
					FOREIGN KEY (IdProduto) REFERENCES Produto(IdProduto),
	Taxa			DOUBLE NOT NULL,
    EnderecoEntrega	VARCHAR(255)
    
);

CREATE TABLE NotaFiscal(
	IdNota		INT auto_increment,
				PRIMARY KEY (IdNota),
	IdProduto		INT,
					FOREIGN KEY (IdProduto) REFERENCES Produto(IdProduto),
	IdEntrega		INT,
					FOREIGN KEY (IdEntrega) REFERENCES Entrega(IdEntrega),
	DataCompra		datetime,
    IdEmpresa		INT,
					FOREIGN KEY (IdEmpresa) REFERENCES Natuterra(IdEmpresa)
);

CREATE TABLE Natuterra(
	IdEmpresa		INT auto_increment,
					PRIMARY KEY (IdEmpresa),
	NomeEmpresa		VARCHAR (255) NOT NULL,
    CNPJ			VARCHAR(30),
    Endereco		VARCHAR(255),
    RazaoSocial		VARCHAR(255)
);

alter table Usuario
add  Endereco VARCHAR (255);










