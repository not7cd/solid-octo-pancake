import mediaObjects.IMedia;

public class MediaPresentation {
    private IMedia m;

    public MediaPresentation(IMedia m) {
        this.m = m;
    }

    public void present() {
        System.out.print(m.render());
    }
}
