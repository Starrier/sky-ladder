/*
package org.starrier.sky.ladder.basic.xml;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static org.starrier.sky.ladder.basic.xml.ReadXML.readXmlDocument;

*/
/**
 * @author starrier
 * @date 2020/11/30
 *//*

public class CreateXML {

    private static final Logger logger = LoggerFactory.getLogger(CreateXML.class);

    public boolean createUserDotXML(String path, String type) {

        boolean writen = true;
        OutputStream outputStream = null;
        XMLWriter xmlWriter = null;
        Document document = null;

        String rootPath = path;

        try {
            document = DocumentHelper.createDocument();
            Element newRootNode = DocumentHelper.createElement(type);
            Element newModule1Node = DocumentHelper.createElement("module");

            newModule1Node.addAttribute("id", "1");
            newRootNode.add(newModule1Node);
            document.add(newRootNode);

            OutputFormat outputFormat = new OutputFormat();
            outputFormat.setEncoding("UTF-8");

            outputStream = new FileOutputStream(rootPath);
            xmlWriter = new XMLWriter(outputStream, outputFormat);

            xmlWriter.write(document);

        } catch (IOException e) {
            logger.error("ConfigFileServiceImpl.createServerDotXML error: " + e);
            return false;
        } catch (Exception e) {
            logger.error("ConfigFileServiceImpl.createServerDotXML error: " + e);
            return false;
        }

        return writen;
    }

    public boolean writeUserDotXML(String path, String module_id, String userName, String passWord) {

        boolean writen = true;

        XMLWriter xmlWriter = null;
        Document document;

        String rootPath = path;

        try (OutputStream outputStream = new FileOutputStream(rootPath);) {
            document = readXmlDocument(rootPath);
            if (document != null) {
                Element root = document.getRootElement();
                List<Element> elementList = root.elements();

                for (Element ele : elementList) {

                    String id = ele.attributeValue("id");
                    if (id.equals(module_id)) {

                        List<Element> userList = ele.elements();

                        if (userList != null && userList.size() > 0) {

                            // 进行比对，是否已存在数据
                            for (Element user : userList) {

                                Element name = user.element("name");
                                String nameValue = name.getText();

                                if (nameValue.equals(userName)) {
                                    writen = false;
                                    break;
                                }
                            }

                            // 有需求才新增
                            if (writen) {

                                Element new_user_node = DocumentHelper.createElement("user");
                                Element new_name_node = DocumentHelper.createElement("name");
                                Element new_pass_node = DocumentHelper.createElement("password");
                                Element new_date_node = DocumentHelper.createElement("date");

                                new_name_node.setText(userName);
                                new_pass_node.setText(passWord);

                                new_user_node.addAttribute("index", userList.size() + 1 + "");

                                new_user_node.add(new_name_node);
                                new_user_node.add(new_pass_node);
                                new_user_node.add(new_date_node);

                                ele.add(new_user_node);
                            }
                        } else {

                            Element new_user_node = DocumentHelper.createElement("user");
                            Element new_name_node = DocumentHelper.createElement("name");
                            Element new_pass_node = DocumentHelper.createElement("password");
                            Element new_date_node = DocumentHelper.createElement("date");

                            new_name_node.setText(userName);
                            new_pass_node.setText(passWord);

                            new_user_node.addAttribute("index", "1");

                            new_user_node.add(new_name_node);
                            new_user_node.add(new_pass_node);
                            new_user_node.add(new_date_node);

                            ele.add(new_user_node);
                        }
                        break;
                    }
                }
            }

            if (writen) {
                OutputFormat outputFormat = new OutputFormat();
                outputFormat.setEncoding("UTF-8");


                xmlWriter = new XMLWriter(outputStream, outputFormat);

                xmlWriter.write(document);
            }
        } catch (IOException e) {
            logger.error("XMLFileServiceImpl.writeChangeDotXML error: " + e);
        } catch (Exception e) {
            logger.error("XMLFileServiceImpl.writeChangeDotXML error: " + e);
        }

        return writen;
    }
}
*/
