package ivyy.taobao.com.dom4j;
import ivyy.taobao.com.entity.Address;
import ivyy.taobao.com.entity.Location;
import ivyy.taobao.com.entity.Point;
import ivyy.taobao.com.entity.Pois;
import ivyy.taobao.com.utils.IoUtils;
import ivyy.taobao.com.utils.UrlUtils;
import ivyy.taobao.com.utils.Dom4jUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
@SuppressWarnings("all")
public class Dom4jTest2 {
	
	public static void main(String[] args)throws Exception {
		//String filepath="D:/"+System.currentTimeMillis()+".xml";
		String filepath="D:/test/map1.xml";
		File f=new File(filepath);
		if(!f.exists()){
			f.createNewFile();
		}
		//List<Pois> list=getReaderXml("URL");
		List<Pois> list=getReaderXml("FILE");
		org.dom4j.Document doc=createAsXML(list);
		IoUtils.write(doc.asXML(),filepath);
		//格式化 
		Dom4jUtils.formatAsXml(doc);
	}
	
	 
	/****
	 * 组装成一个xml
	 * @param list
	 * @return
	 * @throws Exception
	 */
	private static org.dom4j.Document createAsXML(List<Pois> list) throws Exception{
		org.dom4j.Document doc=DocumentHelper.createDocument();
		Element  root=doc.addElement("GeocoderSearchResponse");//根
		root.addElement("status").setText("0");//status
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Pois pois = (Pois) iterator.next();

			Element result=root.addElement("result");//result
			List<Location>  listLoc=pois.getLocations();
			
			Element location=result.addElement("location");//location
			for (Iterator iterator2 = listLoc.iterator(); iterator2.hasNext();) {
				Location locObj = (Location) iterator2.next();
				location.addElement("lat").setText(locObj.getLat()+"");//lat
				location.addElement("lng").setText(locObj.getLng()+"");//lat
				result.addElement("formatted_address").setText(locObj.getFormattedAddress()+"");//formatted_address
				result.addElement("business").setText(locObj.getBusiness()+"");//business
			}
			
			List<Address>  listAdd=pois.getAddress();
			Element comp=result.addElement("addressComponent");//addressComponent
			for (Iterator iterator3 = listAdd.iterator(); iterator3.hasNext();) {
				Address address = (Address) iterator3.next();
				comp.addElement("streetNumber").setText(address.getStreetNumber()+"");//streetNumber
				comp.addElement("street").setText(address.getStreet()+"");//street
				comp.addElement("district").setText(address.getDistrict()+"");//district
				comp.addElement("city").setText(address.getCity()+"");//city
				comp.addElement("province").setText(address.getProvince()+"");//province
				comp.addElement("cityCode").setText(address.getCityCode()+"");//cityCode
			}
		
			Element poi=result.addElement("pois").addElement("poi");
			poi.addElement("addr").setText(pois.getAddr());//addr
			poi.addElement("distance").setText(pois.getDistance());//distance
			poi.addElement("name").setText(pois.getName());//name
			poi.addElement("poiType").setText(pois.getPoiType());//poiType
			poi.addElement("tel").setText(pois.getTel());//tel
			poi.addElement("zip").setText(pois.getZip());//zip
			
			List<Point> listPoint=pois.getPoints();
			Element point=poi.addElement("point");
			for (Iterator iterator4 = listPoint.iterator(); iterator4.hasNext();) {
				Point p = (Point) iterator4.next();
				point.addElement("x").setText(p.getX()+"");
				point.addElement("y").setText(p.getY()+"");
			}
		}
		 
		return doc;
	}
	 
	
	/**
	 * Dom4j（SAX）读取xml数据（解析）
	 * @param params
	 * @throws Exception
	 */
	private static List<Pois> getReaderXml(String flg) throws Exception{
		String fromRead=Dom4jTest2.class.getClassLoader().getResource("xml/map1.xml").getPath();

		List<Pois> list=new ArrayList<Pois>();
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document document=null;
		//从api上面解析
		if(flg.equals("URL")){
			String url = UrlUtils.getBaiduMapUrl("你的key", "39.983424,116.322987", "xml");
			document = saxReader.read(url);
		//从文件上面的xml解析
		}else if(flg.equals("FILE")){
			document = saxReader.read(new File(fromRead));
		}
		Element resultEl = (Element)document.getRootElement().element("result");
		Element poisEl=resultEl.element("pois");//pois节点
		Element locationEl=resultEl.element("location");//location节点
		Element addressEl=resultEl.element("addressComponent");//addressComponent节点
		
		/*******从pois节点下面遍历多个poi节点*******/
		for (Iterator<Element> poIter = poisEl.elementIterator("poi"); poIter.hasNext();) {
			Element element = (Element) poIter.next();
			String addr = element.elementText("addr");
			String distance = element.elementText("distance");
			String name = element.elementText("name");
			String poiType = element.elementText("poiType");
			String tel =(element.elementText("tel")==""?"":element.elementText("tel"));
			String zip =(element.elementText("zip")==""?"":element.elementText("zip"));
			
			Pois poi=new Pois();
			poi.setAddr(addr);
			poi.setDistance(distance);
			poi.setName(name);
			poi.setPoiType(poiType);
			poi.setTel(tel);
			poi.setZip(zip);
			
			
			List<Location> listLoc=new ArrayList<Location>();
			/************Location***************************/
			String business=resultEl.elementText("business");
			String formatted_address=resultEl.elementText("formatted_address");
			String lat = locationEl.elementText("lat");
			String lng = locationEl.elementText("lng");
			
			Location location=new Location();
			location.setBusiness(business);
			location.setFormattedAddress(formatted_address);
			location.setLat(lat);
			location.setLng(lng);

			listLoc.add(location);
			poi.setLocations(listLoc);

			
			List<Address> listAddr=new ArrayList<Address>();
			/************Address***************************/
			Address address=new Address();
			String streetNumber=(addressEl.elementText("streetNumber")==""?"":addressEl.elementText("streetNumber"));
			String street=(addressEl.elementText("street")==""?"":addressEl.elementText("street"));
			String district=(addressEl.elementText("district")==""?"":addressEl.elementText("district"));
			String city=(addressEl.elementText("city")==""?"":addressEl.elementText("city"));
			String province=(addressEl.elementText("province")==""?"":addressEl.elementText("province"));
			String direction=(addressEl.elementText("direction")==""?"":addressEl.elementText("direction"));
			String distancez=(addressEl.elementText("distance")==""?"":addressEl.elementText("distance"));
			
			address.setStreetNumber(streetNumber);
			address.setStreet(street);
			address.setCity(city);
			address.setDistrict(district);
			address.setDirection(direction);
			address.setDistance(distancez);
			address.setProvince(province);
			
			listAddr.add(address);
			
			poi.setAddress(listAddr);
			
			list.add(poi);
		}
		
		return list;
	}
	
}