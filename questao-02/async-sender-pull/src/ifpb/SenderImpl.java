package ifpb;

import com.google.common.util.concurrent.ListenableFuture;
import grpc.MessageOuterClass.*;
import grpc.ReceiverPullServiceGrpc;
import grpc.SenderPullServiceGrpc.SenderPullServiceImplBase;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ExecutionException;

@SuppressWarnings("serial")
public class SenderImpl extends SenderPullServiceImplBase {

	private final ManagedChannel receiverChannel;
	private ReceiverPullServiceGrpc.ReceiverPullServiceFutureStub receiverFutureStub;

	public SenderImpl(){
		this.receiverChannel = ManagedChannelBuilder
				.forAddress("localhost", 10991)
				.usePlaintext()
				.build();
	}

	@Override
	public void sendMessage(Message request, StreamObserver<MessageResult> responseObserver) {
		//send to receiver
		receiverFutureStub = ReceiverPullServiceGrpc.newFutureStub(receiverChannel);
		ListenableFuture<MessageResult> receiverFuture = receiverFutureStub.delivery(request);
		try {
			responseObserver.onNext(receiverFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		responseObserver.onCompleted();

	}

//	private final MessageRepository repository;
//	private final MessageResultRepository resultRepository;
//
//	public SenderImpl(MessageRepository rep, MessageResultRepository resultRep) throws RemoteException{
//		this.repository = rep;
//		this.resultRepository = resultRep;
//	}
//
//	@Override
//	public void sendMessage(Message dto) throws RemoteException{
//		//armazenar temporariamente a mensagem
//		repository.add(dto);
//	}
//
//	@Override
//	public MessageResult getMessage(String id) throws RemoteException {
//		//recuperar a mensagem no repositório
//		MessageResult result = resultRepository.get(id);
//		if (result != null) resultRepository.remove(result);
//		return result;
//	}

}
