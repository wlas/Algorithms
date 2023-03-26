public class HashTable <K,V> {
    private static final int startLength = 10;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private  Basket[] baskets;
    public HashTable(){
        this(startLength);
    }
    public HashTable(int length){
        baskets = (Basket[]) new Object[length];
    }
    private int getBasketIndex(K key){
        return key.hashCode()%baskets.length;
    }

    private void recalculateLoad(){
        Basket[] oldBaskets = baskets;
        int length = baskets.length * 2;
        baskets = (Basket[]) new Object[length];
        for (int i = 0; i < oldBaskets.length; i++) {
            Basket basket = oldBaskets[i];
            Basket.Node node = basket.head;
            while (node != null){
                put(node.entity.key, node.entity.value);
                node = node.next;
            }
            oldBaskets[i] = null;
        }
    }
    public boolean put(K key, V value){
        if(size * LOAD_FACTOR >= baskets.length){
            recalculateLoad();
        }
        int index = getBasketIndex(key);
        Basket basket = baskets[index];
        if(basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        boolean isAdd = basket.add(entity);
        if(isAdd){
            size++;
        }
        return isAdd;
    }

    private boolean remove(K key){
        int index = getBasketIndex(key);
        Basket basket = baskets[index];
        boolean isRemove = basket.remove(key);
        if(isRemove){
            size--;
        }
        return isRemove;
    }
    public V get(K key){
        int index = getBasketIndex(key);
        Basket basket = baskets[index];
        if(basket != null){
            return  basket.get(key);
        }
        return null;
    }
    private  class Basket {
        private Node head;

        private class Node {
            private Node next;
            private Entity entity;
        }
        private V get(K key){
            Node node = head;
            while (node != null){
                if(node.entity.key.equals(key)){
                    return node.entity.value;
                }
                else {
                    node = node.next;
                }
            }
            return null;
        }
        private boolean add(Entity entity){
            Node node = new Node();
            node.entity = entity;
            if(head == null){
                head = node;
                return true;
            }
            else {
                Node courrentNode = head;
                while (courrentNode.next != null){
                    if(courrentNode.entity.key.equals(entity.key)){
                        return false;
                    }
                    courrentNode = courrentNode.next;
                }
                courrentNode.next = node;
                return true;
            }
        }

        public boolean remove(K key){
            if (head == null){
                return false;
            }
            else {
                if(head.entity.key.equals(key)){
                    head = head.next;
                }
                Node courrentNode = head;
                while (courrentNode.next != null){
                    if(courrentNode.next.entity.key.equals(key)){
                        courrentNode.next = courrentNode.next.next;
                        return true;
                    }
                    courrentNode = courrentNode.next;
                }
            }
            return false;
        }
    }
    private class Entity {
        private K key;
        private V value;
    }
}
