## LowPoly
This library is a tool for generating low poly photo.`LowPoly` is implemented by `JNI`, so it's faster than other in java.

Like this:

<img src="/art/mooncake.jpg" alt="screenshot" title="screenshot" width="512" height="512" />
<img src="/art/captain.jpg" alt="screenshot" title="screenshot" width="960" height="600" />



## Including in your project

There are two ways:

 1.You can import the module `lowpoly` to your project by Android Studio
  
  
 2.`LowPoly` is available in the MavenCentral, so getting it as simple as adding it as a dependency
 
 ```gradle
 
 compile 'com.uniquestudio:lowpoly:1.0.0'
 
 ```

 
 
## Usage
 
 
 ```java
 Bitmap out = LowPoly.generate(Bitmap bitmap, int blur);
 ```
 
 Larger the param `blur` is, the `out` bitmap is more abstract. 
 
## License
 
     Copyright 2016 CoXier
 
     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at
 
        http://www.apache.org/licenses/LICENSE-2.0
 
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
 
 