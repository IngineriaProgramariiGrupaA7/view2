package com.ip.view2.xmlparser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import com.ip.view2.model.Diagram;


public class XMLReader {
    /**
     * Clasa JAXBContext furnizeaza punctul de intrare la API-ul JAXB. Acesta oferă o abstracție pentru gestionarea informațiilor Java/XML necesare pentru punerea în aplicare a operațiunilor JAXB: unmarshal, marshal și validați.
     * Clasa Unmarshaller oferă posibilitatea de a transforma datele XML într-un arbore de obiecte de conținut Java.
     * 
     * @param filePath numele documentului XML
     * @return 
     */
    public Diagram parseXMLFile(String filePath) {
        File file = new File(filePath);
        JAXBContext jaxbContext;
        Diagram diagram = null;
      
        try {
            
            jaxbContext = JAXBContext.newInstance(Diagram.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            diagram = (Diagram) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return diagram;
    }

}
