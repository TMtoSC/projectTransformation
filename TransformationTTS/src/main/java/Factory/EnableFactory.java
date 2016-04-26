package Factory;

import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
//import org.yakindu.sct.model.sgraph.*;
import org.yakindu.sct.model.sgraph.impl.SGraphFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;

public class EnableFactory {

	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
	
	public static State enabletoSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		Region r = sgraph.createRegion();
		State temp = null;
		Transition t = null;
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			temp = sgraph.createState();
			temp.setName(hOP.getChildren().get(i).toString());
			r.getVertices().add(sgraph.createState());
			if(i!=0){
				t = sgraph.createTransition();
				t.setSource(r.getVertices().get(i-1));
				t.setTarget(r.getVertices().get(i));
			}
		}
		
	}
}