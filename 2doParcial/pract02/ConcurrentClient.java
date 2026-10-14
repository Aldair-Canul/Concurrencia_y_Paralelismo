package pract02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//curl.exe -v telnet://localhost:8080

public class ConcurrentClient {
    public static void main(String[] args) {
        String host = "localhost"; // Dirección del servidor
        int puerto = 8080;         // Puerto que usa el servidor

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor en " + host + ":" + puerto);

            // Flujo para enviar datos al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Flujo para leer la respuesta del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Enviamos un mensaje (la "solicitud")
            String mensajeAEnviar = "¡Hola Servidor!";
            salida.println(mensajeAEnviar);
            System.out.println("Mensaje enviado: " + mensajeAEnviar);

            // Leemos la respuesta del servidor (si el servidor la envía)
            String respuesta = entrada.readLine();
            if (respuesta != null) {
                System.out.println("Respuesta del servidor: " + respuesta);
            } else {
                System.out.println("El servidor cerró la conexión sin responder.");
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}