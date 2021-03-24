class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public void update(int newValue) {
            this.value = newValue;
        }
    }
    
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cap;
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.head = null;
        this.tail = null;
        this.cap = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            delete(node);
            insert(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() >= cap) {
                map.remove(head.key);
                delete(head);
            }
            node = new Node(key, value);
            insert(node);
            map.put(key, node);
        } else {
            node.update(value);
            delete(node);
            insert(node);
        }
    }
    
    private void delete(Node node) {
        // if node has prev, let prev.next = node.next;
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        // if node has next, let next.prev = node.prev;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        
        //   <---------------->
        //   |                |
        // prev <-> node <-> next
        
        // if node is head, head = node.next
        if (head == node) {
            head = node.next;
        }
        
        // if node is tail, tail = node.prev;
        if (tail == node) {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
        // *->*-> prev -> next -> .... delete node
    }
    
    private void insert(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 // Time Cost: O(1)
 // Space Cost: O(n)