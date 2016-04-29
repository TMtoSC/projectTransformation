package Factory;

import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import taskModelCreation.Concurrency;
import taskModelCreation.Enable2;

public class ConcurrencyFactory extends FactoryTransformation{
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;
	public static State concurrencyToSc(HamstersOperator hOP) {
		/**
		 * Création de l'orthogonal State.
		 */
		State e = sgraph.createState();
		e.isOrthogonal();
		/**
		 * Ajout de la première région.
		 */
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		r.setName("Premiere Région");
		/**
		 * ajout du premier état.
		 */
		if(!(hOP.getChildren().get(0).isLeaf())) {
			if(hOP.getChildren().get(0).getClass() == HamstersOperator.class) {
				HamstersOperator ho = (HamstersOperator) hOP.getChildren().get(0);
				State s = appel(ho);
				r.getVertices().add(s);
			}
			else {
				HamstersOperator ho = (HamstersOperator) hOP.getChildren().get(0);
				State s = appel(ho);
				r.getVertices().add(s);
			}
				
		}
		if(hOP.getChildren().size() >2) {
			for(int i = 1 ; i < hOP.getChildren().size() ; i++ ) {
				
			}
		}
		State s = sgraph.createState();
		r.getVertices().add(s);
		s.setName("Lol");
		
		e.setName("Concurrency");
		Region r2 = sgraph.createRegion();
		
		r2.setName("Deuxieme Région");
		State s2 = sgraph.createState();
		r2.getVertices().add(s2);
		s2.setName("Lol2");
		e.getRegions().add(r2);
		HamstersOperator hp;
		Entry ent = sgraph.createEntry();
		ent.setName("MyEntry");
		return e;
	}
	public static void main(String[] args) throws Exception{
		Concurrency e = new Concurrency();
    	HamstersAPI hampi = e.getAPI();
    	WriteFile.main(FactoryTransformation.Transform(hampi),".\\lol");
	}
}
