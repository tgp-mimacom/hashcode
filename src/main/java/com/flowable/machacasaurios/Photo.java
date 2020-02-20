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
public class Photo {

    @Override
    public String toString() {
        return "Photo{" +
            "orientation='" + orientation + '\'' +
            ", numberOfTags='" + numberOfTags + '\'' +
            ", tags=" + tags +
            '}';
    }
    public Photo(String id, String numberOfTags, String orientation, List<String> tags) {
        this.numberOfTags = numberOfTags;
        this.orientation = orientation;
        this.tags = tags;
        this.id = id;
    }
    String numberOfTags;
    String orientation;
    String id;
    List<String> tags;

    public boolean isHorizontal() {
        return orientation.equals("H");
    }

}
