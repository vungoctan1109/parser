import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DomParserDemo {
    public static void main(String[] args) {
        ArrayList<Article> list =readXml();
        for (Article article:list){
            System.out.println(article.toString());
        }
    }

    private static ArrayList<Article> readXml(){
        ArrayList arrayListArticle = new ArrayList<>();
        ArticleController articleController = new ArticleController();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(Article.VN_EXPRESS_URL);
            Element element = document.getDocumentElement();
            NodeList listArticle = element.getElementsByTagName(Article.ITEM_TAG);
            for (int i = 0; i < listArticle.getLength(); i++) {
                Article article = new Article();
                Node articleNode = listArticle.item(i);
                NodeList articleChildNodeList = articleNode.getChildNodes();
                for (int j = 0; j < articleChildNodeList.getLength(); j++) {
                    Node childNode = articleChildNodeList.item(j);
                    if (childNode.getNodeType() != Node.ELEMENT_NODE){
                        continue;
                    }
                    switch (childNode.getNodeName()){
                        case Article.TITLE_TAG:
                            article.setTitle(childNode.getTextContent());
                            break;
                        case Article.DESCRIPTION_TAG:
                            article.setDescription(childNode.getTextContent());
                            break;
                        case Article.PUBDATE_TAG:
                            article.setPubDate(childNode.getTextContent());
                            break;
                        case Article.LINK_TAG:
                            article.setLink(childNode.getTextContent());
                            break;
                    }
                }
                arrayListArticle.add(article);
                articleController.save(article);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return arrayListArticle;
    }
}
