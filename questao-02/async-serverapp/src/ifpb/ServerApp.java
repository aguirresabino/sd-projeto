package ifpb;

import grpc.MessageOuterClass. *;
import grpc.ServerAppServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings("serial")
public class ServerApp extends ServerAppServiceGrpc.ServerAppServiceImplBase {

	@Override
	public void print(Message request, StreamObserver<MessageResult> responseObserver) {
		MessageDigest msd = null;
		try {
			msd = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		//
		byte[] bhash = msd.digest(request.getText().getBytes());
		BigInteger bi = new BigInteger(bhash);
		//
		MessageResult result = MessageResult.newBuilder()
				.setId(request.getId()).setHash(bi.toString(16)).build();
		//
		System.out.println(request.getId() + " " + request.getText());
		//
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}


//	protected ServerApp() throws RemoteException {
//		super();
//	}
//
//	@Override
//	public MessageResult print(Message msg) throws RemoteException {
//		//
//		MessageDigest msd;
//		try {
//			msd = MessageDigest.getInstance("MD5");
//		} catch (NoSuchAlgorithmException e) {
//			throw new RemoteException("Erro de MD5", e);
//		}
//		//
//		byte[] bhash = msd.digest(msg.getText().getBytes());
//		BigInteger bi = new BigInteger(bhash);
//		//
//		MessageResult result = new MessageResult(msg.getId(), bi.toString(16));
//		//
//		System.out.println(msg.getId() + " " + msg.getText());
//		//
//		return result;
//
//	}

}
