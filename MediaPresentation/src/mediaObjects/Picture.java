package mediaObjects;

public class Picture extends Media {
    public Picture(String content) {
        super(content);
    }

    @Override
    String getIcon() {
        return "\uD83D\uDDBC️";
    }
}
