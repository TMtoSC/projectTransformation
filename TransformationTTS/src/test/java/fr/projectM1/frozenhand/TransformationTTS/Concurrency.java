package fr.projectM1.frozenhand.TransformationTTS;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class Concurrency {
	
	private HamstersAPI hamAPI;
	
	public Concurrency()
	{	hamAPI = new HamstersAPI("Concurrency 1");
		HamstersOperator operator = new HamstersOperator();
		operator.setType(OperatorType.CONCURRENT);
		hamAPI.addHamstersNode(operator);
		
		/**
		 * tache 1
		 */
		HamstersTask task1 = new HamstersTask();
		task1.setType(TaskType.USER);
		task1.setDescription("Tache Feuille numero 1");
		/**
		 * tache 2
		 */
		HamstersTask task2 = new HamstersTask();
		task2.setType(TaskType.USER);
		task2.setDescription("Tache Feuille numero 2");
		/**
		 * tache 3
		 */
		HamstersTask task3 = new HamstersTask();
		task3.setType(TaskType.USER);
		task3.setDescription("Tache Feuille numero 3");
		/**
		 * tache 4
		 */
		HamstersTask task4 = new HamstersTask();
		task4.setType(TaskType.USER);
		task4.setDescription("Tache Feuille numero 4");
		/**
		 * tache 5
		 */
		HamstersTask task5 = new HamstersTask();
		task5.setType(TaskType.USER);
		task5.setDescription("Tache Feuille numero 5");
		/**
		 * tache 6
		 */
		HamstersTask task6 = new HamstersTask();
		task6.setType(TaskType.USER);
		task6.setDescription("Tache Feuille numero 6");
		/**
		 * ajout operator
		 */
		operator.addChild(task1);
		operator.addChild(task2);
		operator.addChild(task3);
		operator.addChild(task4);
		operator.addChild(task5);
		operator.addChild(task6);
	}
	public HamstersAPI getAPI() {
		return hamAPI;
	}
}
