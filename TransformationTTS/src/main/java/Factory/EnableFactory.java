package Factory;

import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
//import org.yakindu.sct.model.sgraph.*;
import org.yakindu.sct.model.sgraph.impl.SGraphFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;

public class EnableFactory {

	private static SGraphFactory sgraph = new SGraphFactoryImpl();
	
	public static State enabletoSc(HamstersOperator hOP) {
		State s = sgraph.createState();
		CompositeElement ce;
		ce = sgraph.createState();
		State e = sgraph.createState();
		e.isComposite();
		Region r = sgraph.createRegion();
		ce.getRegions.add(r);
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			
		}
	}
}
