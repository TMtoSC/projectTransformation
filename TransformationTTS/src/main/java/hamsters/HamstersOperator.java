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
 * @author Célia Martinie <Celia.Martinie-De-Almeida@irit.fr>
 */
public class HamstersOperator extends HamstersNode {

    private transient OperatorType type = OperatorType.ENABLE;

    public HamstersOperator() {
        super("");
    }

    public OperatorType getType() {
        return type;
    }

    public void setType(OperatorType type) {
        OperatorType oldType = this.type;
        this.type = type;
    }

    public HamstersNode getNode(int order) {
        for (HamstersNode node : this.getChildren()) {
            if (node.getOrder() == order) {
                return node;
            }
        }
        return null;
    }

    @Override
    public String getDescription() {
        return type.getStringValue();
    }

}
