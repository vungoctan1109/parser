import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class SAXParserDemo {
    public static void main(String[] args) {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(Article.VN_EXPRESS_URL, userhandler);
            ArrayList<Article> listArticle = userhandler.getArticleArrayList();
            for (Article article: listArticle){
                System.out.println(article.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
