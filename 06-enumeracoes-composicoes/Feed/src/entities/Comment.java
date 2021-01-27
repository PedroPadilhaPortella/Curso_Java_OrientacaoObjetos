public class Comment 
{
    private String Text;

    public Comment(String text) {
        this.Text = text;
    }
    
    public Comment() {}
    
    public String getText() {
        return this.Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }
}