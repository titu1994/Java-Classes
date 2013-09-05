package asignment5;



class ThreadSynchronization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WritableThread a = new WritableThread("/");
		WritableThread b = new WritableThread("*");
		
		a.start();
		b.start();
		
	}

}


class WritableThread extends Thread{
	
	private final String writable;
	
	private static final String REF = "WritableThreadReference";

	public WritableThread(char writable){
		super();
		
		this.writable = writable + "";
	}
	
	public WritableThread(String writable){
		super();
		
		this.writable = writable;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (REF) {
			
			for(int i = 0; i < 5; i++){
				
				System.out.print(writable);
				
				REF.notify();
				
				try {
					REF.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				REF.notify();
			}
		}
		
	}

	
}


