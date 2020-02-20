/* Licensed under the Apache License, Version 2.0 (the "License");
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
package com.flowable.machacasaurios;

import java.util.List;

/**
 * @author inaki
 */
public class Slide {


    String idHorizontal = "";

    String idVertical1 = "";
    String idVertical2 = "";

    List<String> tags;


    public Slide(String idHorizontal, List<String> tags) {
        this.idHorizontal = idHorizontal;
        this.tags = tags;
    }


    public Slide(String idVertical1, String idVertical2, List<String> tags) {
        this.idVertical1 = idVertical1;
        this.idVertical2 = idVertical2;
        this.tags = tags;
    }

    @Override
    public String toString() {
        if(idHorizontal.isEmpty()) {
            return idVertical1 + " " +  idVertical2;
        }
        return idHorizontal;
    }
}
