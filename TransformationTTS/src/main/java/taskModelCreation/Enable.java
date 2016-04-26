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
		operator.setType(OperatorType.ENABLE);
		hamAPI.addHamstersNode(new HamstersOperator());
		
		
		HamstersTask task1 = new HamstersTask();
		task1.setType(TaskType.USER);
		task1.setHelpText("Tache Feuille numero 1");
		HamstersTask task2 = new HamstersTask();
		task2.setType(TaskType.USER);
		task2.setHelpText("Tache Feuille numero 2");
		operator.addChild(task1);
		operator.addChild(task2);
	}

}