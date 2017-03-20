package sink.dao.impl.serializer;

import java.io.IOException;
import java.sql.Blob;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Transactional
public class ImageDaoSerializer extends JsonSerializer<Blob> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void serialize(Blob value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		// TODO to implement decode base 64
		gen.writeString("later");		
	}

}
