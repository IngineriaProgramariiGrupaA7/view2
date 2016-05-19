package com.ip.view2.model;

import javax.xml.bind.annotation.*;


public class Relation {
    private String source;
    private String destination;
    private String type;

    public Relation() {

    }

    /**
     * Preia sursa, destinatia muchiei si tipul relatiei.
     */
	public Relation(String source, String destination, String type) {
        this.source = source;
        this.destination = destination;
        this.type = type;
    }

    /**
     * Returneaza sursa muchiei.
     */
	public String getSource() {
        return source;
    }

    @XmlElement(name="from")
    /**
     * Preia sursa muchiei.
     */
	public void setSource(String source) {
        this.source = source;
    }

    /**
     * Returneaza destinatia muchiei.
     */
	public String getDestination() {
        return destination;
    }

    @XmlElement(name="to")
    /**
     * Preia destinatia muchiei.
     */
	public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returneaza tipul relatiei. 
     */
	public String getType() {
        return type;
    }

    @XmlAttribute(name="type")
    /**
     * Preia tipul relatiei. ex: association,uniassociation etc
     */
	public void setType(String type) {
        this.type = type;
    }
}
