package cn.tekin.spring.util;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * XML处理工具类
 *
 * @author Tekin   tekintian@gmail.com
 * @version $Id: $Id
 */
public class XmlUtil {
    /**
     * Xml util
     */
    public XmlUtil() {
    }

    /**
     * xml转对象
     *
     * @param xml      xml
     * @param objClass obj class
     * @return object
     */
    public static Object toObject(String xml, Class objClass) {
        Persister serializer = new Persister();

        try {
            return serializer.read(objClass, xml);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    /**
     * xml转字符串
     *
     * @param obj obj
     * @return string
     */
    public static String toString(Object obj) {
        Serializer serializer = new Persister();
        StringWriter output = new StringWriter();

        try {
            serializer.write(obj, output);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return output.toString();
    }

    /**
     * xml转 HashMap
     *
     * @param strXML str xml
     * @return map
     */
    public static Map<String, String> toMap(String strXML) {
        try {
            Map<String, String> data = new HashMap();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for(int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == 1) {
                    Element element = (Element)node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }

            try {
                stream.close();
            } catch (Exception var10) {
            }

            return data;
        } catch (Exception var11) {
            var11.printStackTrace();
            return null;
        }
    }
}

