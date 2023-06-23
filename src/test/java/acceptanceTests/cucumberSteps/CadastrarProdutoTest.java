package acceptanceTests.cucumberSteps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.interfaces.IMercadoLeilao;
import org.example.modelo.MercadoLeilao;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CadastrarProdutoTest {
    public String nomeProduto = "";
    public String descricaoProduto = "";
    public Double valorMinimoProduto = 0.0;
    public String cpfLeiloador = "";
    public Date dataLimiteProduto;
    public boolean cadastro = false;
    public boolean expectedError = false;
    public static IMercadoLeilao mercado = new MercadoLeilao();

    // Background
    @Given("O cadastro do usuario Ernani Cesar foi realizado")
    public void oCadastroDoUsuarioErnaniCesarFoiRealizado() throws Exception {
        String nome = "Ernani Cesar";
        String endereco = "Camus Universitário";
        String CPF = "111.111.111-11";
        String email = "ernani.santos@posgrad.ufsc.br";
        mercado.cadastrarUsuario(nome, endereco, email, CPF);
    }

    // Scenario: Cadastrar Produto com Sucesso

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

    @And("A data limite do produto no leilao eh {string}")
    public void aDataLimiteDoProdutoNoLeilaoEh(String dateString) {
        LocalDate teste = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.dataLimiteProduto = Date.from(teste.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @When("O produto eh cadastrado")
    public void o_produto_eh_cadastrado() {
        try {
            mercado.cadastrarProduto(nomeProduto, descricaoProduto, valorMinimoProduto, cpfLeiloador, dataLimiteProduto);
            cadastro = true;
            mercado = new MercadoLeilao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("O produto eh incluido com sucesso")
    public void o_produto_eh_incluido_com_sucesso() {
        Assert.assertTrue(cadastro);
    }

    // Scenario:
    @Given("o nome eh {string}")
    public void oNomeEh(String arg0) {
        System.out.println(arg0);
    }

    @Given("O produto Bola de futebol")
    public void oProdutoBolaDeFutebol() {
        try {
            String nome = "Bola de futebol";
            String descricao = "";
            Double valorMinimo = 1.2;
            String cpf = "111.111.111-11";
            Date date = new Date();
            mercado.cadastrarProduto(nome, descricao, valorMinimo, cpf, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("Jah existe um produto com o mesmo nome")
    public void jahExisteUmProdutoComOMesmoNome() {
        try {
            mercado.cadastrarProduto(nomeProduto, descricaoProduto, valorMinimoProduto, cpfLeiloador, dataLimiteProduto);
        } catch (Exception e) {
            if (e.getMessage().equals("O produto ja existe ou o leiloador nao esta cadastrado."))
                expectedError = true;
        }
    }

    @Then("Eh recebida uma mensagem informando que jah existe um produto cadastrado")
    public void ehRecebidaMensagemJahExisteProduto() {
        Assert.assertTrue(expectedError);
    }
}
