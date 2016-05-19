package com.ip.view2.model;

import javax.xml.bind.annotation.XmlElement;


public class Actor extends Component {
    
	public Actor(String id, String group) {
        super(id, group);
    }
	/**
     * Seteaza categoria componentei.
     */
    public Actor() {
        this.setGroup("actors");
    }

	/**
     * Returneaza id-ul componentei.
     */
    public String getId() {
        return id;
    }

    @XmlElement(name="name")
	/**
     * Preia id-ul componentei.
     */
	public void setId(String id) {
        this.id = id;
    }
}
