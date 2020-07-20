/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MonitorRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6966657455444824623L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MonitorRequest\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"jobId\",\"type\":\"string\"},{\"name\":\"strategy\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence jobId;
  @Deprecated public java.lang.CharSequence strategy;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MonitorRequest() {}

  /**
   * All-args constructor.
   * @param jobId The new value for jobId
   * @param strategy The new value for strategy
   */
  public MonitorRequest(java.lang.CharSequence jobId, java.lang.CharSequence strategy) {
    this.jobId = jobId;
    this.strategy = strategy;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return jobId;
    case 1: return strategy;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: jobId = (java.lang.CharSequence)value$; break;
    case 1: strategy = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'jobId' field.
   * @return The value of the 'jobId' field.
   */
  public java.lang.CharSequence getJobId() {
    return jobId;
  }

  /**
   * Sets the value of the 'jobId' field.
   * @param value the value to set.
   */
  public void setJobId(java.lang.CharSequence value) {
    this.jobId = value;
  }

  /**
   * Gets the value of the 'strategy' field.
   * @return The value of the 'strategy' field.
   */
  public java.lang.CharSequence getStrategy() {
    return strategy;
  }

  /**
   * Sets the value of the 'strategy' field.
   * @param value the value to set.
   */
  public void setStrategy(java.lang.CharSequence value) {
    this.strategy = value;
  }

  /**
   * Creates a new MonitorRequest RecordBuilder.
   * @return A new MonitorRequest RecordBuilder
   */
  public static com.pharbers.kafka.schema.MonitorRequest.Builder newBuilder() {
    return new com.pharbers.kafka.schema.MonitorRequest.Builder();
  }

  /**
   * Creates a new MonitorRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MonitorRequest RecordBuilder
   */
  public static com.pharbers.kafka.schema.MonitorRequest.Builder newBuilder(com.pharbers.kafka.schema.MonitorRequest.Builder other) {
    return new com.pharbers.kafka.schema.MonitorRequest.Builder(other);
  }

  /**
   * Creates a new MonitorRequest RecordBuilder by copying an existing MonitorRequest instance.
   * @param other The existing instance to copy.
   * @return A new MonitorRequest RecordBuilder
   */
  public static com.pharbers.kafka.schema.MonitorRequest.Builder newBuilder(com.pharbers.kafka.schema.MonitorRequest other) {
    return new com.pharbers.kafka.schema.MonitorRequest.Builder(other);
  }

  /**
   * RecordBuilder for MonitorRequest instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MonitorRequest>
    implements org.apache.avro.data.RecordBuilder<MonitorRequest> {

    private java.lang.CharSequence jobId;
    private java.lang.CharSequence strategy;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.MonitorRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.jobId)) {
        this.jobId = data().deepCopy(fields()[0].schema(), other.jobId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.strategy)) {
        this.strategy = data().deepCopy(fields()[1].schema(), other.strategy);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing MonitorRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.MonitorRequest other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.jobId)) {
        this.jobId = data().deepCopy(fields()[0].schema(), other.jobId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.strategy)) {
        this.strategy = data().deepCopy(fields()[1].schema(), other.strategy);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'jobId' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobId() {
      return jobId;
    }

    /**
      * Sets the value of the 'jobId' field.
      * @param value The value of 'jobId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.MonitorRequest.Builder setJobId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.jobId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'jobId' field has been set.
      * @return True if the 'jobId' field has been set, false otherwise.
      */
    public boolean hasJobId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'jobId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.MonitorRequest.Builder clearJobId() {
      jobId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'strategy' field.
      * @return The value.
      */
    public java.lang.CharSequence getStrategy() {
      return strategy;
    }

    /**
      * Sets the value of the 'strategy' field.
      * @param value The value of 'strategy'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.MonitorRequest.Builder setStrategy(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.strategy = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'strategy' field has been set.
      * @return True if the 'strategy' field has been set, false otherwise.
      */
    public boolean hasStrategy() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'strategy' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.MonitorRequest.Builder clearStrategy() {
      strategy = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public MonitorRequest build() {
      try {
        MonitorRequest record = new MonitorRequest();
        record.jobId = fieldSetFlags()[0] ? this.jobId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.strategy = fieldSetFlags()[1] ? this.strategy : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
