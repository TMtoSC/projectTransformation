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
		SGraphFactory factory = SGraphFactory.eINSTANCE;
		Statechart sc;
		sc = factory.createStatechart();
		sc.setName("Test");
		Region re = factory.createRegion();
		re.setName("RegTest");
		sc.getRegions().add(re);
		State s = factory.createState();

		
		for (int i = 0 ; i < hAPI.getHamstersNode().size();i++){
			HamstersNode ha = hAPI.getHamstersNode().get(i);
			if (ha instanceof HamstersTask)
				ha = (HamstersNode) ha.getChildren().get(i);
			if ( ha instanceof HamstersOperator){
				switch( ha.getDescription() ){
					case ">>" : s = Factory.FactoryTransformation.enabletoSc((HamstersOperator) ha);
								re.getVertices().add(s);
			
								break;
				}
			}
		}
			TranslationSCT.WriteFile.main(hAPI, sc);
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
