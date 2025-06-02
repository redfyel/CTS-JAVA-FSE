interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("strum, strum! ∙ ٭✮🎸🎧 °");
        System.out.println("\uD83C\uDFB8"); // 🎸 Guitar

    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("⋆.˚🎹࣪ ࣪ ִֶָ☾.๋࣭ ⭑");
    }
}
public class Task19 {
    public static void main(String[] args) {
        Piano p = new Piano();
        Guitar g = new Guitar();

        p.play();
        g.play();
    }
}
