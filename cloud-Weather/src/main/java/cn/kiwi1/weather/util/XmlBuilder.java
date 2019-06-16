package cn.kiwi1.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.dsig.XMLObject;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Auther:kiwi
 * xml转换pojo
 * @Date: 2019/6/15 14:30
 */
public class XmlBuilder {
    public static Object xmlStrToObjet(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject =null;
        Reader reader =null;
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();//xml转换成对象的接口

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        if(null!=reader){
            reader.close();
        }
        return xmlObject;
    }
}
