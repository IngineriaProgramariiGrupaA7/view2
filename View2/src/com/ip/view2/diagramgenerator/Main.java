package com.ip.view2.diagramgenerator;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Class Main.
 */
public class Main {
    
    /**
     * Se initializeaza XMLReader pentru parsarea datelor din xml
     * Se Apleleaza functia de generarea a diagramei,in index.html care va fi deschisa cu 
     * browserul implicit
     *
     * @param args the arguments
     */
	public static void main(String args[]) {
        DiagramGenerator dg = new DiagramGenerator();
        try {
            dg.generateDiagram("www/xml/data.xml", "www/html/index.html");
            Desktop.getDesktop().open(new File("www/html/index.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
