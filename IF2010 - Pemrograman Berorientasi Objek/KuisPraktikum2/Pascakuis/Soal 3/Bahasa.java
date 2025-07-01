import java.util.ArrayList;

public abstract class Bahasa {
    protected ArrayList<String> files;
    protected String extention;

    public Bahasa(ArrayList<String> files) {
        this.files = files;
    }
    
    // Menghapus extention dari akhir nama file
    // Contohnya: namaFile "Main.jawa" akan berubah menjadi "Main"
    public String removeExtention(String namaFile) {
        int extens = namaFile.lastIndexOf('.');
        String filename = namaFile.substring(0, extens);
        return filename;
    }

    public abstract void compile() throws BahasaError;
    public abstract void grade(String inputFilename, String outputFilename) throws BahasaError;

}

class BahasaFactory {
    
    // Mengembalikan kelas bahasa untuk namaBahasa yang diberikan. Jika bahasa adalah selain: 
    // - "Jawa"
    // - "C"
    // - "Ular"
    // Maka ia akan mengembalikan error
    public static Bahasa getBahasaRunner(String namaBahasa, ArrayList<String> files) throws BahasaError {
        if (namaBahasa.equals("Jawa")) {
            return new BahasaJawa(files);
        }
        else if (namaBahasa.equals("C")) { 
            return new BahasaC(files);
        }
        else if (namaBahasa.equals("Ular")) {
            return new BahasaUlar(files);
        }
        else {
            throw new BahasaNotExistsException();
        }
    }
}

class BahasaError extends Exception {
    public BahasaError() {
        super();
    }

    public BahasaError(String message) {
        super(message);
    }
}

class WrongExtentionException extends BahasaError {
    public WrongExtentionException(String supposedExtention, String filename) {
        // Mengembalikan pesan error dalam format:
        // Expected extention "{supposedExtention}" for {filename}
        //
        // Contoh: 
        // Expected extention ".jawa" for Main.bukanjawa
        super("Expected extention \""+ supposedExtention + "\" for " + filename);
    }
}

class TestcaseMismatchException extends BahasaError {
    public TestcaseMismatchException(String inputFilename, String outputFilename) {
        // Mengembalikan pesan error dalam format:
        // Input testcase for {inputFilename} got output filename of {outputFilename}
        //
        // Contoh: 
        // Input testcase for 1.in got output filename of not1.out
        super("Input testcase for " + inputFilename + " got output filename of " + outputFilename);
    }
}

class BahasaNotExistsException extends BahasaError {
    public BahasaNotExistsException() {
        // Mengembalikan pesan error "Bahasa doesn't exists!"
        super("Bahasa doesn't exists!");
    }
}