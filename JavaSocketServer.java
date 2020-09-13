//Finn Raae
//9/13/2020
//Computer Networks - iterative socket server
//This project requires students to implement an iterative (single-threaded) server for use in a 
//client-server configuration to examine, analyze, and study the effects an iterative server has on the efficiency 
//(average turn-around time) of processing client requests.


//The iterative (single-threaded) server should handle one client request at a time (serially)
//
//    The Java ServerSocket object caches client requests automatically
//
//The iterative (single-threaded) server must support the following client requests:
//
//    Date and Time - the date and time on the server
//    Uptime - how long the server has been running since last boot-up
//    Memory Use - the current memory usage on the server
//    Netstat - lists network connections on the server
//    Current Users - list of users currently connected to the server
//    Running Processes - list of programs currently running on the server

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class JavaSocketServer {

	public static void main(String[] args) {
		try {
			//start connection
			System.out.println("waiting for client.");
			ServerSocket serverSocket = new ServerSocket(6868);					//create server
			Socket socket = serverSocket.accept();							//listen for connection
			System.out.println("connected");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//make reader
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	//make printer
			while (true) {										//while loop to get input over and over again
				//get input
				String input = in.readLine();							//input variable
				
				//send output
				out.print("This is the output you  said:" + input);				//output
				//if statement to decide what output is 
				if (input.equals("Date and Time")) {
					out.print("get the information for Date and Time");			//output
				}
				else if (input.equals("Uptime")) {
					out.print("get the information for UpTime");				//output
				}
				else if (input.equals("Memory Use")) {
					out.print("get the information for Memory Use");			//output
				}
				else if (input.equals("Netstat")) {
					out.print("get the information for Netstat");				//output
				}
				else if (input.equals("Current Use")) {
					out.print("get the information for Current Use");			//output
				}
				else if (input.equals("Running Processes")) {
					out.print("get the information for Running Processes");			//output
				}
				else if (input.equals("Exit")) {
					out.print("Goodbye and have a nice day.");				//output
					socket.close();								//close client
					serverSocket.close();							//close server
				}
				else {
					out.print("Please enter a Valid Command.");				//output
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
}
