package ifpb;

import com.google.common.util.concurrent.ListenableFuture;
import grpc.MessageOuterClass. *;
import grpc.ReceiverPullServiceGrpc;
import grpc.ServerAppServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ExecutionException;

@SuppressWarnings("serial")
public class Receiver extends ReceiverPullServiceGrpc.ReceiverPullServiceImplBase {

	private final ManagedChannel serverChannel;
	private ServerAppServiceGrpc.ServerAppServiceFutureStub serverFutureStub;

	protected Receiver() {
		this.serverChannel = ManagedChannelBuilder
				.forAddress("localhost", 10992)
				.usePlaintext()
				.build();
	}

	@Override
	public void delivery(Message request, StreamObserver<MessageResult> responseObserver) {
		System.out.println("Recebendo uma mensagem e tentando encaminhar para o server.");

		serverFutureStub = ServerAppServiceGrpc.newFutureStub(serverChannel);
		ListenableFuture<MessageResult> serverFuture = serverFutureStub.print(request);
		try {
			responseObserver.onNext(serverFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		responseObserver.onCompleted();
	}

//	private final ResponseMessageRepository repository;
//
//	protected Receiver(ResponseMessageRepository repository) throws RemoteException {
//		this.repository = repository;
//	}
//
//	@Override
//	public void delivery(Message msg) throws RemoteException {
//		//
//		System.out.println("Recebendo uma mensagem e tentando encaminhar para o server.");
//		//
//		Registry registry =  LocateRegistry.getRegistry(10992);
////		Registry registry =  LocateRegistry.getRegistry("async-serverapp", 10992);
//		try {
//			IServerApp serverApp = (IServerApp) registry.lookup("ServerApp");
//			MessageResult result = serverApp.print(msg);
//			repository.add(result);
//		}
//		catch(NotBoundException | AccessException e){
//			throw new RuntimeException("Foi mal!!");
//		}
//
//	}
//
//	@Override
//	public MessageResult result(String id) throws RemoteException {
//		return repository.get(id);
//	}

}
