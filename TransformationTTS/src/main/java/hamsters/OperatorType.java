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
 * @author Racim Fahssi <Racim.Fahssi@irit.fr>
 */
public enum OperatorType implements HamstersType {

    /**
     * enable operator {@literal >>}
     */
    ENABLE(">>", "enable", "enable16.png"),
    /**
     * disable operator {@literal [>}
     */
    DISABLE("[>", "disable", "disable16.png"),
    /**
     * concurrent operator {@literal |||}
     */
    CONCURRENT("|||", "concurrent", "concurrent16.png"),
    /**
     * choice operator {@literal []}
     */
    CHOICE("[]", "choice", "choice16.png"),
    /**
     * suspend resume operator {@literal [>}
     */
    SUSPEND_RESUME("|>", "suspend_resume", "suspend_resume16.png"),
    /**
     * order independent operator {@literal |=|}
     */
    ORDER_INDEPENDENT("|=|", "order_independent", "order_independent16.png");
    private final String expression;
    private final String name;
    private final String icon;

    private final String PALETTE_PATH = "fr/irit/hamsters/palette/";

    OperatorType(final String s, final String name, final String icon) {
        this.expression = s;
        this.name = name;
        this.icon = icon;
    }

    public String getIconString() {
        return PALETTE_PATH + icon;
    }

    /**
     *
     * @return
     */
    public String getStringValue() {
        return expression;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param s
     * @return
     */
    public static OperatorType getType(String s) {
        for (OperatorType t : values()) {
            if (t.getStringValue().equals(s) || t.getName().equals(s)) {
                return t;
            }
        }
        return ENABLE;
    }
}
