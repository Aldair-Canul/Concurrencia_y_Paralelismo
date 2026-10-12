import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class main {
    public static void main(String[] args) {
        try {
            Act_Stream.escribir();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}