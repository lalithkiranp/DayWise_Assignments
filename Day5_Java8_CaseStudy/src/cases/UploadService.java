package cases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UploadService {
	    public static void main(String[] args) {
	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        Runnable uploadTask = () -> System.out.println("Uploading by " + Thread.currentThread().getName());

	        for (int i = 0; i < 5; i++) {
	            executor.submit(uploadTask);
	        }

	        executor.shutdown();
	    }
	}

