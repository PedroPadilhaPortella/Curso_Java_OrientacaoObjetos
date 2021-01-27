import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date Moment;
    private String Title;
    private String Content;
    private Integer Likes;
    private List<Comment> comments = new ArrayList<>();
    
    public Post(Date Moment, String Title, String Content, Integer Likes) {
        this.Moment = Moment;
        this.Title = Title;
        this.Content = Content;
        this.Likes = Likes;
    }
    
    public Post() {}


    public Date getMoment() {
        return this.Moment;
    }

    public void setMoment(Date Moment) {
        this.Moment = Moment;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Integer getLikes() {
        return this.Likes;
    }

    public void setLikes(Integer Likes) {
        this.Likes = Likes;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void AddComment(Comment comment) {
        comments.add(comment);
    }

    public void RemoveComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTitle() + "\n");
        sb.append(this.getLikes() + " Likes - " + sdf.format(this.getMoment()) + "\n");
        sb.append(this.Content  +"\n");
        sb.append("Comments :\n");
        for (Comment comment : comments) {
            sb.append("   " + comment.getText()  + "\n");
        }

        return sb.toString();
    }
}
