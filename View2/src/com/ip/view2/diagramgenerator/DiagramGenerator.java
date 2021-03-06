package com.ip.view2.diagramgenerator;

import com.ip.view2.model.*;
import com.ip.view2.xmlparser.XMLReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// TODO: Auto-generated Javadoc
/**
 * The Class DiagramGenerator.
 */
public class DiagramGenerator {
    
    /** Bufferul ce contine informatia din index.html */
    private BufferedWriter html;
    
    /** The diagram. */
    private Diagram diagram;
    
    /** The value of constant gravity. */
    private final int valueOfConstantGravity=-5000;

    /**
     * Se ataseaza tagul de head 
     */
    private void attachHead() {
        String head = null;
        try {
            head = new String(Files.readAllBytes(Paths.get("www/frames/head.html")), StandardCharsets.UTF_8);
            html.write(head);
            attachNetwork();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attach network.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void attachNetwork() throws IOException {
        html.write("\t\tfunction draw() {");
        attachNodes();
        attachEdges();
        attachOptions();
        createNetwork();
    }

    /**
     * Verifica daca nu exista duplicate in lista de componente
     *
     * @param components the components
     * @param id the id
     * @return true, if successful
     */
    private boolean notDuplicate(List<? extends Component> components, String id) {
        for(Component component : components) {
            if(component.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    /**
     * In cazul in care nu avem duplicate in cele doua liste se adauga in set id-ul componentei
     *
     * @param list1 the list1
     * @param list2 the list2
     * @return the list
     */
    private List<Component> union(List<? extends Component> list1, List<? extends Component> list2) {
        Set<Component> set = new HashSet<Component>();

        set.addAll(list1);
        for(Component component : list2) {
            if(notDuplicate(list1,component.getId())) {
                set.add(component);
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * Se preiau toti actorii din diagrama
     *
     * @param usecases the usecases
     * @return the all actors from diagram
     */
    private List<Component> getAllActorsFromDiagram(List<Usecase> usecases) {
        List<Component> actors = new ArrayList<>();
        for(Usecase usecase : usecases) {
            List<Actor> usecaseActors = usecase.getActors();
            actors = union(actors,usecaseActors);
        }
        return actors;
    }

    /**
     *	Se preiau toate actiunile din diagrama
     *
     * @param usecases the usecases
     * @return the all actions from diagram
     */
    private List<Component> getAllActionsFromDiagram(List<Usecase> usecases) {
        List<Component> actions = new ArrayList<>();
        for(Usecase usecase : usecases) {
            List<Action> usecaseActions = usecase.getActions();
            actions = union(actions,usecaseActions);
        }
        return actions;
    }
    
    /**
     * Se ataseaza actorii si actiunile diagramei
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void attachNodes() throws IOException {
        StringBuilder nodes = new StringBuilder("\n\t\t\tnodes = [\n\t\t\t\t");
        NodeGenerator nodeGenerator = new NodeGenerator();
        List<Usecase> usecases = diagram.getUsecases();
        List<Component> actors = getAllActorsFromDiagram(usecases);
        for(Component actor : actors) {
            String node = nodeGenerator.generateNode(actor);
            nodes.append(node).append(",\n\t\t\t\t");
        }
        List<Component> actions = getAllActionsFromDiagram(usecases);
        for(int i=0;i<actions.size()-1;i++) {
            String node = nodeGenerator.generateNode(actions.get(i));
            nodes.append(node).append(",\n\t\t\t\t");
        }
        String lastNode = nodeGenerator.generateNode(actions.get(actions.size() - 1));
        nodes.append(lastNode).append("\n\t\t\t];\n");
        html.write(String.valueOf(nodes));
    }

    /**
     * Se ataseaza muchiile diagramei
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void attachEdges() throws IOException {
        StringBuilder edges = new StringBuilder("\n\t\t\tedges = [\n\t\t\t\t");
        EdgeGenerator edgeGenerator = new EdgeGenerator();
        List<Usecase> usecases = diagram.getUsecases();
        for (int k=0;k<usecases.size()-1;k++) {
            List<Relation> relations = usecases.get(k).getEdges();
            for (Relation relation : relations) {
                String edge = edgeGenerator.generateEdge(relation, usecases.get(k).getColor());
                edges.append(edge).append(",\n\t\t\t\t");
            }
        }
        Usecase lastUsecase = usecases.get(usecases.size()-1);
        List<Relation> relations = lastUsecase.getEdges();
        for(int i=0;i<relations.size()-1;i++) {
            String edge = edgeGenerator.generateEdge(relations.get(i), lastUsecase.getColor());
            edges.append(edge).append(",\n\t\t\t\t");
        }
        String lastEdge = edgeGenerator.generateEdge(relations.get(relations.size()-1),lastUsecase.getColor());
        edges.append(lastEdge).append("\n\t\t\t];\n\n");
        html.write(String.valueOf(edges));
    }

    /**
     * Se ataseaza optiunile  diagramei din fisierul  options.js
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void attachOptions() throws IOException {
        String options = null;
        try {
            options = new String(Files.readAllBytes(Paths.get("www/frames/options.js")), StandardCharsets.UTF_8);
            int constantGravity=this.valueOfConstantGravity*diagram.getUsecases().size();
            html.write("\t\t\tvar gravityConstant="+constantGravity+";\n");
            html.write(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializarea retelei. Se citesc informatii din network.js , care vor fi introduse in pagina de index
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void createNetwork() throws IOException {
        String network = null;
        try {
            network = new String(Files.readAllBytes(Paths.get("www/frames/network.js")), StandardCharsets.UTF_8);
            html.write(network);
            html.write("\n\t\t}\n");
            html.write("function saveAs(){var canvas=document.getElementById(\'canv\');\nvar img = canvas.toDataURL(\"image/png\");\nvar a=document.createElement(\'a\');\na.href = img;\na.download = \"UseCaseDiagram.png\";\na.click();\n};\t</script>\n</head>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Se realizeaza atasarea body-ului
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void attachBody() throws IOException {
        String body = null;
        try {
            body = new String(Files.readAllBytes(Paths.get("www/frames/body.html")), StandardCharsets.UTF_8);
            html.write(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Genereaza diagrama prin parsearea xml-ului, dupa care se genereaza
     *	continutului tagului head si body, impreuna cu optiunile lor specifice.
     *
     * @param xmlPath the xml path
     * @param htmlPath the html path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void generateDiagram(String xmlPath, String htmlPath) throws IOException {
        XMLReader xmlReader = new XMLReader();
        diagram = xmlReader.parseXMLFile(xmlPath);

        html = new BufferedWriter(new FileWriter(htmlPath));
        attachHead();
        attachBody();
        html.close();
    }
}
