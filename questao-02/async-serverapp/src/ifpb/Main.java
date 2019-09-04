package ifpb;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) throws IOException, AlreadyBoundException, InterruptedException {
		System.out.println("Servidor inicializado");

		//inicializar o serviço para server app
		Server serverSender = ServerBuilder.forPort(10992)
				.addService(new ServerApp())
				.build();
		serverSender.start();
		serverSender.awaitTermination();

//		//
//		System.out.println("Servidor inicializado");
//		//
//		Registry registry = LocateRegistry.createRegistry(10992);
//		registry.bind("ServerApp", new ServerApp());
	}
	
}
