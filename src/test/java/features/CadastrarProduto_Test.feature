Feature: Cadastrar Produto
  Cadastrar produtos

  Background:
    Given O cadastro do usuario Ernani Cesar foi realizado

  Scenario: Cadastrar Produto com Sucesso
    Given O nome do produto "Bola de futebol"
    And   A descricao do produto "Oficial Fifa"
    And   Valor minimo eh 1.2
    And   CPF do leiloador eh "111.111.111-11"
    And   A data limite do produto no leilao eh "24/06/2023"
    When  O produto eh cadastrado
    Then  O produto eh incluido com sucesso

  Scenario: Cadastrar produto com mesmo nome gera erro
    Given O produto Bola de futebol
    Given O nome do produto "Bola de futebol"
    And   A descricao do produto "Oficial Fifa"
    And   Valor minimo eh 1.2
    And   CPF do leiloador eh "111.111.111-11"
    And   A data limite do produto no leilao eh "24/06/2023"
    When  Jah existe um produto com o mesmo nome
    Then  Eh recebida uma mensagem informando que jah existe um produto cadastrado
