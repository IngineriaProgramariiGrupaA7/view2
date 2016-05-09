package com.ip.view2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "diagrama")
@XmlAccessorType(XmlAccessType.FIELD)
public class Diagram {

    @XmlElement(name="usecase")
    private List<Usecase> usecases;

    public Diagram() {
        usecases = new ArrayList<>();
    }

    public List<Usecase> getUsecases() {
        return usecases;
    }

    public void setUsecases(List<Usecase> usecases) {
        this.usecases = usecases;
    }
}
