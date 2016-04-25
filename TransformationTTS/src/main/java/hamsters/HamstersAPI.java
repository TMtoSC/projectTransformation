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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Racim Fahssi <Racim.Fahssi@irit.fr>
 */
public class HamstersAPI {

    /*
     ***************************************************************************
     *************** Start Variables *******************************************
     ***************************************************************************
     */
    private final List<HamstersNode> hamstersNode = new ArrayList<>();

    private String modelName;

    // ROLE and SUBROUTINE
    private boolean subroutine = false;
    private String role = null;

    /*
     *************** End Variables *********************************************
     */

 /*
     ***************************************************************************
     *************** Start Constructors ****************************************
     ***************************************************************************
     */
    public HamstersAPI(String modelName) {
        this.modelName = modelName;
    }

    /*
     *************** End Constructors *******************************************
     */

 /*
     ***************************************************************************
     *************** Start Getters *********************************************
     ***************************************************************************
     */
    public String getModelName() {
        return modelName;
    }

    public List<HamstersNode> getHamstersNode() {
        return hamstersNode;
    }

    public List<HamstersElement> getHierachicalTree() {
        List<HamstersElement> common = new ArrayList<>();
        common.addAll(hamstersNode);
        return common;
    }

    /*
     *************** End Getters ***********************************************
     */

 /*
     ***************************************************************************
     *************** Start Setters *********************************************
     ***************************************************************************
     */
    public void setModelName(String modelName) {
        String oldModelName = this.modelName;
        this.modelName = modelName;
    }

    /*
     *************** End Setters ***********************************************
     */

 /*
     ***************************************************************************
     *************** Start Hamsters Property Change ****************************
     ***************************************************************************
     */
 /*
     *************** End Hamsters Property Change ******************************
     */

 /*
     ***************************************************************************
     *************** Start Adding Method ***************************************
     ***************************************************************************
     */
    public void addHamstersNode(HamstersNode node) {
        if (!hamstersNode.contains(node)) {
            hamstersNode.add(node);
            node.setApi(this);
        }
    }


    /*
     *************** End Adding Method *****************************************
     */

 /*
     ***************************************************************************
     *************** Start Removing Method *************************************
     ***************************************************************************
     */
    public void removeHamstersNode(HamstersNode node) {
        if (hamstersNode.contains(node)) {
            hamstersNode.remove(node);
        }
    }

    // ROLE and subroutine
    public void setSubRoutine(boolean issub) {
        subroutine = issub;
    }

    public boolean isSubRoutine() {
        return subroutine;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
