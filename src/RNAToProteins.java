import java.util.Stack;

public class RNAToProteins {
    public static void main(String[] args) {
        String rna1 = "AGCUGGGAAACGUAGGCCUA";
        String rna2 ="UAAAGAGAAGCCAGC";

         System.out.println(convertRNAToProteins(rna1));
        System.out.println(convertRNAToProteins(rna2));
    }

    public static String convertRNAToProteins(String rna) {
        //store amino acids
        Stack<Character>  aAcids = new Stack<>();
        //store codons
        String codon ="";

        //iterate through RNA chars
        for (int i = 0; i <  rna.length() ; i++) {
            //add characters to string
            codon += rna.charAt(i);

            // if codon length is 3, translate it into an amino acid
            if (codon.length() == 3) {
                //translate and push to stack
                char aminoAcid = translateCodon(codon);
                aAcids.push(aminoAcid);
                //reset codon
                codon = "";
            }
        }

        //end with period of not 3
        if (!codon.isEmpty()) {
            aAcids.push('.');
        }

        //convert to string
        String result = "";
        while (!aAcids.isEmpty()) {
            result = aAcids.pop() + result;
        }

        return result;
    }

    public static char translateCodon(String codon) {
        if (codon.equals("UUU") || codon.equals("UUC")) {
            return 'F';
        } else if (codon.equals("UUA") || codon.equals("UUG")) {
            return 'L';
        } else if (codon.equals("UCU") || codon.equals("UCC") || codon.equals("UCA") || codon.equals("UCG")) {
            return 'S';
        } else if (codon.equals("UAU") || codon.equals("UAC")) {
            return 'Y';
        } else if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
            return '.';
        } else if (codon.equals("UGU") || codon.equals("UGC")) {
            return 'C';
        } else if (codon.equals("UGG")) {
            return 'W';
        } else if (codon.equals("CUU") || codon.equals("CUC") || codon.equals("CUA") || codon.equals("CUG")) {
            return 'L';
        } else if (codon.equals("CCU") || codon.equals("CCC") || codon.equals("CCA") || codon.equals("CCG")) {
            return 'P';
        } else if (codon.equals("CAU") || codon.equals("CAC") ) {
            return 'H';
        }else if (codon.equals("CAA") || codon.equals("CAG") ) {
            return 'Q';
        }else if (codon.equals("CGG") || codon.equals("CGA") || codon.equals("CGC") || codon.equals("CGU")) {
            return 'R';
        }else if (codon.equals("AUU") || codon.equals("AUC") || codon.equals("AUA")) {
            return 'I';
        }else if (codon.equals("AUG")) {
            return 'M';
        }else if (codon.equals("ACU") || codon.equals("ACG") || codon.equals("ACA") || codon.equals("ACC")) {
            return 'T';
        }else if (codon.equals("AAU") || codon.equals("AAC")) {
            return 'N';
        }else if (codon.equals("AAA") || codon.equals("AAG")) {
            return 'K';
        }else if (codon.equals("AGU") || codon.equals("AGC")) {
            return 'S';
        }else if (codon.equals("AGA") || codon.equals("AGG")) {
            return 'R';
        }else if (codon.equals("GUU") || codon.equals("GUC") || codon.equals("GUA") || codon.equals("GUG")) {
            return 'V';
        }else if (codon.equals("GCA") || codon.equals("GCC") || codon.equals("GCU") || codon.equals("GCG")) {
            return 'A';
        }else if (codon.equals("GAU") || codon.equals("GAC")) {
            return 'D';
        }else if (codon.equals("GAA") || codon.equals("GAG")) {
            return 'E';
        }else if (codon.equals("GGG") || codon.equals("GGA") || codon.equals("GGC") || codon.equals("GGU")) {
            return 'L';
        }else{
            return '?';
        }

    }}