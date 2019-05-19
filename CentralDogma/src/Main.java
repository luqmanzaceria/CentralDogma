import java.util.Scanner;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {


    public static void main(String[] args) {
        //user inputs DNA sequence
        System.out.print("Type in the DNA sequence without spaces: ");
        Scanner dna = new Scanner(System.in);


        String sequence = dna.nextLine();

        int numOfBases = sequence.length();

        int i = 0;
        String base = "";
        List<String> codon = new ArrayList<String>();

        int lastBase = 0;

        //separates RNA chars into groups of 3
        while (i < numOfBases) {

            base = base + transcript(sequence.charAt(i++));

            if (i % 3 == 0) {
                codon.add(base);
                base = "";
            }

            lastBase = codon.size() - 1;


        }

        System.out.println(" ");
        System.out.println("RNA Sequence: ");
        System.out.println("   " + codon);
        System.out.println(" ");

        System.out.println(translate(codon));


    }

    //transcription of DNA sequence (DNA -> RNA)
    public static char transcript(char iChar) {
        char iCharUpper = Character.toUpperCase(iChar);


        if (iCharUpper == 'A') {

            return 'U';


        }
        if (iCharUpper == 'T') {

            return 'A';

        }
        if (iCharUpper == 'C') {

            return 'G';

        }
        if (iCharUpper == 'G') {
            return 'C';

        } else {
            return '*';
        }

    }

    //translation of RNA sequence (RNA -> Amino Acids/Proteins)
    public static String translate(List<String> codon) {
        HashMap<String, List<String>> pro = new HashMap<>();

        pro.put("met", Arrays.asList(new String[]{"AUG"}));
        pro.put("lys", Arrays.asList(new String[]{"AAA", "AAG"}));
        pro.put("asn", Arrays.asList(new String[]{"AAU", "AAC"}));
        pro.put("tyr", Arrays.asList(new String[]{"UAU", "UAC"}));
        pro.put("gln", Arrays.asList(new String[]{"CAA", "CAG"}));
        pro.put("his", Arrays.asList(new String[]{"CAU", "CAC"}));
        pro.put("ile", Arrays.asList(new String[]{"AUU", "AUC", "AUA"}));
        pro.put("phe", Arrays.asList(new String[]{"UUU", "UUC"}));
        pro.put("val", Arrays.asList(new String[]{"GUU", "GUC", "GUA", "GUG"}));
        pro.put("thr", Arrays.asList(new String[]{"ACU", "ACC", "ACA", "ACG"}));
        pro.put("ser", Arrays.asList(new String[]{"UCU", "UCC", "UCA", "UCG", "AGU", "AGC"}));
        pro.put("pro", Arrays.asList(new String[]{"CCU", "CCC", "CCA", "CCG"}));
        pro.put("ala", Arrays.asList(new String[]{"GCU", "GCC", "GCA", "GCG"}));
        pro.put("arg", Arrays.asList(new String[]{"CGU", "CGC", "CGA", "CGG", "AGA", "AGG"}));
        pro.put("leu", Arrays.asList(new String[]{"UUA", "UUG", "CUU", "CUC", "CUA", "CUG"}));
        pro.put("cys", Arrays.asList(new String[]{"UGU", "UGC"}));
        pro.put("trp", Arrays.asList(new String[]{"UGG"}));
        pro.put("gly", Arrays.asList(new String[]{"GGU", "GGC", "GGA", "GGG"}));
        pro.put("asp", Arrays.asList(new String[]{"GAU", "GAC"}));
        pro.put("glu", Arrays.asList(new String[]{"GAA, GAG"}));
        pro.put("stop", Arrays.asList(new String[]{"UAA", "UAG", "UGA"}));

        System.out.println("Amino Acids: ");

        for (String group : codon) {

            for (HashMap.Entry progb: pro.entrySet()) {
                if( ((List)progb.getValue()).contains(group)){
                    System.out.println("   " + progb.getKey());

                }
            }

        }

        return " ";

    }
}
