package mediaObjects;

public abstract class Media implements IMedia{

    protected String content;
    public Media(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.print(this);
    }

    @Override
    public String render() {
        return this.toString();
    }

    abstract String getIcon();

    String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return getIcon() + " " + getContent();
    }
}
