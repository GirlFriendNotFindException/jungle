package com.lgd.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Complier {

	public static void compiler2(String code, String className) throws Exception {

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		DiagnosticCollector diagnostics = new DiagnosticCollector();

		// 定义一个StringWriter类，用于写Java程序
		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		// 开始写Java程序
		out.println(code);
		out.close();

		StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
		// 为这段代码取个名子：Judges
		SimpleJavaFileObject file = (new Complier()).new JavaSourceFromString(className, writer.toString());
		Iterable compilationUnits = Arrays.asList(file);
		// options命令行选项
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		path = URLDecoder.decode(path, "utf-8");

		Iterable<String> options = Arrays.asList("-d", path);// 指定的路径一定要存在，javac不会自己创建文件夹
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, options, null,
				compilationUnits);
		
		boolean success = task.call();
		//System.out.println((success) ? "编译成功" : "编译失败");
	}
	
	public static Object getInstance(String className) throws Exception{
		String code = AutoCreateJavaBean.getClassCode(className).createJavaBena();
		Complier.compiler2(code, className);
		Class<?> cls=Class.forName(className);
		Object o=cls.newInstance();
		System.out.println(o);
		return o;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		getInstance("Judges");
	}

	// 用于传递源程序的JavaSourceFromString类
	class JavaSourceFromString extends SimpleJavaFileObject {

		final String code;

		JavaSourceFromString(String name, String code) {
			super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.code = code;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) {
			return code;
		}
	}
}