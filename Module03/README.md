*In this module you will learn how to use basic multithreading mechanisms in Java - The subject*
### introduction:
back in the days, when computers weren't taken for granted, and their abilities were very limited, it wasn't possible to use more than a single program (or application if you'd like) at once, for example if you're working on an excel sheet, you can't open anything else unless you closed excel (yeah, not even a music player), thankfully that was frustrating enough that they had to come up with a solution, like for example make the operating system manage and help the CPU handle more than a single program by passing the processes of those apps one after another for a very short time in a seamless way, thus the concept of **Multitasking** was born

```text
┌──────────┐ ── (Excel) ─────────► [ Process 1 ] ──────────────────► [ Process 1  ] ───...  
│  OS /    │  
│  CPU     │ ── (Music Player) ────────────────► [  Process 2 ] ──────────────────► [Process 2 ] ───...  
└──────────┘
```

But we would ask for more wouldn't we?like my computer I want to multitask, want my music from Youtube, check my emails, brows the internet more.. all meanwhile excel is open and waiting on the side while i'm pretending to be productive hehe, and this was solved by **Multithreading**, so meanwhile the computer is jumping between processes of different programs, it's also jumping between the threads of a single app too, in this example, we're talking about the threads of your beloved browser (Internet Explorer)
```text
┌──────────┐ ── (Excel) ───────────► [ Process 1 ] ──────────────────────► [ Process 1  ] ───...  
│  OS /    │
│  CPU     │ ── (Internet Explorer) ──────────────► [Process 2 (Th1 -- Th2)] ──────────────────► [Process 2  (Th1-- Th2) ] ───...
└──────────┘
```
but what if the computer had more than one CPU? or cores, which is the case nowadays, well two different programs can actually run at the exact same time each on a CPU (or a core), as well as two threads, can run at the same time, and they could be of the same program or not.
### Creating, starting and stopping threads
Theory aside, it's time to code a bit,
There are mainly four ways to create threads in Java:
#### Extending the Thread class:
```
class MyThread extends Thread {
 @Override 
 public void run() { 
	 //code to be exec by the thread 
	 System.out.println("I am a Thread!"); 
 }
}

public static void main() {
	MyThread th = new MyThread();
	th.start(); //starts the thread and calls run method.
}
```
#### Using Runnable interface:
this is better than extending Thread, we'll look at it later
```
class MyRunnable implements Runnable{
    @Override
    public void run() {
	    //code to be exec by the thread
        System.out.println("Thread is running using Runnable interface");
    }
}
public static void main() {
	MyRunnable task = new MyRunnable();
	Thread th = new Thread(task);
	//or simply Thread th = new Thread(new MyRunnable());
	th.start();
}
```
#### Implementing the Runnable interface as an anonymous class

```
public static void main() {
	Runnable runnable = new Runnable() {
		@override
		public void run() {
	        System.out.println("Thread is running using Runnable interface as an anonymous class");
		}
	};
	
	Thread th = new Thread(runnable);
	th.start();
}
```

#### Implementing the Runnable interface with a Lambda expression
```
public static void main() {
	Runnable runnable = () -> {
	    System.out.println("Thread is running using Runnable interface with Lambda expression");
	};
	
	Thread th = new Thread(runnable);
	th.start();
}
```

so maybe now is a good time to read about [lambda exp](blah) and [anonymous functions]() as well (i'll add them later ig.. )
#### Naming and sleeping:
we can name our thread simply by: 
```
Thread th = new Thread(runnable, "Jasmine");
```

and in case we wanted the threads to introduce themselves after sleeping, it'll look like:
```
public static void main() {
	Runnable runnable = () -> {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Sup! I'm " + Thread.currentThread().getName());
	};
	
	Thread th = new Thread(runnable, "Jasmine");
	th.start();
}
```
#### Things worth mentioning:
##### Calling run() Instead of start()
we've been overriding and defining `run()` all this time, what could be wrong with calling it then?
calling `run()`will give the expected execution, except for it will be executed by ***the main thread*** instead of the method's thread, or more specifically, by the thread that called the method and not to whom the method belongs to, so in order for the method to be run by its own thread, we should call `start()`
```
// the main thread is what runs run() method
public static void main() {
	MyThread th = new MyThread();
	th.run();
}
```

```
public static void main() {
	MyThread th = new MyThread();
	th.start(); //starts the thread MyThread and calls run method.
}
```
##### stopping a thread:
the Runnable interface have a `stop()` method, but it isn't safe to use it (deprecated) because it just stops the thread without guaranteeing safety, thus it may leave the objects that the thread have access to in unknown state, so when other threads will try to use those objects, the program could unexpectedly fail, instead we should handle the stopping by implementing proper methods for that .
##### Daemon Threads:
the JVM will keep running if the main thread exited and another thread is still running, so until every thread exits, if this isn't the behavior we're wishing for, and for some reason we want the JVM to stop running as soon as the main thread does so, we can set that thread (not the main one) a daemon thread, via `setDaemon(true)` method
```
thread.setDaemon(true);
thread.start();
```

