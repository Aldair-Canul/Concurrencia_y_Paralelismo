package pract02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrentServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleRequest(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String mensajeCliente = entrada.readLine();
            System.out.println("Servidor recibió: " + mensajeCliente);
            salida.println("Mensaje recibido correctamente"); // Respuesta al cliente

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}