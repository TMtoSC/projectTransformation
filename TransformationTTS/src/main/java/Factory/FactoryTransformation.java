package Factory;

import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
//import org.yakindu.sct.model.sgraph.*;
import org.yakindu.sct.model.sgraph.impl.SGraphFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import hamsters.HamstersAPI;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.OperatorType;

public class FactoryTransformation {

	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	public static State enabletoSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		State temp = null;
		Transition t = null;
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			
			if(!(hOP.getChildren().get(i).getClass().equals(HamstersOperator.class))) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).toString());
				r.getVertices().add(sgraph.createState());
				if(i!=0){
					t = sgraph.createTransition();
					t.setSource(r.getVertices().get(i-1));
					t.setTarget(r.getVertices().get(i));
					}
				}
			else {
				HamstersNode ot = hOP.getChildren().get(i);
				
			}
		}
		for(int i = 0 ; i < hOP.getChildren().size(); i++) {
			
		}
		
		FinalState fs = sgraph.createFinalState();
		r.getVertices().add(fs);
		Transition lastTransition = sgraph.createTransition();
		lastTransition.setSource(r.getVertices().get(r.getVertices().size()-1));
		lastTransition.setTarget(fs);
		return e;
		
	}

	public static State choiceToSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		State initialChoiceState = (State) sgraph.createChoice();
		r.getVertices().add(initialChoiceState);
		State temp = null;
		Transition t = null;
		for (int i = 0; i < hOP.getChildren().size(); i++) {
			temp = sgraph.createState();
			temp.setName(hOP.getChildren().get(i).toString());
			r.getVertices().add(sgraph.createState());
			if (i != 0) {
				t = sgraph.createTransition();
				t.setSource(initialChoiceState);
				t.setTarget(r.getVertices().get(i));
			}
		}
		return e;
	}

	public static State disableToSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		Region rTemp = null;
		State temp = null;
		Transition t = null;
		if (hOP.getChildren().size() == 2) {
			for (int i = 0; i < hOP.getChildren().size(); i++) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).toString());
				temp.isComposite();
				rTemp = sgraph.createRegion();
				temp.getRegions().add(rTemp);
				r.getVertices().add(temp);
				if (i != 0) {
					t = sgraph.createTransition();
					t.setSource(r.getVertices().get(0));
					t.setTarget(r.getVertices().get(1));
				}
			}
		}
		FinalState fs = sgraph.createFinalState();
		r.getVertices().add(fs);
		Transition lastTransition = sgraph.createTransition();
		lastTransition.setSource(r.getVertices().get(1));
		lastTransition.setTarget(fs);

		return e;
	}

	public static State concurrencyToSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isOrthogonal();
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		Region r2 = sgraph.createRegion();
		e.getRegions().add(r2);
		Region rTemp = null;
		State temp = null;
		Transition t = null;
		if (hOP.getChildren().size() > 2) {
			temp = sgraph.createState();
			temp.setName(hOP.getChildren().get(0).toString());
			temp.isComposite();
			rTemp = sgraph.createRegion();
			temp.getRegions().add(rTemp);
			r.getVertices().add(temp);
			for (int i = 1; i < hOP.getChildren().size(); i++) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).toString());
				temp.isComposite();
				rTemp = sgraph.createRegion();
				temp.getRegions().add(rTemp);
				r2.getVertices().add(temp);
			}
		}
		return e;

	}
}
