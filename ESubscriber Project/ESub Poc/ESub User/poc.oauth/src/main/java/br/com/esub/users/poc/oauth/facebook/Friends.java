package br.com.esub.users.poc.oauth.facebook;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;



public class Friends {
	
	private List<Data> data;

	@Override
	public String toString() {
		return "Friends [data=" + data + "]";
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
}
