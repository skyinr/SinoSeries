package games.moegirl.sinocraft.sinocore.old.utility.json;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author DustW
 **/
public interface BaseSerializer<T> extends JsonSerializer<T>, JsonDeserializer<T> {
    static <E> TypeToken<List<E>> listOf(final Type arg) {
        //noinspection unchecked
        return new TypeToken<List<E>>() {
        }.where(new TypeParameter<>() {
        }, (TypeToken<E>) TypeToken.of(arg));
    }
}
