/*
 * Copyright 2014 Racim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hamsters;

/**
 *
 * @author Eric Barboni <Eric.Barboni@irit.fr>
 * @author Racim Fahssi <Racim.Fahssi@irit.fr>
 */
public class HamstersTask extends HamstersNode {

    /*
     ***************************************************************************
     *************** Start Property Name ***************************************
     ***************************************************************************
     */
 /*
     *************** End Property Name *****************************************
     */

 /*
     ***************************************************************************
     *************** Start Variables *******************************************
     ***************************************************************************
     */
    private TaskType type = TaskType.ABSTRACT;
    private transient boolean optional = false;
    private transient boolean iterative = false;
    private int nbIteration = 0;
    private int criticality = 0;
    private String helpText = "";
    private int minExecutionTime;
    private int maxExecutionTime;
    private boolean folded = false;
    private boolean copy = false;


    /*
     ***************************************************************************
     *************** Start Constructors ****************************************
     ***************************************************************************
     */
    public HamstersTask() {
        super("");
    }

    /*
     *************** End Constructors *******************************************
     */

 /*
     ***************************************************************************
     *************** Start Getters *********************************************
     ***************************************************************************
     */
    public TaskType getType() {
        return type;
    }

    public int getNbIteration() {
        return nbIteration;
    }

    public int getCriticality() {
        return criticality;
    }

    public int getMaxExecutionTime() {
        return maxExecutionTime;
    }

    public String getHelpText() {
        return helpText;
    }

    public int getMinExecutionTime() {
        return minExecutionTime;
    }

    public boolean isFolded() {
        return folded;
    }

    public boolean isCopy() {
        return copy;
    }

    public boolean isOptional() {
        return optional;
    }

    public boolean isIterative() {
        return iterative;
    }

    /*
     ***************************************************************************
     *************** Start Setters *********************************************
     ***************************************************************************
     */
    public void setType(TaskType type) {
        TaskType oldType = this.type;
        this.type = type;
    }

    public void setOptional(boolean optional) {
        boolean oldOptional = this.optional;
        this.optional = optional;
    }

    public void setIterative(boolean iterative) {
        boolean oldIterative = this.iterative;
        this.iterative = iterative;
    }

    public void setNbIteration(int nbIteration) {
        int oldNbIteration = this.nbIteration;
        this.nbIteration = nbIteration;
    }

    public void setCriticality(int criticality) {
        int oldCriticality = this.criticality;
        this.criticality = criticality;
    }

    public void setHelpText(String helpText) {
        String oldHelpText = this.helpText;
        this.helpText = helpText;
    }

    public void setMaxExecutionTime(int maxExecutionTime) {
        int oldMaxExecutionTime = this.maxExecutionTime;
        this.maxExecutionTime = maxExecutionTime;
    }

    public void setMinExecutionTime(int minExecutionTime) {
        int oldMinExecutionTime = this.minExecutionTime;
        this.minExecutionTime = minExecutionTime;
    }

    public void setFolded(boolean folded) {
        boolean oldFolded = this.folded;
        this.folded = folded;
    }

    public void setCopy(boolean copy) {
        boolean oldCopy = this.copy;
        this.copy = copy;
    }


    /*
     *************** End Setters ***********************************************
     */

 /*
     ***************************************************************************
     *************** Start Adding Method ***************************************
     ***************************************************************************
     */
 /*
     *************** End Adding Method *****************************************
     */

 /*
     ***************************************************************************
     *************** Start Removing Method *************************************
     ***************************************************************************
     */
 /*
     *************** End Removing Method ***************************************
     */
}
