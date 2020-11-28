Projeto da Disciplica de Desenvolvimentod e Software sistema para vendas e pagamentos de titulo via API RESTFULL em sprint boot JAVA

PARA SALVAR UMA VENDA
POST - http://localhost:8080/salvarVenda
{
    "Cliente":{
        "CPF": "10073870927",
        "Nome": "Eduardo",
        "Telefone": "41 991791086"

    },
    "Vendedor":{
        "CPF": "888",
        "Nome": "Joaozinho"
    },
    "Titulo":{
        "DataCriação": "27/11/2020",
        "DataVencimento": "01/01/2021",
        "DataPagamento": "01/01/2020",
        "Valor": 31.90,
        "Situacao": "pendente"
    },
    
    "ProdutosVenda":[{
        "Nome": "Coxinha de Frango",
        "Quantidade": 2,
        "Preco": 1.90

    },
    {
        "Nome": "Pastel de Frango",
        "Quantidade": 1,
        "Preco": 2.10

    }
    ]
}
-----------------------------
PARA OBTER TITULOS INFORME O  CPF DO CLIENTE, O ENVIO DA REQUISIÇÃO DEVE SER DO TIPO TEXT
POST - http://localhost:8080/getTitulos 

-------------------------------
PARA PAGAMENTO DO TITULO INFORME O CODIGO DO BOLETO OBTIDO PELA CONSULTA DE TITULOS, O ENVIO DA REQUISIÇÃO DEVE SER DO TIPO TEXT
POST - http://localhost:8080/getTitulos 

