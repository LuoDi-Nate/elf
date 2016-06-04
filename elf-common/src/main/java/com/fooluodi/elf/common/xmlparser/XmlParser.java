package com.fooluodi.elf.common.xmlparser;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by di on 7/12/15.
 */
public class XmlParser {
    public static void main(String[] args) {
        String url = "a.xml";

        SAXReader reader = new SAXReader();
        try {
            InputStream resourceAsStream = XmlParser.class.getResourceAsStream(url);
            Document document = reader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
                Element next = (Element)iterator.next();

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
