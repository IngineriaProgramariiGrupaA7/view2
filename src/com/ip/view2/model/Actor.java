package com.ip.view2.model;

import javax.xml.bind.annotation.XmlElement;


public class Actor extends Component {
    public Actor(String id, String group) {
        super(id, group);
    }
    public Actor() {
        this.setGroup("actors");
    }


    public String getId() {
        return id;
    }

    @XmlElement(name="name")
    public void setId(String id) {
        this.id = id;
    }
}
