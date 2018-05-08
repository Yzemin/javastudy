package com.ziv.fog.structure.agent;

/**
 * @author ziv
 * 代理模式 aop
 *		-抽象角色，真实角色，代理角色
 *		-动态代理，静态代理
 */
interface StarStatus{
	void confcr();
	void sing();
}
//	真实角色
class RealStarStatus implements StarStatus{
	@Override
	public void confcr() {
		System.out.println("RealStarStatus:CONFCR");
	}

	@Override
	public void sing() {
		System.out.println("RealStarStatus:SING");
	}
	
}
//	代理角色
class ProxyStarStatus implements StarStatus{
	private StarStatus star;
	public ProxyStarStatus() {
		if(this.star == null)
			this.star = new RealStarStatus();
	}
	public ProxyStarStatus(StarStatus star) {
		this.star = star;
	}
	@Override
	public void confcr() {
		System.out.println("ProxyStarStatus:CONFCR");
	}

	@Override
	public void sing() {
		star.sing();
	}
	
}
public class AgentStatus {
	public static void main(String[] args) {
//		new ProxyStarStatus().sing();
		RealStarStatus realStarStatus = new RealStarStatus();
		ProxyStarStatus proxyStarStatus = new ProxyStarStatus(realStarStatus);
		proxyStarStatus.confcr();
		proxyStarStatus.sing();
	}
}
