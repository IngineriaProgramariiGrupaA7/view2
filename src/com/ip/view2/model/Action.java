package com.ip.view2.model;

import javax.xml.bind.annotation.XmlElement;


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

    @XmlElement(name="description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    @XmlElement(name="name")
    public void setId(String id) {
        this.id = id;
    }
}
