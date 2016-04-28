package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersNode;
import hamsters.HamstersOperator;

public class EnableFactory extends FactoryTransformation {
	
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	public static State enabletoSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		e.setName("lol");
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		State temp = null;
		Transition t = null;
		Entry ent = sgraph.createEntry();
		Transition l = sgraph.createTransition();
		l.setSource(ent);
		r.getVertices().add(ent);
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			
			if(!(hOP.getChildren().get(i).getClass().equals(HamstersOperator.class))) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).getDescription());
				r.getVertices().add(temp);
				if(i ==0){
					l.setTarget(temp);
				}
				if(i!=0){
					t = sgraph.createTransition();
					t.setSource(r.getVertices().get(i-1));
					t.setTarget(r.getVertices().get(i));
					}
				}
			else {
				/**
				 * Faire attention
				 * possibilité de bug ! 
				 */
				HamstersOperator ot = (HamstersOperator) hOP.getChildren().get(i);
				r.getVertices().add(appel(ot));
			}
		}
		for(int i = 0 ; i < hOP.getChildren().size(); i++) {
			
		}
		return e;
		
	}

}
