public class App {
    public static void main(String[] args) throws Exception {
        String[] vetor = new String[] {"Pedro", "Daniel", "Samuel"};

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
        
        for (String nome : vetor) {
            System.out.println(nome);
        }
    }
}
