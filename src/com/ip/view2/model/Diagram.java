package com.ip.view2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


@XmlRootElement(name = "diagram")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diagram {

    @XmlElement(name = "usecase")
    private List<Usecase> usecases;
    private static List<String> colors;
    private static Random random;

    public Diagram() {
        usecases = new ArrayList<>();
        random = new Random();
        colors = new LinkedList<>();
        colors.add("blue");
        colors.add("red");
        colors.add("green");
        colors.add("yellow");
        colors.add("orange");
        colors.add("purple");
        colors.add("brown");
        colors.add("cyan");
        colors.add("magenta");
    }

    public List<Usecase> getUsecases() {
        return usecases;
    }

    public void setUsecases(List<Usecase> usecases) {
        this.usecases = usecases;
    }

    public static String getRandomColor() {
        int index = random.nextInt(colors.size());
        String color = colors.get(index);
        colors.remove(index);
        return color;
    }
}