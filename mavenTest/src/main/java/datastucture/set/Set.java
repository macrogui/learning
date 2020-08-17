package datastucture.set;

/**
 * 业务场景：客户统计，词汇量统计。。。。
 * @param <E>
 */
public interface Set<E> {
    //不能添加重复元素
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
