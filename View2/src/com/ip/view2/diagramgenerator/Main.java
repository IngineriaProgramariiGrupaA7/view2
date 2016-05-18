package com.ip.view2.diagramgenerator;

import com.ip.view2.model.Diagram;
import com.ip.view2.xmlparser.XMLReader;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    @SuppressWarnings("unused")
	public static void main(String args[]) {
        XMLReader xmlReader = new XMLReader();
        Diagram diagram = xmlReader.parseXMLFile("www/xml/data.xml");
        DiagramGenerator dg = new DiagramGenerator();

        try {
            dg.generateDiagram("www/xml/data.xml", "www/html/index.html");
            Desktop.getDesktop().open(new File("www/html/index.html"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
