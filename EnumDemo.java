class EnumDemo{
	enum Constants{
		Constants_A,
		Constants_B,
		Constants_C
	}
	public static void doit(Constants c){
		switch(c){
			case Constants_A:
				System.out.println("a");
				break;
			case Constants_B:
				System.out.println("b");
				break;
		}
	}
	public static void main(String[] args){
		EnumDemo.doit(Constants.Constants_A);
		System.out.println(""+Constants.values());
	}
}

			
			
