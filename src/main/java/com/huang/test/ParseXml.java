package com.huang.test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author huang
 * @Classname ParseXml
 * @Description TODO
 * @Date 2019/6/21 21:27
 * @Created by huang
 */
public class ParseXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //创建documentBuilder对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse(ParseXml.class.getResourceAsStream("/spring/spring-test.xml"));

        NodeList nodeList = document.getElementsByTagName("bean");
        for(int i = 0; i<nodeList.getLength(); i++){
          NamedNodeMap namedNodeMap = nodeList.item(i).getAttributes();
          //遍历节点属性
            for(int j = 0; j<namedNodeMap.getLength(); j++){
                //节点属性
                Node node = namedNodeMap.item(j);
                System.out.println(node.getNodeName());
                System.out.println(node.getNodeValue());
            }
            //获取该节点下的孩子节点
            NodeList childNodeList = nodeList.item(i).getChildNodes();

        }
    }

    static {
        System.out.println("test");
    }
}
