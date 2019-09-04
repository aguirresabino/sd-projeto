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
 * <pre>
 * services
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Message.proto")
public final class SenderPullServiceGrpc {

  private SenderPullServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.SenderPullService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.MessageOuterClass.Message,
      grpc.MessageOuterClass.MessageResult> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = grpc.MessageOuterClass.Message.class,
      responseType = grpc.MessageOuterClass.MessageResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.MessageOuterClass.Message,
      grpc.MessageOuterClass.MessageResult> getSendMessageMethod() {
    io.grpc.MethodDescriptor<grpc.MessageOuterClass.Message, grpc.MessageOuterClass.MessageResult> getSendMessageMethod;
    if ((getSendMessageMethod = SenderPullServiceGrpc.getSendMessageMethod) == null) {
      synchronized (SenderPullServiceGrpc.class) {
        if ((getSendMessageMethod = SenderPullServiceGrpc.getSendMessageMethod) == null) {
          SenderPullServiceGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<grpc.MessageOuterClass.Message, grpc.MessageOuterClass.MessageResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.SenderPullService", "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MessageOuterClass.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.MessageOuterClass.MessageResult.getDefaultInstance()))
                  .setSchemaDescriptor(new SenderPullServiceMethodDescriptorSupplier("sendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SenderPullServiceStub newStub(io.grpc.Channel channel) {
    return new SenderPullServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SenderPullServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SenderPullServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SenderPullServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SenderPullServiceFutureStub(channel);
  }

  /**
   * <pre>
   * services
   * </pre>
   */
  public static abstract class SenderPullServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(grpc.MessageOuterClass.Message request,
        io.grpc.stub.StreamObserver<grpc.MessageOuterClass.MessageResult> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.MessageOuterClass.Message,
                grpc.MessageOuterClass.MessageResult>(
                  this, METHODID_SEND_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * services
   * </pre>
   */
  public static final class SenderPullServiceStub extends io.grpc.stub.AbstractStub<SenderPullServiceStub> {
    private SenderPullServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SenderPullServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SenderPullServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SenderPullServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(grpc.MessageOuterClass.Message request,
        io.grpc.stub.StreamObserver<grpc.MessageOuterClass.MessageResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * services
   * </pre>
   */
  public static final class SenderPullServiceBlockingStub extends io.grpc.stub.AbstractStub<SenderPullServiceBlockingStub> {
    private SenderPullServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SenderPullServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SenderPullServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SenderPullServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.MessageOuterClass.MessageResult sendMessage(grpc.MessageOuterClass.Message request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * services
   * </pre>
   */
  public static final class SenderPullServiceFutureStub extends io.grpc.stub.AbstractStub<SenderPullServiceFutureStub> {
    private SenderPullServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SenderPullServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SenderPullServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SenderPullServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.MessageOuterClass.MessageResult> sendMessage(
        grpc.MessageOuterClass.Message request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SenderPullServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SenderPullServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((grpc.MessageOuterClass.Message) request,
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

  private static abstract class SenderPullServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SenderPullServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.MessageOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SenderPullService");
    }
  }

  private static final class SenderPullServiceFileDescriptorSupplier
      extends SenderPullServiceBaseDescriptorSupplier {
    SenderPullServiceFileDescriptorSupplier() {}
  }

  private static final class SenderPullServiceMethodDescriptorSupplier
      extends SenderPullServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SenderPullServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SenderPullServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SenderPullServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
