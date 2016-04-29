package taskModelCreation;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class Choice {
	
	private HamstersAPI hamAPI;
	
	public Choice()
	{
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
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}
