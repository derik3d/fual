package com.app.fual.FualMain;

public class DataResponse {

	private String testName = "daniel";
	private String testPass = "asdf";
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestPass() {
		return testPass;
	}
	public void setTestPass(String testPass) {
		this.testPass = testPass;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((testPass == null) ? 0 : testPass.hashCode());
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
		DataResponse other = (DataResponse) obj;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		if (testPass == null) {
			if (other.testPass != null)
				return false;
		} else if (!testPass.equals(other.testPass))
			return false;
		return true;
	}
	
	
	
}
