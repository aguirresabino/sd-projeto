package ifpb.grpc;

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
public final class ServerAppServiceGrpc {

  private ServerAppServiceGrpc() {}

  public static final String SERVICE_NAME = "ifpb.grpc.ServerAppService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ifpb.grpc.Message,
      ifpb.grpc.MessageResult> getPrintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "print",
      requestType = ifpb.grpc.Message.class,
      responseType = ifpb.grpc.MessageResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ifpb.grpc.Message,
      ifpb.grpc.MessageResult> getPrintMethod() {
    io.grpc.MethodDescriptor<ifpb.grpc.Message, ifpb.grpc.MessageResult> getPrintMethod;
    if ((getPrintMethod = ServerAppServiceGrpc.getPrintMethod) == null) {
      synchronized (ServerAppServiceGrpc.class) {
        if ((getPrintMethod = ServerAppServiceGrpc.getPrintMethod) == null) {
          ServerAppServiceGrpc.getPrintMethod = getPrintMethod = 
              io.grpc.MethodDescriptor.<ifpb.grpc.Message, ifpb.grpc.MessageResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ifpb.grpc.ServerAppService", "print"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ifpb.grpc.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ifpb.grpc.MessageResult.getDefaultInstance()))
                  .setSchemaDescriptor(new ServerAppServiceMethodDescriptorSupplier("print"))
                  .build();
          }
        }
     }
     return getPrintMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerAppServiceStub newStub(io.grpc.Channel channel) {
    return new ServerAppServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerAppServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServerAppServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerAppServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServerAppServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ServerAppServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void print(ifpb.grpc.Message request,
        io.grpc.stub.StreamObserver<ifpb.grpc.MessageResult> responseObserver) {
      asyncUnimplementedUnaryCall(getPrintMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPrintMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ifpb.grpc.Message,
                ifpb.grpc.MessageResult>(
                  this, METHODID_PRINT)))
          .build();
    }
  }

  /**
   */
  public static final class ServerAppServiceStub extends io.grpc.stub.AbstractStub<ServerAppServiceStub> {
    private ServerAppServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerAppServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerAppServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerAppServiceStub(channel, callOptions);
    }

    /**
     */
    public void print(ifpb.grpc.Message request,
        io.grpc.stub.StreamObserver<ifpb.grpc.MessageResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPrintMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServerAppServiceBlockingStub extends io.grpc.stub.AbstractStub<ServerAppServiceBlockingStub> {
    private ServerAppServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerAppServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerAppServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerAppServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ifpb.grpc.MessageResult print(ifpb.grpc.Message request) {
      return blockingUnaryCall(
          getChannel(), getPrintMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServerAppServiceFutureStub extends io.grpc.stub.AbstractStub<ServerAppServiceFutureStub> {
    private ServerAppServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerAppServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerAppServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerAppServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ifpb.grpc.MessageResult> print(
        ifpb.grpc.Message request) {
      return futureUnaryCall(
          getChannel().newCall(getPrintMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRINT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerAppServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServerAppServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRINT:
          serviceImpl.print((ifpb.grpc.Message) request,
              (io.grpc.stub.StreamObserver<ifpb.grpc.MessageResult>) responseObserver);
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

  private static abstract class ServerAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerAppServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ifpb.grpc.MessageOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerAppService");
    }
  }

  private static final class ServerAppServiceFileDescriptorSupplier
      extends ServerAppServiceBaseDescriptorSupplier {
    ServerAppServiceFileDescriptorSupplier() {}
  }

  private static final class ServerAppServiceMethodDescriptorSupplier
      extends ServerAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServerAppServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServerAppServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerAppServiceFileDescriptorSupplier())
              .addMethod(getPrintMethod())
              .build();
        }
      }
    }
    return result;
  }
}
