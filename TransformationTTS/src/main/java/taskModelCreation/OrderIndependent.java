package taskModelCreation;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class OrderIndependent {

		
		private HamstersAPI hamAPI;
		
		public OrderIndependent()
		{
			hamAPI = new HamstersAPI("OrderIndependent 1");
			HamstersOperator operator = new HamstersOperator();
			operator.setType(OperatorType.ORDER_INDEPENDENT);
			hamAPI.addHamstersNode(operator);
			
			
			HamstersTask task1 = new HamstersTask();
			task1.setType(TaskType.USER);
			task1.setHelpText("Tache noeud numero 1");
			HamstersTask task2 = new HamstersTask();
			task2.setType(TaskType.USER);
			task2.setHelpText("Tache noeud numero 2");
			HamstersTask task3 = new HamstersTask();
			task3.setType(TaskType.USER);
			task3.setHelpText("Tache noeud numero 3");
			operator.addChild(task1);
			operator.addChild(task2);
			operator.addChild(task3);
			
//			HamstersTask task3 = new HamstersTask();
//			task3.setType(TaskType.USER);
//			task3.setHelpText("Tache Feuille numero 1");
//			HamstersTask task4 = new HamstersTask();
//			task4.setType(TaskType.USER);
//			task4.setHelpText("Tache Feuille numero 2");
//			task1.addChild(task3);
//			task2.addChild(task4);
		}
		public HamstersAPI getAPI() {
			return hamAPI;
		}
}
