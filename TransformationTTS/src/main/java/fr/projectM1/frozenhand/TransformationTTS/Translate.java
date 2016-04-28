package fr.projectM1.frozenhand.TransformationTTS;

import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.State;

import hamsters.HamstersAPI;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;

public class Translate 
{
	
	private TaskModel taskModel;
	private StateChart stateChart;
	
	public Translate()
	{
		taskModel = new TaskModel();
		stateChart = new StateChart();
	}
	
	public Translate(TaskModel tm, StateChart sc)
	{
		taskModel = tm;
		stateChart = sc;
	}
	
	public void run(HamstersAPI hAPI) throws Exception
	{
		
	}
	
	private void transformENtoSC (){}/*(Object... on){
	    StateChart sc = new StateChart();
	    State initial = sc.addInitialState();
	    CompositeState cs = sc.addCompositeState();
	    sc.addTransition(initial,cs);
	    Object prevObj = null;
	    for (Object o: on){
	        cs.addState(o);
	        if (prevObj !=null){
	            cs.addTransition(prevObj,o);
	        }
	        prevObj = o;
	    }
	}*/

}
