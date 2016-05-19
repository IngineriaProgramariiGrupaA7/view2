package com.ip.view2.model;

import javax.xml.bind.annotation.XmlElement;


public class Action extends Component {
    private String description;
	
	/**
     * Seteaza categoria componentei.
     */
    public Action() {
        this.setGroup("actions");
    }

    
	public Action(String id, String group) {
        super(id, group);
    }

    /**
     * Returneaza decrierea componentei.
     */
	public String getDescription() {
        return description;
    }

    @XmlElement(name="description")
    /**
     * Preia descrierea componentei.
     */
	public void setDescription(String description) {
        this.description = description;
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
