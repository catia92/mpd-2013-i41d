package binder;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class PropertySetterWithValidationFinder extends AbstractPropertySetterFinder{

	@Override
	protected Setter makeSetter(Member m) {
		Method prop = (Method) m; 
		Validator v = prop.getAnnotation(Validator.class);
		final PropertySetter setter = new PropertySetter(prop);
		if(v != null){
			return new SetterValidation(v, setter);
		}else {
			return setter;
		}
	}
}
