package translationTaskModelToStachart;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

import fr.projectM1.frozenhand.TransformationTTS.EnablewithAbstractTasks;
import fr.projectM1.frozenhand.TransformationTTS.OrderIndependent;
import hamsters.HamstersNode;
import hamsters.HamstersOperator;
import hamsters.HamstersTask;
import statechartsInXML.WriteFile;

/**
 * OrderIndependentFactory 
 * Classe servant à créer un état d'un stateChart avec l'opérateur OrderIndependent
 * tout en lui attachant des tâches
 * @author frozenhandgroup
 */
public class OrderIndependentTranslation extends TaskModelTranslation{
	
	/**
	 * sgraph est une instance de SGaphFactory de la bibliothèque Yakindu
	 */
	private static SGraphFactory sgraph = SGraphFactory.eINSTANCE;

	/**
	 * permet de parcourir une structure hiérachique de type hamsterOperateur
	 * et construit un état du stateChart
	 * @param hOP un hamsterOperateur pour parcourir la structure arborescente 
	 * @return un état 
	 */
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
					temp = recursiveTranslation(listglob.get(i).get(j));
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
	
	/**
	 * L'algo de ForceBrute permettant de faire tous les ordonnancements possibles 
	 * des hamsters node
	 * @param noeudsRest une liste de HamstersNode cette liste est celle des noeudsrestants
	 * @param hn une liste de HamstersNode est la liste crée avec un ordonnancement dedans
	 * @param lg une liste de listes de HamstersNode la liste globale contenant tous les ordonnancements
	 * @return une liste de listes HamstersNode
	 */
	private static List<List<HamstersNode>> creationList(List<HamstersNode> noeudsRest, List<HamstersNode> hn , List<List<HamstersNode>> lg) {
		List<HamstersNode> buff = new ArrayList<>(noeudsRest);
		/**
		 * s'il ne reste qu'un élément
		 * ajout de cet élément puis ajout de la liste dans la liste globale. Fin de récursivité.
		 */
		if(noeudsRest.size()==1) {
			hn.add(noeudsRest.get(0));
			lg.add(new ArrayList<>(hn));
			return lg;
		}
		List<HamstersNode> init = new ArrayList<>(hn);
		/**
		 * boucle de récursivité.
		 * Ajoute dans la liste courante le premier fils de la liste des noeuds restants.
		 * Envoi des listes modifiées à la récursivité
		 * Reinitialisation des listes une fois la récursivité terminée 
		 * et n reboucle.
		 * 
		 */
		for (int j = 0 ; j< noeudsRest.size(); j++){
			hn.add(noeudsRest.get(j));
			buff.remove(j);
			creationList(buff,hn,lg);
			buff.add(j,noeudsRest.get(j));
			hn.clear();
			for( int k = 0 ; k < init.size() ; k++) {
				hn.add(init.get(k));
			}
		}
		return null;
	}

}
