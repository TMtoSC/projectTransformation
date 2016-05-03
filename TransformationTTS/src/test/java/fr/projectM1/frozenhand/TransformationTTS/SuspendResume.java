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
 * SuspendResume
 * Cette Classe Junit permet de faire un test unitaire de l'opérateur SuspendResume
 * @author frozenhandgroup
 *
 */
public class SuspendResume {

		
		private HamstersAPI hamAPI;
		@Before
		public void setUP()	{
			hamAPI = new HamstersAPI("SuspendResume 1");
			HamstersOperator operator = new HamstersOperator();
			operator.setType(OperatorType.SUSPEND_RESUME);
			hamAPI.addHamstersNode(operator);
			
			
			HamstersTask task1 = new HamstersTask();
			task1.setType(TaskType.USER);
			task1.setDescription("Tache désactivée et resume");
			HamstersTask task2 = new HamstersTask();
			task2.setType(TaskType.USER);
			task2.setDescription("Tache désactivante");
			operator.addChild(task1);
			operator.addChild(task2);
		}
		
		/**
		 *  retourne un HamsterAPI
		 * @return un HamstersAPI
		 */
		public HamstersAPI getAPI() {
			return hamAPI;
		}
		
		/**
		 * Test de l'enregistrement du fichier
		 * Après le test sur l'opérateur suspendResume
		 */
		@Test
		public  void testSR (){
			try {
				WriteFile.main(TaskModelTranslation.Transform(hamAPI),".\\tests\\SuspendResume");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
