package Backend.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.Writer;

public class XMLWriter {

    private Document document;

    public XMLWriter(){

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =  documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    public Element addNode(Element parent, String name, String[][] attributes) {
        return addNode(parent, name, attributes, null);
    }

    public Element addNode(Element parent, String name, String[][] attributes, String text) {

        Element element = document.createElement(name);

        if(attributes != null) {
            for (String[] pair : attributes) {
                element.setAttribute(pair[0], pair[1]);
            }
        }

        if(parent==null){
            document.appendChild(element);
        } else {
            parent.appendChild(element);
        }

        if(text!=null){
            addText(element, text);
        }

        return element;
    }

    public void addText(Element parent, String text) {
        parent.appendChild(document.createTextNode(text));
    }

    public void exportFile(Writer writer) {

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(writer);

            transformer.transform(domSource, streamResult);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
