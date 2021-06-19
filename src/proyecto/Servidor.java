/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GABRIEL
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket sc = null;
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            final InetAddress ADDR = InetAddress.getByName("25.69.213.103");
            server = new ServerSocket(PUERTO, 50, ADDR);
            System.out.println(server);
            System.out.println("Servidor Iniciado");

            while (true) {
                sc = server.accept();
                
                System.out.println("Cliente Conectado");
                in= new DataInputStream(sc.getInputStream());
                out= new DataOutputStream(sc.getOutputStream());
                
                String mensaje= in.readUTF();
                System.out.println(mensaje);
                
                out.writeUTF("Hola desde el servidor");
                
                sc.close();
                System.out.println("Cliente Desconectado");
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
