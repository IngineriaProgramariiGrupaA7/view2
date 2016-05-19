package com.ip.view2.model;

public abstract class Component {
    protected String id;
    protected String group;

    Component() {

    }

    /**
     * Preia id-ul si categoria componentei.
     */
	Component(String id, String group) {
        this.id = id;
        this.group = group;
    }

    /**
     * Returneaza id-ul componentei.
     */
	public String getId() {
        return id;
    }

    /**
     * Preia id-ul componentei.
     */
	public void setId(String id) {
        this.id = id;
    }

    /**
     * Returneaza categoria componentei.
     */
	public String getGroup() {
        return group;
    }

    /**
     * Preia categoria componentei.
     */
	public void setGroup(String group) {
        this.group = group;
    }
}
