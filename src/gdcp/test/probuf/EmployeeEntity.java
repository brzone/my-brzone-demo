// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Employee.proto

package gdcp.test.probuf;

public final class EmployeeEntity {
  private EmployeeEntity() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface EmployeeOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional uint64 id = 1;
    /**
     * <code>optional uint64 id = 1;</code>
     *
     * <pre>
     *id
     * </pre>
     */
    boolean hasId();
    /**
     * <code>optional uint64 id = 1;</code>
     *
     * <pre>
     *id
     * </pre>
     */
    long getId();

    // optional string name = 2;
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *name
     * </pre>
     */
    boolean hasName();
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *name
     * </pre>
     */
    java.lang.String getName();
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *name
     * </pre>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    // optional uint32 age = 3;
    /**
     * <code>optional uint32 age = 3;</code>
     *
     * <pre>
     *age
     * </pre>
     */
    boolean hasAge();
    /**
     * <code>optional uint32 age = 3;</code>
     *
     * <pre>
     *age
     * </pre>
     */
    int getAge();
  }
  /**
   * Protobuf type {@code Employee}
   */
  public static final class Employee extends
      com.google.protobuf.GeneratedMessage
      implements EmployeeOrBuilder {
    // Use Employee.newBuilder() to construct.
    private Employee(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Employee(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Employee defaultInstance;
    public static Employee getDefaultInstance() {
      return defaultInstance;
    }

    public Employee getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Employee(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readUInt64();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              name_ = input.readBytes();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              age_ = input.readUInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return gdcp.test.probuf.EmployeeEntity.internal_static_Employee_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return gdcp.test.probuf.EmployeeEntity.internal_static_Employee_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              gdcp.test.probuf.EmployeeEntity.Employee.class, gdcp.test.probuf.EmployeeEntity.Employee.Builder.class);
    }

    public static com.google.protobuf.Parser<Employee> PARSER =
        new com.google.protobuf.AbstractParser<Employee>() {
      public Employee parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Employee(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Employee> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // optional uint64 id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    /**
     * <code>optional uint64 id = 1;</code>
     *
     * <pre>
     *id
     * </pre>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional uint64 id = 1;</code>
     *
     * <pre>
     *id
     * </pre>
     */
    public long getId() {
      return id_;
    }

    // optional string name = 2;
    public static final int NAME_FIELD_NUMBER = 2;
    private java.lang.Object name_;
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *name
     * </pre>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *name
     * </pre>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string name = 2;</code>
     *
     * <pre>
     *name
     * </pre>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional uint32 age = 3;
    public static final int AGE_FIELD_NUMBER = 3;
    private int age_;
    /**
     * <code>optional uint32 age = 3;</code>
     *
     * <pre>
     *age
     * </pre>
     */
    public boolean hasAge() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional uint32 age = 3;</code>
     *
     * <pre>
     *age
     * </pre>
     */
    public int getAge() {
      return age_;
    }

    private void initFields() {
      id_ = 0L;
      name_ = "";
      age_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeUInt64(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getNameBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeUInt32(3, age_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getNameBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, age_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static gdcp.test.probuf.EmployeeEntity.Employee parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(gdcp.test.probuf.EmployeeEntity.Employee prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Employee}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements gdcp.test.probuf.EmployeeEntity.EmployeeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return gdcp.test.probuf.EmployeeEntity.internal_static_Employee_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return gdcp.test.probuf.EmployeeEntity.internal_static_Employee_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                gdcp.test.probuf.EmployeeEntity.Employee.class, gdcp.test.probuf.EmployeeEntity.Employee.Builder.class);
      }

      // Construct using gdcp.test.probuf.EmployeeEntity.Employee.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        id_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        age_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return gdcp.test.probuf.EmployeeEntity.internal_static_Employee_descriptor;
      }

      public gdcp.test.probuf.EmployeeEntity.Employee getDefaultInstanceForType() {
        return gdcp.test.probuf.EmployeeEntity.Employee.getDefaultInstance();
      }

      public gdcp.test.probuf.EmployeeEntity.Employee build() {
        gdcp.test.probuf.EmployeeEntity.Employee result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public gdcp.test.probuf.EmployeeEntity.Employee buildPartial() {
        gdcp.test.probuf.EmployeeEntity.Employee result = new gdcp.test.probuf.EmployeeEntity.Employee(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.name_ = name_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.age_ = age_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof gdcp.test.probuf.EmployeeEntity.Employee) {
          return mergeFrom((gdcp.test.probuf.EmployeeEntity.Employee)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(gdcp.test.probuf.EmployeeEntity.Employee other) {
        if (other == gdcp.test.probuf.EmployeeEntity.Employee.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasName()) {
          bitField0_ |= 0x00000002;
          name_ = other.name_;
          onChanged();
        }
        if (other.hasAge()) {
          setAge(other.getAge());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        gdcp.test.probuf.EmployeeEntity.Employee parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (gdcp.test.probuf.EmployeeEntity.Employee) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional uint64 id = 1;
      private long id_ ;
      /**
       * <code>optional uint64 id = 1;</code>
       *
       * <pre>
       *id
       * </pre>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional uint64 id = 1;</code>
       *
       * <pre>
       *id
       * </pre>
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>optional uint64 id = 1;</code>
       *
       * <pre>
       *id
       * </pre>
       */
      public Builder setId(long value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint64 id = 1;</code>
       *
       * <pre>
       *id
       * </pre>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0L;
        onChanged();
        return this;
      }

      // optional string name = 2;
      private java.lang.Object name_ = "";
      /**
       * <code>optional string name = 2;</code>
       *
       * <pre>
       *name
       * </pre>
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string name = 2;</code>
       *
       * <pre>
       *name
       * </pre>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string name = 2;</code>
       *
       * <pre>
       *name
       * </pre>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string name = 2;</code>
       *
       * <pre>
       *name
       * </pre>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string name = 2;</code>
       *
       * <pre>
       *name
       * </pre>
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string name = 2;</code>
       *
       * <pre>
       *name
       * </pre>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        name_ = value;
        onChanged();
        return this;
      }

      // optional uint32 age = 3;
      private int age_ ;
      /**
       * <code>optional uint32 age = 3;</code>
       *
       * <pre>
       *age
       * </pre>
       */
      public boolean hasAge() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional uint32 age = 3;</code>
       *
       * <pre>
       *age
       * </pre>
       */
      public int getAge() {
        return age_;
      }
      /**
       * <code>optional uint32 age = 3;</code>
       *
       * <pre>
       *age
       * </pre>
       */
      public Builder setAge(int value) {
        bitField0_ |= 0x00000004;
        age_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional uint32 age = 3;</code>
       *
       * <pre>
       *age
       * </pre>
       */
      public Builder clearAge() {
        bitField0_ = (bitField0_ & ~0x00000004);
        age_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Employee)
    }

    static {
      defaultInstance = new Employee(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Employee)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Employee_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Employee_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016Employee.proto\"1\n\010Employee\022\n\n\002id\030\001 \001(\004" +
      "\022\014\n\004name\030\002 \001(\t\022\013\n\003age\030\003 \001(\rB\"\n\020gdcp.test" +
      ".probufB\016EmployeeEntity"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_Employee_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_Employee_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Employee_descriptor,
              new java.lang.String[] { "Id", "Name", "Age", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
