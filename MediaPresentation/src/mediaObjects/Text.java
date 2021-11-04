package mediaObjects;

public class Text extends Media{
    public Text(String content) {
        super(content);
    }

    @Override
    String getIcon() {
        return "\uD83D\uDCDD";
    }
}
