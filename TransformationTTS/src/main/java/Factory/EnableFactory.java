package Factory;

import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersNode;
import hamsters.HamstersOperator;

public class EnableFactory {
	
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
/**
 * transformtion de l'opérateur séquence
 * @param hOP
 * @return
 */
	public static State enabletoSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		e.setName("lol");
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		State temp = null;
		Transition t = null;
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			
			if(!(hOP.getChildren().get(i).getClass().equals(HamstersOperator.class))) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).getDescription());
				r.getVertices().add(temp);
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
		return e;
		
	}

}
