
import java.io.*;

public class Act_Stream {
    public static void escribir( ) throws IOException {
        OutputStream fos = new FileOutputStream("data.txt", true);
        fos.write(0x31);
        fos.write(50);
        fos.write(0x0A);

        fos.flush();
        fos.close();
    }

    public static void leer() throws IOException {
        InputStream fis = new FileInputStream("data.txt");
        int byteFile;
        byteFile = fis.read();
        System.out.println(byteFile);
        fis.close();
    }

//    public static void guardarNota (String nota) {
//        System.out.println("guardar Nota");
//    }
//
//    public static String leerNotas() {
//        return "notas";
//    }
}
