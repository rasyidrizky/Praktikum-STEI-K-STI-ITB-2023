import java.util.ArrayList;

public class BahasaJawa extends Bahasa {
    public BahasaJawa(ArrayList<String> files) {
        super(files);
        extention = ".jawa";
    }

    public void compile() throws BahasaError {
        /* Tambahkan error checking disini */
        for (String i : files) {
            if (!i.contains(extention)) {
                throw new WrongExtentionException(extention, i);
            }
        }

        System.out.println("jawac " + String.join(" ", files));
    }

    public void grade(String inputFilename, String outputFilename) throws BahasaError {
        /* Tambahkan error checking disini */
        boolean in = inputFilename.contains(".in");
        boolean out = outputFilename.contains(".out");
        if (!in) {
            throw new WrongExtentionException(".in", inputFilename);
        }
        else if (!out) {
            throw new WrongExtentionException(".out", inputFilename);
        }

        String inname = removeExtention(inputFilename);
        String outname = removeExtention(outputFilename);

        if (!inname.equals(outname)) {
            throw new TestcaseMismatchException(inputFilename, outputFilename);
        }

        System.out.println("jawa " + removeExtention(files.get(0)) + " < " + inputFilename + " > " + outputFilename);
    }
}
