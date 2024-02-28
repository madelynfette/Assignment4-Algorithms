import java.util.LinkedList;
import java.util.Queue;

public class DNAToRNA {
    public static void main(String[] args) {

        String dna1= "AGCTGGGAAACGTAGGCCTA";
        System.out.println("DNA Sequence 1: " +dna1);
        System.out.println("RNA Sequence 1: " +DNAtoRNA(dna1));

         String dna2 ="TTTTTTTTTTGGCGCG";
        System.out.println("DNA Sequence 2: " + dna2);
        System.out.println("RNA Sequence 2: " + DNAtoRNA(dna2));

        String dna3 ="CTTTGGGACTAGTAACCCATTTCGGCT";
        System.out.println("DNA Sequence 3: " + dna3);
        System.out.println("RNA Sequence 3: " + DNAtoRNA(dna3));
    }

    public static String DNAtoRNA(String dnaSequence) {
        //queue for RNA chars
        Queue<Character>  queue = new LinkedList<>();
        //check if null
        if (dnaSequence ==null) {
            return null;
        }
        //iterate through DNA sequence
        for (int i = 0;  i < dnaSequence.length(); i++) {
            char c = dnaSequence.charAt(i);
            //if char is T, replace with U, add to queue
            if (c == 'T') {
                queue.add('U');
            } else {
                //if not add to queue
                queue.add(c);
            }


        }


        String RNA ="";
        //iterate through queue and add to RNA sequence
        while ( !queue.isEmpty()) {
            RNA +=   queue.remove();
        }

        return RNA;

    }

}