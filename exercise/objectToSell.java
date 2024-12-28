package exercise;

public class objectToSell {
	private String objectName;
	private Double objectValue;
	private Integer objectQuantity;
	private String objectType;
	
	public objectToSell(String objectName, Double objectValue, Integer objectQuantity, String objectType) {
		this.objectName = objectName;
		this.objectValue = objectValue;
		this.objectQuantity = objectQuantity;
		this.objectType = objectType;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Double getObjectValue() {
		return objectValue;
	}

	public void setObjectValue(Double objectValue) {
		this.objectValue = objectValue;
	}

	public Integer getObjectQuantity() {
		return objectQuantity;
	}

	public void setObjectQuantity(Integer objectQuantity) {
		this.objectQuantity = objectQuantity;
	}
	
	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	
	public Double total(objectToSell objectParam) {
		return objectParam.getObjectValue() * objectParam.getObjectQuantity();
	}
}
