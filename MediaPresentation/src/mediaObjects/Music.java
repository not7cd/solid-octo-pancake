package mediaObjects;

public class Music extends Media {
    public Music(String content) {
        super(content);
    }

    @Override
    String getIcon() {
        return "\uD83C\uDFBC";
    }
}
