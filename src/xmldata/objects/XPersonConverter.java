/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmldata.objects;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class XPersonConverter extends AbstractSingleValueConverter {

        public boolean canConvert(Class clazz) {
                return clazz.equals(XPerson.class);
        }

        public Object fromString(String str) {
                XPerson person = new XPerson();
                person.setName(str);
                return person;
        }

}