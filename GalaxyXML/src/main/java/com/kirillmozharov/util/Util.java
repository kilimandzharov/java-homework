package com.kirillmozharov.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Util {
    /**
     * 2.	Для файла Вселенной произвести трансформацию в static методе
     * (параметры: имя входного и имя выходного файлов) класса Util по следующему признаку:
     * 	Все планеты с одинаковыми именами группируются в теги
     *  <EqualGroup number=”i” name=””>…</ EqualGroup>, где number  -
     *  это номер тега в файле, name – имя группы тегов, объединенных по данному имени
     * 	Все теги EqualGroup должны быть размещены в корневом теге Planets
     * @param from
     * @param to
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void transorm(String from, String to) throws IOException, SAXException,
            ParserConfigurationException, TransformerException {
        HashMap<String, ArrayList<Element>> grouped = new HashMap<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(from));
        NodeList nodeList = document.getElementsByTagName("Planet");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String name = element.getElementsByTagName("Name").item(0).getTextContent();
            ArrayList<Element> elements = grouped.getOrDefault(name, new ArrayList<>());
            elements.add(element);
            grouped.put(name, elements);
        }

        Document newDocument = documentBuilder.newDocument();
        Element planets = newDocument.createElement("Planets");
        newDocument.appendChild(planets);

        int counter = 0;
        for (Map.Entry<String, ArrayList<Element>> stringArrayListEntry : grouped.entrySet()) {
            String groupName = stringArrayListEntry.getKey();
            Element entryGroup = newDocument.createElement("EntryGroup");
            entryGroup.setAttribute("name", groupName);
            entryGroup.setAttribute("number", Integer.toString(counter++));
            for (Element element : stringArrayListEntry.getValue()) {
                Element addition = (Element) newDocument.importNode(element, true);
                entryGroup.appendChild(addition);
            }
            planets.appendChild(entryGroup);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(newDocument);
        StreamResult result = new StreamResult(new File(to));
        transformer.transform(source, result);
    }
}
