package ifpb;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		//log
		System.out.println("Inicializado o serviço de Sender");

		//inicializar o serviço para sender
		Server serverSender = ServerBuilder.forPort(10990)
				.addService(new SenderImpl())
				.build();
		serverSender.start();
		serverSender.awaitTermination();

//		//inicializar o repositorio
//		MessageRepository repository = new MessageRepository();
//		SendedMessageRepository sendedMessageRepository = new SendedMessageRepository();
//		MessageResultRepository resultRepository = new MessageResultRepository();
//		//inicializar o gerenciador de tarefas
//		TaskManager.runTask(repository, sendedMessageRepository, resultRepository);
//		//inicializar o serviço para client app
//		Registry registry = LocateRegistry.createRegistry(10990);
//		registry.bind("Sender", new SenderImpl(repository, resultRepository));
	}
}
