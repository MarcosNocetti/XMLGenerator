/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerate;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author gabri
 */
public class Handler extends DefaultHandler{

	// List to hold Employees object
	private List<Employee> empList = null;
	private Employee emp = null;
	private StringBuilder data = null;

	// getter method for employee list
	public List<Employee> getEmpList() {
		return empList;
	}

	boolean bSalary = false;
	boolean bName = false;
        boolean bSurname = false;

	boolean bGender = false;
	boolean bAddress = false;

        @Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("employee")) {
			// create a new Employee and put it in Map
			String id = attributes.getValue("id");
			// initialize Employee object and set id attribute
			emp = new Employee();
			emp.setId(Integer.parseInt(id));
			// initialize list
			if (empList == null)
				empList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("firstname")) {
			// set boolean values for fields, will be used in setting Employee variables
			bName = true;
                } else if (qName.equalsIgnoreCase("lastname")) {
			bSurname = true;
		} else if (qName.equalsIgnoreCase("salary")) {
			bSalary = true;
		} else if (qName.equalsIgnoreCase("gender")) {
			bGender = true;
		} else if (qName.equalsIgnoreCase("address")) {
			bAddress = true;
		}
		// create the data container
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bSalary) {
			// age element, set Employee age
			emp.setSalary(data.toString());
			bSalary = false;
		} else if (bName) {
			emp.setName(data.toString());
			bName = false;
                } else if (bSurname) {
			emp.setSurname(data.toString());
			bSurname = false;
		} else if (bAddress) {
			emp.setAdress(data.toString());
			bAddress = false;
		} else if (bGender) {
			emp.setGender(data.toString());
			bGender = false;
		}
		
		if (qName.equalsIgnoreCase("Employee")) {
			// add Employee object to list
			empList.add(emp);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
