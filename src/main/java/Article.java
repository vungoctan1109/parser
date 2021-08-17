public class Article {
    public static final String VN_EXPRESS_URL = "https://vnexpress.net/rss/tam-su.rss";
    public static final String ITEM_TAG = "item";
    public static final String TITLE_TAG = "title";
    public static final String DESCRIPTION_TAG = "description";
    public static final String PUBDATE_TAG = "pubDate";
    public static final String LINK_TAG = "link";

    private String title;
    private String description;
    private String pubDate;
    private String link;

    public Article() {
    }

    public Article(String title, String description, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' + "\n" +
                "description='" + description + '\'' + "\n" +
                "pubDate='" + pubDate + '\'' + "\n" +
                "link='" + link + '\'' +
                '}';
    }
}
