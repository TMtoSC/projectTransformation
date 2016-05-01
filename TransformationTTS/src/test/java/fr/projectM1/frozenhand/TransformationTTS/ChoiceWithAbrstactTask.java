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

/**
 * ChoiceWithAbstractTask
 * cette classe sert à tester l'opérateur choice avec une tâche abstraite
 * @author frozenhandgroup
 *
 */
public class ChoiceWithAbrstactTask {
	
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
		
		HamstersOperator operatorfils = new HamstersOperator();
		operatorfils.setType(OperatorType.CHOICE);
		operator.addChild(operatorfils);
		
		HamstersTask task11 = new HamstersTask();
		task11.setType(TaskType.USER);
		task11.setDescription("Tache Enfant numero 1");
		HamstersTask task12 = new HamstersTask();
		task12.setType(TaskType.USER);
		task12.setDescription("Tache Enfant numero 2");
		HamstersTask task13 = new HamstersTask();
		task13.setType(TaskType.USER);
		task13.setDescription("Tache Enfant numero 3");
		HamstersTask task14 = new HamstersTask();
		task14.setType(TaskType.USER);
		task14.setDescription("Tache Enfant numero 4");
		
		operatorfils.addChild(task11);
		operatorfils.addChild(task12);
		operatorfils.addChild(task13);
		operatorfils.addChild(task14);
		}
		
		/**
		 * Test de l'enregistrement du fichier
		 * Après le test sur l'opérateur choice
		 */
		@Test
		public  void testCHabstract (){
			try {
				WriteFile.main(FactoryTransformation.Transform(hamAPI),".\\tests\\ChoiceWithAbstractTask");
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
