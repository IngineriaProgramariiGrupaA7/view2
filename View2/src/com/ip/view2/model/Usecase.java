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

    /**
     * Preia o culoare alesa random.
     */
	public Usecase() {
        this.color = Diagram.getRandomColor();
    }

    /**
     * Creaza un actor, o actiune si o muchie pentru care va prelua informatiile ulterior.
     */
	public Usecase(String color) {
        actors = new ArrayList<>();
        actions = new ArrayList<>();
        edges = new ArrayList<>();
        this.color = color;
    }

    /**
     * Adauga un actor.
     */
	public void addActor(Actor actor) {
        actors.add(actor);
    }

    /**
     * Adauga o actiune.
     */
	public void addAction(Action action) {
        actions.add(action);
    }

    /**
     * Returneaza informatiile despre actor.
     */
	public List<Actor> getActors() {
        return actors;
    }

    /**
     * Returneaza informatiile despre actiune.
     */
	public List<Action> getActions() {
        return actions;
    }

    /**
     * Returneaza informatiile despre muchie.
     */
	public List<Relation> getEdges() {
        return edges;
    }

    /**
     * Returneaza culoarea.
     */
	public String getColor() {
        return color;
    }

    /**
     * Preia culoarea.
     */
	public void setColor(String color) {
        this.color = color;
    }

    /**
     * Preia toate informatiile despre actor.
     */
	public void setActors(List<Actor> actors) {
        this.actors = actors;
    }


    /**
     * Preia toate informatiile despre actiune.
     */
	public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * Preia toate informatiile despre muchie.
     */
	public void setEdges(List<Relation> edges) {
        this.edges = edges;
    }
}
