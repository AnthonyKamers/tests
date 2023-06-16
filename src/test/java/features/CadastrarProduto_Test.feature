Feature: Cadastrar Produto
  Cadastrar produtos

  Background:
    Given O nome de usuario "Joao da silva"
    And o endereco "Campus Universitario"
    And e o CPF "111.111.111-11"
    And e o e-mail "teste@teste.com.br"
    When O usuario eh cadastrado
    Then O usuario eh incluido com sucesso

  Scenario: Cadastrar Produto com Sucesso
    Given O nome do produto "Bola de futebol"
    And   A descricao do produto "Oficial Fifa"
    And   Valor minimo eh 1.2
    And   CPF do leiloador eh "111.111.111-11"
    When  O produto eh cadastrado
    Then  O produto eh incluido com sucesso

  Scenario: Teste
    Given o nome eh "teste"
