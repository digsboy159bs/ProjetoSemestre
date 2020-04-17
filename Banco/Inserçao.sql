USE NatuterraDrinks;

INSERT INTO TipoUsuario(TituloTipo)
values ('Administrador'), ('Funcionario'), ('Cliente');

INSERT INTO Usuario( NomeUsuario, Email, Senha, CPF, Endereco, IdTipo)
values ('Kleber', 'kleberSantos$@gmail.com', 'kleber123', '344.377.109-67', 'Rua japao Dos doido N°51', 2), 
('Artur', 'ArturPiaui@gmail.com', 'Piaui123', '123.456.678-89', 'Rua Saramandaia Dos mortos N°13', 1);

INSERT INTO Natuterra(NomeEmpresa, CNPJ, Endereco, RazaoSocial)
values ('Natuterra Drinks', '26.465.300/0001-30', 'Avenida Joao Paulo Ablas N°900, CEP = 06711250', ' Natuterra Drinks - Comercio Atacadista de Bebidas LTDA');

INSERT INTO Produto(NomeProduto, Valor, Quantidade, Peso, Validade)
values ('Leite vegetal de amendoas', 6.00 , 100, 1.00, '2020-07-24' ), ('Leite vegetal de coco e aveia', 13.00, 100,  1.00, '2020-07-24' );

INSERT INTO Entrega(TempoEntrega, Taxa, EnderecoEntrega, IdProduto)
values ('2020-07-24', 3.00, 'Rua japao Dos doido N°51', 3);

INSERT INTO NotaFiscal(DataCompra, IdProduto, IdEntrega, IdEmpresa)
values ('2020-06-24', 3, 5, 1);

SELECT * FROM Usuario;
SELECT * FROM TipoUsuario;
SELECT * FROM Natuterra;
SELECT * FROM Entrega;
SELECT * FROM Produto;
SELECT * FROM NotaFiscal;



