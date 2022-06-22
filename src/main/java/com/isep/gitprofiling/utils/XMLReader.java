package com.isep.gitprofiling.utils;

import com.isep.gitprofiling.model.AdditionalInfo;
import com.isep.gitprofiling.model.Author;
import com.isep.gitprofiling.model.Report;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLReader {

        public List<Report> parseXML(String xml) {

            System.out.println(xml);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            String repository = "";
            String report_date= "";

            List<Report> listReports = new ArrayList<>();

            try {

                dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

                DocumentBuilder db = dbf.newDocumentBuilder();

                File file = new File("report.xml");
                FileWriter writer = new FileWriter("report.xml");
                writer.write(xml);
                writer.close();
                Document doc = db.parse(file);

                doc.getDocumentElement().normalize();

                System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
                System.out.println("------");

                NodeList list = doc.getDocumentElement().getChildNodes();


                for (int temp = 0; temp < list.getLength(); temp++) {

                    Node node = list.item(temp);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        Element element = (Element) node;

                        switch(element.getNodeName()){
                            case "repository":
                                repository=element.getTextContent();
                                break;
                            case "report-date":
                                report_date=element.getTextContent();
                                break;

                            case "blame":
                                NodeList listNodes1 = element.getChildNodes();

                                extractData(repository, report_date, listReports, listNodes1);
                                break;

                            case "changes":
                                NodeList listNodes = element.getChildNodes();

                                extractData(repository, report_date, listReports, listNodes);
                                break;

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listReports;
        }

    public void extractData(String repository, String report_date, List<Report> listReports, NodeList listNodes1) {
        for(int temp1 = 0; temp1 < listNodes1.getLength(); temp1++) {
            if (listNodes1.item(temp1).getNodeName().equals("authors")) {

                NodeList authors = listNodes1.item(temp1).getChildNodes();

                for (int temp2 = 0; temp2 < authors.getLength(); temp2++) {
                    String author_name ="";
                    Integer numCommits = null;
                    Integer insertions = null;
                    Integer deletions = null;
                    Float changesPercentage = null;
                    Integer rows = null;
                    Float stability = null;
                    Float age = null;
                    Float commentsPercentage = null;

                    if(authors.item(temp2).getNodeName().trim().equals("author")){
                        NodeList authorAtributes= authors.item(temp2).getChildNodes();

                        for (int temp3=0 ; temp3 < authorAtributes.getLength(); temp3++){

                            switch (authorAtributes.item(temp3).getNodeName()){
                                case "name":
                                    author_name = authorAtributes.item(temp3).getTextContent();
                                    break;

                                case "commits":
                                    numCommits = Integer.parseInt(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "insertions":
                                    insertions = Integer.parseInt(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "deletions":
                                    deletions = Integer.parseInt(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "percentage-of-changes":
                                    changesPercentage = Float.parseFloat(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "rows":
                                    rows = Integer.parseInt(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "stability":
                                    stability = Float.parseFloat(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "age":
                                    age = Float.parseFloat(authorAtributes.item(temp3).getTextContent());
                                    break;

                                case "percentage-in-comments":
                                    commentsPercentage = Float.parseFloat(authorAtributes.item(temp3).getTextContent());
                                    break;

                            }
                        }
                        if(listReports.size()==0)listReports.add(new Report(new Author(author_name,numCommits,insertions,deletions,changesPercentage),report_date,repository));
                        else {
                            boolean flag = false;
                            for (int i = 0; i < listReports.size(); i++) {
                                if (author_name.equals(listReports.get(i).getAuthor().getAuthorName()) && rows != null) {
                                    listReports.get(i).getAuthor().setAddInfo(new AdditionalInfo(rows, stability, age, commentsPercentage));
                                    flag = true;
                                }
                            }
                             if (!flag){
                                listReports.add(new Report(new Author(author_name, numCommits, insertions, deletions, changesPercentage), report_date, repository));
                            }
                        }

                    }

                }

            }
        }
    }


}
