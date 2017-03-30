package sink.dao.impl.deserializer;

import java.io.IOException;
import java.sql.Blob;

import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Transactional
public class ImageDaoDeserializer extends JsonDeserializer<Blob> {
	
	@Autowired
	private SessionFactory	sessionFactory;
	
	@Override
	public Blob deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException, JsonProcessingException {
		String encodedImage = jsonParser.getText();
		if (!StringUtils.isEmpty(encodedImage)) {
			byte[] decodedByte = Base64.decodeBase64(encodedImage);
			Blob blob = sessionFactory.getCurrentSession().getLobHelper().createBlob(decodedByte);
			return blob;
		}
		return null;
	}
	
}
