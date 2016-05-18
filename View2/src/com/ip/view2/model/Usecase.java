package com.ip.view2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "usecase")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usecase {

    @XmlElement(name="actor")
    private List<Actor> actors;
    @XmlElement(name="action")
    private List<Action> actions;
    @XmlElement(name="relationship")
    private List<Relation> edges;
    private String color;

    public Usecase() {
        this.color = Diagram.getRandomColor();
    }

    public Usecase(String color) {
        actors = new ArrayList<>();
        actions = new ArrayList<>();
        edges = new ArrayList<>();
        this.color = color;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Action> getActions() {
        return actions;
    }

    public List<Relation> getEdges() {
        return edges;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }


    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void setEdges(List<Relation> edges) {
        this.edges = edges;
    }
}
