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
	
	public void run(HamstersAPI hAPI)
	{
		SGraphFactory factory = SGraphFactory.eINSTANCE;
		Statechart sc;
		sc = factory.createStatechart();
		sc.setName("Test");
		Region re = factory.createRegion();
		re.setName("RegTest");
		sc.getRegions().add(re);
		
		for (int i = 0 ; i < hAPI.getHamstersNode().size();i++){
			HamstersNode ha = hAPI.getHamstersNode().get(i);
			if (ha instanceof HamstersTask)
				ha = (HamstersNode) ha.getChildren().get(i);
			if ( ha instanceof HamstersOperator){
				switch( ha.getDescription() ){
					case ">>" : State s = Factory.FactoryTransformation.enabletoSc((HamstersOperator) ha);
								re.getVertices().add(s);
								break;
				}
			}
		}
		try {
			TranslationSCT.WriteFile.main(hAPI, sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
