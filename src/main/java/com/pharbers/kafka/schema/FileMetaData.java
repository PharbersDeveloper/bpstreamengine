/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class FileMetaData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2976631748437174536L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FileMetaData\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"RunId\",\"type\":\"string\"},{\"name\":\"JobId\",\"type\":\"string\"},{\"name\":\"MetaDataPath\",\"type\":\"string\"},{\"name\":\"SampleDataPath\",\"type\":\"string\"},{\"name\":\"ConvertType\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence RunId;
  @Deprecated public java.lang.CharSequence JobId;
  @Deprecated public java.lang.CharSequence MetaDataPath;
  @Deprecated public java.lang.CharSequence SampleDataPath;
  @Deprecated public java.lang.CharSequence ConvertType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FileMetaData() {}

  /**
   * All-args constructor.
   * @param RunId The new value for RunId
   * @param JobId The new value for JobId
   * @param MetaDataPath The new value for MetaDataPath
   * @param SampleDataPath The new value for SampleDataPath
   * @param ConvertType The new value for ConvertType
   */
  public FileMetaData(java.lang.CharSequence RunId, java.lang.CharSequence JobId, java.lang.CharSequence MetaDataPath, java.lang.CharSequence SampleDataPath, java.lang.CharSequence ConvertType) {
    this.RunId = RunId;
    this.JobId = JobId;
    this.MetaDataPath = MetaDataPath;
    this.SampleDataPath = SampleDataPath;
    this.ConvertType = ConvertType;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return RunId;
    case 1: return JobId;
    case 2: return MetaDataPath;
    case 3: return SampleDataPath;
    case 4: return ConvertType;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: RunId = (java.lang.CharSequence)value$; break;
    case 1: JobId = (java.lang.CharSequence)value$; break;
    case 2: MetaDataPath = (java.lang.CharSequence)value$; break;
    case 3: SampleDataPath = (java.lang.CharSequence)value$; break;
    case 4: ConvertType = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'RunId' field.
   * @return The value of the 'RunId' field.
   */
  public java.lang.CharSequence getRunId() {
    return RunId;
  }

  /**
   * Sets the value of the 'RunId' field.
   * @param value the value to set.
   */
  public void setRunId(java.lang.CharSequence value) {
    this.RunId = value;
  }

  /**
   * Gets the value of the 'JobId' field.
   * @return The value of the 'JobId' field.
   */
  public java.lang.CharSequence getJobId() {
    return JobId;
  }

  /**
   * Sets the value of the 'JobId' field.
   * @param value the value to set.
   */
  public void setJobId(java.lang.CharSequence value) {
    this.JobId = value;
  }

  /**
   * Gets the value of the 'MetaDataPath' field.
   * @return The value of the 'MetaDataPath' field.
   */
  public java.lang.CharSequence getMetaDataPath() {
    return MetaDataPath;
  }

  /**
   * Sets the value of the 'MetaDataPath' field.
   * @param value the value to set.
   */
  public void setMetaDataPath(java.lang.CharSequence value) {
    this.MetaDataPath = value;
  }

  /**
   * Gets the value of the 'SampleDataPath' field.
   * @return The value of the 'SampleDataPath' field.
   */
  public java.lang.CharSequence getSampleDataPath() {
    return SampleDataPath;
  }

  /**
   * Sets the value of the 'SampleDataPath' field.
   * @param value the value to set.
   */
  public void setSampleDataPath(java.lang.CharSequence value) {
    this.SampleDataPath = value;
  }

  /**
   * Gets the value of the 'ConvertType' field.
   * @return The value of the 'ConvertType' field.
   */
  public java.lang.CharSequence getConvertType() {
    return ConvertType;
  }

  /**
   * Sets the value of the 'ConvertType' field.
   * @param value the value to set.
   */
  public void setConvertType(java.lang.CharSequence value) {
    this.ConvertType = value;
  }

  /**
   * Creates a new FileMetaData RecordBuilder.
   * @return A new FileMetaData RecordBuilder
   */
  public static com.pharbers.kafka.schema.FileMetaData.Builder newBuilder() {
    return new com.pharbers.kafka.schema.FileMetaData.Builder();
  }

  /**
   * Creates a new FileMetaData RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FileMetaData RecordBuilder
   */
  public static com.pharbers.kafka.schema.FileMetaData.Builder newBuilder(com.pharbers.kafka.schema.FileMetaData.Builder other) {
    return new com.pharbers.kafka.schema.FileMetaData.Builder(other);
  }

  /**
   * Creates a new FileMetaData RecordBuilder by copying an existing FileMetaData instance.
   * @param other The existing instance to copy.
   * @return A new FileMetaData RecordBuilder
   */
  public static com.pharbers.kafka.schema.FileMetaData.Builder newBuilder(com.pharbers.kafka.schema.FileMetaData other) {
    return new com.pharbers.kafka.schema.FileMetaData.Builder(other);
  }

  /**
   * RecordBuilder for FileMetaData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FileMetaData>
    implements org.apache.avro.data.RecordBuilder<FileMetaData> {

    private java.lang.CharSequence RunId;
    private java.lang.CharSequence JobId;
    private java.lang.CharSequence MetaDataPath;
    private java.lang.CharSequence SampleDataPath;
    private java.lang.CharSequence ConvertType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.FileMetaData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.RunId)) {
        this.RunId = data().deepCopy(fields()[0].schema(), other.RunId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.JobId)) {
        this.JobId = data().deepCopy(fields()[1].schema(), other.JobId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.MetaDataPath)) {
        this.MetaDataPath = data().deepCopy(fields()[2].schema(), other.MetaDataPath);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.SampleDataPath)) {
        this.SampleDataPath = data().deepCopy(fields()[3].schema(), other.SampleDataPath);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ConvertType)) {
        this.ConvertType = data().deepCopy(fields()[4].schema(), other.ConvertType);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing FileMetaData instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.FileMetaData other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.RunId)) {
        this.RunId = data().deepCopy(fields()[0].schema(), other.RunId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.JobId)) {
        this.JobId = data().deepCopy(fields()[1].schema(), other.JobId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.MetaDataPath)) {
        this.MetaDataPath = data().deepCopy(fields()[2].schema(), other.MetaDataPath);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.SampleDataPath)) {
        this.SampleDataPath = data().deepCopy(fields()[3].schema(), other.SampleDataPath);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ConvertType)) {
        this.ConvertType = data().deepCopy(fields()[4].schema(), other.ConvertType);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'RunId' field.
      * @return The value.
      */
    public java.lang.CharSequence getRunId() {
      return RunId;
    }

    /**
      * Sets the value of the 'RunId' field.
      * @param value The value of 'RunId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder setRunId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.RunId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'RunId' field has been set.
      * @return True if the 'RunId' field has been set, false otherwise.
      */
    public boolean hasRunId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'RunId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder clearRunId() {
      RunId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'JobId' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobId() {
      return JobId;
    }

    /**
      * Sets the value of the 'JobId' field.
      * @param value The value of 'JobId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder setJobId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.JobId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'JobId' field has been set.
      * @return True if the 'JobId' field has been set, false otherwise.
      */
    public boolean hasJobId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'JobId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder clearJobId() {
      JobId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'MetaDataPath' field.
      * @return The value.
      */
    public java.lang.CharSequence getMetaDataPath() {
      return MetaDataPath;
    }

    /**
      * Sets the value of the 'MetaDataPath' field.
      * @param value The value of 'MetaDataPath'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder setMetaDataPath(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.MetaDataPath = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'MetaDataPath' field has been set.
      * @return True if the 'MetaDataPath' field has been set, false otherwise.
      */
    public boolean hasMetaDataPath() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'MetaDataPath' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder clearMetaDataPath() {
      MetaDataPath = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'SampleDataPath' field.
      * @return The value.
      */
    public java.lang.CharSequence getSampleDataPath() {
      return SampleDataPath;
    }

    /**
      * Sets the value of the 'SampleDataPath' field.
      * @param value The value of 'SampleDataPath'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder setSampleDataPath(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.SampleDataPath = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'SampleDataPath' field has been set.
      * @return True if the 'SampleDataPath' field has been set, false otherwise.
      */
    public boolean hasSampleDataPath() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'SampleDataPath' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder clearSampleDataPath() {
      SampleDataPath = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ConvertType' field.
      * @return The value.
      */
    public java.lang.CharSequence getConvertType() {
      return ConvertType;
    }

    /**
      * Sets the value of the 'ConvertType' field.
      * @param value The value of 'ConvertType'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder setConvertType(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.ConvertType = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ConvertType' field has been set.
      * @return True if the 'ConvertType' field has been set, false otherwise.
      */
    public boolean hasConvertType() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ConvertType' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.FileMetaData.Builder clearConvertType() {
      ConvertType = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public FileMetaData build() {
      try {
        FileMetaData record = new FileMetaData();
        record.RunId = fieldSetFlags()[0] ? this.RunId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.JobId = fieldSetFlags()[1] ? this.JobId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.MetaDataPath = fieldSetFlags()[2] ? this.MetaDataPath : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.SampleDataPath = fieldSetFlags()[3] ? this.SampleDataPath : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.ConvertType = fieldSetFlags()[4] ? this.ConvertType : (java.lang.CharSequence) defaultValue(fields()[4]);
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
