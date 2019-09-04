package ifpb;

import com.google.common.util.concurrent.ListenableFuture;
import grpc.MessageOuterClass.*;
import grpc.SenderPullServiceGrpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.ExecutionException;

public class Main {

//    private static int cont;

	private static void sendAndResultMessage(String id, String text, SenderPullServiceFutureStub sender) {

		// construct traffic message
		Message message = Message.newBuilder().setId(id).setText(text).build();

		ListenableFuture<MessageResult> senderFuture = sender.sendMessage(message);

		// promise object async call
        MessageResult result = null;
        try {
            result = senderFuture.get();
//            cont++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("Recebido resultado para mensagem " + result.getId() + ": " + result.getHash());

//		---- old code
//		sender.sendMessage(new Message(id, text));
//		//recuperar uma resposta
//		while(true){
//			//
//			Thread.sleep(2000);
//			//
//			System.out.println("Verificando se há resposta.");
//			MessageResult result = sender.getMessage(id);
//			if (result == null) {
//				continue;
//			}
//			else {
//				System.out.println("Recebido resultado para mensagem " + id + ": " + result.getHash());
//				break;
//			}
//		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//log
		System.out.println("Acionado o clientapp");

		//recuperação do Sender
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 10990)
				.usePlaintext()
				.build();

		SenderPullServiceFutureStub senderFutureStub = grpc.SenderPullServiceGrpc.newFutureStub(channel);

		String id = "askjdlkasjd";
		String text = "Hello World!";

		for (int i = 0; i < 100; i++){
			final String ix = id + "#" + i;
			final String mx = text + "#" + i;

			sendAndResultMessage(ix, mx, senderFutureStub);
		}

//        while(true){
//            if(cont==100){
//                break;
//            }
//        }

	}

//		---- old code
		//recuperação do Sender
//		Registry registry = LocateRegistry.getRegistry("async-sender-pull", 10990);
//		Registry registry = LocateRegistry.getRegistry( 10990);
//		ISender sender = (ISender) registry.lookup("Sender");
//		//
//		String id = "askjdlkasjd";
//		String text = "Hello World!";
//		//
//		for (int i = 0; i < 100; i++){
//			//
//			final String ix = id + "#" + i;
//			final String mx = text + "#" + i;
//			//
//			Thread t = new Thread(){
//				public void run() {
//					try {
//						sendAndResultMessage(ix, mx, sender);
//					}
//					catch (RemoteException | InterruptedException e) {
//						e.printStackTrace();
//					}
//				};
//			};
//			t.start();
//		}
	
}
