package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersOperator;

public class ChoiceFactory extends FactoryTransformation {
	
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	public static State choiceToSc(HamstersOperator hOP) {
		// création de l'état composite initial
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getParent().getDescription());
		
		// création de la région de cet état composite
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		
		// création du point d'entrée de la région link au premier état qui ammorce le choix
		Entry ent = sgraph.createEntry();
		r.getVertices().add(ent);
		
		// création de l'état ammorcant le choix
		State initialChoiceState = (State) sgraph.createChoice();
		r.getVertices().add(initialChoiceState);
		
		// création de la transition entre l'entry et l'état ammorcant le choix
		Transition firstTransition = sgraph.createTransition();
		firstTransition.setSource(ent);
		firstTransition.setTarget(initialChoiceState);
		// variable concernant les différents fils du choix 
		State temp = null;
		Transition t = null;
		
		// création des fils et de ses transitions avec le parent 
		for (int i = 0; i < hOP.getChildren().size(); i++) {
			temp = sgraph.createState();
			temp.setName(hOP.getChildren().get(i).getDescription());
			r.getVertices().add(temp);
			if (i != 0) {
				t = sgraph.createTransition();
				t.setSource(initialChoiceState);
				t.setTarget(r.getVertices().get(i));
			}
		}
		return e;
	}
}
