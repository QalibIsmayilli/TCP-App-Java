package org.example;

import lombok.SneakyThrows;
import main.FileUtility;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        writeAsBytes();
    }
    @SneakyThrows
    public static void writeAsBytes() throws IOException {
        Socket socket = new Socket("localhost",6789);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] msg = FileUtility.readIntoFileWithBytes("C:/Users/USER/OneDrive/Pictures/2602818.jpg");
        dataOutputStream.writeInt(msg.length);
        dataOutputStream.write(msg);
        socket.close();
    }
    @SneakyThrows
    public static void writeAsString(){
        Socket socket = new Socket("localhost",6789);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeBytes("message from WriteAsBytes ");
        socket.close();
    }

}