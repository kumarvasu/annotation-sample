package test_proj;

public class Test {
		
	public static void main(String[] args) throws Exception {
	
		AnnotationHandler handler = new AnnotationHandler();
		TargetObject tobj = (TargetObject) handler.handle(Class.forName("test_proj.TargetObject"));
		System.out.println(tobj.getVar());
	}

}
