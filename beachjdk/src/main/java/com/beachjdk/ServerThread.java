package com.beachjdk;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import Logic.Device;

public class ServerThread extends Thread {
    private String address;
    private int port;
    private ServerSocket serverSocket;

    public ServerThread(String ip, int port) {
        this.address = ip;
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(this.port, 5, InetAddress.getByName(this.address));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("  ⢠⣴⣶⣶⣶⣆⠀⣴⣶⣶⣶⡇⠀⣠⣶⣶⣶⠆⠀⢀⣴⣶⣶⣦⠀⣤⣶⡆⢠⣴⡖⠀⠀⢠⣴⡖⢀⣴⣶⣶⣶⣄⠀⢠⣴⡆⣠⣶⡄\n  ⣾⣿⡟⢻⣿⠇⢀⣿⣿⠛⠋⠁⢀⣿⣿⣿⣿⠀⢠⣾⣿⠟⠻⠋⢀⣿⣿⠀⣿⣿⠃⠀⠀⣼⣿⠃⢸⣿⡿⠻⣿⣿⠀⣿⣿⣿⡿⠋\n⠀ ⣿⣿⣷⣿⣅⠀⢸⣿⣷⣶⡏⠀⣼⣿⢳⣿⣿⠀⣾⣿⠏⠀⠀⠀⢸⣿⣧⣤⣿⡟⠀⠀⠀⣿⡟⠀⣼⣿⡇⢀⣿⡟⢠⣿⣿⣿⣧\n⠀⢰⣿⡟⣉⣽⣿⠀⣾⣿⣉⣤⡄⢰⣿⣿⣼⣿⣿⠀⣿⣿⠀⠀⡀⠀⣾⣿⠛⣿⣿⡇⠀⣀⢸⣿⡇⠀⣿⣿⢠⣾⠟⠁⢸⣿⠟⣿⣿⡄\n⠀⣸⣿⣿⡿⠟⠁⢀⣿⣿⣿⠿⢇⣿⣿⠟⣿⣿⣿⠀⢻⣿⣷⣾⠇⠀⣿⣿⠀⣿⣿⠀⣼⣿⣿⣿⠀⢸⣿⡿⠟⠁⠀⠀⣿⣿⠀⢿⣿⠧\n⠀⠉⠉⠁⠀⠀⠀⠈⠉⠀⠀⠀⠈⠉⠉⠀⠉⠁⠀⠀⠀⠉⠉⠁⠀⠈⠉⠀⠀⠉⠀⠀⠈⠉⠉⠀⠀⠈⠁⠀⠀⠀⠀⠀⠉⠀⠀⠈⠁\n [DEBUG SERVER] Server Started on: " 
                           + address + ":" + port);
        while (true) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("[S] New connection from " + client.getInetAddress().getHostAddress());
                new ClientThread(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
