// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/ascend/proto/greetings.proto

package com.ascend.proto;

public final class Greetings {
  private Greetings() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ascend_proto_Greeting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ascend_proto_Greeting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ascend_proto_GreetingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ascend_proto_GreetingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ascend_proto_GreetingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ascend_proto_GreetingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ascend_proto_SumElements_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ascend_proto_SumElements_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ascend_proto_SumRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ascend_proto_SumRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ascend_proto_SumResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ascend_proto_SumResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n com/ascend/proto/greetings.proto\022\020com." +
      "ascend.proto\"\034\n\010Greeting\022\020\n\010greeting\030\001 \001" +
      "(\t\"?\n\017GreetingRequest\022,\n\010greeting\030\001 \001(\0132" +
      "\032.com.ascend.proto.Greeting\"\"\n\020GreetingR" +
      "esponse\022\016\n\006result\030\001 \001(\t\"9\n\013SumElements\022\023" +
      "\n\013firstNumber\030\001 \001(\005\022\025\n\rsecondNumnber\030\002 \001" +
      "(\005\"?\n\nSumRequest\0221\n\nsumElement\030\001 \001(\0132\035.c" +
      "om.ascend.proto.SumElements\"\035\n\013SumRespon" +
      "se\022\016\n\006result\030\001 \001(\0052\326\002\n\017GreetingService\022N" +
      "\n\005Hello\022!.com.ascend.proto.GreetingReque" +
      "st\032\".com.ascend.proto.GreetingResponse\022B" +
      "\n\003Sum\022\034.com.ascend.proto.SumRequest\032\035.co" +
      "m.ascend.proto.SumResponse\022Y\n\016HelloManyT" +
      "imes\022!.com.ascend.proto.GreetingRequest\032" +
      "\".com.ascend.proto.GreetingResponse0\001\022T\n" +
      "\tLongHello\022!.com.ascend.proto.GreetingRe" +
      "quest\032\".com.ascend.proto.GreetingRespons" +
      "e(\001B\037\n\020com.ascend.protoB\tGreetingsP\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_ascend_proto_Greeting_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ascend_proto_Greeting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ascend_proto_Greeting_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_com_ascend_proto_GreetingRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ascend_proto_GreetingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ascend_proto_GreetingRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_com_ascend_proto_GreetingResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_ascend_proto_GreetingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ascend_proto_GreetingResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_com_ascend_proto_SumElements_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_ascend_proto_SumElements_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ascend_proto_SumElements_descriptor,
        new java.lang.String[] { "FirstNumber", "SecondNumnber", });
    internal_static_com_ascend_proto_SumRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_ascend_proto_SumRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ascend_proto_SumRequest_descriptor,
        new java.lang.String[] { "SumElement", });
    internal_static_com_ascend_proto_SumResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_ascend_proto_SumResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ascend_proto_SumResponse_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
