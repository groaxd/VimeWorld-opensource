package net.xtrafrancyz.mods.texteria.util.maxrects;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GdxArray<T> implements Iterable<T>
{
    public T[] items;
    public int size;
    public boolean ordered;
    private GdxArray.ArrayIterable<T> iterable;

    public GdxArray()
    {
        this(true, 16);
    }

    public GdxArray(int capacity)
    {
        this(true, capacity);
    }

    public GdxArray(boolean ordered, int capacity)
    {
        this.ordered = ordered;
        this.items = (Object[])(new Object[capacity]);
    }

    public GdxArray(boolean ordered, int capacity, Class arrayType)
    {
        this.ordered = ordered;
        this.items = (Object[])((Object[])Array.newInstance(arrayType, capacity));
    }

    public GdxArray(Class arrayType)
    {
        this(true, 16, arrayType);
    }

    public GdxArray(GdxArray <? extends T > array)
    {
        this(array.ordered, array.size, array.items.getClass().getComponentType());
        this.size = array.size;
        System.arraycopy(array.items, 0, this.items, 0, this.size);
    }

    public GdxArray(T[] array)
    {
        this(true, array, 0, array.length);
    }

    public GdxArray(boolean ordered, T[] array, int start, int count)
    {
        this(ordered, count, array.getClass().getComponentType());
        this.size = count;
        System.arraycopy(array, start, this.items, 0, this.size);
    }

    public void add(T value)
    {
        T[] at = this.items;

        if (this.size == at.length)
        {
            at = this.resize(Math.max(8, (int)((float)this.size * 1.75F)));
        }

        at[this.size++] = value;
    }

    public void add(T value1, T value2)
    {
        T[] at = this.items;

        if (this.size + 1 >= at.length)
        {
            at = this.resize(Math.max(8, (int)((float)this.size * 1.75F)));
        }

        at[this.size] = value1;
        at[this.size + 1] = value2;
        this.size += 2;
    }

    public void add(T value1, T value2, T value3)
    {
        T[] at = this.items;

        if (this.size + 2 >= at.length)
        {
            at = this.resize(Math.max(8, (int)((float)this.size * 1.75F)));
        }

        at[this.size] = value1;
        at[this.size + 1] = value2;
        at[this.size + 2] = value3;
        this.size += 3;
    }

    public void add(T value1, T value2, T value3, T value4)
    {
        T[] at = this.items;

        if (this.size + 3 >= at.length)
        {
            at = this.resize(Math.max(8, (int)((float)this.size * 1.8F)));
        }

        at[this.size] = value1;
        at[this.size + 1] = value2;
        at[this.size + 2] = value3;
        at[this.size + 3] = value4;
        this.size += 4;
    }

    public void addAll(GdxArray <? extends T > array)
    {
        this.addAll(array.items, 0, array.size);
    }

    public void addAll(GdxArray <? extends T > array, int start, int count)
    {
        if (start + count > array.size)
        {
            throw new IllegalArgumentException("start + count must be <= size: " + start + " + " + count + " <= " + array.size);
        }
        else
        {
            this.addAll(array.items, start, count);
        }
    }

    public void addAll(T... array)
    {
        this.addAll(array, 0, array.length);
    }

    public void addAll(T[] array, int start, int count)
    {
        T[] at = this.items;
        int i = this.size + count;

        if (i > at.length)
        {
            at = this.resize(Math.max(Math.max(8, i), (int)((float)this.size * 1.75F)));
        }

        System.arraycopy(array, start, at, this.size, count);
        this.size = i;
    }

    public T get(int index)
    {
        if (index >= this.size)
        {
            throw new IndexOutOfBoundsException("index can\'t be >= size: " + index + " >= " + this.size);
        }
        else
        {
            return (T)this.items[index];
        }
    }

    public void set(int index, T value)
    {
        if (index >= this.size)
        {
            throw new IndexOutOfBoundsException("index can\'t be >= size: " + index + " >= " + this.size);
        }
        else
        {
            this.items[index] = value;
        }
    }

    public void insert(int index, T value)
    {
        if (index > this.size)
        {
            throw new IndexOutOfBoundsException("index can\'t be > size: " + index + " > " + this.size);
        }
        else
        {
            T[] at = this.items;

            if (this.size == at.length)
            {
                at = this.resize(Math.max(8, (int)((float)this.size * 1.75F)));
            }

            if (this.ordered)
            {
                System.arraycopy(at, index, at, index + 1, this.size - index);
            }
            else
            {
                at[this.size] = at[index];
            }

            ++this.size;
            at[index] = value;
        }
    }

    public void insertRange(int index, int count)
    {
        if (index > this.size)
        {
            throw new IndexOutOfBoundsException("index can\'t be > size: " + index + " > " + this.size);
        }
        else
        {
            int i = this.size + count;

            if (i > this.items.length)
            {
                this.items = this.resize(Math.max(Math.max(8, i), (int)((float)this.size * 1.75F)));
            }

            System.arraycopy(this.items, index, this.items, index + count, this.size - index);
            this.size = i;
        }
    }

    public void swap(int first, int second)
    {
        if (first >= this.size)
        {
            throw new IndexOutOfBoundsException("first can\'t be >= size: " + first + " >= " + this.size);
        }
        else if (second >= this.size)
        {
            throw new IndexOutOfBoundsException("second can\'t be >= size: " + second + " >= " + this.size);
        }
        else
        {
            T[] at = this.items;
            T t = at[first];
            at[first] = at[second];
            at[second] = t;
        }
    }

    public boolean contains(T value, boolean identity)
    {
        T[] at = this.items;
        int i = this.size - 1;

        if (!identity && value != null)
        {
            while (i >= 0)
            {
                if (value.equals(at[i--]))
                {
                    return true;
                }
            }
        }
        else
        {
            while (i >= 0)
            {
                if (at[i--] == value)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsAll(GdxArray <? extends T > values, boolean identity)
    {
        T[] at = values.items;
        int i = 0;

        for (int j = values.size; i < j; ++i)
        {
            if (!this.contains(at[i], identity))
            {
                return false;
            }
        }

        return true;
    }

    public boolean containsAny(GdxArray <? extends T > values, boolean identity)
    {
        T[] at = values.items;
        int i = 0;

        for (int j = values.size; i < j; ++i)
        {
            if (this.contains(at[i], identity))
            {
                return true;
            }
        }

        return false;
    }

    public int indexOf(T value, boolean identity)
    {
        T[] at = this.items;

        if (!identity && value != null)
        {
            int k = 0;

            for (int l = this.size; k < l; ++k)
            {
                if (value.equals(at[k]))
                {
                    return k;
                }
            }
        }
        else
        {
            int i = 0;

            for (int j = this.size; i < j; ++i)
            {
                if (at[i] == value)
                {
                    return i;
                }
            }
        }

        return -1;
    }

    public int lastIndexOf(T value, boolean identity)
    {
        T[] at = this.items;

        if (!identity && value != null)
        {
            for (int j = this.size - 1; j >= 0; --j)
            {
                if (value.equals(at[j]))
                {
                    return j;
                }
            }
        }
        else
        {
            for (int i = this.size - 1; i >= 0; --i)
            {
                if (at[i] == value)
                {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean removeValue(T value, boolean identity)
    {
        T[] at = this.items;

        if (!identity && value != null)
        {
            int k = 0;

            for (int l = this.size; k < l; ++k)
            {
                if (value.equals(at[k]))
                {
                    this.removeIndex(k);
                    return true;
                }
            }
        }
        else
        {
            int i = 0;

            for (int j = this.size; i < j; ++i)
            {
                if (at[i] == value)
                {
                    this.removeIndex(i);
                    return true;
                }
            }
        }

        return false;
    }

    public T removeIndex(int index)
    {
        if (index >= this.size)
        {
            throw new IndexOutOfBoundsException("index can\'t be >= size: " + index + " >= " + this.size);
        }
        else
        {
            T[] at = this.items;
            T t = at[index];
            --this.size;

            if (this.ordered)
            {
                System.arraycopy(at, index + 1, at, index, this.size - index);
            }
            else
            {
                at[index] = at[this.size];
            }

            at[this.size] = null;
            return t;
        }
    }

    public void removeRange(int start, int end)
    {
        int i = this.size;

        if (end >= i)
        {
            throw new IndexOutOfBoundsException("end can\'t be >= size: " + end + " >= " + this.size);
        }
        else if (start > end)
        {
            throw new IndexOutOfBoundsException("start can\'t be > end: " + start + " > " + end);
        }
        else
        {
            T[] at = this.items;
            int j = end - start + 1;
            int k = i - j;

            if (this.ordered)
            {
                System.arraycopy(at, start + j, at, start, i - (start + j));
            }
            else
            {
                int l = Math.max(k, end + 1);
                System.arraycopy(at, l, at, start, i - l);
            }

            for (int i1 = k; i1 < i; ++i1)
            {
                at[i1] = null;
            }

            this.size = i - j;
        }
    }

    public boolean removeAll(GdxArray <? extends T > array, boolean identity)
    {
        int i = this.size;
        int j = i;
        T[] at = this.items;

        if (identity)
        {
            int k = 0;

            for (int l = array.size; k < l; ++k)
            {
                T t = array.get(k);

                for (int i1 = 0; i1 < i; ++i1)
                {
                    if (t == at[i1])
                    {
                        this.removeIndex(i1);
                        --i;
                        break;
                    }
                }
            }
        }
        else
        {
            int j1 = 0;

            for (int k1 = array.size; j1 < k1; ++j1)
            {
                T t1 = array.get(j1);

                for (int l1 = 0; l1 < i; ++l1)
                {
                    if (t1.equals(at[l1]))
                    {
                        this.removeIndex(l1);
                        --i;
                        break;
                    }
                }
            }
        }

        return i != j;
    }

    public T pop()
    {
        if (this.size == 0)
        {
            throw new IllegalStateException("Array is empty.");
        }
        else
        {
            --this.size;
            T t = this.items[this.size];
            this.items[this.size] = null;
            return t;
        }
    }

    public T peek()
    {
        if (this.size == 0)
        {
            throw new IllegalStateException("Array is empty.");
        }
        else
        {
            return (T)this.items[this.size - 1];
        }
    }

    public T first()
    {
        if (this.size == 0)
        {
            throw new IllegalStateException("Array is empty.");
        }
        else
        {
            return (T)this.items[0];
        }
    }

    public boolean notEmpty()
    {
        return this.size > 0;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void clear()
    {
        Arrays.fill(this.items, 0, this.size, (Object)null);
        this.size = 0;
    }

    public T[] shrink()
    {
        if (this.items.length != this.size)
        {
            this.resize(this.size);
        }

        return this.items;
    }

    public T[] ensureCapacity(int additionalCapacity)
    {
        if (additionalCapacity < 0)
        {
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + additionalCapacity);
        }
        else
        {
            int i = this.size + additionalCapacity;

            if (i > this.items.length)
            {
                this.resize(Math.max(Math.max(8, i), (int)((float)this.size * 1.75F)));
            }

            return this.items;
        }
    }

    public T[] setSize(int newSize)
    {
        this.truncate(newSize);

        if (newSize > this.items.length)
        {
            this.resize(Math.max(8, newSize));
        }

        this.size = newSize;
        return this.items;
    }

    protected T[] resize(int newSize)
    {
        T[] at = this.items;
        T[] at1 = (Object[])((Object[])Array.newInstance(at.getClass().getComponentType(), newSize));
        System.arraycopy(at, 0, at1, 0, Math.min(this.size, at1.length));
        this.items = at1;
        return at1;
    }

    public void reverse()
    {
        T[] at = this.items;
        int i = 0;
        int j = this.size - 1;

        for (int k = this.size / 2; i < k; ++i)
        {
            int l = j - i;
            T t = at[i];
            at[i] = at[l];
            at[l] = t;
        }
    }

    public GdxArray.ArrayIterator<T> iterator()
    {
        if (this.iterable == null)
        {
            this.iterable = new GdxArray.ArrayIterable(this);
        }

        return this.iterable.iterator();
    }

    public void truncate(int newSize)
    {
        if (newSize < 0)
        {
            throw new IllegalArgumentException("newSize must be >= 0: " + newSize);
        }
        else if (this.size > newSize)
        {
            for (int i = newSize; i < this.size; ++i)
            {
                this.items[i] = null;
            }

            this.size = newSize;
        }
    }

    public T[] toArray()
    {
        return (T[])((Object[])this.toArray(this.items.getClass().getComponentType()));
    }

    public <V> V[] toArray(Class<V> type)
    {
        V[] av = (Object[])((Object[])Array.newInstance(type, this.size));
        System.arraycopy(this.items, 0, av, 0, this.size);
        return av;
    }

    public int hashCode()
    {
        if (!this.ordered)
        {
            return super.hashCode();
        }
        else
        {
            Object[] aobject = this.items;
            int i = 1;
            int j = 0;

            for (int k = this.size; j < k; ++j)
            {
                i *= 31;
                Object object = aobject[j];

                if (object != null)
                {
                    i += object.hashCode();
                }
            }

            return i;
        }
    }

    public boolean equals(Object object)
    {
        if (object == this)
        {
            return true;
        }
        else if (!this.ordered)
        {
            return false;
        }
        else if (!(object instanceof GdxArray))
        {
            return false;
        }
        else
        {
            GdxArray gdxarray = (GdxArray)object;

            if (!gdxarray.ordered)
            {
                return false;
            }
            else
            {
                int i = this.size;

                if (i != gdxarray.size)
                {
                    return false;
                }
                else
                {
                    Object[] aobject = this.items;
                    Object[] aobject1 = gdxarray.items;
                    int j = 0;

                    while (true)
                    {
                        if (j >= i)
                        {
                            return true;
                        }

                        Object object = aobject[j];
                        Object object1 = aobject1[j];

                        if (object == null)
                        {
                            if (object1 != null)
                            {
                                break;
                            }
                        }
                        else if (!object.equals(object1))
                        {
                            break;
                        }

                        ++j;
                    }

                    return false;
                }
            }
        }
    }

    public boolean equalsIdentity(Object object)
    {
        if (object == this)
        {
            return true;
        }
        else if (!this.ordered)
        {
            return false;
        }
        else if (!(object instanceof GdxArray))
        {
            return false;
        }
        else
        {
            GdxArray gdxarray = (GdxArray)object;

            if (!gdxarray.ordered)
            {
                return false;
            }
            else
            {
                int i = this.size;

                if (i != gdxarray.size)
                {
                    return false;
                }
                else
                {
                    Object[] aobject = this.items;
                    Object[] aobject1 = gdxarray.items;

                    for (int j = 0; j < i; ++j)
                    {
                        if (aobject[j] != aobject1[j])
                        {
                            return false;
                        }
                    }

                    return true;
                }
            }
        }
    }

    public String toString()
    {
        if (this.size == 0)
        {
            return "[]";
        }
        else
        {
            T[] at = this.items;
            StringBuilder stringbuilder = new StringBuilder(32);
            stringbuilder.append('[');
            stringbuilder.append(at[0]);

            for (int i = 1; i < this.size; ++i)
            {
                stringbuilder.append(", ");
                stringbuilder.append(at[i]);
            }

            stringbuilder.append(']');
            return stringbuilder.toString();
        }
    }

    public String toString(String separator)
    {
        if (this.size == 0)
        {
            return "";
        }
        else
        {
            T[] at = this.items;
            StringBuilder stringbuilder = new StringBuilder(32);
            stringbuilder.append(at[0]);

            for (int i = 1; i < this.size; ++i)
            {
                stringbuilder.append(separator);
                stringbuilder.append(at[i]);
            }

            return stringbuilder.toString();
        }
    }

    public static <T> GdxArray<T> of(Class<T> arrayType)
    {
        return new GdxArray(arrayType);
    }

    public static <T> GdxArray<T> of(boolean ordered, int capacity, Class<T> arrayType)
    {
        return new GdxArray(ordered, capacity, arrayType);
    }

    public static <T> GdxArray<T> with(T... array)
    {
        return new GdxArray(array);
    }

    public static class ArrayIterable<T> implements Iterable<T>
    {
        private final GdxArray<T> array;
        private final boolean allowRemove;
        private GdxArray.ArrayIterator iterator1;
        private GdxArray.ArrayIterator iterator2;

        public ArrayIterable(GdxArray<T> array)
        {
            this(array, true);
        }

        public ArrayIterable(GdxArray<T> array, boolean allowRemove)
        {
            this.array = array;
            this.allowRemove = allowRemove;
        }

        public GdxArray.ArrayIterator<T> iterator()
        {
            return new GdxArray.ArrayIterator(this.array, this.allowRemove);
        }
    }

    public static class ArrayIterator<T> implements Iterator<T>, Iterable<T>
    {
        private final GdxArray<T> array;
        private final boolean allowRemove;
        int index;
        boolean valid;

        public ArrayIterator(GdxArray<T> array)
        {
            this(array, true);
        }

        public ArrayIterator(GdxArray<T> array, boolean allowRemove)
        {
            this.valid = true;
            this.array = array;
            this.allowRemove = allowRemove;
        }

        public boolean hasNext()
        {
            if (!this.valid)
            {
                throw new RuntimeException("#iterator() cannot be used nested.");
            }
            else
            {
                return this.index < this.array.size;
            }
        }

        public T next()
        {
            if (this.index >= this.array.size)
            {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            else if (!this.valid)
            {
                throw new RuntimeException("#iterator() cannot be used nested.");
            }
            else
            {
                return (T)this.array.items[this.index++];
            }
        }

        public void remove()
        {
            if (!this.allowRemove)
            {
                throw new RuntimeException("Remove not allowed.");
            }
            else
            {
                --this.index;
                this.array.removeIndex(this.index);
            }
        }

        public void reset()
        {
            this.index = 0;
        }

        public GdxArray.ArrayIterator<T> iterator()
        {
            return this;
        }
    }
}
