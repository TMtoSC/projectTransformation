package Factory;

import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
//import org.yakindu.sct.model.sgraph.*;
import org.yakindu.sct.model.sgraph.impl.SGraphFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Factory;

import hamsters.HamstersAPI;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import hamsters.OperatorType;

public class FactoryTransformation {
	SGraphFactory factory = SGraphFactory.eINSTANCE;

public void Transform(HamstersAPI hAPI) throws Exception {
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
				case ">>" : s = EnableFactory.enabletoSc((HamstersOperator) ha);
							re.getVertices().add(s);
							break;
			}
		}
	}
		TranslationSCT.WriteFile.main(hAPI, sc);
}


public State appel(String str, HamstersOperator ha){
	switch( str ){
		case ">>" : return EnableFactory.enabletoSc(ha);
		case "[]" : return ChoiceFactory.choiceToSc(ha);
		case "[>" : return DisableFactory.disableToSc(ha);
		case "|||" : return ConcurrencyFactory.concurrencyToSc(ha);
	}
		return null;	
	}
}


