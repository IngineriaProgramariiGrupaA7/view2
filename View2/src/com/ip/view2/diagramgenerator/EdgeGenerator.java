package com.ip.view2.diagramgenerator;

import com.ip.view2.model.Relation;


// TODO: Auto-generated Javadoc
/**
 * The Class EdgeGenerator.
 */
public class EdgeGenerator {
    
    /**
     * In functie de tipul fiecarei relatii, se genereaza in string-ul edge 
     * codul specific pentru desenarea efectiva muchiilor
     *
     * @param relation the relation
     * @param color the color
     * @return the string
     */
    public String generateEdge(Relation relation, String color) {
        String edge = "{from: '" + relation.getSource() + "', to: '" + relation.getDestination() + "', color: '" + color + "'";
        switch (relation.getType()) {
            case "association":
                edge += getAssociationOptions();
                break;
            case "uniassociation":
                edge += getUniAssociationOptions();
                break;
            case "generalization":
                edge += getInheritenceOptions();
                break;
            case "include":
                edge += getInclusionOptions();
                break;
            case "extend":
                edge += getExtensionOptions();
                break;
        }
        return edge;
    }

    /**
     * Gets the association options.
     *
     * @return the association options
     */
    private String getAssociationOptions() {
        String options = "}";
        return options;
    }

    /**
     * Gets the uni association options.
     *
     * @return the uni association options
     */
    private String getUniAssociationOptions() {
        String options = ", arrows: {to: true}}";
        return options;
    }

    /**
     * Gets the inheritence options.
     *
     * @return the inheritence options
     */
    private String getInheritenceOptions() {
        String options = ", arrows: {empty: true, to: true}}";
        return options;
    }

    /**
     * Gets the inclusion options.
     *
     * @return the inclusion options
     */
    private String getInclusionOptions() {
        String options = ", label: '<<include>>', dashes: true, arrows: {to: true}}";
        return options;
    }

    /**
     * Gets the extension options.
     *
     * @return the extension options
     */
    private String getExtensionOptions() {
        String options = ", label: '<<extend>>', dashes: true, arrows: {to: true}}";
        return options;
    }
}