package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void abrirURL (String url) {
		
		getDriver().get(url);
				
	}
	
	public void escreva(By Locator, String Texto) {

		getDriver().findElement(Locator).clear();
		getDriver().findElement(Locator).sendKeys(Texto);

	}

	public void escreva(String Id, String Texto) {

		escreva(By.id(Id), Texto);

	}

	public String obterValorInput(String Id) {

		return getDriver().findElement(By.id(Id)).getAttribute("value");

	}

	public String obterValorTexto(String Texto) {

		return getDriver().findElement(By.id(Texto)).getText();

	}

	/**** area de cliques ****/

	public void cliqueRadio(String Id) {

		getDriver().findElement(By.id(Id)).click();

	}

	public void cliqueCheckBox(String Id) {

		getDriver().findElement(By.id(Id)).click();
	}

	public boolean verificarClique(String Id) {

		return getDriver().findElement(By.id(Id)).isSelected();

	}

	public void cliqueBotao(String NomeBotao) {

		getDriver().findElement(By.xpath("//input[@value='" + NomeBotao + "']")).click();

	}
	
	public void cliqueBotaoBy(By Locator) {
		
		getDriver().findElement(Locator);
	}

	/**** area de selects ****/

	public void selecionarCombo(String Id, String Valor) {

		WebElement elemento = getDriver().findElement(By.id(Id));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(Valor);

	}

	/**** area de deselecionar opção ****/

	public void deselecionarCombo(String Id, String Valor) {

		WebElement elemento = getDriver().findElement(By.id(Id));
		Select combo = new Select(elemento);
		combo.deselectByValue(Valor);

	}

	public String obterValorDoCombo(String Id) {

		WebElement elemento = getDriver().findElement(By.id(Id));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();

	}

	public List<String> obterValoresDoCombo(String Id) {

		WebElement elemento = getDriver().findElement(By.id(Id));
		Select combo = new Select(elemento);
		List<WebElement> lista = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : lista) {

			valores.add(opcao.getText());

		}

		return valores;
	}

	public int obterQuantidadeDeOpcoesDoCombo(String Id) {

		WebElement elemento = getDriver().findElement(By.id(Id));
		Select combo = new Select(elemento);
		List<WebElement> lista = combo.getOptions();
		return lista.size();
	}

	public boolean verificarOpcaoCombo(String Id, String Texto) {

		WebElement elemento = getDriver().findElement(By.id(Id));
		Select combo = new Select(elemento);
		List<WebElement> lista = combo.getOptions();

		for (WebElement opcao : lista) {

			if (opcao.getText().equals(Texto)) {

				return true;
			}

		}

		return false;

	}

	/**** area de alerta ****/

	public String alertaObterTexto() {

		Alert alerta = getDriver().switchTo().alert();
		return alerta.getText();

	}

	public String alertaObterTextoEAceitar() {

		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.accept();
		return valor;

	}

	public String alertaObterTextoENegar() {

		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.dismiss();
		return valor;

	}

	public void alertaEscrever(String Texto) {

		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.sendKeys(Texto);
		alerta.accept();

	}

	/**** area de frames e janelas ****/

	public void entrarFrame(String Id) {

		getDriver().switchTo().frame(Id);

	}

	public void sairFrame() {

		getDriver().switchTo().defaultContent();

	}

	public void trocarJanela(String Id) {

		getDriver().switchTo().window(Id);

	}

/**** area de tabela ****/
	
	public void interagirComTabela (int indiceBusca, int indiceInteracao, String valor, String valorBusca, String acao) {
		
		String xpath = "//tbody/tr[td["+indiceBusca+"]='"+valorBusca+"']/td["+indiceInteracao+"]/input";
		WebElement tabela = getDriver().findElement(By.xpath(xpath));
		
		switch(acao) {
		
		case "click": tabela.click();
		break;
		case "escrever": tabela.sendKeys(valor);
		break;

		default: System.out.println("Ação Inválida");
		
		} 
	}
}
