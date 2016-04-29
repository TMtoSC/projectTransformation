package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import hamsters.HamstersOperator;
import taskModelCreation.Enable2;

public class EnableFactory extends FactoryTransformation {

	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	public static State enabletoSc(HamstersOperator hOP) {
		// création de l'état composite
		State e = sgraph.createState();
		e.isComposite();
		e.setName("enableComposite");
		// création de la région du composite
		Region r = sgraph.createRegion();
		e.getRegions().add(r);

		State temp = null;
		Entry ent = sgraph.createEntry();
		r.getVertices().add(ent);
		Transition t = null;
		// création de l'enable
		for( int i = 0 ; i < hOP.getChildren().size() ; i++) {
			if(!(hOP.getChildren().get(i).getClass().equals(HamstersOperator.class))) {
				temp = sgraph.createState();
				temp.setName(hOP.getChildren().get(i).getDescription());
				r.getVertices().add(temp);
			}
			else {
				/**
				 * Faire attention
				 * possibilité de bug !
				 */
				HamstersOperator ot = (HamstersOperator) hOP.getChildren().get(i);
				State sOt = appel(ot);
				r.getVertices().add(sOt);


			}

			// création de toutes les transitions
			t = sgraph.createTransition();
			t.setSource(r.getVertices().get(i));
			t.setTarget(r.getVertices().get(i+1));
			t = null;
		}
		return e;
	}
	
	public static void main(String[] args){
		taskModelCreation.Enable2 e = new Enable2();
		try {
			WriteFile.main(FactoryTransformation.Transform(e.getAPI()), "/Users/daviddang/Desktop/testFile");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
