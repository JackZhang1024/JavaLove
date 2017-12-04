package builder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by zfz on 2017/12/10.
 */
public class XmlUtils {

    public static Object getBean(){
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("config.xml"));
            NodeList nodeList = doc.getElementsByTagName("classname");
            Node node = nodeList.item(0).getFirstChild();
            String nodeValue = node.getNodeValue();
            Class c = Class.forName(nodeValue);
            return c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
