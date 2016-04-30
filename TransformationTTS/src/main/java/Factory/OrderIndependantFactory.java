package Factory;

import java.util.ArrayList;

import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import taskModelCreation.Enable2;
import taskModelCreation.OrderIndependent;

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
		Region r = sgraph.createRegion();
		e.getRegions().add(r);
		r.getVertices().add(enter);
		
		/**
		 * création du choix.
		 */
		Choice initialChoiceState = sgraph.createChoice();
		r.getVertices().add(initialChoiceState);
		State temp = null;
		Transition t = null;
		
		for(int i = 0 ; i< hOP.getChildren().size() ; i++) {
			ArrayList<HamstersTask> listeCombi = combinationGenerator(hOP, i);
			for ( int j = 0 ; j < combinationGenerator(hOP, i).size() ; j++){
				if(hOP.getChildren().get(i).isLeaf()) {
					temp = sgraph.createState();
					temp.setName(hOP.getChildren().get(i).getDescription());
					temp = (State) listeCombi.get(i).getChildren().get(j);
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
		}
		return e;	
	}
	
	private static ArrayList<HamstersTask> combinationGenerator(HamstersOperator hOP , int i ){
		ArrayList<HamstersTask> temp = new ArrayList<HamstersTask>();
		if ( temp.size() >= hOP.getChildren().size()){
			return temp;
		}
		for ( i = 0 ; i < hOP.getChildren().size(); i++){
			temp.add((HamstersTask) hOP.getChildren().get(i));
			combinationGenerator(hOP, temp.size()+1);
		}
		return temp;
		
	}
	public static void main(String[] args){
		taskModelCreation.OrderIndependent o = new OrderIndependent();
		try {
			WriteFile.main(FactoryTransformation.Transform(o.getAPI()), "/Users/daviddang/Desktop/OrderIndependentFile");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
