package com.ip.view2.diagramgenerator;
import com.ip.view2.model.*;


// TODO: Auto-generated Javadoc
/**
 * The Class NodeGenerator.
 */
public class NodeGenerator {
    
    /**
     * In functie de tipul fiecarei componente, se genereaza in string-ul node
     * codul specific pentru desenarea efectiva a actorilor si a actiunilor
     *
     * @param component the component
     * @return the string
     */
    public String generateNode(Component component) {
        String node = "";
        switch(component.getGroup()) {
            case "actors" :
                node = "{id: '" + component.getId() + "', label: '" + component.getId() + "', group:'actors'}";
                break;
            case "actions" :
                String description = ((Action)component).getDescription();
                node = "{id: '" + component.getId() + "', label: '" + component.getId() + "', group:'actions', title: '" + description + "'}";
                break;
        }
        return node;
    }
}
