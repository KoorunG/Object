package hashset;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class InstrumentedHashSet<E> implements Set<E> {
    private int addCount = 0;
    private Set<E> set;

    public InstrumentedHashSet(Set<E> set){
        this.set = set;
    }
    @Override
    public boolean add(E e){            // InstrumentedHashSet에서 새로 오버라이딩 하고자 하는 메소드
        addCount++;
        return set.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c){ // InstrumentedHashSet에서 새로 오버라이딩 하고자 하는 메소드
        addCount += c.size();
        return set.addAll(c);
    }

    public int getAddCount(){       // InstrumentedHashSet의 고유 메소드 
        return addCount;
    }


    // 포워딩으로 처리 -> Set의 오퍼레이션을 내부의 HashSet 인스턴스에 동일한 메소드 호출을 그대로 전달 (?)
    // 기존 클래스의 인터페이스를 그대로 외부에 제공하면서 구현에 대한 결합 없이 일부 작동 방식 (여기서는 add, addAll)을 변경하고 싶은 경우에 유용함

    @Override
    public int size() {return set.size();}

    @Override
    public boolean isEmpty() {return set.isEmpty();}

    @Override
    public boolean contains(Object o) {return set.contains(o);}

    @Override
    public Iterator<E> iterator() {return set.iterator();}

    @Override
    public Object[] toArray() {return set.toArray();}

    @Override
    public <T> T[] toArray(T[] a) {return set.toArray(a);}

    @Override
    public boolean remove(Object o) {return set.remove(o);}

    @Override
    public boolean containsAll(Collection<?> c) {return set.containsAll(c);}

    @Override
    public boolean retainAll(Collection<?> c) {return set.retainAll(c);}

    @Override
    public boolean removeAll(Collection<?> c) {return set.removeAll(c);}

    @Override
    public void clear() {set.clear();}
}
