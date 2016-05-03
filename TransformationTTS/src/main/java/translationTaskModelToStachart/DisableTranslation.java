package translationTaskModelToStachart;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import fr.projectM1.frozenhand.TransformationTTS.Disable;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import statechartsInXML.WriteFile;


/**
 * DisableFactory 
 * Classe servant à créer un état d'un stateChart avec l'opérateur Disable
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
public class DisableTranslation extends TaskModelTranslation {
	/**
	 * factory est une instance de SGaphFactory de la bibliotheque Yakindu
	 */
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	/**
	 * permet de parcourir une structure hiérachique de type hamsterOperateur
	 * et construit un état du stateChart
	 * @param hOP un hamsterOperateur pour parcourir la structure arborescente 
	 * @return un état 
	 */
	public static State disableToSc(HamstersOperator hOP) {
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getDescription());
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		Entry ent = sgraph.createEntry();
		r.getVertices().add(ent);
		State temp = null;
		Transition t = null;
		if (hOP.getChildren().size() == 2) {
			for (int i = 0; i < hOP.getChildren().size(); i++) {
				if (hOP.getChildren().get(i).isLeaf()) {
					temp = sgraph.createState();
					temp.setName(hOP.getChildren().get(i).getDescription());
					r.getVertices().add(temp);
				} else {
					
					HamstersNode ot = hOP.getChildren().get(i);
					temp = recursiveTranslation(ot);
					r.getVertices().add(temp);
				}
			}
			t = sgraph.createTransition();
			t.setSource(ent);
			t.setTarget(r.getVertices().get(1));
			t = null;
			t = sgraph.createTransition();
			t.setSource(r.getVertices().get(1));
			t.setTarget(r.getVertices().get(2));
			t = null;
		}
		return e;
	}

}
