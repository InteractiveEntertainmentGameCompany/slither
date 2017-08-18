package wilson.justin.slither.content.io;

/**
 *
 * @author Phantasye
 *
 */
public interface SerializationStrategy {

    void serialize();
    
    Object deserialize();
}
