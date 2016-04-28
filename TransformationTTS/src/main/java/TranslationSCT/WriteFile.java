package TranslationSCT;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.yakindu.sct.model.resource.SCTResourceFactory;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.factories.FactoryUtils;

import Factory.FactoryTransformation;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;

import org.eclipse.emf.common.util.*;

public class WriteFile {

	public static void main(Statechart sc, String filePath) throws Exception
	{

		URI uri = URI.createFileURI(filePath+".sct");
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("sct", new SCTResourceFactory());
		
		ResourceSet reset = new ResourceSetImpl();
		reset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sct", new SCTResourceFactory());
		XMIResourceImpl ress = new XMIResourceImpl(uri);
		ress.getContents().add(sc);
		ress.save(Collections.EMPTY_MAP);

	}
}
