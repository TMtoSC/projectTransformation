package taskModelCreation;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class Enable {
	
	private HamstersAPI hamAPI;
	
	public Enable()
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
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}
