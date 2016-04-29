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
		State e = sgraph.createState();
		e.isOrthogonal();
		Region r = sgraph.createRegion();
		Region r2 = sgraph.createRegion();
		e.getRegions().add(r);
		e.getRegions().add(r2);
		e.setName("Concurrency");
		HamstersOperator hp;
		Entry ent = sgraph.createEntry();
		ent.setName("MyEntry");
		/**
		 * création de la première région.
		 */
		//Region r = sgraph.createRegion();
		e.getRegions().add(r);
		State synchro1 = sgraph.createState();
		synchro1.setName("Synchronisation n°1");
		State compoLeft = sgraph.createState();
		compoLeft.setName(hOP.getChildren().get(0).getDescription());
		r.getVertices().add(ent);
		r.getVertices().add(compoLeft);
		r.getVertices().add(synchro1);
		Transition t1 = sgraph.createTransition();
		t1.setSource(ent);
		t1.setTarget(compoLeft);
		if(!(hOP.getChildren().get(0).isLeaf())) {
			compoLeft.isComposite();
			r = sgraph.createRegion();
			hp = (HamstersOperator) hOP.getChildren().get(0);
			compoLeft.getRegions().add(r);
			r.getVertices().add(appel(hp));
			
		}
		/**
		 * création de la seconde région.
		 */
		State synchro2 = sgraph.createState();
		synchro2.setName("Synchronisation n°2");
//		Region r2 = sgraph.createRegion();
		State compoRight = sgraph.createState();
		compoRight.setName(hOP.getChildren().get(0).getDescription());
		Transition t2 = sgraph.createTransition();
		t2.setSource(ent);
		t2.setTarget(compoRight);
		r2.getVertices().add(ent);
		e.getRegions().add(r2);
		r2.getVertices().add(synchro2);
		if(!(hOP.getChildren().get(1).isLeaf())) {
			compoLeft.isComposite();
			r = sgraph.createRegion();
			hp = (HamstersOperator) hOP.getChildren().get(1);
			compoLeft.getRegions().add(r);
			r.getVertices().add(appel(hp));
		}
		/**
		 * fin de création..
		 */
		Region rTemp1 = null;
		Region rTemp2 = null;
		State transitState = null;
		State tempOrto = null;
		Transition t = null;
		/*
		if (hOP.getChildren().size() > 2) {
			/**
			 * Si plus de deux concurrences, récursvité de concurrence
			 */
			/*
			
			for(int i = 1; i < hOP.getChildren().size();i++){
				
				rTemp1 = sgraph.createRegion();
				rTemp2 = sgraph.createRegion();
				transitState = sgraph.createState();
				tempOrto = sgraph.createState();
				tempOrto.isOrthogonal();
				tempOrto.getRegions().add(rTemp1);
				tempOrto.getRegions().add(rTemp2);
				/**
				 * si le fils est une feuille 
				 */
		/*
				if(hOP.getChildren().get(i).isLeaf()) {
					
					transitState.setName(hOP.getChildren().get(i).getDescription());
					
					
					temp.isComposite();
					rTemp = sgraph.createRegion();
					temp.getRegions().add(rTemp);
					r.getVertices().add(temp);
			
			
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
		}*/
		return e;

	}
	
	
	public static void main(String[] args) throws Exception{
		Concurrency e = new Concurrency();
    	HamstersAPI hampi = e.getAPI();
    	WriteFile.main(FactoryTransformation.Transform(hampi),".\\lol");
	}
}
