package hhj.demo.springboot.filter;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * @author hhj
 *
 */
@Component("concurrentCountFilter")
public class ConcurrentCountFilter implements Filter {
	private static AtomicInteger count = new AtomicInteger();

	/**
	 * 获取当前并发数
	 */
	public static int get() {
		return count.get();
	}

	/**
	 * 增加
	 */
	public static int increase() {
		return count.incrementAndGet();
	}

	public static int decrement() {
		return count.decrementAndGet();
	}

	/**
	 * 最大并发数，负数表示不限制
	 */
	public int maxConcurrent = 100;

	public void init(FilterConfig filterConfig) throws ServletException {
		String maxStr = filterConfig.getInitParameter("maxConcurrent");
		int num = -1;
		if (maxStr != null && !"".equals(maxStr)) {
			try {
				num = Integer.parseInt(maxStr);
			} catch (NumberFormatException e) {
			}
		}
		if (num >= 1) {
			this.maxConcurrent = num;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			int num = increase(); // 增加
			if (maxConcurrent > 0) {
				if (maxConcurrent >= num) {
					chain.doFilter(request, response);
				} else {
					HttpServletResponse res = (HttpServletResponse) response;
					res.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "达到最大并发数：" + maxConcurrent);
				}
			} else {
				// 未限制
				chain.doFilter(request, response);
			}
		} finally {
			decrement(); // 减少
		}
	}

	public void destroy() {

	}

}
