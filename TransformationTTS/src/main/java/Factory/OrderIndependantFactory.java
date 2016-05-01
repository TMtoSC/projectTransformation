package Factory;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import TranslationSCT.WriteFile;
import fr.projectM1.frozenhand.TransformationTTS.Enable2;
import fr.projectM1.frozenhand.TransformationTTS.OrderIndependent;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;

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
		
		Transition t = null;
		/**
		 * Début de l'algo permettant n order independant
		 */
		List<HamstersNode> hnList = new ArrayList<>();
		List<HamstersNode> tempe = new ArrayList<>(hOP.getChildren());
		List<List<HamstersNode>> listglob = new ArrayList<>();
		creationList(tempe,hnList,listglob);
		
		for(int i = 0 ;  i < listglob.size() ; i++){
			State compo = sgraph.createState();
			compo.isComposite();
			r.getVertices().add(compo);
			Region newr = sgraph.createRegion();
			compo.getRegions().add(newr);
			Entry entry = sgraph.createEntry();
			newr.getVertices().add(entry);
			Transition newt = sgraph.createTransition();
			newt.setSource(initialChoiceState);
			newt.setTarget(compo);
			for(int j = 0 ; j < listglob.get(i).size(); j++) {				
				State temp = sgraph.createState();
				Transition sequency = sgraph.createTransition();
				if(!(listglob.get(i).get(j).isLeaf())) {
					temp = appel(listglob.get(i).get(j));
				}
				temp.setName(listglob.get(i).get(j).getDescription());
				newr.getVertices().add(temp);
				if(j==0) {
					sequency.setSource(entry);
					sequency.setTarget(temp);
				}
				else {
					
					sequency.setSource(newr.getVertices().get(j));
					sequency.setTarget(newr.getVertices().get(j+1));
				}
				temp = null;
				sequency =null;
			}
			
		}
		
		return e;	
	}
	
	private static List<List<HamstersNode>> creationList(List<HamstersNode> rem, List<HamstersNode> hn , List<List<HamstersNode>> lg) {
		List<HamstersNode> buff = new ArrayList<>(rem);
		if(rem.size()==1) {
			hn.add(rem.get(0));
			lg.add(new ArrayList<>(hn));
			return lg;
		}
		List<HamstersNode> init = new ArrayList<>(hn);
		for (int j = 0 ; j< rem.size(); j++){
			hn.add(rem.get(j));
			buff.remove(j);
			creationList(buff,hn,lg);
			buff.add(j,rem.get(j));
			hn.clear();
			for( int k = 0 ; k < init.size() ; k++) {
				hn.add(init.get(k));
			}
		}
		return null;
	}

}
