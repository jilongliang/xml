 一、JAVASCRIPT中使用DOM操作XML文档
 	参考博客：		
  	http://jilongliang.iteye.com/blog/2172950
  
  
二、在 Word 中插入域代码并设置域代码的格式
	参考博客：		
	http://jilongliang.iteye.com/blog/2172949
	
	
	
三、jsoup、dom4j、jdom、jaxen、xstream
	1、jsoup(☆★★★推荐语法和jQuery类似，而且非常好用解析xml或html都可以強烈推薦)
		参考博客：
		http://jsoup.org/
		http://jilongliang.iteye.com/category/285439
		
	2、dom4j(☆★★★推荐)
		参考博客：		
		http://jilongliang.iteye.com/category/285438

	3、Jdom
		参考博客：
		http://www.jdom.org/
		https://github.com/hunterhacker/jdom/wiki/JDOM2-A-Primer
		https://fisheye.codehaus.org/browse/jaxen/tags
		http://www.w3school.com.cn/xpath/xpath_functions.asp
		
	4、jaxen（jar裡面有dom4j和jdom，w3cdom的整合）
		http://jaxen.codehaus.org/
		
	5、xstream
	    xstream不是很常用，不整合在xml项目上面.可以参考以下博客
		http://xstream.codehaus.org/
		http://xstream.codehaus.org/javadoc/index.html
		http://www.cnblogs.com/hoojo/archive/2011/04/22/2025197.html
	
	6、XML  文档定义有几种形式？它们之间有何本质区别？解析 XML  文档有哪几种方式？
	
		a: 两种形式 dtd schema,
		b: 本质区别:schema 本身是 xml 的,可以被 XML 解析器解析(这也是从 DTD 上发展 schema 的根本目的),
		c:有 DOM,SAX,STAX 等
		
		DOM: 处理大型文件时其性能下降的非常厉害.这个问题是由 DOM 的树结构所造成的,这种
			结构占用的内存较多,而且 DOM 必须在解析文件之前把整个文档装入内存,适合对 XML 的随机
			访问
		SAX: 不现于 DOM,SAX 是事件驱动型的 XML 解析方式.它顺序读取 XML 文件,不需要一次
			全部装载整个文件.当遇到像文件开头,文档结束,或者标签开头与标签结束时,它会触发一个事件,
			用户通过在其回调事件中写入处理代码来处理 XML 文件,适合对 XML 的顺序访问
		STAX: StreamingAPI for XML (StAX)
	
	
四、office_word.xml文件(★用office打开它是一个word文档来的)


