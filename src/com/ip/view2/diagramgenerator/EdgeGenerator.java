package com.ip.view2.diagramgenerator;

import com.ip.view2.model.Relation;


public class EdgeGenerator {
    public String generateEdge(Relation relation, String color) {
        String edge = "{from: '" + relation.getSource() + "', to: '" + relation.getDestination() + "', color: '" + color + "'";
        switch (relation.getType()) {
            case "asociere":
                edge += getAssociationOptions();
                break;
            case "uniasociere":
                edge += getUniAssociationOptions();
                break;
            case "mostenire":
                edge += getInheritenceOptions();
                break;
            case "include":
                edge += getInclusionOptions();
                break;
            case "extinde":
                edge += getExtensionOptions();
                break;
        }
        return edge;
    }

    private String getAssociationOptions() {
        String options = "}";
        return options;
    }

    private String getUniAssociationOptions() {
        String options = ", arrows: {to: true}}";
        return options;
    }

    private String getInheritenceOptions() {
        String options = ", arrows: {empty: true, to: true}}";
        return options;
    }

    private String getInclusionOptions() {
        String options = ", label: '<<include>>', dashes: true, arrows: {to: true}}";
        return options;
    }

    private String getExtensionOptions() {
        String options = "label: '<<extend>>', dashes: true, arrows: {from: true}}";
        return options;
    }
}