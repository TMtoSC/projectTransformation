package Factory;

import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersOperator;

public class ChoiceFactory {
	
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

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
}
