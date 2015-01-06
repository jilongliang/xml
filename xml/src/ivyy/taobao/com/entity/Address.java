package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 * serialize序列化 默认 true
 * deserialize反序列化 默认 true
 */
public class Address implements Serializable{
	private int id;
	private String country;//国家
	private String province;//省份
	private String city;//城市
	private String street;//街道
	private String district;//地区
	private String cityCode;//邮政编码
	private String streetNumber;//街道号
	private String direction;//附近
	private String distance;
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Address() {
	}
	
	public Address(int id,String country) {
		this.id=id;
		this.country=country;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
