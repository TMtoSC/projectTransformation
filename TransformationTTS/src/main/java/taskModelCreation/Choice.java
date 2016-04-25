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
		hamAPI = new HamstersAPI("Sequence 1");
		HamstersOperator operator = new HamstersOperator();
		operator.setType(OperatorType.CHOICE);
		hamAPI.addHamstersNode(new HamstersOperator());
		
		HamstersTask task1 = new HamstersTask();
		task1.setType(TaskType.USER);
		task1.setHelpText("Tache Feuille numero 1");
		HamstersTask task2 = new HamstersTask();
		task2.setType(TaskType.USER);
		task2.setHelpText("Tache Feuille numero 2");
		HamstersTask task3 = new HamstersTask();
		task3.setType(TaskType.USER);
		task3.setHelpText("Tache Feuille numero 3");
		HamstersTask task4 = new HamstersTask();
		task4.setType(TaskType.USER);
		task4.setHelpText("Tache Feuille numero 4");
	}

}
