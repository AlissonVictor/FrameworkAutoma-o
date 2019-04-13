package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.TaskPage;
import core.BasePage;

public class Tasks extends BaseTest {

	TaskPage tp = new TaskPage();
	
@Test
	public void criarTask() {
	
	tp.criarTask();
	tp.preencherCampos();
	
	//Assert.assertEquals(expected, actual);
}

//@Test
	public void editartarefa() {
	tp.criarTask();
	tp.preencherCampos();
}
	
}
