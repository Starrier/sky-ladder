package org.starrier.sky.ladder.basic.xml;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author starrier
 * @date 2020/11/30
 */
public class ReadXML {

    private static final Logger logger = LoggerFactory.getLogger(ReadXML.class);

    public static Document readXmlDocument(String filePath) {


        Document doc = null;

        // 解析xml文档内容
        try (InputStream in = new FileInputStream(new File(filePath))) {
            SAXReader reader = new SAXReader();
            //in = XMLUtil.class.getClassLoader().getResourceAsStream(filePath);// 获取到xml文件

            doc = reader.read(in);
        } catch (Exception e) {
            logger.error("XMLUtil.readXml error: " + e);
            return null;
        }
        return doc;
    }

    public static List<Element> readXml(String filePath) {


        List<Element> elementList = null;
        // 解析xml文档内容
        try (InputStream in = new FileInputStream(new File(filePath))) {
            SAXReader reader = new SAXReader();
            //in = XMLUtil.class.getClassLoader().getResourceAsStream(filePath);// 获取到xml文件

            Document doc = reader.read(in);

            Element root = doc.getRootElement();
            elementList = root.elements();
            logger.debug("XMLUtil.readXml root name:" + root.getName());
        } catch (Exception e) {
            logger.error("XMLUtil.readXml error: " + e);
            return null;
        }
        return elementList;
    }

    public List<HashMap<String, String>> readUserDotXML(String path, String module_id) {

        List<HashMap<String, String>> users = new ArrayList<HashMap<String, String>>();

        String rootPath = path;

        List<Element> list = readXml(rootPath);
        if (list != null) {
            for (Element ele : list) {

                String index = ele.attributeValue("id");

                if (module_id.equals(index)) {

                    List<Element> userList = ele.elements();

                    if (userList != null && userList.size() > 0) {
                        for (Element user : userList) {

                            HashMap<String, String> hashMap = new HashMap<String, String>();

                            Element name = user.element("name");
                            Element password = user.element("password");

                            String nameValue = name.getText();
                            String passwordValue = password.getText();

                            hashMap.put("name", nameValue);
                            hashMap.put("password", passwordValue);

                            users.add(hashMap);
                        }
                    }

                    logger.debug("XMLFileServiceImpl.readUserDotXML Element module_id:" + module_id + ",users size:" + users.size());
                    break;
                }
            }
        }

        return users;
    }
}
