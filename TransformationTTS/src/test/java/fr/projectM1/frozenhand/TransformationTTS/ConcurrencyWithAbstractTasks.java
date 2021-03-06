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
 * ConcurrencyWithAbstractTask
 * cette classe sert à tester l'opérateur choice avec une tâche abstraite
 * @author frozenhandgroup
 *
 */
public class ConcurrencyWithAbstractTasks {
	HamstersAPI hamAPI;
	@Before
	public void setUP() {
	hamAPI = new HamstersAPI("Concurrency 1");
	HamstersTask firstTask = new HamstersTask();
	firstTask.setType(TaskType.ABSTRACT);
	hamAPI.addHamstersNode(firstTask);
	HamstersOperator operator = new HamstersOperator();
	operator.setType(OperatorType.CONCURRENT);
	firstTask.addChild(operator);
	
	/**
	 * Création tâche 1 feuille 
	 */
	HamstersTask task1 = new HamstersTask();
	task1.setType(TaskType.USER);
	operator.addChild(task1);
	/**
	 * Création tâche 2 séquence
	 * 
	 */
	HamstersTask task2 = new HamstersTask();
	task2.setType(TaskType.ABSTRACT);
	HamstersOperator opseq = new HamstersOperator();
	opseq.setType(OperatorType.ENABLE);
	task2.addChild(opseq);
	HamstersTask ena1 = new HamstersTask();
	HamstersTask ena2 = new HamstersTask();
	ena1.setDescription("Enable 1");
	ena2.setDescription("Ena 2");
	ena1.setType(TaskType.MOTOR);
	ena2.setType(TaskType.MOTOR);
	opseq.addChild(ena1);
	opseq.addChild(ena2);
	/**
	 * création tâche 3 choix
	 * 
	 */
	HamstersOperator opchoice = new HamstersOperator();
	opchoice.setType(OperatorType.CHOICE);
	HamstersTask choi1 = new HamstersTask();
	HamstersTask choi2 = new HamstersTask();
	choi1.setDescription("Choice 1");
	choi2.setDescription("Choice 2");
	opchoice.addChild(choi1);
	opchoice.addChild(choi2);
	
	/**
	 * ajout dans la concurrence
	 */
	operator.addChild(task1);
	operator.addChild(task2);
	operator.addChild(opchoice);
	}

	/**
	 * Test de l'enregistrement du fichier
	 * Après le test sur l'opérateur concurrency
	 */
	@Test
	public  void testCWE (){
		try {
			WriteFile.main(TaskModelTranslation.Transform(hamAPI),".\\tests\\ConcurrencyWithAbstractTask");
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
		// TODO Auto-generated method stub
		return hamAPI;
	}
}
