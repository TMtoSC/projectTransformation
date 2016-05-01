package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import fr.projectM1.frozenhand.TransformationTTS.Disable;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;


/**
 * DisableFactory 
 * Classe servant à créer un état d'un stateChart avec l'opérateur Disable
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
public class DisableFactory extends FactoryTransformation {
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
					/**
					 * Faire attention possibilité de bug !
					 */
					HamstersNode ot = hOP.getChildren().get(i);
					temp = appel(ot);
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
	/**
	 * Permet de simuler la création d'une tâche avec l'opérateur disable
	 * @param args
	 */
	public static void main(String[] args) {
		fr.projectM1.frozenhand.TransformationTTS.Disable d = new Disable();
		try {
			WriteFile.main(FactoryTransformation.Transform(d.getAPI()), "/Users/daviddang/Desktop/disableTest");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
