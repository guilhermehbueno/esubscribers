package br.com.esub.users.poc.oauth.facebook;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Data {
	
	private String name;
	private String id;
	@XStreamImplicit(itemFieldName="data", keyFieldName="data")
	private List<Data> data;
	
	private String paging;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public String getPaging() {
		return paging;
	}
	public void setPaging(String paging) {
		this.paging = paging;
	}
	@Override
	public String toString() {
		return "Data [name=" + name + ", id=" + id + ", data=" + data
				+ ", paging=" + paging + "]";
	}
}
