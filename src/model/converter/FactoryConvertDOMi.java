
package model.converter;

public class FactoryConvertDOMi {
        private static IConvertDomXML conv = null;
        public static IConvertDomXML getInstance(String type)
        {   
            IConvertDomXML res=null;
            
            if (conv==null){
                res = init();
            }
            return res;
        }
        private static IConvertDomXML init()
        {   
            return new PersonConvertDomXML();

        }
}
