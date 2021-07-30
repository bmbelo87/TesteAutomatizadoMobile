package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.ClockPage;
import static utils.Utils.*;

import java.util.List;

public class ClockSteps {

	ClockPage c = new ClockPage(driver);

	@Dado("que o usuario acione o menu Alarme")
	public void acionarOMenuAlarme() throws Exception {
		c.acessarMenuAlarme();
	}

	@Quando("o usuario acionar o botao Adicionar Alarme")
	public void oUsuarioAcionarOBotaoAdicionarAlarme() throws Exception {
		c.acionarBotaoNovoAlarme();
	}

	@Quando("configurar a hora para {string}, {string}")
	public void configurarAHoraPara(String hora, String periodo) throws Exception {
		
		String tempo [] = hora.split(":");
		String horaA = tempo[0];
		String minutos = tempo[1];
		
		c.clicarNaHora(horaA);
		c.clicarNoMinuto(minutos);
		c.selecionarOPeriodo(periodo);
		c.acionarBotaoOK();
	}

	@Entao("o app adiciona um novo alarme com as informacoes:")
	public void oAppAdicionaUmNovoAlarmeComAsInformacoes(List<String> dados) {
		c.validarInformacoes(dados);
	}

	
}
