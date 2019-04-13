package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class Inicializacao extends BasePage {

	public void abrirSite () {
		
		abrirURL("https://mark7.herokuapp.com/login");
	}

	public void logar () {
		
		escreva("login_email", "alissonvictor.ss@outlook.com");
		escreva("login_password", "testes");
		cliqueBotaoBy(By.id("lockedtop_0$ctl07$lockedtop_0$btnLoginctl07$lockedtop_0$ctl05$"));
	}
	
}
