package fr.projectM1.frozenhand.TransformationTTS;

import org.junit.Before;
import org.junit.Test;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;
import statechartsInXML.WriteFile;
import translationTaskModelToStachart.TaskModelTranslation;

/**
 * Choice
 * Cette Classe Junit permet de faire un test unitaire de l'opérateur choice
 * @author frozenhandgroup
 *
 */
public class Choice {
	
	private HamstersAPI hamAPI;
	
		
		@Before 
		public void setUP() {
		hamAPI = new HamstersAPI("Choice 1");
		HamstersOperator operator = new HamstersOperator();
		operator.setType(OperatorType.CHOICE);
		hamAPI.addHamstersNode(operator);
		
		
		HamstersTask task1 = new HamstersTask();
		task1.setType(TaskType.USER);
		task1.setDescription("Tache Feuille numero 1");
		HamstersTask task2 = new HamstersTask();
		task2.setType(TaskType.USER);
		task2.setDescription("Tache Feuille numero 2");
		HamstersTask task3 = new HamstersTask();
		task3.setType(TaskType.USER);
		task3.setDescription("Tache Feuille numero 3");
		HamstersTask task4 = new HamstersTask();
		task4.setType(TaskType.USER);
		task4.setDescription("Tache Feuille numero 4");
		
		operator.addChild(task1);
		operator.addChild(task2);
		operator.addChild(task3);
		operator.addChild(task4);
		
	}
		

	/**
	 * Test de l'enregistrement du fichier Après le test sur l'opérateur choice
	 */
		@Test
		public  void testCH (){
			try {
				WriteFile.main(TaskModelTranslation.Transform(hamAPI),".\\tests\\Choice");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		/**
		 *  retourne un HamsterAPI
		 * @return un HamstersAPI
		 */
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}
