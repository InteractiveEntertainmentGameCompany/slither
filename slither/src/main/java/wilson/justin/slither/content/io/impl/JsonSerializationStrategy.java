package wilson.justin.slither.content.io.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import wilson.justin.slither.content.io.SerializationStrategy;

/**
 * 
 * @author Phantasye
 *
 * @param <T>
 */
public class JsonSerializationStrategy<T extends Object> implements SerializationStrategy {

	private static final Logger logger = Logger.getLogger(JsonSerializationStrategy.class.getName());

	private final T serializable;
	private final String filePath;
	private final Gson gson = new Gson();

	public JsonSerializationStrategy(String filePath, T serializable) {
		this.filePath = filePath;
		this.serializable = serializable;
	}

	@Override
	public void serialize() {
		Path dst = Paths.get(filePath);
		try (OutputStream out = Files.newOutputStream(dst);
				JsonWriter writer = new JsonWriter(new BufferedWriter(new OutputStreamWriter(out)))) {
			gson.toJson(serializable, serializable.getClass(), writer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error whilst serializing.", e.getCause());
		}
	}

	@Override
	public T deserialize() {
		try (InputStream in = Files.newInputStream(Paths.get(filePath));
				JsonReader data = new JsonReader(new BufferedReader(new InputStreamReader(in)))) {
			T obj = gson.fromJson(data, serializable.getClass());
			return obj;
		} catch (NoSuchFileException e) {
			this.serialize();
			return deserialize();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error whilst deserializing.", e.getCause());
		}
		return serializable;
	}

}
