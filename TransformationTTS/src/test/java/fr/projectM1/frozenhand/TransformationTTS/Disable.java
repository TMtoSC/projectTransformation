package fr.projectM1.frozenhand.TransformationTTS;

import org.junit.Before;
import org.junit.Test;

import Factory.FactoryTransformation;
import TranslationSCT.WriteFile;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class Disable {

	private HamstersAPI hamAPI;
	
	@Before
	public void serUP(){
		hamAPI = new HamstersAPI("Disable 1");
		HamstersOperator operator = new HamstersOperator();
		operator.setType(OperatorType.DISABLE);
		hamAPI.addHamstersNode(operator);
		
		HamstersTask task1 = new HamstersTask();
		task1.setType(TaskType.USER);
		task1.setDescription("Tache désactivante");
		
		HamstersTask task3 = new HamstersTask();
		task3.setType(TaskType.USER);
		task3.setDescription("Tache Feuille numero 1");
		HamstersTask task4 = new HamstersTask();
		task4.setType(TaskType.USER);
		task4.setDescription("Tache Feuille numero 2");
	
		HamstersOperator opEn = new HamstersOperator();
		opEn.setType(OperatorType.ENABLE);
		operator.addChild(opEn);
		operator.addChild(task1);
		
		opEn.addChild(task3);
		opEn.addChild(task4);
		
		
	}
	@Test
	public  void testDI (){
		try {
			WriteFile.main(FactoryTransformation.Transform(hamAPI),".\\tests\\Disable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}
