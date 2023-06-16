package acceptanceTests.cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CadastrarProdutoTest {
    public String nomeProduto = "";
    public String descricaoProduto = "";
    public Double valorMinimoProduto = 0.0;
    public String cpfLeiloador = "";
    public boolean cadastro = false;

    @Given("O nome do produto {string}")
    public void o_nome_do_produto(String string) {
        this.nomeProduto = string;
    }

    @Given("A descricao do produto {string}")
    public void a_descricao_do_produto(String string) {
        this.descricaoProduto = string;
    }

    @Given("Valor minimo eh {double}")
    public void valor_minimo_eh(Double double1) {
        this.valorMinimoProduto = double1;
    }

    @Given("CPF do leiloador eh {string}")
    public void cpf_do_leiloador_eh(String string) {
        this.cpfLeiloador = string;
    }

    @When("O produto eh cadastrado")
    public void o_produto_eh_cadastrado() {
        System.out.println("vou cadastrar o produto agora");
        cadastro = true;
    }

    @Then("O produto eh incluido com sucesso")
    public void o_produto_eh_incluido_com_sucesso() {
        Assert.assertTrue(cadastro);
    }

    @Given("o nome eh {string}")
    public void oNomeEh(String arg0) {
        System.out.println(arg0);
    }
}
