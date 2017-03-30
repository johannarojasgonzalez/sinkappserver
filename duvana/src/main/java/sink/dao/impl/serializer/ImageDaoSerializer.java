package sink.dao.impl.serializer;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Transactional
public class ImageDaoSerializer extends JsonSerializer<Blob> {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(ImageDaoSerializer.class);
	
	@Autowired
	private SessionFactory			sessionFactory;
	
	@Override
	public void serialize(Blob value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		try {
			byte[] ba;
			ba = value.getBytes(1, Long.valueOf(value.length()).intValue());
			String encodeBase64 = Base64.encodeBase64String(ba);
			gen.writeString(encodeBase64);
		} catch (SQLException e) {
			LOGGER.error("Error while serializing image" + e.getMessage());
		}
	}
	
}
