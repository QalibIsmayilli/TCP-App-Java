package org.example;

import lombok.SneakyThrows;
import main.FileUtility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        readAsbytes();
    }



    @SneakyThrows
    public static void readAsbytes(){
        ServerSocket ourFistServerSocket = new ServerSocket(6789);
        while(true){
            Socket connection = ourFistServerSocket.accept();
            DataInputStream dis = new DataInputStream(connection.getInputStream());

            byte[] msg = readMessage(dis);
            FileUtility.writeBytes("C:/Users/USER/OneDrive/Desktop/Dublicate.jpg",msg);
        }
    }

    @SneakyThrows
    public static byte[] readMessage(DataInputStream dis){
        byte[] bytes = new byte[dis.readInt()];
        dis.readFully(bytes);
        return bytes;
    }

    @SneakyThrows
    public static void readAsString(){
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while(true){
            Socket connection = ourFirstServerSocket.accept();
            BufferedReader msgFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String msg = msgFromClient.readLine();
            System.out.println("clientden gelen mesaj : " + msg);
        }
    }
}