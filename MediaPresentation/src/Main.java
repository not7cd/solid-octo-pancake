import mediaObjects.*;

public class Main {

    public static void main(String[] args) {
        MediaPresentation p = new MediaPresentation(
                new SequenceComposition(
                        new Text("A vacation to remember..."),
                        new ParallelComposition(
                                new Music("Some lovely music"),
                                new SequenceComposition(
                                        new Picture("pic1"),
                                        new Picture("pic2"),
                                        new Picture("pic3"),
                                        new Picture("pic4"),
                                        new Picture("pic5"),
                                        new Video("vid1"),
                                        new Picture("pic6"),
                                        new Picture("pic7"),
                                        new Picture("pic8"),
                                        new Picture("pic9"),
                                        new Video("vid2"),
                                        new Video("vid3")
                                )),
                        new Text("We’ll go there again!")
                )
        );

        MediaPresentation pWTF = new MediaPresentation(
                new ParallelComposition(
                        new SequenceComposition(new Music("Never Gonna Give You Up"), new Music("Dardue - Sandstorm")),
                        new SequenceComposition(new Text("This is"), new Text("where it falls apart"))
                )
        );
        p.present();
        pWTF.present();
    }
}
