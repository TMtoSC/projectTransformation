package Factory;

import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersOperator;

public class DisableFactory {
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

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
}
