package com.ip.view2.diagramgenerator;
import com.ip.view2.model.*;


public class NodeGenerator {
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
