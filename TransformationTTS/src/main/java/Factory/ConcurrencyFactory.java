package Factory;

import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersOperator;

public class ConcurrencyFactory {
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
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
