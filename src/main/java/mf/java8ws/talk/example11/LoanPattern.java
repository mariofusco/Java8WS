package mf.java8ws.talk.example11;

public class LoanPattern {

    public static class Resource {

        private Resource() {
            System.out.println("Opening resource");
        }

        public void operate() {
            System.out.println("Operating on resource");
            throw new RuntimeException();
        }

        public void dispose() {
            System.out.println("Disposing resource");
        }

    }

    public static void main(String... args) {

    }
}
