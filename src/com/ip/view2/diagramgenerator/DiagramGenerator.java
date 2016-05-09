package com.ip.view2.diagramgenerator;

import com.ip.view2.model.*;
import com.ip.view2.xmlparser.XMLReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Rares on 09.05.2016.
 */
public class DiagramGenerator{
    private BufferedWriter html;
    private Diagram diagram;

    private void attachHead() {
        String head = null;
        try {
            head = new String(Files.readAllBytes(Paths.get("www/frames/head.html")), StandardCharsets.UTF_8);
            html.write(head);
            attachNetwork();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void attachNetwork() throws IOException {
        html.write("\t\tfunction draw() {");
        attachNodes();
        attachEdges();
        attachOptions();
        createNetwork();
    }

    private void attachNodes() throws IOException {
        StringBuilder nodes = new StringBuilder("\n\t\t\tnodes = [\n\t\t\t\t");
        NodeGenerator nodeGenerator = new NodeGenerator();
        List<Usecase> usecases = diagram.getUsecases();
        for(Usecase usecase : usecases) {
            List<Actor> actors = usecase.getActors();
            for(Actor actor : actors) {
                String node = nodeGenerator.generateNode(actor);
                nodes.append(node).append(",\n\t\t\t\t");
            }

            List<Action> actions = usecase.getActions();
            for(int i=0;i<actions.size() - 1;i++) {
                String node = nodeGenerator.generateNode(actions.get(i));
                nodes.append(node).append(",\n\t\t\t\t");
            }
            String lastNode = nodeGenerator.generateNode(actions.get(actions.size()-1));
            nodes.append(lastNode).append("\n\t\t\t];\n");
        }
        html.write(String.valueOf(nodes));
    }

    private void attachEdges() throws IOException {
        StringBuilder edges = new StringBuilder("\n\t\t\tedges = [\n\t\t\t\t");
        EdgeGenerator edgeGenerator = new EdgeGenerator();
        List<Usecase> usecases = diagram.getUsecases();
        for(Usecase usecase : usecases) {
            List<Relation> relations = usecase.getEdges();
            for(int i=0;i<relations.size()-1;i++) {
                String edge = edgeGenerator.generateEdge(relations.get(i),usecase.getColor());
                edges.append(edge).append(",\n\t\t\t\t");
            }
            String lastEdge = edgeGenerator.generateEdge(relations.get(relations.size()-1),usecase.getColor());
            edges.append(lastEdge).append("\n\t\t\t];\n\n");
        }
        html.write(String.valueOf(edges));
    }

    private void attachOptions() throws IOException{
        String options = null;
        try {
            options = new String(Files.readAllBytes(Paths.get("www/frames/options.js")), StandardCharsets.UTF_8);
            html.write(options);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNetwork() throws IOException{
        String network = null;
        try {
            network = new String(Files.readAllBytes(Paths.get("www/frames/network.js")), StandardCharsets.UTF_8);
            html.write(network);
            html.write("\n\t\t}\n\t</script>\n</head>\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void attachBody() throws IOException{
        String body = null;
        try {
            body = new String(Files.readAllBytes(Paths.get("www/frames/body.html")), StandardCharsets.UTF_8);
            html.write(body);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateDiagram(String xmlPath, String htmlPath) throws IOException {
        XMLReader xmlReader = new XMLReader();
        diagram = xmlReader.parseXMLFile(xmlPath);

        html = new BufferedWriter(new FileWriter(htmlPath));
        attachHead();
        attachBody();
        html.close();
    }
}
