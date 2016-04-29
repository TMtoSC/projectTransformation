package taskModelCreation;

import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;
import hamsters.TaskType;

public class WXR {
	
	private HamstersAPI hamAPI;
	
	public WXR(){
		
		// profondeur 0 
		hamAPI = new HamstersAPI("WXR");
		HamstersOperator op = new HamstersOperator();
		HamstersTask task = new HamstersTask();
		task.setDescription("manage WXR");
		task.setType(TaskType.ABSTRACT);
		hamAPI.addHamstersNode(task);
		op.setType(OperatorType.DISABLE);
		task.addChild(op);
		
		//profondeur 1
		HamstersTask decideWXRIsReady = new HamstersTask();
		decideWXRIsReady.setType(TaskType.COGNITIVE);
		HamstersTask setupWXR = new HamstersTask();
		setupWXR.setType(TaskType.ABSTRACT);
		op.addChild(setupWXR);
		op.addChild(decideWXRIsReady);
		
		//profondeur 2
		HamstersOperator op1 = new HamstersOperator();
		op1.setType(OperatorType.CONCURRENT);
		setupWXR.addChild(op);
		HamstersTask manageMode = new HamstersTask();
		manageMode.setType(TaskType.ABSTRACT);
		HamstersTask manageTiltAngle = new HamstersTask();
		manageTiltAngle.setType(TaskType.ABSTRACT);
		op1.addChild(manageMode);
		op1.addChild(manageTiltAngle);
		
		//profondeur 3 manageMode
		
		HamstersOperator op2 = new HamstersOperator();
		op2.setType(OperatorType.DISABLE);
		manageMode.addChild(op2);
		HamstersOperator op3 = new HamstersOperator();
		op3.setType(OperatorType.ENABLE);
		op2.addChild(op3);
		
		HamstersTask decideModeIsCorrect = new HamstersTask();
		decideModeIsCorrect.setType(TaskType.COGNITIVE);
		op2.addChild(decideModeIsCorrect);
		
		//profondeur 3 manageTiltAngle
		HamstersOperator op4 = new HamstersOperator();
		op4.setType(OperatorType.ENABLE);
		manageTiltAngle.addChild(op4);
		
		HamstersTask decideChangeTiltAngle = new HamstersTask();
		decideChangeTiltAngle.setType(TaskType.COGNITIVE);
		op4.addChild(decideChangeTiltAngle);
		
		HamstersTask changeTiltAngle = new HamstersTask();
		changeTiltAngle.setType(TaskType.ABSTRACT);
		op4.addChild(changeTiltAngle);
		
		//profondeur 4 manageMode
		HamstersTask decideChangeMode = new HamstersTask();
		decideChangeMode.setType(TaskType.COGNITIVE);
		op3.addChild(decideChangeMode);
		
		HamstersTask changeMode = new HamstersTask();
		changeMode.setType(TaskType.ABSTRACT);
		op3.addChild(changeMode);
		

		//profondeur 4 manageTiltAngle
		HamstersOperator op6 = new HamstersOperator();
		op6.setType(OperatorType.DISABLE);
		changeTiltAngle.addChild(op6);
		
		HamstersOperator op7 = new HamstersOperator();
		op7.setType(OperatorType.ENABLE);
		op6.addChild(op7);
		
		HamstersTask decideAngleIsCorrect = new HamstersTask();
		decideAngleIsCorrect.setType(TaskType.COGNITIVE);
		op6.addChild(decideAngleIsCorrect);
		
		//profondeur 5 manageMode
		
		HamstersOperator op5 = new HamstersOperator();
		op5.setType(OperatorType.CHOICE);
		changeMode.addChild(op5);
		
		HamstersTask switchToWXON = new HamstersTask();
		switchToWXON.setType(TaskType.INPUT);
		HamstersTask switchToTST = new HamstersTask();
		switchToTST.setType(TaskType.INPUT);
		HamstersTask switchToWXA = new HamstersTask();
		switchToTST.setType(TaskType.INPUT);
		HamstersTask switchToSTDBY = new HamstersTask();
		switchToSTDBY.setType(TaskType.INPUT);
		HamstersTask switchOff = new HamstersTask();
		switchOff.setType(TaskType.INPUT);
		
		op5.addChild(switchToWXON);
		op5.addChild(switchToTST);
		op5.addChild(switchToWXA);
		op5.addChild(switchToSTDBY);
		op5.addChild(switchOff);
		
		//profondeur 5 manageTiltAngle 
		
		HamstersTask selectManual = new HamstersTask();
		selectManual.setType(TaskType.INPUT);
		HamstersTask stabilizationOff = new HamstersTask();
		stabilizationOff.setType(TaskType.INPUT);
		HamstersTask angleEditing = new HamstersTask();
		angleEditing.setType(TaskType.ABSTRACT);
		HamstersTask selectAuto = new HamstersTask();
		selectAuto.setType(TaskType.INPUT);
		
		op7.addChild(selectManual);
		op7.addChild(stabilizationOff);
		op7.addChild(angleEditing);
		op7.addChild(selectAuto);
		
		//profondeur 6 manageTiltAngle
		
		HamstersOperator op8 = new HamstersOperator();
		op8.setType(OperatorType.DISABLE);
		angleEditing.addChild(op8);
		
		HamstersTask modifyAngle = new HamstersTask();
		modifyAngle.setType(TaskType.ABSTRACT);
		HamstersTask stabilizationOn = new HamstersTask();
		stabilizationOff.setType(TaskType.INPUT);
		
		op8.addChild(modifyAngle);
		op8.addChild(stabilizationOn);
		
		//profondeur 7 manageTiltAngle
		
		HamstersOperator op9 = new HamstersOperator();
		op9.setType(OperatorType.ENABLE);
		
		HamstersTask decideAngle = new HamstersTask();
		decideAngle.setType(TaskType.COGNITIVE);
		HamstersTask editAngle = new HamstersTask();
		editAngle.setType(TaskType.INPUT);
		HamstersTask checkUpdateValue = new HamstersTask();
		checkUpdateValue.setType(TaskType.OUTPUT);
		
		op9.addChild(decideAngle);
		op9.addChild(editAngle);
		op9.addChild(checkUpdateValue);
		
	}
}
