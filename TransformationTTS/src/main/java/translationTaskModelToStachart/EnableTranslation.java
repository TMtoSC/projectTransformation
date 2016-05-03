package translationTaskModelToStachart;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import hamsters.HamstersNode;
import hamsters.HamstersOperator;

/**
 * EnableFactory 
 * Classe servant à créer un état d'un stateChart avec l'opérateur Enable
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
public class EnableTranslation extends TaskModelTranslation {

	/**
	 * sgraph est une instance de SGaphFactory de la bibliotheque Yakindu
	 */
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	/**
	 * permet de parcourir une structure hiérachique de type hamsterOperateur
	 * et construit un état du stateChart
	 * @param hOP un hamsterOperateur pour parcourir la structure arborescente 
	 * @return un état 
	 */
	public static State enabletoSc(HamstersOperator hOP) {
		// création de l'état composite
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getDescription());
		// création de la région du composite
		Region r = sgraph.createRegion();
		e.getRegions().add(r);

		// création du point d'entrée de la région link au premier état qui ammorce la sequence
		State temp = null;
		Entry ent = sgraph.createEntry();
		r.getVertices().add(ent);
		Transition t = null;
		// création de l'enable
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			if(hOP.getChildren().get(i).isLeaf()) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).getDescription());
				r.getVertices().add(temp);
			}
			else {
				/**
				 * Faire attention
				 * possibilité de bug !
				 */
				HamstersNode ot = hOP.getChildren().get(i);
				temp = recursiveTranslation(ot);
				r.getVertices().add(temp);
			}

			// création de toutes les transitions
			t = sgraph.createTransition();
			t.setSource(r.getVertices().get(i));
			t.setTarget(r.getVertices().get(i+1));
			t = null;
		}
		return e;
	}

}
