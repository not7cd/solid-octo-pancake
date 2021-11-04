import mediaObjects.IMedia;

public class MediaPresentation {
    private IMedia m;

    public MediaPresentation(IMedia m) {
        this.m = m;
    }

    public void present() {
        System.out.println();
        System.out.print(m.render());
        System.out.println();
    }
}
