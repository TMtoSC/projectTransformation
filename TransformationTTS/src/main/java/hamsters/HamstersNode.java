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
 * @author Eric Barboni <Eric.Barboni@irit.fr>
 * @author Racim Fahssi <Racim.Fahssi@irit.fr>
 */
public abstract class HamstersNode extends HamstersVertex implements Order {

    private final List<HamstersNode> children = new ArrayList<>();
    private HamstersNode parent = null;
    private int uniqueID = 0;
    private transient int order = 0;
    /*
     ordre qui d�fini si la tache est a droite ou a gauche
     par exemple pour le choix
     l'ordre est relatif a la profondeur de l'op�rateur
     */
    public HamstersNode(String description) {
        super(description);
    }

    /**
     * no parent then null
     *
     * @return
     */
    public HamstersNode getParent() {
        return parent;
    }

    public void setParent(HamstersNode parent) {
        HamstersNode oldParent = this.parent;
        this.parent = parent;
        //firePropertyChange(HamstersNodeProperty.HAMSTERS_NODE_SET_PARENT.name(), oldParent, oldParent);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public void setUniqueID(int unId) {
        uniqueID = unId;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(final int order) {
        this.order = order;
    }

    public List<HamstersNode> getChildren() {
        return children;
    }

    public synchronized void addChild(HamstersNode node) {
        if (!children.contains(node)) {
            children.add(node);
        }
    }

    public synchronized void removeChild(HamstersNode node) {
        if (children.contains(node)) {
            children.remove(node);
        }
    }

}
