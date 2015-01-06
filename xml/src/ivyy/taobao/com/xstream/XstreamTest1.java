package ivyy.taobao.com.xstream;

import ivyy.taobao.com.entity.Student;
import ivyy.taobao.com.utils.IoUtils;

import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class XstreamTest1 {
	public static void main(String[] args)throws Exception {
		
		String filePath = XstreamTest1.class.getClassLoader().getResource("xml/student.xml").getPath();

		//FileReader reader=IoUtils.Reader(filePath);
		//String reader=IoUtils.reader(filePath);
		XStream stream = new XStream(new DomDriver());
		//stream.alias("student", Student.class);
		//stream.aliasType("student", Student.class);
		//stream.aliasAttribute(Student.class, "userName", "userName");
		//Student stu = (Student)stream.fromXML(reader);
		
		Student stu=new Student();
		stu.setClassId("第198班");
		stu.setUserName("令狐沖");
		stream.aliasPackage("pack", "com.org.entity");//重命名包名
		String xml=stream.toXML(stu);
		
		System.out.println(xml);
	}
}
