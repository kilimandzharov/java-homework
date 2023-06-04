package com.kirillmozharov.program;

import com.kirillmozharov.util.Util;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * 1.	Для каждого класса реализовать методы загрузки данных из XML файла и выгрузку в него, структура которого
 *  должна соответствовать структуре класса. При реализации данных методов использовать Jackson Parser
 */

public class Program {
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {

            Util.transorm("UniverseInput.xml", "result.xml");

    }
}
