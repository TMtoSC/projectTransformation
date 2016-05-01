
package Factory;

import TranslationSCT.WriteFile;
import fr.projectM1.frozenhand.TransformationTTS.WXR;

/**
 * WXRFactory 
 * classe servant à enregistrer sur son pc un fichier xml 
 * après transformation en stateChart
 * @author frozenhandgroup
 */
public class WXRFactory {

	/**
	 * La méthode main permet la transformation d'un fichier xml de WXR
	 * et propose un frame pour l'enregistrement du fichier après transformation
	 * @param args les arguments
	 */
	public static void main(String[] args) {
		fr.projectM1.frozenhand.TransformationTTS.WXR wxr = new WXR();
		try {
			WriteFile.main(FactoryTransformation.Transform(wxr.getAPI()), ".\\wxr");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
