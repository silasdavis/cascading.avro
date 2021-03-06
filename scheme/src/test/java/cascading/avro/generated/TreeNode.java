/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package cascading.avro.generated;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TreeNode extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TreeNode\",\"namespace\":\"cascading.avro.generated\",\"fields\":[{\"name\":\"label\",\"type\":[\"null\",\"string\"]},{\"name\":\"count\",\"type\":\"int\"},{\"name\":\"children\",\"type\":{\"type\":\"array\",\"items\":\"TreeNode\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence label;
  @Deprecated public int count;
  @Deprecated public java.util.List<cascading.avro.generated.TreeNode> children;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public TreeNode() {}

  /**
   * All-args constructor.
   */
  public TreeNode(java.lang.CharSequence label, java.lang.Integer count, java.util.List<cascading.avro.generated.TreeNode> children) {
    this.label = label;
    this.count = count;
    this.children = children;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return label;
    case 1: return count;
    case 2: return children;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: label = (java.lang.CharSequence)value$; break;
    case 1: count = (java.lang.Integer)value$; break;
    case 2: children = (java.util.List<cascading.avro.generated.TreeNode>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'label' field.
   */
  public java.lang.CharSequence getLabel() {
    return label;
  }

  /**
   * Sets the value of the 'label' field.
   * @param value the value to set.
   */
  public void setLabel(java.lang.CharSequence value) {
    this.label = value;
  }

  /**
   * Gets the value of the 'count' field.
   */
  public java.lang.Integer getCount() {
    return count;
  }

  /**
   * Sets the value of the 'count' field.
   * @param value the value to set.
   */
  public void setCount(java.lang.Integer value) {
    this.count = value;
  }

  /**
   * Gets the value of the 'children' field.
   */
  public java.util.List<cascading.avro.generated.TreeNode> getChildren() {
    return children;
  }

  /**
   * Sets the value of the 'children' field.
   * @param value the value to set.
   */
  public void setChildren(java.util.List<cascading.avro.generated.TreeNode> value) {
    this.children = value;
  }

  /** Creates a new TreeNode RecordBuilder */
  public static cascading.avro.generated.TreeNode.Builder newBuilder() {
    return new cascading.avro.generated.TreeNode.Builder();
  }
  
  /** Creates a new TreeNode RecordBuilder by copying an existing Builder */
  public static cascading.avro.generated.TreeNode.Builder newBuilder(cascading.avro.generated.TreeNode.Builder other) {
    return new cascading.avro.generated.TreeNode.Builder(other);
  }
  
  /** Creates a new TreeNode RecordBuilder by copying an existing TreeNode instance */
  public static cascading.avro.generated.TreeNode.Builder newBuilder(cascading.avro.generated.TreeNode other) {
    return new cascading.avro.generated.TreeNode.Builder(other);
  }
  
  /**
   * RecordBuilder for TreeNode instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TreeNode>
    implements org.apache.avro.data.RecordBuilder<TreeNode> {

    private java.lang.CharSequence label;
    private int count;
    private java.util.List<cascading.avro.generated.TreeNode> children;

    /** Creates a new Builder */
    private Builder() {
      super(cascading.avro.generated.TreeNode.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(cascading.avro.generated.TreeNode.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.label)) {
        this.label = data().deepCopy(fields()[0].schema(), other.label);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.count)) {
        this.count = data().deepCopy(fields()[1].schema(), other.count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.children)) {
        this.children = data().deepCopy(fields()[2].schema(), other.children);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing TreeNode instance */
    private Builder(cascading.avro.generated.TreeNode other) {
            super(cascading.avro.generated.TreeNode.SCHEMA$);
      if (isValidValue(fields()[0], other.label)) {
        this.label = data().deepCopy(fields()[0].schema(), other.label);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.count)) {
        this.count = data().deepCopy(fields()[1].schema(), other.count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.children)) {
        this.children = data().deepCopy(fields()[2].schema(), other.children);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'label' field */
    public java.lang.CharSequence getLabel() {
      return label;
    }
    
    /** Sets the value of the 'label' field */
    public cascading.avro.generated.TreeNode.Builder setLabel(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.label = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'label' field has been set */
    public boolean hasLabel() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'label' field */
    public cascading.avro.generated.TreeNode.Builder clearLabel() {
      label = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'count' field */
    public java.lang.Integer getCount() {
      return count;
    }
    
    /** Sets the value of the 'count' field */
    public cascading.avro.generated.TreeNode.Builder setCount(int value) {
      validate(fields()[1], value);
      this.count = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'count' field has been set */
    public boolean hasCount() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'count' field */
    public cascading.avro.generated.TreeNode.Builder clearCount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'children' field */
    public java.util.List<cascading.avro.generated.TreeNode> getChildren() {
      return children;
    }
    
    /** Sets the value of the 'children' field */
    public cascading.avro.generated.TreeNode.Builder setChildren(java.util.List<cascading.avro.generated.TreeNode> value) {
      validate(fields()[2], value);
      this.children = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'children' field has been set */
    public boolean hasChildren() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'children' field */
    public cascading.avro.generated.TreeNode.Builder clearChildren() {
      children = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public TreeNode build() {
      try {
        TreeNode record = new TreeNode();
        record.label = fieldSetFlags()[0] ? this.label : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.count = fieldSetFlags()[1] ? this.count : (java.lang.Integer) defaultValue(fields()[1]);
        record.children = fieldSetFlags()[2] ? this.children : (java.util.List<cascading.avro.generated.TreeNode>) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
