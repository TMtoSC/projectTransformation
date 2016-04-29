package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;

public class DisableFactory extends FactoryTransformation{
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	public static State disableToSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		State temp = null;
		Transition t = null;
		if (hOP.getChildren().size() == 2) {
			for (int i = 0; i < hOP.getChildren().size(); i++) {
				if(hOP.getChildren().get(i).isLeaf()) {
					temp = sgraph.createState();
					temp.setName(hOP.getChildren().get(i).toString());
					r.getVertices().add(temp);
				}
				else{
					/**
					 * Faire attention
					 * possibilité de bug !
					 */
					HamstersNode ot = hOP.getChildren().get(i);
					temp = appel(ot);
					r.getVertices().add(temp);
				}
					t = sgraph.createTransition();
					t.setSource(r.getVertices().get(0));
					t.setTarget(r.getVertices().get(1));
					t = null;
			}
		}
		return e;
	}
}
