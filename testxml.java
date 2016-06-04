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
		//����һ��DocumentBuilderFactory ����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//����һ��DocumentBuilder����
			DocumentBuilder db =	dbf.newDocumentBuilder();
			//ͨ��DocumentBuilder ����xx��xml�ļ�
			Document document = 	db.parse("xx.xml");
			//��ȡ����book�ڵ�ļ���
			NodeList booklist = document.getElementsByTagName("book");
			//ͨ��getLengt��ȡ����
		System.out.println("һ����"+booklist.getLength()+"����");
			for(int i = 0;i<booklist.getLength();i++){
				System.out.println("=========================���ڱ�����"+(i+1)+"=================================");
//				//item(i)��ȡÿһ��book�ڵ㣬nodelist�Ĵ��㿪ʼ
//				Node node = booklist.item(i);
//				//��ȡ���Լ���
//				NamedNodeMap attrs = node.getAttributes();
//				System.out.println("��"+(i+1)+"���鹲��"+attrs.getLength()+"������");
//				for(int j = 0;j<attrs.getLength();j++){
//					//��ȡÿһ������
//					Node attr = attrs.item(j);
//					//��ȡÿһ����������
//					System.out.print("������"+attr.getNodeName());
//					//��ȡ����ֵ
//					System.out.println("������"+attr.getNodeValue());
//				}
				/*ǰ���Ѿ�֪��book�ڵ�����ֻ��1��id���ԣ���book�ڵ����ǿ������ת����ת����element���͡�
				1��ͨ��document.getElementByTagName("��ǩ��")������б�ǩ���Ľڵ㣬�õ�һ��NodeList����
				2��ͨ��NodeList.getLength()��ü��ϳ��ȣ���������
				3��element book=��element��bookList.item(i);//ǿ��ת��Ϊelement����
				4��string attrValue = book.getAttribute("id");
				 * */
				Element book = (Element) booklist.item(i);
				String attrValue =book.getAttribute("id");
				System.out.println("����ֵ��id,����ֵ��"+attrValue);
				NodeList ChildsNode= book.getChildNodes();
				System.out.println("��"+(i+1)+"����һ����"+ChildsNode.getLength()+"���ڵ�");
				for(int k = 1;k<ChildsNode.getLength();k++){
					if(ChildsNode.item(k).getNodeType() == Node.ELEMENT_NODE){
						System.out.print("��"+(k+1)+"���ӽڵ�"+ChildsNode.item(k).getNodeName()+":");
						System.out.println("--�ڵ�ֵ��:"+ChildsNode.item(k).getFirstChild().getNodeValue());
					}
					
				}
				System.out.println("==================��"+(i+1)+"�����Ѿ�����������===================================");
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
