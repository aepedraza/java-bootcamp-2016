package com.globant.bootcamp.topic2;

public class File {
	private String name;
	private float kbSize;
	
	public File(String name, float kbSize) {
		this.name = name;
		this.kbSize = kbSize;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getKbSize() {
		return kbSize;
	}
	
	public void setKbSize(float kbSize) {
		this.kbSize = kbSize;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(kbSize);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (Float.floatToIntBits(kbSize) != Float.floatToIntBits(other.kbSize))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "File [name=" + name + ", kbSize=" + kbSize + "]";
	}
}
