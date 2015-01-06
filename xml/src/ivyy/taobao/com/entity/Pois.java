package ivyy.taobao.com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pois implements Serializable{
	private String addr;
	private String distance;
	private String name;
	private String poiType;
	private String tel;
	private String zip;
	private String status;
	private String url;
	private String mapUrl;
	private List<Point> points=new ArrayList<Point>();
	private List<Location> locations=new ArrayList<Location>();
	private List<Address> address=new ArrayList<Address>();
	private List<Pois> pois=new ArrayList<Pois>();
	
	public String getStatus() {
		return status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Pois> getPois() {
		return pois;
	}
	public void setPois(List<Pois> pois) {
		this.pois = pois;
	} 
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoiType() {
		return poiType;
	}
	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public String getMapUrl() {
		return mapUrl;
	}
	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	
}
