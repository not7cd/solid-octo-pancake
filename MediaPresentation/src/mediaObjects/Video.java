package mediaObjects;

public class Video extends Media {
    public Video(String content) {
        super(content);
    }

    @Override
    String getIcon() {
        return "\uD83C\uDF9E️";
    }
}
