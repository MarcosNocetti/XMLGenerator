/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author gabri
 */
public class XMLGenerate {

    public static final String xmlFilePath = "..\\xmlfile.xml";
    
   
    
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        try {
            
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
            // root element
            Element root = document.createElement("company");
            document.appendChild(root);
 
            // employee element
            Element employee = document.createElement("employee");
 
            root.appendChild(employee);
 
            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            employee.setAttributeNode(attr);
 
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("James"));
            employee.appendChild(firstName);
 
            // lastname element
            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode("Harley"));
            employee.appendChild(lastname);
 
            // gender element
            Element gender = document.createElement("gender");
            gender.appendChild(document.createTextNode("Male"));
            employee.appendChild(gender);
            
            // salary element
            Element salary = document.createElement("salary");
            salary.appendChild(document.createTextNode("3000$"));
            employee.appendChild(salary);
            
            // address elements
            Element Address = document.createElement("Address");
            Address.appendChild(document.createTextNode("Rua dos bobos, 25"));
            employee.appendChild(Address);
 
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
 
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        Handler d = new Handler(); 
        saxParser.parse(new File("..\\xmlfile.xml"), d);
        List<Employee> empList = d.getEmpList();
        //print employee information
        for(Employee emp : empList)
            System.out.println(emp);
    }  
}
