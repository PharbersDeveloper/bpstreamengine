/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class UploadEnd extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6937969824602262168L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UploadEnd\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"dataSetId\",\"type\":\"string\"},{\"name\":\"assetId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence dataSetId;
  @Deprecated public java.lang.CharSequence assetId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UploadEnd() {}

  /**
   * All-args constructor.
   * @param dataSetId The new value for dataSetId
   * @param assetId The new value for assetId
   */
  public UploadEnd(java.lang.CharSequence dataSetId, java.lang.CharSequence assetId) {
    this.dataSetId = dataSetId;
    this.assetId = assetId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return dataSetId;
    case 1: return assetId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: dataSetId = (java.lang.CharSequence)value$; break;
    case 1: assetId = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'dataSetId' field.
   * @return The value of the 'dataSetId' field.
   */
  public java.lang.CharSequence getDataSetId() {
    return dataSetId;
  }

  /**
   * Sets the value of the 'dataSetId' field.
   * @param value the value to set.
   */
  public void setDataSetId(java.lang.CharSequence value) {
    this.dataSetId = value;
  }

  /**
   * Gets the value of the 'assetId' field.
   * @return The value of the 'assetId' field.
   */
  public java.lang.CharSequence getAssetId() {
    return assetId;
  }

  /**
   * Sets the value of the 'assetId' field.
   * @param value the value to set.
   */
  public void setAssetId(java.lang.CharSequence value) {
    this.assetId = value;
  }

  /**
   * Creates a new UploadEnd RecordBuilder.
   * @return A new UploadEnd RecordBuilder
   */
  public static com.pharbers.kafka.schema.UploadEnd.Builder newBuilder() {
    return new com.pharbers.kafka.schema.UploadEnd.Builder();
  }

  /**
   * Creates a new UploadEnd RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UploadEnd RecordBuilder
   */
  public static com.pharbers.kafka.schema.UploadEnd.Builder newBuilder(com.pharbers.kafka.schema.UploadEnd.Builder other) {
    return new com.pharbers.kafka.schema.UploadEnd.Builder(other);
  }

  /**
   * Creates a new UploadEnd RecordBuilder by copying an existing UploadEnd instance.
   * @param other The existing instance to copy.
   * @return A new UploadEnd RecordBuilder
   */
  public static com.pharbers.kafka.schema.UploadEnd.Builder newBuilder(com.pharbers.kafka.schema.UploadEnd other) {
    return new com.pharbers.kafka.schema.UploadEnd.Builder(other);
  }

  /**
   * RecordBuilder for UploadEnd instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UploadEnd>
    implements org.apache.avro.data.RecordBuilder<UploadEnd> {

    private java.lang.CharSequence dataSetId;
    private java.lang.CharSequence assetId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.UploadEnd.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.dataSetId)) {
        this.dataSetId = data().deepCopy(fields()[0].schema(), other.dataSetId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.assetId)) {
        this.assetId = data().deepCopy(fields()[1].schema(), other.assetId);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing UploadEnd instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.UploadEnd other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.dataSetId)) {
        this.dataSetId = data().deepCopy(fields()[0].schema(), other.dataSetId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.assetId)) {
        this.assetId = data().deepCopy(fields()[1].schema(), other.assetId);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'dataSetId' field.
      * @return The value.
      */
    public java.lang.CharSequence getDataSetId() {
      return dataSetId;
    }

    /**
      * Sets the value of the 'dataSetId' field.
      * @param value The value of 'dataSetId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.UploadEnd.Builder setDataSetId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.dataSetId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'dataSetId' field has been set.
      * @return True if the 'dataSetId' field has been set, false otherwise.
      */
    public boolean hasDataSetId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'dataSetId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.UploadEnd.Builder clearDataSetId() {
      dataSetId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'assetId' field.
      * @return The value.
      */
    public java.lang.CharSequence getAssetId() {
      return assetId;
    }

    /**
      * Sets the value of the 'assetId' field.
      * @param value The value of 'assetId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.UploadEnd.Builder setAssetId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.assetId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'assetId' field has been set.
      * @return True if the 'assetId' field has been set, false otherwise.
      */
    public boolean hasAssetId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'assetId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.UploadEnd.Builder clearAssetId() {
      assetId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public UploadEnd build() {
      try {
        UploadEnd record = new UploadEnd();
        record.dataSetId = fieldSetFlags()[0] ? this.dataSetId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.assetId = fieldSetFlags()[1] ? this.assetId : (java.lang.CharSequence) defaultValue(fields()[1]);
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
