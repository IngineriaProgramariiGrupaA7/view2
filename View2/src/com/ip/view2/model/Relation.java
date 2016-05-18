package com.ip.view2.model;

import javax.xml.bind.annotation.*;


public class Relation {
    private String source;
    private String destination;
    private String type;

    public Relation() {

    }

    public Relation(String source, String destination, String type) {
        this.source = source;
        this.destination = destination;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    @XmlElement(name="from")
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    @XmlElement(name="to")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute(name="type")
    public void setType(String type) {
        this.type = type;
    }
}
