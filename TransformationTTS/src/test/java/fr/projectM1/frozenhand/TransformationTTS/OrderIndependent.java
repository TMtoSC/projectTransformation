package fr.projectM1.frozenhand.TransformationTTS;

import org.junit.Before;

import Factory.FactoryTransformation;
import TranslationSCT.WriteFile;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
public class OrderIndependent {
		HamstersAPI hamAPI;
		
			@Before 
			public void initTest() {
		
			hamAPI = new HamstersAPI("OrderIndependent 1");
			HamstersOperator operator = new HamstersOperator();
			operator.setType(OperatorType.ORDER_INDEPENDENT);
			hamAPI.addHamstersNode(operator);
			
			
			HamstersTask task1 = new HamstersTask();
			task1.setType(TaskType.USER);
			task1.setDescription("Tache noeud numero 1");
			HamstersTask task2 = new HamstersTask();
			task2.setType(TaskType.USER);
			task2.setDescription("Tache noeud numero 2");
			HamstersTask task3 = new HamstersTask();
			task3.setType(TaskType.USER);
			task3.setDescription("Tache noeud numero 3");
			HamstersTask task4 = new HamstersTask();
			task4.setType(TaskType.USER);
			task4.setDescription("Tache noeud numero 4");
			operator.addChild(task1);
			operator.addChild(task2);
			operator.addChild(task3);
			operator.addChild(task4);

			}
		
		

	@Test
	public void TestOI() {
		fr.projectM1.frozenhand.TransformationTTS.OrderIndependent o = new OrderIndependent();
		try {
			WriteFile.main(FactoryTransformation.Transform(hamAPI), ".\\tests\\OrderIndependant");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}
