/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ParentUrlRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6845229141387044904L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ParentUrlRecord\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"MetaData\",\"type\":\"string\"},{\"name\":\"SampleData\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence MetaData;
  @Deprecated public java.lang.CharSequence SampleData;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ParentUrlRecord() {}

  /**
   * All-args constructor.
   * @param MetaData The new value for MetaData
   * @param SampleData The new value for SampleData
   */
  public ParentUrlRecord(java.lang.CharSequence MetaData, java.lang.CharSequence SampleData) {
    this.MetaData = MetaData;
    this.SampleData = SampleData;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return MetaData;
    case 1: return SampleData;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: MetaData = (java.lang.CharSequence)value$; break;
    case 1: SampleData = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'MetaData' field.
   * @return The value of the 'MetaData' field.
   */
  public java.lang.CharSequence getMetaData() {
    return MetaData;
  }

  /**
   * Sets the value of the 'MetaData' field.
   * @param value the value to set.
   */
  public void setMetaData(java.lang.CharSequence value) {
    this.MetaData = value;
  }

  /**
   * Gets the value of the 'SampleData' field.
   * @return The value of the 'SampleData' field.
   */
  public java.lang.CharSequence getSampleData() {
    return SampleData;
  }

  /**
   * Sets the value of the 'SampleData' field.
   * @param value the value to set.
   */
  public void setSampleData(java.lang.CharSequence value) {
    this.SampleData = value;
  }

  /**
   * Creates a new ParentUrlRecord RecordBuilder.
   * @return A new ParentUrlRecord RecordBuilder
   */
  public static com.pharbers.kafka.schema.ParentUrlRecord.Builder newBuilder() {
    return new com.pharbers.kafka.schema.ParentUrlRecord.Builder();
  }

  /**
   * Creates a new ParentUrlRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ParentUrlRecord RecordBuilder
   */
  public static com.pharbers.kafka.schema.ParentUrlRecord.Builder newBuilder(com.pharbers.kafka.schema.ParentUrlRecord.Builder other) {
    return new com.pharbers.kafka.schema.ParentUrlRecord.Builder(other);
  }

  /**
   * Creates a new ParentUrlRecord RecordBuilder by copying an existing ParentUrlRecord instance.
   * @param other The existing instance to copy.
   * @return A new ParentUrlRecord RecordBuilder
   */
  public static com.pharbers.kafka.schema.ParentUrlRecord.Builder newBuilder(com.pharbers.kafka.schema.ParentUrlRecord other) {
    return new com.pharbers.kafka.schema.ParentUrlRecord.Builder(other);
  }

  /**
   * RecordBuilder for ParentUrlRecord instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ParentUrlRecord>
    implements org.apache.avro.data.RecordBuilder<ParentUrlRecord> {

    private java.lang.CharSequence MetaData;
    private java.lang.CharSequence SampleData;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.ParentUrlRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.MetaData)) {
        this.MetaData = data().deepCopy(fields()[0].schema(), other.MetaData);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.SampleData)) {
        this.SampleData = data().deepCopy(fields()[1].schema(), other.SampleData);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ParentUrlRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.ParentUrlRecord other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.MetaData)) {
        this.MetaData = data().deepCopy(fields()[0].schema(), other.MetaData);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.SampleData)) {
        this.SampleData = data().deepCopy(fields()[1].schema(), other.SampleData);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'MetaData' field.
      * @return The value.
      */
    public java.lang.CharSequence getMetaData() {
      return MetaData;
    }

    /**
      * Sets the value of the 'MetaData' field.
      * @param value The value of 'MetaData'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ParentUrlRecord.Builder setMetaData(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.MetaData = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'MetaData' field has been set.
      * @return True if the 'MetaData' field has been set, false otherwise.
      */
    public boolean hasMetaData() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'MetaData' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ParentUrlRecord.Builder clearMetaData() {
      MetaData = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'SampleData' field.
      * @return The value.
      */
    public java.lang.CharSequence getSampleData() {
      return SampleData;
    }

    /**
      * Sets the value of the 'SampleData' field.
      * @param value The value of 'SampleData'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ParentUrlRecord.Builder setSampleData(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.SampleData = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'SampleData' field has been set.
      * @return True if the 'SampleData' field has been set, false otherwise.
      */
    public boolean hasSampleData() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'SampleData' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ParentUrlRecord.Builder clearSampleData() {
      SampleData = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ParentUrlRecord build() {
      try {
        ParentUrlRecord record = new ParentUrlRecord();
        record.MetaData = fieldSetFlags()[0] ? this.MetaData : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.SampleData = fieldSetFlags()[1] ? this.SampleData : (java.lang.CharSequence) defaultValue(fields()[1]);
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
