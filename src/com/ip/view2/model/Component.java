package com.ip.view2.model;

public abstract class Component {
    protected String id;
    protected String group;

    Component() {

    }

    Component(String id, String group) {
        this.id = id;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
