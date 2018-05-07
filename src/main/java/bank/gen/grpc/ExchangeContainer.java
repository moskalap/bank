// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: currency.proto

package bank.gen.grpc;

/**
 * Protobuf type {@code currency.ExchangeContainer}
 */
public  final class ExchangeContainer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:currency.ExchangeContainer)
    ExchangeContainerOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExchangeContainer.newBuilder() to construct.
  private ExchangeContainer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExchangeContainer() {
    rates_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExchangeContainer(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              rates_ = new java.util.ArrayList<bank.gen.grpc.ExchangeRate>();
              mutable_bitField0_ |= 0x00000001;
            }
            rates_.add(
                input.readMessage(bank.gen.grpc.ExchangeRate.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        rates_ = java.util.Collections.unmodifiableList(rates_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return bank.gen.grpc.CurrencyProto.internal_static_currency_ExchangeContainer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return bank.gen.grpc.CurrencyProto.internal_static_currency_ExchangeContainer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            bank.gen.grpc.ExchangeContainer.class, bank.gen.grpc.ExchangeContainer.Builder.class);
  }

  public static final int RATES_FIELD_NUMBER = 1;
  private java.util.List<bank.gen.grpc.ExchangeRate> rates_;
  /**
   * <code>repeated .currency.ExchangeRate rates = 1;</code>
   */
  public java.util.List<bank.gen.grpc.ExchangeRate> getRatesList() {
    return rates_;
  }
  /**
   * <code>repeated .currency.ExchangeRate rates = 1;</code>
   */
  public java.util.List<? extends bank.gen.grpc.ExchangeRateOrBuilder> 
      getRatesOrBuilderList() {
    return rates_;
  }
  /**
   * <code>repeated .currency.ExchangeRate rates = 1;</code>
   */
  public int getRatesCount() {
    return rates_.size();
  }
  /**
   * <code>repeated .currency.ExchangeRate rates = 1;</code>
   */
  public bank.gen.grpc.ExchangeRate getRates(int index) {
    return rates_.get(index);
  }
  /**
   * <code>repeated .currency.ExchangeRate rates = 1;</code>
   */
  public bank.gen.grpc.ExchangeRateOrBuilder getRatesOrBuilder(
      int index) {
    return rates_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < rates_.size(); i++) {
      output.writeMessage(1, rates_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < rates_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, rates_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof bank.gen.grpc.ExchangeContainer)) {
      return super.equals(obj);
    }
    bank.gen.grpc.ExchangeContainer other = (bank.gen.grpc.ExchangeContainer) obj;

    boolean result = true;
    result = result && getRatesList()
        .equals(other.getRatesList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRatesCount() > 0) {
      hash = (37 * hash) + RATES_FIELD_NUMBER;
      hash = (53 * hash) + getRatesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static bank.gen.grpc.ExchangeContainer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static bank.gen.grpc.ExchangeContainer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static bank.gen.grpc.ExchangeContainer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static bank.gen.grpc.ExchangeContainer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(bank.gen.grpc.ExchangeContainer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code currency.ExchangeContainer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:currency.ExchangeContainer)
      bank.gen.grpc.ExchangeContainerOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return bank.gen.grpc.CurrencyProto.internal_static_currency_ExchangeContainer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return bank.gen.grpc.CurrencyProto.internal_static_currency_ExchangeContainer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              bank.gen.grpc.ExchangeContainer.class, bank.gen.grpc.ExchangeContainer.Builder.class);
    }

    // Construct using bank.gen.grpc.ExchangeContainer.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getRatesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (ratesBuilder_ == null) {
        rates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        ratesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return bank.gen.grpc.CurrencyProto.internal_static_currency_ExchangeContainer_descriptor;
    }

    @java.lang.Override
    public bank.gen.grpc.ExchangeContainer getDefaultInstanceForType() {
      return bank.gen.grpc.ExchangeContainer.getDefaultInstance();
    }

    @java.lang.Override
    public bank.gen.grpc.ExchangeContainer build() {
      bank.gen.grpc.ExchangeContainer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public bank.gen.grpc.ExchangeContainer buildPartial() {
      bank.gen.grpc.ExchangeContainer result = new bank.gen.grpc.ExchangeContainer(this);
      int from_bitField0_ = bitField0_;
      if (ratesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          rates_ = java.util.Collections.unmodifiableList(rates_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.rates_ = rates_;
      } else {
        result.rates_ = ratesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof bank.gen.grpc.ExchangeContainer) {
        return mergeFrom((bank.gen.grpc.ExchangeContainer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(bank.gen.grpc.ExchangeContainer other) {
      if (other == bank.gen.grpc.ExchangeContainer.getDefaultInstance()) return this;
      if (ratesBuilder_ == null) {
        if (!other.rates_.isEmpty()) {
          if (rates_.isEmpty()) {
            rates_ = other.rates_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRatesIsMutable();
            rates_.addAll(other.rates_);
          }
          onChanged();
        }
      } else {
        if (!other.rates_.isEmpty()) {
          if (ratesBuilder_.isEmpty()) {
            ratesBuilder_.dispose();
            ratesBuilder_ = null;
            rates_ = other.rates_;
            bitField0_ = (bitField0_ & ~0x00000001);
            ratesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRatesFieldBuilder() : null;
          } else {
            ratesBuilder_.addAllMessages(other.rates_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      bank.gen.grpc.ExchangeContainer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (bank.gen.grpc.ExchangeContainer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<bank.gen.grpc.ExchangeRate> rates_ =
      java.util.Collections.emptyList();
    private void ensureRatesIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        rates_ = new java.util.ArrayList<bank.gen.grpc.ExchangeRate>(rates_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        bank.gen.grpc.ExchangeRate, bank.gen.grpc.ExchangeRate.Builder, bank.gen.grpc.ExchangeRateOrBuilder> ratesBuilder_;

    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public java.util.List<bank.gen.grpc.ExchangeRate> getRatesList() {
      if (ratesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(rates_);
      } else {
        return ratesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public int getRatesCount() {
      if (ratesBuilder_ == null) {
        return rates_.size();
      } else {
        return ratesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public bank.gen.grpc.ExchangeRate getRates(int index) {
      if (ratesBuilder_ == null) {
        return rates_.get(index);
      } else {
        return ratesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder setRates(
        int index, bank.gen.grpc.ExchangeRate value) {
      if (ratesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRatesIsMutable();
        rates_.set(index, value);
        onChanged();
      } else {
        ratesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder setRates(
        int index, bank.gen.grpc.ExchangeRate.Builder builderForValue) {
      if (ratesBuilder_ == null) {
        ensureRatesIsMutable();
        rates_.set(index, builderForValue.build());
        onChanged();
      } else {
        ratesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder addRates(bank.gen.grpc.ExchangeRate value) {
      if (ratesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRatesIsMutable();
        rates_.add(value);
        onChanged();
      } else {
        ratesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder addRates(
        int index, bank.gen.grpc.ExchangeRate value) {
      if (ratesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRatesIsMutable();
        rates_.add(index, value);
        onChanged();
      } else {
        ratesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder addRates(
        bank.gen.grpc.ExchangeRate.Builder builderForValue) {
      if (ratesBuilder_ == null) {
        ensureRatesIsMutable();
        rates_.add(builderForValue.build());
        onChanged();
      } else {
        ratesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder addRates(
        int index, bank.gen.grpc.ExchangeRate.Builder builderForValue) {
      if (ratesBuilder_ == null) {
        ensureRatesIsMutable();
        rates_.add(index, builderForValue.build());
        onChanged();
      } else {
        ratesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder addAllRates(
        java.lang.Iterable<? extends bank.gen.grpc.ExchangeRate> values) {
      if (ratesBuilder_ == null) {
        ensureRatesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, rates_);
        onChanged();
      } else {
        ratesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder clearRates() {
      if (ratesBuilder_ == null) {
        rates_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        ratesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public Builder removeRates(int index) {
      if (ratesBuilder_ == null) {
        ensureRatesIsMutable();
        rates_.remove(index);
        onChanged();
      } else {
        ratesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public bank.gen.grpc.ExchangeRate.Builder getRatesBuilder(
        int index) {
      return getRatesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public bank.gen.grpc.ExchangeRateOrBuilder getRatesOrBuilder(
        int index) {
      if (ratesBuilder_ == null) {
        return rates_.get(index);  } else {
        return ratesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public java.util.List<? extends bank.gen.grpc.ExchangeRateOrBuilder> 
         getRatesOrBuilderList() {
      if (ratesBuilder_ != null) {
        return ratesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(rates_);
      }
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public bank.gen.grpc.ExchangeRate.Builder addRatesBuilder() {
      return getRatesFieldBuilder().addBuilder(
          bank.gen.grpc.ExchangeRate.getDefaultInstance());
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public bank.gen.grpc.ExchangeRate.Builder addRatesBuilder(
        int index) {
      return getRatesFieldBuilder().addBuilder(
          index, bank.gen.grpc.ExchangeRate.getDefaultInstance());
    }
    /**
     * <code>repeated .currency.ExchangeRate rates = 1;</code>
     */
    public java.util.List<bank.gen.grpc.ExchangeRate.Builder> 
         getRatesBuilderList() {
      return getRatesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        bank.gen.grpc.ExchangeRate, bank.gen.grpc.ExchangeRate.Builder, bank.gen.grpc.ExchangeRateOrBuilder> 
        getRatesFieldBuilder() {
      if (ratesBuilder_ == null) {
        ratesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            bank.gen.grpc.ExchangeRate, bank.gen.grpc.ExchangeRate.Builder, bank.gen.grpc.ExchangeRateOrBuilder>(
                rates_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        rates_ = null;
      }
      return ratesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:currency.ExchangeContainer)
  }

  // @@protoc_insertion_point(class_scope:currency.ExchangeContainer)
  private static final bank.gen.grpc.ExchangeContainer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new bank.gen.grpc.ExchangeContainer();
  }

  public static bank.gen.grpc.ExchangeContainer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExchangeContainer>
      PARSER = new com.google.protobuf.AbstractParser<ExchangeContainer>() {
    @java.lang.Override
    public ExchangeContainer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExchangeContainer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExchangeContainer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExchangeContainer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public bank.gen.grpc.ExchangeContainer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
