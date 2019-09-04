package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Message.proto")
public final class ReceiverPullServiceGrpc {

  private ReceiverPullServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.ReceiverPullService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.MessageOuterClass.Message,
      grpc.MessageOuterClass.MessageResult> getDeliveryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delivery",
      requestType = grpc.MessageOuterClass.Message.class,
      responseType = grpc.MessageOuterClass.MessageResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.MessageOuterClass.Message,
      grpc.MessageOuterClass.MessageResult> getDeliveryMethod() {
    io.grpc.MethodDescriptor<grpc.MessageOuterClass.Message, grpc.MessageOuterClass.MessageResult> getDeliveryMethod;
    if ((getDeliveryMethod = ReceiverPullServiceGrpc.getDeliveryMethod) == null) {
      synchronized (ReceiverPullServiceGrpc.class) {
        if ((getDeliveryMethod = ReceiverPullServiceGrpc.getDeliveryMethod) == null) {
          ReceiverPullServiceGrpc.getDeliveryMethod = getDeliveryMethod = 
              io.grpc.MethodDescriptor.<grpc.MessageOuterClass.Message, grpc.MessageOuterClass.MessageResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.ReceiverPullService", "delivery"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MessageOuterClass.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MessageOuterClass.MessageResult.getDefaultInstance()))
                  .setSchemaDescriptor(new ReceiverPullServiceMethodDescriptorSupplier("delivery"))
                  .build();
          }
        }
     }
     return getDeliveryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReceiverPullServiceStub newStub(io.grpc.Channel channel) {
    return new ReceiverPullServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReceiverPullServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReceiverPullServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReceiverPullServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReceiverPullServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReceiverPullServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void delivery(grpc.MessageOuterClass.Message request,
        io.grpc.stub.StreamObserver<grpc.MessageOuterClass.MessageResult> responseObserver) {
      asyncUnimplementedUnaryCall(getDeliveryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeliveryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.MessageOuterClass.Message,
                grpc.MessageOuterClass.MessageResult>(
                  this, METHODID_DELIVERY)))
          .build();
    }
  }

  /**
   */
  public static final class ReceiverPullServiceStub extends io.grpc.stub.AbstractStub<ReceiverPullServiceStub> {
    private ReceiverPullServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReceiverPullServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReceiverPullServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReceiverPullServiceStub(channel, callOptions);
    }

    /**
     */
    public void delivery(grpc.MessageOuterClass.Message request,
        io.grpc.stub.StreamObserver<grpc.MessageOuterClass.MessageResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeliveryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReceiverPullServiceBlockingStub extends io.grpc.stub.AbstractStub<ReceiverPullServiceBlockingStub> {
    private ReceiverPullServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReceiverPullServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReceiverPullServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReceiverPullServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.MessageOuterClass.MessageResult delivery(grpc.MessageOuterClass.Message request) {
      return blockingUnaryCall(
          getChannel(), getDeliveryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReceiverPullServiceFutureStub extends io.grpc.stub.AbstractStub<ReceiverPullServiceFutureStub> {
    private ReceiverPullServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReceiverPullServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReceiverPullServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReceiverPullServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.MessageOuterClass.MessageResult> delivery(
        grpc.MessageOuterClass.Message request) {
      return futureUnaryCall(
          getChannel().newCall(getDeliveryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELIVERY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReceiverPullServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReceiverPullServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELIVERY:
          serviceImpl.delivery((grpc.MessageOuterClass.Message) request,
              (io.grpc.stub.StreamObserver<grpc.MessageOuterClass.MessageResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReceiverPullServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReceiverPullServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.MessageOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReceiverPullService");
    }
  }

  private static final class ReceiverPullServiceFileDescriptorSupplier
      extends ReceiverPullServiceBaseDescriptorSupplier {
    ReceiverPullServiceFileDescriptorSupplier() {}
  }

  private static final class ReceiverPullServiceMethodDescriptorSupplier
      extends ReceiverPullServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReceiverPullServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReceiverPullServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReceiverPullServiceFileDescriptorSupplier())
              .addMethod(getDeliveryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
