# tqi_evolution_backend_2021 ![GitHub Workflow Status](https://img.shields.io/github/workflow/status/andersonmeurer/tqi_evolution_backend_2021/CI)

Não pense que é capaz. Saiba que é.
Dado o cenário abaixo, elabore uma sugestão para o back-end necessária para resolver o problema.
Use a criatividade! Você pode explorar aqui todos os seus conhecimentos, demonstrando fluxos, telas, protótipos e/ou codificação.
É importante sabermos por que você decidiu fazer a solução, portanto deixe clara a motivação das suas escolhas.

Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:

OK - i. Cadastro de clientes
    O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.

ii. Login
    A autenticação será realizada por e-mail e senha.

OK - iii. Solicitação de empréstimo
    Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
    O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.

iv. Acompanhamento das solicitações de empréstimo
    O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
    Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
    No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

Restrições
1. A implementação deve utilizar linguagem Java ou Kotlin.
2. Use todos os seus conhecimentos adquiridos no bootcamp para explorar bem a solução. Não se preocupe, porque não existe certo ou errado. Só queremos conhecer um pouco mais sobre você.
3. Utilize o GitHub para repositório de código.

O prazo máximo para finalizar esta implementação é 10/01/2022. Portanto, explore bem este tempo!

Quando finalizar, você deve criar uma tag no GitHub chamada tqi_evolution_avaliacao. Desta forma, nosso time já irá avaliar o material final.

Bora pra este desafio?

----------------------------
localhost:8080/cliente
{
    "nome": "Anderson",
    "cpf": "05184611908",
    "rg": "48382027",
    "endereco": "Endereco teste",
    "renda": 1000,
    "email": "andersonmeurerr@gmail.com",
    "senha": "123"
}

localhost:8080/solicitaremprestimo:
{
    "idCliente":1,
    "valorTotal": "60000",
    "numeroPacelas": 60,
    "dataPrimeiraParcela": "01/04/2022"
}


