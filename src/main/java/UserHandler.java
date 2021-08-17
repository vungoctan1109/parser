import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class UserHandler extends DefaultHandler {
    private boolean isTitle;
    private boolean isDescription;
    private boolean isPubDate;
    private boolean isLink;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    private Article currentArticle;

    public ArrayList<Article> getArticleArrayList() {
        return articleArrayList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case Article.ITEM_TAG:
                currentArticle = new Article();
                break;
            case Article.TITLE_TAG:
                isTitle = true;
                break;
            case Article.DESCRIPTION_TAG:
                isDescription = true;
                break;
            case Article.PUBDATE_TAG:
                isPubDate = true;
                break;
            case Article.LINK_TAG:
                isLink = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case Article.ITEM_TAG:
                articleArrayList.add(currentArticle);
                break;
            case Article.TITLE_TAG:
                isTitle = false;
                break;
            case Article.DESCRIPTION_TAG:
                isDescription = false;
                break;
            case Article.PUBDATE_TAG:
                isPubDate = false;
                break;
            case Article.LINK_TAG:
                isLink = false;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (isTitle) {
            currentArticle.setTitle(value);
        }
        if (isDescription) {
            currentArticle.setDescription(value);
        }
        if (isPubDate) {
            currentArticle.setPubDate(value);
        }
        if (isLink) {
            currentArticle.setLink(value);
        }
    }
}
