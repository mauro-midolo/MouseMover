# Mouse Mover [![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)](https://github.com/mauro-midolo/MouseMover/blob/master/LICENSE) [![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven.plugins/maven-javadoc-plugin.svg?label=Maven%20Central)](https://mvnrepository.com/artifact/com.github.mauro-midolo/MouseMover)
## Tool usage
You can use the application directly using the .exe file (for windows) or .jar file (for linux or MacOS) <br>
You can download the latest version from [here](https://repo1.maven.org/maven2/com/github/mauro-midolo/MouseMover/1.4.1/MouseMover-1.4.1-distribution.zip) <br>
This is the application interface:<br>

![Mouse Mover example](https://github.com/mauro-midolo/MouseMover/blob/master/src/main/resources/MouseMover.PNG?raw=true)
## Java API Usage
You also can activate the mouse mover inside your java application using the API<br>
Follow the steps to import and use the library:
* Import the project as maven dependency <br>
`  
  <dependency>
  <groupId>com.github.mauro-midolo</groupId>
  <artifactId>MouseMover</artifactId>
  <version>1.4.1</version>
  </dependency>
`
  
* Create and execute following code<br>
  `
  import com.github.mauromidolo.mousemover.controll.MouseMoverController;
  MouseMoverController.getInstance().switchOn(30);
  `