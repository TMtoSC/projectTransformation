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
 * Enable
 * Cette Classe Junit permet de faire un test unitaire de l'opérateur Enable
 * @author frozenhandgroup
 *
 */
public class Enable {
	
	private HamstersAPI hamAPI;
	@Before
	public void setUP()
	{
		hamAPI = new HamstersAPI("Sequence 1");
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
	}
	
	/**
	 * Test de l'enregistrement du fichier
	 * Après le test sur l'opérateur enable
	 */
	@Test
	public  void testEN (){
		try {
			WriteFile.main(FactoryTransformation.Transform(hamAPI),".\\tests\\Enable");
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
