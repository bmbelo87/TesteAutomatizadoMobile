package pageObjects;

import static org.junit.Assert.assertEquals;
import static utils.Utils.driver;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClockPage {
	
	public ClockPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ALARM']")
	private MobileElement botaoAlarme;

	@AndroidFindBy(accessibility = "Add alarm")
	private MobileElement botaoAdd;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoOk;

	@AndroidFindBy(id = "com.google.android.deskclock:id/edit_label")
	private MobileElement campoLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement campoEditText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Default (Cesium)']")
	private MobileElement textoCombo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Barium']")
	private MobileElement opcaoCombo;

	@AndroidFindBy(xpath = "//android.widget.Switch[@text='ON'][1]")
	private MobileElement switchApp;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Repeat']")
	private MobileElement check;

	public void acessarMenuAlarme() throws Exception {
		System.out.println("Acessando o menu alarme");
		botaoAlarme.click();
	}

	public void acionarBotaoNovoAlarme() throws Exception {
		System.out.println("adicionando novo alarme");
		botaoAdd.click();
	}

	public void acionarBotaoOK() throws Exception {
		botaoOk.click();
	}

	public void interagirComEditText() throws Exception {
		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		System.out.println("interagindo com edit text");
		campoLabel.click();

		campoEditText.sendKeys("Novo Alarme");
	}

	public void interagirComCombo() throws Exception {
		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		System.out.println("Interagindo com Combo");
		textoCombo.click();
		opcaoCombo.click();
	}

	public void interagindoComSwitch() throws Exception {
		System.out.println("interagindo com o switch");
		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		switchApp.click();
		Thread.sleep(2000);

		assertEquals("false", switchApp.getAttribute("checked"));
	}

	public void interagindoComCheckBox() throws Exception {
		acessarMenuAlarme();
		acionarBotaoNovoAlarme();

		check.click();
		assertEquals("true", check.getAttribute("checked"));
	}

	public void clicarNaHora(String hora) throws Exception {
		MobileElement clickHora = (MobileElement) driver.findElement(MobileBy.AccessibilityId(hora));
		clickHora.click();

	}

	public void clicarNoMinuto(String minuto) throws Exception {
		MobileElement clickMinuto = (MobileElement) driver.findElement(MobileBy.AccessibilityId(minuto));
		clickMinuto.click();

	}

	public void selecionarOPeriodo(String periodo) throws Exception {
		// android:id/am_label
		String periodoModificado = periodo.toLowerCase();
		MobileElement clickPeriodo = (MobileElement) driver
				.findElement(MobileBy.id("android:id/" + periodoModificado + "_label"));
		clickPeriodo.click();

	}
	
	public void validarInformacoes(List<String> dados) {
		
		MobileElement infos;
		
		for (String info : dados ) { 
			infos = (MobileElement) driver.findElement(MobileBy.xpath("//*[@text='"+info+"']"));
			System.out.println("Infos tela: "+ infos.getText());
			assertEquals(info, infos.getText());
		}
		
	}

}
