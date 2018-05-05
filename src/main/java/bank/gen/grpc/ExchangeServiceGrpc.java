package bank.gen.grpc;

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
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: currency.proto")
public final class ExchangeServiceGrpc {

  private ExchangeServiceGrpc() {}

  public static final String SERVICE_NAME = "currency.ExchangeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExchangeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<bank.gen.grpc.Currencies,
      bank.gen.grpc.ExchangeRate> METHOD_EXCHANGE = getExchangeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<bank.gen.grpc.Currencies,
      bank.gen.grpc.ExchangeRate> getExchangeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<bank.gen.grpc.Currencies,
      bank.gen.grpc.ExchangeRate> getExchangeMethod() {
    return getExchangeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<bank.gen.grpc.Currencies,
      bank.gen.grpc.ExchangeRate> getExchangeMethodHelper() {
    io.grpc.MethodDescriptor<bank.gen.grpc.Currencies, bank.gen.grpc.ExchangeRate> getExchangeMethod;
    if ((getExchangeMethod = ExchangeServiceGrpc.getExchangeMethod) == null) {
      synchronized (ExchangeServiceGrpc.class) {
        if ((getExchangeMethod = ExchangeServiceGrpc.getExchangeMethod) == null) {
          ExchangeServiceGrpc.getExchangeMethod = getExchangeMethod = 
              io.grpc.MethodDescriptor.<bank.gen.grpc.Currencies, bank.gen.grpc.ExchangeRate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "currency.ExchangeService", "exchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bank.gen.grpc.Currencies.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bank.gen.grpc.ExchangeRate.getDefaultInstance()))
                  .setSchemaDescriptor(new ExchangeServiceMethodDescriptorSupplier("exchange"))
                  .build();
          }
        }
     }
     return getExchangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExchangeServiceStub newStub(io.grpc.Channel channel) {
    return new ExchangeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExchangeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ExchangeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExchangeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ExchangeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ExchangeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void exchange(bank.gen.grpc.Currencies request,
        io.grpc.stub.StreamObserver<bank.gen.grpc.ExchangeRate> responseObserver) {
      asyncUnimplementedUnaryCall(getExchangeMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExchangeMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                bank.gen.grpc.Currencies,
                bank.gen.grpc.ExchangeRate>(
                  this, METHODID_EXCHANGE)))
          .build();
    }
  }

  /**
   */
  public static final class ExchangeServiceStub extends io.grpc.stub.AbstractStub<ExchangeServiceStub> {
    private ExchangeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExchangeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExchangeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExchangeServiceStub(channel, callOptions);
    }

    /**
     */
    public void exchange(bank.gen.grpc.Currencies request,
        io.grpc.stub.StreamObserver<bank.gen.grpc.ExchangeRate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExchangeMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ExchangeServiceBlockingStub extends io.grpc.stub.AbstractStub<ExchangeServiceBlockingStub> {
    private ExchangeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExchangeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExchangeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExchangeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<bank.gen.grpc.ExchangeRate> exchange(
        bank.gen.grpc.Currencies request) {
      return blockingServerStreamingCall(
          getChannel(), getExchangeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExchangeServiceFutureStub extends io.grpc.stub.AbstractStub<ExchangeServiceFutureStub> {
    private ExchangeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExchangeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExchangeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExchangeServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXCHANGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExchangeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExchangeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXCHANGE:
          serviceImpl.exchange((bank.gen.grpc.Currencies) request,
              (io.grpc.stub.StreamObserver<bank.gen.grpc.ExchangeRate>) responseObserver);
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

  private static abstract class ExchangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExchangeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return bank.gen.grpc.CurrencyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExchangeService");
    }
  }

  private static final class ExchangeServiceFileDescriptorSupplier
      extends ExchangeServiceBaseDescriptorSupplier {
    ExchangeServiceFileDescriptorSupplier() {}
  }

  private static final class ExchangeServiceMethodDescriptorSupplier
      extends ExchangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExchangeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExchangeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExchangeServiceFileDescriptorSupplier())
              .addMethod(getExchangeMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
