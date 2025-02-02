package games.moegirl.sinocraft.sinocore.utility;

/**
 * 用于替代 AtomicReference 将变量传入 lambda 表达式，不保证线程安全
 * @author luqin2007
 */
public final class Reference<T> {

    private T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
