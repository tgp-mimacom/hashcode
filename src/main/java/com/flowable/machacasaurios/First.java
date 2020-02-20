///* Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.flowable.machacasaurios;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
///**
// * @author inaki
// */
//@Component
//public class First {
//
//    List<Slide> horizontalSlides = new ArrayList<>();
//
//    String verticalSlideAux;
//
//    public List<Slide> simple(List<Photo> photos) {
//        photos.forEach(photo -> {
//
//            if (photo.isHorizontal()) {
//                horizontalSlides.add(new Slide(photo.id));
//            } else {
//                if (verticalSlideAux.isEmpty()) {
//                    verticalSlideAux = photo.id;
//
//                } else {
//                    horizontalSlides.add(new Slide(verticalSlideAux, photo.id));
//                    verticalSlideAux = "";
//                }
//            }
//        });
//
//        return horizontalSlides;
//
//    }
//
//}
