package acceptanceTests.cucumberSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.interfaces.IMercadoLeilao;
import org.example.modelo.MercadoLeilao;
import org.junit.Assert;

public class CadastrarUsuarioTest {
	public String nome = "";
	public String endereco = "";
	public String cpf = "";
	public String email = "";
	public Boolean cadastro = false;
	public static IMercadoLeilao mercado = new MercadoLeilao();

	@Given("^O nome de usuario \"([^\"]*)\"$")
	public void o_nome_de_usuario(String arg1) {
		this.nome = arg1;
	}

	@Given("^o endereco \"([^\"]*)\"$")
	public void o_endereco(String arg1) {
		this.endereco = arg1;
	}

	@Given("^e o CPF \"([^\"]*)\"$")
	public void e_o_CPF(String arg1) throws Throwable {
		this.cpf = arg1;
	}

	@Given("^e o e-mail \"([^\"]*)\"$")
	public void e_o_e_mail(String arg1) throws Throwable {
		this.email = arg1;
	}

	@When("^O usuario eh cadastrado$")
	public void o_usuario_eh_cadastrado() throws Throwable {
		try {
			System.out.println("vou cadastrar o usuario agora");
			mercado.cadastrarUsuario(this.nome, this.endereco, this.email, this.cpf);
			cadastro = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^O usuario eh incluido com sucesso$")
	public void o_usuario_eh_incluido_com_sucesso() throws Throwable {
		Assert.assertTrue(cadastro);
	}
}
