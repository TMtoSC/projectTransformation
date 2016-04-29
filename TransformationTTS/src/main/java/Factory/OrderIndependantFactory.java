package Factory;

import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;

import hamsters.HamstersOperator;

public class OrderIndependantFactory extends FactoryTransformation{
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	public static State orderindependantToSC(HamstersOperator hOP) {
		/**
		 * Création du premier état composite.
		 */
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getDescription());
		/**
		 * création de la région et de l'entrypoint
		 */
		Entry enter = sgraph.createEntry();
		Region reg = sgraph.createRegion();
		e.getRegions().add(reg);
		reg.getVertices().add(enter);
		
		/**
		 * création du choix.
		 */
		Choice initialChoiceState = sgraph.createChoice();
		reg.getVertices().add(initialChoiceState);
		
		for(int i = 0 ; i< hOP.getChildren().size() ; i++) {
			for(int j =0 ; j < hOP.getChildren().size();j++) {
				
			}
		}
		return null;
		
	}
}
