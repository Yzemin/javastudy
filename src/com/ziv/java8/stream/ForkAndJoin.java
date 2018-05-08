package com.ziv.java8.stream;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月29日   下午1:11:04 
 * 类说明 :
 * **		并行流与串行流	**
 * 				-fork/join框架
 * 	
*/
public class ForkAndJoin {
	public static  void main(String[] args) {
		ForkJoinPool pool =new ForkJoinPool();
		Dome1 dome= new Dome1(0,100000000L);
	}
}
class Dome1 extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	private long start;
	private long end;
	private static final long THRESHOLD = 10000;
	
	public Dome1(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long len= end - start;
		if(len <= THRESHOLD) {
			long sum = 0;
			for(long i = start;i<=end;i++) {
				sum+=i;
			}
			return sum;
		}else {
			long middle = (start + end) / 2;
			Dome1 left = new Dome1(start,middle);
			left.fork();
			
			Dome1 right = new Dome1(middle+1,end);
			right.fork();
			
			return left.join() + right.join();
		}
	}
	
}
 