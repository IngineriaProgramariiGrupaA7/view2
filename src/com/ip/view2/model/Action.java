package com.ip.view2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Action extends Component {
    private String description;

    public Action() {
        this.setGroup("actions");
    }

    public Action(String id, String group) {
        super(id, group);
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name="descriere")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    @XmlElement(name="nume")
    public void setId(String id) {
        this.id = id;
    }
}
