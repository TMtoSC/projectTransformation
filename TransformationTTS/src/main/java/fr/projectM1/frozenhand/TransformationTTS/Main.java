package fr.projectM1.frozenhand.TransformationTTS;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import TranslationSCT.WriteFile;
import hamsters.HamstersAPI;
import hamsters.HamstersOperator;
import taskModelCreation.Enable;

public class Main {

	
	
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        final MainJFrame frame = new MainJFrame();
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	frame.setVisible(true);
            }
        });
        
    	/*TaskModel taskModel = new TaskModel(frame.getFile());
		 StateChart stateChart = new StateChart();
		 
		 
		 HamstersAPI api = new HamstersAPI(taskModel.getName());
		 Translate trans = new Translate(taskModel, stateChart);*/
        //Enable e = new Enable();
        //HamstersOperator hOP = new HamstersOperator();
        //hOP = (HamstersOperator) e.getAPI().getHamstersNode().get(0);
        Enable e = new Enable();
        Translate t = new Translate();
        t.run(e.getAPI());
        
    }
	

	
	
}
