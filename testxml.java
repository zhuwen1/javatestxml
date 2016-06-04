package xx;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class testxml {
	public static void main(String []args){
		//创建一个DocumentBuilderFactory 对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//创建一个DocumentBuilder对象
			DocumentBuilder db =	dbf.newDocumentBuilder();
			//通过DocumentBuilder 解析xx。xml文件
			Document document = 	db.parse("xx.xml");
			//获取所有book节点的集合
			NodeList booklist = document.getElementsByTagName("book");
			//通过getLengt获取长度
		System.out.println("一共有"+booklist.getLength()+"本书");
			for(int i = 0;i<booklist.getLength();i++){
				System.out.println("=========================正在遍历第"+(i+1)+"=================================");
//				//item(i)获取每一个book节点，nodelist的从零开始
//				Node node = booklist.item(i);
//				//获取属性集合
//				NamedNodeMap attrs = node.getAttributes();
//				System.out.println("第"+(i+1)+"本书共有"+attrs.getLength()+"个属性");
//				for(int j = 0;j<attrs.getLength();j++){
//					//获取每一个属性
//					Node attr = attrs.item(j);
//					//获取每一个属性名字
//					System.out.print("属性名"+attr.getNodeName());
//					//获取属性值
//					System.out.println("属性名"+attr.getNodeValue());
//				}
				/*前提已经知道book节点有且只有1个id属性，将book节点进行强制类型转换，转换成element类型。
				1、通过document.getElementByTagName("标签名")获得所有标签名的节点，得到一个NodeList集合
				2、通过NodeList.getLength()获得集合长度，遍历集合
				3、element book=（element）bookList.item(i);//强制转换为element类型
				4、string attrValue = book.getAttribute("id");
				 * */
				Element book = (Element) booklist.item(i);
				String attrValue =book.getAttribute("id");
				System.out.println("属性值是id,属性值得"+attrValue);
				NodeList ChildsNode= book.getChildNodes();
				System.out.println("第"+(i+1)+"本书一共有"+ChildsNode.getLength()+"个节点");
				for(int k = 1;k<ChildsNode.getLength();k++){
					if(ChildsNode.item(k).getNodeType() == Node.ELEMENT_NODE){
						System.out.print("第"+(k+1)+"个子节点"+ChildsNode.item(k).getNodeName()+":");
						System.out.println("--节点值是:"+ChildsNode.item(k).getFirstChild().getNodeValue());
					}
					
				}
				System.out.println("==================第"+(i+1)+"本书已经被遍历完了===================================");
			}
			
			
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
