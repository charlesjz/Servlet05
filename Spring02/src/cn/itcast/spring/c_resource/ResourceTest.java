package cn.itcast.spring.c_resource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class ResourceTest {

	// 测试ClassPathResource
	@Test
	public void testClassPathResource() throws Exception {
		Resource resource1 = new ClassPathResource("cn/itcast/spring/c_resource/applicationContext_dao.xml");
		Resource resource2 = new ClassPathResource("applicationContext_dao.xml", this.getClass());

		System.out.println(resource1.getFile().getAbsolutePath());
		System.out.println(resource2.getFile().getAbsolutePath());
	}

	// FileSystemResource
	// UrlResource
	@Test
	public void test2() throws Exception {
		Resource resource = new FileSystemResource("c:/applicationContext.xml");
		System.out.println(resource.exists());
		System.out.println(resource.getFile().getAbsolutePath());
		System.out.println("\n");

		Resource resource2 = new UrlResource("file://c:/applicationContext.xml");
		System.out.println(resource2.exists());
		System.out.println(resource.getFile().getAbsolutePath());
	}

	// ServletContextResource，需要在Web环境下才可以
	@Test
	public void testServletContextResource() {
		// Resource resource = new ServletContextResource(servletContext, "/WEB-INF/classes/applicationContext.xml");
		// System.out.println(resource);
	}
}
