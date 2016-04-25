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
public abstract class HamstersElement {

    private String description = "";
    private String oldDescription = "";
    private HamstersAPI api = null;

    public HamstersElement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getOldDescription() {
        return oldDescription;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
    }

    public void setOldDescription(String oldDescription) {
        this.oldDescription = oldDescription;
    }

    public HamstersAPI getApi() {
        return api;
    }

    public void setApi(HamstersAPI api) {
        HamstersAPI oldApi = this.api;
        this.api = api;
    }
}
