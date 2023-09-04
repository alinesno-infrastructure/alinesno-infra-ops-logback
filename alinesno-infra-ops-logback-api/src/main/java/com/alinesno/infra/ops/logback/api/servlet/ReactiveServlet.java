package com.alinesno.infra.ops.logback.api.servlet;

import com.alinesno.infra.ops.logback.sse.EventSource;
import com.alinesno.infra.ops.logback.sse.EventSourceListener;
import com.alinesno.infra.ops.logback.sse.IStreamLoggerClient;
import com.alinesno.infra.ops.logback.sse.SSEEventSourceFactory;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * ReactiveServlet 类是一个 HttpServlet 类，用于处理响应式请求。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@WebServlet(urlPatterns = "/api/ops/logback/stream", asyncSupported = true)
public class ReactiveServlet extends HttpServlet {

	private static final Logger log = LoggerFactory.getLogger(ReactiveServlet.class);

	@Autowired
	private IStreamLoggerClient loggerClient;

	/**
	 * 处理 GET 请求的方法。
	 *
	 * @param request  HttpServletRequest 对象
	 * @param resp     HttpServletResponse 对象
	 * @throws IOException 如果发生 I/O 错误
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/event-stream");
		resp.setCharacterEncoding("UTF-8");

		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(10 * 1000);

		PrintWriter out = asyncContext.getResponse().getWriter();

		generatorStream(asyncContext, out, request);
	}

	/**
	 * 生成流的方法。
	 *
	 * @param asyncContext 异步上下文
	 * @param out          输出流
	 * @param request      HttpServletRequest 对象
	 * @throws IOException 如果发生 I/O 错误
	 */
	private void generatorStream(AsyncContext asyncContext, PrintWriter out, HttpServletRequest request) throws IOException {

		InputStream inputStream = request.getInputStream();
		String requestBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

		log.debug("request body = {}", requestBody);

		EventSourceListener eventSourceListener = new EventSourceListener() {
			@Override
			public void onEvent(EventSource eventSource, String id, String type, String data) {
				out.println("data: " + data); // 发送日志数据给客户端
				out.println(); // 发送空行以表示事件结束
				out.flush();
			}
		};

		EventSource.Factory eventSourceFactory = new SSEEventSourceFactory(asyncContext);
		EventSource eventSource = eventSourceFactory.newEventSource(eventSourceListener);

		loggerClient.streamChatCompletion(eventSourceListener);

		asyncContext.addListener(new AsyncListener() {
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				eventSource.cancel();
			}

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				eventSource.cancel();
			}

			@Override
			public void onError(AsyncEvent event) throws IOException {
				eventSource.cancel();
			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				// 不需要实现此方法
			}
		});

	}
}
