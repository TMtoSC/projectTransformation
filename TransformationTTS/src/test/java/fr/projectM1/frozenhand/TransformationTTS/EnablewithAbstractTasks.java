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
 * EnableWithAbstractTask
 * cette classe sert à tester l'opérateur choice avec une tâche abstraite
 * @author frozenhandgroup
 *
 */
public class EnablewithAbstractTasks {

	private HamstersAPI hamAPI;
	@Before
	public void setUP()
	{
		hamAPI = new HamstersAPI("Sequence 2");
		HamstersOperator operator = new HamstersOperator();
		HamstersTask task = new HamstersTask();
		task.setHelpText("tache abstraite");
		hamAPI.addHamstersNode(task);
		operator.setType(OperatorType.ENABLE);
		task.addChild(operator);


		HamstersTask task1 = new HamstersTask();
		task1.setType(TaskType.USER);
		task1.setDescription("Tache Feuille numero 1");
		HamstersTask task2 = new HamstersTask();
		task2.setType(TaskType.USER);
		task2.setDescription("Tache Feuille numero 2");
		operator.addChild(task1);
		operator.addChild(task2);

		HamstersTask task11 = new HamstersTask();
		task11.setType(TaskType.USER);
		task11.setDescription("tache fils feuille 1");
		HamstersTask task12 = new HamstersTask();
		task12.setType(TaskType.USER);
		task12.setDescription("tache fils 2 feuille 1");

		HamstersOperator op = new HamstersOperator();
		op.setType(OperatorType.ENABLE);
		operator.addChild(op);
		op.addChild(task11);
		op.addChild(task12);
	}
	
	/**
	 * Test de l'enregistrement du fichier
	 * Après le test sur l'opérateur enable
	 */
	@Test
	public  void testENWAT (){
		try {
			WriteFile.main(FactoryTransformation.Transform(hamAPI),".\\tests\\EnableWithAbstractTask");
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