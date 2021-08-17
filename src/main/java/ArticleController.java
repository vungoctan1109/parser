import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleController {
    public void save(Article article){
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("Can not open connection to database.");
            }
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("insert into articles");
            sqlBuilder.append(" ");
            sqlBuilder.append("(title, description, pubDate, link)");
            sqlBuilder.append(" ");
            sqlBuilder.append("values");
            sqlBuilder.append(" ");
            sqlBuilder.append("(?, ?, ?, ?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(sqlBuilder.toString());
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setString(3, article.getPubDate());
            preparedStatement.setString(4, article.getLink());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
