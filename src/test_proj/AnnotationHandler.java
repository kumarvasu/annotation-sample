package test_proj;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AnnotationHandler {
	
	public <T> T handle(Class<T> clazz){		
		T tObj = null;
		try {
			tObj = clazz.getConstructor().newInstance();
			Field field = clazz.getDeclaredField("var");
			if(field.isAnnotationPresent(CustomAnnotation.class)){
				CustomAnnotation annotation = (CustomAnnotation)field.getDeclaredAnnotation(CustomAnnotation.class);
				field.setAccessible(true);
				if("ANDROID".equals(annotation.platform())){				
					field.set(tObj, "android url");
				} else {
					field.set(tObj, "ios url");
				}
			}
		}catch(NoSuchFieldException e){
			
		}catch(InvocationTargetException ite){
			
		}catch(IllegalAccessException iae){
			iae.printStackTrace();
		}catch(InstantiationException ie){
			
		}catch(NoSuchMethodException nsme){
			
		}
		return tObj;
	}

}
