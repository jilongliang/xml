package ivyy.taobao.com.jsoup;
import ivyy.taobao.com.dom4j.Dom4jTest1;
import ivyy.taobao.com.entity.Address;
import ivyy.taobao.com.entity.Location;
import ivyy.taobao.com.entity.Point;
import ivyy.taobao.com.entity.Pois;
import ivyy.taobao.com.utils.IoUtils;
import ivyy.taobao.com.utils.UrlUtils;
import ivyy.taobao.com.utils.Dom4jUtils;

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
public class JsoupMap {
	
	public static void main(String[] args)throws Exception {
		String Encodeing="GBK";
		//List<Pois> list=JsoupReadXml("URL",Encodeing);//从api读取

		//------------------------------可以將這些數據保存到數據庫-------------------
		List<Pois> list=JsoupReadXml("FILE",Encodeing);//从本地的文件读取
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Pois pois = (Pois) iterator.next();
			
			//System.out.println(pois.getAddr());
			
			//------------------------------Address-----------------
			
			List<Address> listAdds=pois.getAddress();
			for (Iterator iterator2 = listAdds.iterator(); iterator2.hasNext();) {
				Address address = (Address) iterator2.next();
				System.out.println(address.getCity());
			}
			
			//------------------------------Location-----------------
			List<Location> locations = pois.getLocations();
			
			for (Iterator iterator2 = locations.iterator(); iterator2.hasNext();) {
				Location location = (Location) iterator2.next();
				System.out.println(location.getFormattedAddress());
			}
			
		}
	}
	 
	/**
	 * 用Jsoup去解析xml
	 * @param params
	 */
	private static List<Pois> JsoupReadXml(String flg,String Encodeing) throws Exception{
		List<Pois> list=new ArrayList<Pois>();
		
		String url = UrlUtils.getBaiduMapUrl("你的key", "39.983424,116.322987", "xml");
		org.jsoup.nodes.Document doc=null;
		if(flg.equals("URL")){
			  doc=Jsoup.connect(url).get();//网络连接
		}else if(flg.equals("FILE")){
			  String fromRead=Dom4jTest1.class.getClassLoader().getResource("xml/map1.xml").getPath();
			  String html=IoUtils.reader(fromRead);
			  doc=Jsoup.parse(html,Encodeing);
		}
		
		//org.jsoup.nodes.Document doc=Jsoup.parse(params);//本地数据,连接关闭就可以调用
		if(doc!=null)
		{
			Elements pois=doc.select("poi");//获取到poi节点
			for(org.jsoup.nodes.Element poi:pois){
				String addr=poi.getElementsByTag("addr").text().trim();
				String distance=poi.getElementsByTag("distance").text().trim();
				String name=poi.getElementsByTag("name").text().trim();
				String tel=poi.getElementsByTag("tel").text().trim();
				String zip=poi.getElementsByTag("zip").text().trim();
				String poiType=poi.getElementsByTag("poiType").text().trim();

				Pois p=new Pois();
				p.setAddr(addr);
				p.setDistance(distance);
				p.setName(name);
				p.setPoiType(poiType);
				p.setTel(tel);
				p.setZip(zip);
				
				List<Point> listPoint=new ArrayList<Point>();
				Point point=new Point();
				
				String x=poi.getElementsByTag("x").text().trim();
				point.setX(x);
				String y=poi.getElementsByTag("y").text().trim();
				point.setY(y);
				
				listPoint.add(point);
				p.setPoints(listPoint);
				
				List<Address> listAdd=new ArrayList<Address>();
				
				Elements comps=doc.select("addressComponent");
				
				for (org.jsoup.nodes.Element comp:comps) {
					String streetNumber=comp.getElementsByTag("streetNumber").text().trim();
					String district=comp.getElementsByTag("district").text().trim();
					String street=comp.getElementsByTag("street").text().trim();
					String city=comp.getElementsByTag("city").text().trim();
					String province=comp.getElementsByTag("province").text().trim();

					Address add=new Address();
					add.setStreetNumber(streetNumber);
					add.setStreet(street);
					add.setDistrict(district);
					add.setCity(city);
					add.setProvince(province);
					listAdd.add(add);
				}
				p.setAddress(listAdd);
				
				List<Location> listLoc=new ArrayList<Location>();
				Elements location=doc.select("location");
				for (org.jsoup.nodes.Element obj:location) {
					String	lat=obj.getElementsByTag("lat").text().trim();
					String	formatted_address=obj.getElementsByTag("formatted_address").text().trim();
					String	lng=obj.getElementsByTag("lng").text().trim();
					String	business=doc.select("business").text().trim();

					Location locat=new Location();
					locat.setLng(lng);
					locat.setLat(lat);
					locat.setFormattedAddress(formatted_address);
					locat.setBusiness(business);
					listLoc.add(locat);
				}
				String	status=doc.select("status").text().trim();
				p.setStatus(status);
				p.setLocations(listLoc);
				list.add(p);
			}
		}
		return list;
	}
}