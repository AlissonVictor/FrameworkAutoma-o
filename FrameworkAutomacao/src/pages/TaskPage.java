package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class TaskPage extends BasePage {

	public void criarTask () {
		
		cliqueBotaoBy(By.id("insert-button"));
		
	}
		
	public void preencherCampos () {
		
		escreva("title", "Teste Automação");
		escreva("dueDate", "13/04/2019");
		escreva(By.xpath("//*[@id=\"add-task\"]/div[4]/div/div/input"), "Selenium");
		cliqueBotaoBy(By.id("form-submit-button"));
	}
	
	public void editarCampos () {
		
		
		
	}
}
