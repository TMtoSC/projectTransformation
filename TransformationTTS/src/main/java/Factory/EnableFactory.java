package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import fr.projectM1.frozenhand.TransformationTTS.Enable2;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;

/**
 * EnableFactory 
 * Classe servant à créer un état d'un stateChart avec l'opérateur Enable
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
public class EnableFactory extends FactoryTransformation {

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
	public static State enabletoSc(HamstersOperator hOP) {
		// création de l'état composite
		State e = sgraph.createState();
		e.isComposite();
		e.setName(hOP.getDescription());
		// création de la région du composite
		Region r = sgraph.createRegion();
		e.getRegions().add(r);

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
				temp = appel(ot);
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
	
	/**
	 * Permet de simuler la création d'une tâche avec l'opérateur disable
	 * @param args
	 */
	public static void main(String[] args){
		fr.projectM1.frozenhand.TransformationTTS.Enable2 e = new Enable2();
		try {
			WriteFile.main(FactoryTransformation.Transform(e.getAPI()), "/Users/daviddang/Desktop/testFile");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
