/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class OssTaskResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3533821403855370200L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OssTaskResult\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"jobId\",\"type\":\"string\"},{\"name\":\"traceId\",\"type\":\"string\"},{\"name\":\"progress\",\"type\":\"long\"},{\"name\":\"error\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence jobId;
  @Deprecated public java.lang.CharSequence traceId;
  @Deprecated public long progress;
  @Deprecated public java.lang.CharSequence error;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OssTaskResult() {}

  /**
   * All-args constructor.
   * @param jobId The new value for jobId
   * @param traceId The new value for traceId
   * @param progress The new value for progress
   * @param error The new value for error
   */
  public OssTaskResult(java.lang.CharSequence jobId, java.lang.CharSequence traceId, java.lang.Long progress, java.lang.CharSequence error) {
    this.jobId = jobId;
    this.traceId = traceId;
    this.progress = progress;
    this.error = error;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return jobId;
    case 1: return traceId;
    case 2: return progress;
    case 3: return error;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: jobId = (java.lang.CharSequence)value$; break;
    case 1: traceId = (java.lang.CharSequence)value$; break;
    case 2: progress = (java.lang.Long)value$; break;
    case 3: error = (java.lang.CharSequence)value$; break;
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
   * Gets the value of the 'progress' field.
   * @return The value of the 'progress' field.
   */
  public java.lang.Long getProgress() {
    return progress;
  }

  /**
   * Sets the value of the 'progress' field.
   * @param value the value to set.
   */
  public void setProgress(java.lang.Long value) {
    this.progress = value;
  }

  /**
   * Gets the value of the 'error' field.
   * @return The value of the 'error' field.
   */
  public java.lang.CharSequence getError() {
    return error;
  }

  /**
   * Sets the value of the 'error' field.
   * @param value the value to set.
   */
  public void setError(java.lang.CharSequence value) {
    this.error = value;
  }

  /**
   * Creates a new OssTaskResult RecordBuilder.
   * @return A new OssTaskResult RecordBuilder
   */
  public static com.pharbers.kafka.schema.OssTaskResult.Builder newBuilder() {
    return new com.pharbers.kafka.schema.OssTaskResult.Builder();
  }

  /**
   * Creates a new OssTaskResult RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OssTaskResult RecordBuilder
   */
  public static com.pharbers.kafka.schema.OssTaskResult.Builder newBuilder(com.pharbers.kafka.schema.OssTaskResult.Builder other) {
    return new com.pharbers.kafka.schema.OssTaskResult.Builder(other);
  }

  /**
   * Creates a new OssTaskResult RecordBuilder by copying an existing OssTaskResult instance.
   * @param other The existing instance to copy.
   * @return A new OssTaskResult RecordBuilder
   */
  public static com.pharbers.kafka.schema.OssTaskResult.Builder newBuilder(com.pharbers.kafka.schema.OssTaskResult other) {
    return new com.pharbers.kafka.schema.OssTaskResult.Builder(other);
  }

  /**
   * RecordBuilder for OssTaskResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OssTaskResult>
    implements org.apache.avro.data.RecordBuilder<OssTaskResult> {

    private java.lang.CharSequence jobId;
    private java.lang.CharSequence traceId;
    private long progress;
    private java.lang.CharSequence error;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.OssTaskResult.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.jobId)) {
        this.jobId = data().deepCopy(fields()[0].schema(), other.jobId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.traceId)) {
        this.traceId = data().deepCopy(fields()[1].schema(), other.traceId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.progress)) {
        this.progress = data().deepCopy(fields()[2].schema(), other.progress);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.error)) {
        this.error = data().deepCopy(fields()[3].schema(), other.error);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing OssTaskResult instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.OssTaskResult other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.jobId)) {
        this.jobId = data().deepCopy(fields()[0].schema(), other.jobId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.traceId)) {
        this.traceId = data().deepCopy(fields()[1].schema(), other.traceId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.progress)) {
        this.progress = data().deepCopy(fields()[2].schema(), other.progress);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.error)) {
        this.error = data().deepCopy(fields()[3].schema(), other.error);
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
    public com.pharbers.kafka.schema.OssTaskResult.Builder setJobId(java.lang.CharSequence value) {
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
    public com.pharbers.kafka.schema.OssTaskResult.Builder clearJobId() {
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
    public com.pharbers.kafka.schema.OssTaskResult.Builder setTraceId(java.lang.CharSequence value) {
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
    public com.pharbers.kafka.schema.OssTaskResult.Builder clearTraceId() {
      traceId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'progress' field.
      * @return The value.
      */
    public java.lang.Long getProgress() {
      return progress;
    }

    /**
      * Sets the value of the 'progress' field.
      * @param value The value of 'progress'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.OssTaskResult.Builder setProgress(long value) {
      validate(fields()[2], value);
      this.progress = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'progress' field has been set.
      * @return True if the 'progress' field has been set, false otherwise.
      */
    public boolean hasProgress() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'progress' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.OssTaskResult.Builder clearProgress() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'error' field.
      * @return The value.
      */
    public java.lang.CharSequence getError() {
      return error;
    }

    /**
      * Sets the value of the 'error' field.
      * @param value The value of 'error'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.OssTaskResult.Builder setError(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.error = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'error' field has been set.
      * @return True if the 'error' field has been set, false otherwise.
      */
    public boolean hasError() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'error' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.OssTaskResult.Builder clearError() {
      error = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public OssTaskResult build() {
      try {
        OssTaskResult record = new OssTaskResult();
        record.jobId = fieldSetFlags()[0] ? this.jobId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.traceId = fieldSetFlags()[1] ? this.traceId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.progress = fieldSetFlags()[2] ? this.progress : (java.lang.Long) defaultValue(fields()[2]);
        record.error = fieldSetFlags()[3] ? this.error : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

}
