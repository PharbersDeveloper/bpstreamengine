/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class BPJob extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3195506215893256097L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BPJob\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"jobId\",\"type\":\"string\"},{\"name\":\"traceId\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"job\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence jobId;
  @Deprecated public java.lang.CharSequence traceId;
  @Deprecated public java.lang.CharSequence type;
  @Deprecated public java.lang.CharSequence job;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public BPJob() {}

  /**
   * All-args constructor.
   * @param jobId The new value for jobId
   * @param traceId The new value for traceId
   * @param type The new value for type
   * @param job The new value for job
   */
  public BPJob(java.lang.CharSequence jobId, java.lang.CharSequence traceId, java.lang.CharSequence type, java.lang.CharSequence job) {
    this.jobId = jobId;
    this.traceId = traceId;
    this.type = type;
    this.job = job;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return jobId;
    case 1: return traceId;
    case 2: return type;
    case 3: return job;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: jobId = (java.lang.CharSequence)value$; break;
    case 1: traceId = (java.lang.CharSequence)value$; break;
    case 2: type = (java.lang.CharSequence)value$; break;
    case 3: job = (java.lang.CharSequence)value$; break;
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
   * Gets the value of the 'traceId' field.
   * @return The value of the 'traceId' field.
   */
  public java.lang.CharSequence getTraceId() {
    return traceId;
  }

  /**
   * Sets the value of the 'traceId' field.
   * @param value the value to set.
   */
  public void setTraceId(java.lang.CharSequence value) {
    this.traceId = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.CharSequence getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.CharSequence value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'job' field.
   * @return The value of the 'job' field.
   */
  public java.lang.CharSequence getJob() {
    return job;
  }

  /**
   * Sets the value of the 'job' field.
   * @param value the value to set.
   */
  public void setJob(java.lang.CharSequence value) {
    this.job = value;
  }

  /**
   * Creates a new BPJob RecordBuilder.
   * @return A new BPJob RecordBuilder
   */
  public static com.pharbers.kafka.schema.BPJob.Builder newBuilder() {
    return new com.pharbers.kafka.schema.BPJob.Builder();
  }

  /**
   * Creates a new BPJob RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BPJob RecordBuilder
   */
  public static com.pharbers.kafka.schema.BPJob.Builder newBuilder(com.pharbers.kafka.schema.BPJob.Builder other) {
    return new com.pharbers.kafka.schema.BPJob.Builder(other);
  }

  /**
   * Creates a new BPJob RecordBuilder by copying an existing BPJob instance.
   * @param other The existing instance to copy.
   * @return A new BPJob RecordBuilder
   */
  public static com.pharbers.kafka.schema.BPJob.Builder newBuilder(com.pharbers.kafka.schema.BPJob other) {
    return new com.pharbers.kafka.schema.BPJob.Builder(other);
  }

  /**
   * RecordBuilder for BPJob instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BPJob>
    implements org.apache.avro.data.RecordBuilder<BPJob> {

    private java.lang.CharSequence jobId;
    private java.lang.CharSequence traceId;
    private java.lang.CharSequence type;
    private java.lang.CharSequence job;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.BPJob.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.jobId)) {
        this.jobId = data().deepCopy(fields()[0].schema(), other.jobId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.traceId)) {
        this.traceId = data().deepCopy(fields()[1].schema(), other.traceId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.type)) {
        this.type = data().deepCopy(fields()[2].schema(), other.type);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.job)) {
        this.job = data().deepCopy(fields()[3].schema(), other.job);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing BPJob instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.BPJob other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.jobId)) {
        this.jobId = data().deepCopy(fields()[0].schema(), other.jobId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.traceId)) {
        this.traceId = data().deepCopy(fields()[1].schema(), other.traceId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.type)) {
        this.type = data().deepCopy(fields()[2].schema(), other.type);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.job)) {
        this.job = data().deepCopy(fields()[3].schema(), other.job);
        fieldSetFlags()[3] = true;
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
    public com.pharbers.kafka.schema.BPJob.Builder setJobId(java.lang.CharSequence value) {
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
    public com.pharbers.kafka.schema.BPJob.Builder clearJobId() {
      jobId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'traceId' field.
      * @return The value.
      */
    public java.lang.CharSequence getTraceId() {
      return traceId;
    }

    /**
      * Sets the value of the 'traceId' field.
      * @param value The value of 'traceId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.BPJob.Builder setTraceId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.traceId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'traceId' field has been set.
      * @return True if the 'traceId' field has been set, false otherwise.
      */
    public boolean hasTraceId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'traceId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.BPJob.Builder clearTraceId() {
      traceId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.CharSequence getType() {
      return type;
    }

    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.BPJob.Builder setType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.type = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.BPJob.Builder clearType() {
      type = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'job' field.
      * @return The value.
      */
    public java.lang.CharSequence getJob() {
      return job;
    }

    /**
      * Sets the value of the 'job' field.
      * @param value The value of 'job'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.BPJob.Builder setJob(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.job = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'job' field has been set.
      * @return True if the 'job' field has been set, false otherwise.
      */
    public boolean hasJob() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'job' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.BPJob.Builder clearJob() {
      job = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public BPJob build() {
      try {
        BPJob record = new BPJob();
        record.jobId = fieldSetFlags()[0] ? this.jobId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.traceId = fieldSetFlags()[1] ? this.traceId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.type = fieldSetFlags()[2] ? this.type : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.job = fieldSetFlags()[3] ? this.job : (java.lang.CharSequence) defaultValue(fields()[3]);
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
