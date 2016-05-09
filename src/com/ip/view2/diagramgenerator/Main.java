package com.ip.view2.diagramgenerator;

import com.ip.view2.model.Diagram;
import com.ip.view2.xmlparser.XMLReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Rares on 09.05.2016.
 */
public class Main {
    public static void main(String args[]) {
        XMLReader xmlReader = new XMLReader();
        Diagram diagram = xmlReader.parseXMLFile("www/xml/data.xml");
        DiagramGenerator dg = new DiagramGenerator();

        try {
         dg.generateDiagram("www/xml/data.xml","www/html/index.html");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
