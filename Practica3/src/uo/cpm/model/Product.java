package uo.cpm.model;

import java.util.Objects;

public class Product {
	
	private String code;
	private String type;
	private String name;
	private float price;
	private int units;
	
	public Product(String code, String type, String name, float price, int units){
		this.code = code;
		this.type = type;
		this.name = name;
		this.price = price;
		this.units = units;
	}
	
	public Product (Product anotherItem) {
        this(anotherItem.code, anotherItem.type, anotherItem.name, anotherItem.price, anotherItem.units);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.type);
		buffer.append(" - ");
		buffer.append(this.name);
		buffer.append(" - ");
		buffer.append(this.price);
		buffer.append(" €");
		if (this.units!=0){
			buffer.append(" (");
			buffer.append(this.units);
			buffer.append(" uds)");
			}
		return buffer.toString();
	   }

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}
}
