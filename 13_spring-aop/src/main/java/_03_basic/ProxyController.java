package _03_basic;

public class ProxyController implements Controller {

	private Controller controller;
	
	public ProxyController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void execute() throws Exception {
		
		String clzName = controller.getClass().getSimpleName();
		
		long s = System.currentTimeMillis();
		
		controller.execute();
		
		long e = System.currentTimeMillis();
		double time = (e-s) / 1000d;
		
		System.out.println(clzName + " execute 결과 : " + time);
		
	}

}