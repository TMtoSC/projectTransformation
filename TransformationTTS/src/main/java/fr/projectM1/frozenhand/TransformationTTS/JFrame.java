/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.projectM1.frozenhand.TransformationTTS;
import java.awt.Color;
import java.io.BufferedWriter;
import javax.swing.JFileChooser;

import org.yakindu.sct.model.sgraph.Statechart;

import hamsters.HamstersAPI;
import statechartsInXML.WriteFile;
import translationTaskModelToStachart.TaskModelTranslation;

import java.io.File;
import java.io.FileWriter;

/**
 * Frame principale de l'application.
 * va permettre a l'utilisateur de créer des instances des différents opérateurs hamsters
 * puis de les traduire en statecharts et enfin de les enregistrer la ou il veut
 * grâce a un file chooser
 * 
 * un second file chooser correspondant au menu Ouvrir
 * servira lors de l'implantation du traducteur de xml hamsters
 * vers structure de données hamsters
 * ceci afin de pouvoir prendre les données d'un modèle de tâches directement depuis l'exterieur du code
 * sans avoir a le créer directement dans le code java.
 * 
 * @author Jeff
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creation de la frame principale.
     * Appel de la fonction d'initialisation des composants
     */
    public JFrame() {
        initComponents();

    }

    /**
     * Fonction initialisant les variables de la frame.
     * elle place et initialise les widgets dans la frame
     * liaison des éléments avec leurs listener et leurs callbacks
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	selectedFile = new File("");
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser1.setVisible(false);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        
        setAllRed();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Séquence");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Choix");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Ordre-Indépendant");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Conccurence");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Désactivation");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("Interruption-Reprise");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.setText("Traduire");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jMenu1.setText("Parcourir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Enregistrer");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addGap(105, 105, 105)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Fonction permettant de mettre la couleur de fond de tous les boutons en rouge.
     */
    private void setAllRed()
    {
        jButton1.setBackground(Color.red);
        jButton2.setBackground(Color.red);
        jButton3.setBackground(Color.red);
        jButton4.setBackground(Color.red);
        jButton5.setBackground(Color.red);
        jButton6.setBackground(Color.red);
    }
    
    /**
     * Fonction callback gérant le clique sur le menu1.
     * ouvre un fichier et le stocke dans la variable de la frame selectedFile
     * @param evt evenement envoyé par l'event handler
     */
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        jFileChooser1.setVisible(true);
        int returnVal = jFileChooser1.showDialog(this,"Ouvrir");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	selectedFile = jFileChooser1.getSelectedFile();
            //System.out.println(file.getPath());
           // try boolean res = file.createNewFile();
        }
    }//GEN-LAST:event_jMenu1MouseClicked
    
    /**
     * Fonction callback gérant le clique sur le menu2.
     * permet l'appel a la fonction d'enregistrement d'un fichier
     * de la classe WriteFile prenant le chemin et le nom
     * que le fileChooser a permis de selectionner
     * @param evt evenement envoyé par l'event handler
     */
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
    	jFileChooser1.setVisible(true);
        int returnVal = jFileChooser1.showDialog(this,"Enregistrer");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	selectedFile = jFileChooser1.getSelectedFile();
        	
        	
            try {
				WriteFile.main(statechart,selectedFile.getAbsolutePath());
			} catch (Exception e1) {

				e1.printStackTrace();
			}
        }
    	
    }

    /**
     * Callback appelé lors du clique sur le bouton1.
     * creation d'une instance de la classe Enable
     * qui va créer un modèle de tâche Hamsters
     * stockage de l'api de cet operateur dans la variable membre de la frame
     * changement de la couleur de tous les boutons a rouge
     * puis changement de la couleur de ce bouton a vert
     * ceci afin de montrer a l'utilisateur quel opérateur est actuellement dans la frame
     * @param evt
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    	fr.projectM1.frozenhand.TransformationTTS.Enable Operateur = new Enable();
    	hampi = Operateur.getAPI();
    	setAllRed();
    	jButton1.setBackground(Color.green);
    }//GEN-LAST:event_jButton1MouseClicked
    
    /**
     * Callback appelé lors du clique sur le bouton2.
     * creation d'une instance de la classe Choice
     * qui va créer un modèle de tâche Hamsters
     * stockage de l'api de cet operateur dans la variable membre de la frame
     * changement de la couleur de tous les boutons a rouge
     * puis changement de la couleur de ce bouton a vert
     * ceci afin de montrer a l'utilisateur quel opérateur est actuellement dans la frame
     * @param evt
     */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
    	fr.projectM1.frozenhand.TransformationTTS.Choice Operateur = new Choice();
    	hampi = Operateur.getAPI();
    	setAllRed();
    	jButton2.setBackground(Color.green);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * Callback appelé lors du clique sur le bouton3.
     * creation d'une instance de la classe Order Independant
     * qui va créer un modèle de tâche Hamsters
     * stockage de l'api de cet operateur dans la variable membre de la frame
     * changement de la couleur de tous les boutons a rouge
     * puis changement de la couleur de ce bouton a vert
     * ceci afin de montrer a l'utilisateur quel opérateur est actuellement dans la frame
     * @param evt
     */
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
    	fr.projectM1.frozenhand.TransformationTTS.OrderIndependent Operateur = new OrderIndependent();
    	hampi = Operateur.getAPI();
    	setAllRed();
    	jButton3.setBackground(Color.green);
    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * Callback appelé lors du clique sur le bouton4.
     * creation d'une instance de la classe Concurrency
     * qui va créer un modèle de tâche Hamsters
     * stockage de l'api de cet operateur dans la variable membre de la frame
     * changement de la couleur de tous les boutons a rouge
     * puis changement de la couleur de ce bouton a vert
     * ceci afin de montrer a l'utilisateur quel opérateur est actuellement dans la frame
     * @param evt
     */
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
    	fr.projectM1.frozenhand.TransformationTTS.Concurrency Operateur = new Concurrency();
    	hampi = Operateur.getAPI();
    	setAllRed();
    	jButton4.setBackground(Color.green);
    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * Callback appelé lors du clique sur le bouton5.
     * creation d'une instance de la classe Disable
     * qui va créer un modèle de tâche Hamsters
     * stockage de l'api de cet operateur dans la variable membre de la frame
     * changement de la couleur de tous les boutons a rouge
     * puis changement de la couleur de ce bouton a vert
     * ceci afin de montrer a l'utilisateur quel opérateur est actuellement dans la frame
     * @param evt
     */
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
    	fr.projectM1.frozenhand.TransformationTTS.Disable Operateur = new Disable();
    	hampi = Operateur.getAPI();
    	setAllRed();
    	jButton5.setBackground(Color.green);
    }//GEN-LAST:event_jButton5MouseClicked

    /**
     * Callback appelé lors du clique sur le bouton6.
     * creation d'une instance de la classe SuspendResume
     * qui va créer un modèle de tâche Hamsters
     * stockage de l'api de cet operateur dans la variable membre de la frame
     * changement de la couleur de tous les boutons a rouge
     * puis changement de la couleur de ce bouton a vert
     * ceci afin de montrer a l'utilisateur quel opérateur est actuellement dans la frame
     * @param evt
     */
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
    	fr.projectM1.frozenhand.TransformationTTS.SuspendResume Operateur = new SuspendResume();
    	hampi = Operateur.getAPI();
    	setAllRed();
    	jButton6.setBackground(Color.green);
    }//GEN-LAST:event_jButton6MouseClicked

    /**
     * Callback appelé lors du clique sur le bouton7.
     * va stocker dans la variable de la frame la traduction de l'opérateur
     * actuellement stocké dans la frame en statecharts
     * @param evt
     */
    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
    	try {
			statechart = TaskModelTranslation.Transform(hampi);
	    	jButton7.setBackground(Color.green);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_jButton7MouseClicked


	/**
	 * Variables de la classe de Frame.
	 * variables membres de la classe
	 * boutons, filechooser, menu => éléments cliquables
	 * menuBar => élément de structure de la frame
	 * selectedFile, hampi, statechart => éléments de stockage des informations
	 */
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private File selectedFile;
    private HamstersAPI hampi;
    private Statechart statechart;
    

}
