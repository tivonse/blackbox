package com.tiv.lab.blackbox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tiv.lab.blackbox.service.StubService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableCaching
public class BlackboxApplication implements CommandLineRunner {

	private final static Logger logger = LoggerFactory.getLogger(BlackboxApplication.class);

	@Autowired
	private StubService stubService;

	private ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {
		SpringApplication.run(BlackboxApplication.class, args);
	}

	@Override
	public void run(String... args) {

	}

	@Bean
	public SimpleCacheManager simpleCacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<Cache>();
		caches.add(new ConcurrentMapCache("queryAllStubs"));
		caches.add(new ConcurrentMapCache("getStubById"));
		cacheManager.setCaches(caches);
		return cacheManager;
	}

	@JsonDeserialize(as = ParentInterfaceDeserializer.class)
	interface ParentInterface {
		String getSubject();
		Set<SubInterface> getSubInterfaceSet();

		interface SubInterface {
			String getContent();
		}
	}

	@Data
	public static class ParentClass implements ParentInterface, Serializable {
		@JsonProperty("subject")
		String subject;

		@JsonProperty("subInterfaceSet")
		Set<SubInterface> subInterfaceSet;
		ParentClass() {}

		@Data
		public static class ParentClassSubInterface implements ParentInterface.SubInterface, Serializable {
			@JsonProperty("content")
			String content;

			ParentClassSubInterface() {}

			@JsonCreator
			ParentClassSubInterface(String content) {
				this.content = content;
			}
		}
	}

	static class ParentInterfaceDeserializer extends JsonDeserializer<ParentInterface> {
		@Override
		public ParentInterface deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
			final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        	final ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();

        	return mapper.treeToValue(node, ParentInterface.class);
		}
//		pseudo
//		ParentClass parentClass = new ParentClass();
//		parentClass.setSubject("debug");
//		Set<ParentClass.SubInterface> inputs = new HashSet<>();
//		inputs.add(new ParentClass.ParentClassSubInterface("list"));
//		parentClass.setSubInterfaceSet(inputs);
//
////		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//		ObjectNode rootNode = objectMapper.valueToTree(parentClass);
//
//		Object asAnObject = objectMapper.treeToValue(rootNode, ParentClass.class);
//		ParentInterface result = (ParentInterface) asAnObject;
//
//		System.out.println(result);
	}


}
