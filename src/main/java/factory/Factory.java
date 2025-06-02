package factory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import action.Action;

public class Factory {
    private static HashMap<String, Class<? extends Action>> classHashMap = new HashMap<>();

    static {
        try {
            InputStream xmlStream = Factory.class.getClassLoader().getResourceAsStream("actions.xml");
            if (xmlStream == null) {
                throw new RuntimeException("actions.xml non trouvé dans les ressources");
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlStream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("action");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    String name = elem.getAttribute("name");
                    String className = elem.getAttribute("class");
                    Class<? extends Action> clazz = (Class<? extends Action>) Class.forName(className);
                    classHashMap.put(name, clazz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Action get(String className) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<? extends Action> clazz = classHashMap.get(className);
        if (clazz == null) throw new IllegalArgumentException("Action non trouvée : " + className);
        return clazz.getDeclaredConstructor().newInstance();
    }
}