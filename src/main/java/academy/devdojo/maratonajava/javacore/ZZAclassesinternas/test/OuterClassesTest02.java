package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {

    private String name = "Luffy";


    void print(){
        class LocalClass {
            final String lastName = "Monkey";


            public void printLocal(){
                System.out.println(name + " " + lastName);
            }
        }

        new LocalClass().printLocal();
    }

    public static void main(String[] args) {
        OuterClassesTest02 outerClassesTest02 = new OuterClassesTest02();
        outerClassesTest02.print();
    }
}
