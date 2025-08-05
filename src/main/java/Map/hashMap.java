package Map;

public class hashMap {
}
/*  哈希表结构中数组名为table，默认长度为16，加载因子0.75
  *  HashMap每个对象包含以下内容，链表中的键值对对象包含(键的hash值，键，值，下个节点的地址值)
  * 红黑树中键值对对象包含(键的hash值，键，值，父节点地址值，左右子节点的地址值，节点颜色)
  * put方法完整为 public V put(K key, V value){return putVal(hash(key)),key,value,false,true}
  * 返回值为被覆盖元素的值，若没有覆盖返回null，    hash(key)就是返回key的哈希值
  *
  * 参数为键的哈希值，键，值，键重复是否保留，true表示老元素值保留，不会覆盖，false就是老元素值不保留，会覆盖
  *    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
        Node<K,V>[] tab;    //记录哈希表中数组的地址值
        Node<K,V> p;        //记录键值对对象的地址值
        int n, i;           //n为数组长度，i为索引

        把哈希表中数组的地址值和数组长度给到tab和n。
        resize：若为第一次添加数据，底层会创建一个默认长度为16，加载因子0.75的数组
                不为第一次添加，会看是否达到扩容条件，若达到会扩容2倍，并把数据全部转移到新的hash表中
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        i的表达式：数组长度与键的哈希值进行计算，计算当前键值对对象应存入的位置
        p就是获取到的对应元素的数据，为null就是第一次添加数据
        newNode就是根据哈希值，键，值，下一节点地址创建new了个键值对对象，放到数组中
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);


        要添加位置有值时
         else {
            Node<K,V> e; K k;
            if (p.hash == hash &&   数组中键值对的哈希值 与 当前要添加键值对的哈希值 比较，键不一样false，走else if
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;


            else if (p instanceof TreeNode)     判断数组中获取出来的键值对是不是红黑树的节点
                 是就调用putTreeVal，把当前节点按照红黑树的规则添加到树
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);


            else {  不是就说明下面挂的是链表
                for (int binCount = 0; ; ++binCount) {  for循环不写条件默认true
                    if ((e = p.next) == null) {     判断下面节点有没有其他节点，此时就会创建新的节点形成链表
                        p.next = newNode(hash, key, value, null);
                        判断链表长度是否超过8，超过8就会调用treeifyBin，再判断数组长度是否大于等于64
                        同时满足则将链表转为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    若哈希值一样，就会调用equals方法比较内部的属性值，也一样就会break
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            若e不为null。表示当前的键一样，值会被覆盖 ，所谓覆盖只是将老元素的值覆盖，其他不变
                   if (e != null) { e为null就不会覆盖元素
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                  老元素的值  当前要添加的值
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }


        ++modCount;
        threshold就是记录数组长度再 * 0.75
        if (++size > threshold)
            resize();
        表示未覆盖，返回null
        return null;
    }
  */
