package taskModelCreation;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class Enable2 {

	private HamstersAPI hamAPI;

	public Enable2()
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
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}